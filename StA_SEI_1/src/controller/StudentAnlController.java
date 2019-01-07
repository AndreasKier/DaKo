package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import db_connection.DB_Connection;
import view.*;
import anwendung.*;

/*TODO:
 * siehe unten,
 * prüfen ob student bereits vorhanden ist etc. 
 */

public class StudentAnlController implements ActionListener {
	private StudentAnlView studentanl = new StudentAnlView(this);
	private Student student; 
	
	public void studentanl() {
		try {
			studentanl.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void actionPerformed(ActionEvent e) {
		studentanl.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		try {
			if(e.getActionCommand().equals("Back")) {
				studentanl.setVisible(false);
			}
			if(e.getActionCommand().equals("Speichern")) {
				try {
					String studentname = studentanl.getTextFieldName();
					String studentemail = studentanl.getTextFieldEmail();
					Hochschule studenthochschule = studentanl.getComboBoxHochschule(); 
					Studiengruppe studentstudiengruppe = studentanl.getComboBoxStudiengruppe();
					int studentmatrikelnr = Integer.parseInt(studentanl.getTextFieldMatrikelnr());
					String studentstrasse = studentanl.getTextFieldStrasse();
					String studenthausnr = studentanl.getTextFieldHausnr(); 
					int studentplz = studentanl.getTextFieldPlz();
					String studentort = studentanl.getTextFieldOrt();
					int counter = 0;
			
					if(studentstrasse == null && studenthausnr == null && studentplz == 0 && studentort == null)
						student = new Student(studentname, studentemail, studenthochschule, studentstudiengruppe, studentmatrikelnr, counter);
					else if(studentstrasse != "" && studenthausnr != "" && studentplz != 0 && studentort != "")
						student = new Student(studentname, studentemail, studenthochschule, studentstudiengruppe, studentmatrikelnr, studentstrasse, studenthausnr, studentplz, studentort, counter);
						Adresse adresse = new Adresse(studentstrasse, studenthausnr, studentplz, studentort);
					
					
					
					//Datenbankanbindung! (Beispiel aus uebung 5 ButtonHandler methode actionPerformed
					DB_Connection con = DB_Connection.getDbConnection();
					String query = "INSERT INTO person(Name, email, Hochschule)" + "VALUES('"+ student.getName() + " ', '"+ student.getEMail() + "', '"+student.getHochschule() +"')";
					int idperson = 0;
					
//TODO:
					//Prüfen ob Student/Professor bereits vorhanden ist
					//keine Doppelanlegung, evtl Abfragen ob Benutzer trotzdem angelegt werden soll mit neuer ID 
					//schleife?? SQL abfrage nach Namen(gibt Namen evtl öfter!!) und jeden Namen mit den vergleichen
					//gleiche mit adresse
					//alle Änderung auch bei Professor ändern!!!!
					String querystab = "SELECT ID, Name, email, Hochschule, counter, Studiengruppe, Matrikelnummer From person p, student s WHERE (s.ID_P = p.ID) AND (Name = '"+studentname+"')";
					ResultSet rsperson = con.executequery_rs(querystab);
					
					
					//Was ist wenn zwei von ResultSet ausgewählt werden (z. b. bei gleichen Namen)
					Student person = new Student();
					while(rsperson.next()) { 
						person.setID(rsperson.getInt("ID"));
						person.setName(rsperson.getString("Name"));
						person.setEMail(rsperson.getString("email"));
						person.setHochschule(Hochschule.valueOf(rsperson.getString("Hochschule")));
						person.setCounter(rsperson.getInt("counter"));
						person.setStudiengruppe(Studiengruppe.valueOf(rsperson.getString("Studiengruppe")));
						person.setMatrikelnr(rsperson.getInt("Matrikelnummer"));
						
					}
					
					int idadr = person.getID();
					String queryatab = "SELECT Strasse, Hausnummer, PLZ, Ort FROM person p, adresse a WHERE (a.ID_Person = p.ID) AND (p.ID_Person = '" + idadr + "')";
					ResultSet rsadresse = con.executequery_rs(queryatab);
					
					Adresse adr = new Adresse();
					while(rsadresse.next()) {
						adr.setStrasse(rsadresse.getString("Strasse"));
						adr.setHausnr(rsadresse.getString("Hausnummer"));
						adr.setPlz(rsadresse.getInt("PLZ"));
						adr.setOrt(rsadresse.getString("Ort"));
					}
							
					boolean equalS = student.equalsst(person);
					boolean equalA = adresse.equalsAdr(adr);
					
					if(equalS == false && equalA == false) {
						//autoincrement auslesen
						idperson = con.executequery_autoKey(query, true);	
					
						String query2 = "INSERT INTO student(ID_P, Studiengruppe, Matrikelnummer)" + "VALUES('" + idperson +"','"+ student.getStudiengruppe() + "', '" + student.getMatrikelnr() + "')";

						boolean bool = con.executequery(query2);
						if(studentstrasse != null && studenthausnr != null && studentplz != 0 && studentort != null) {
							String queryadr = "INSERT INTO adresse(ID_Person, Strasse, Hausnummer, PLZ, Ort)" + "VALUES('" + idperson +"','"+ studentstrasse + "', '" + studenthausnr +"','" +studentplz+ "', '" +studentort+ "')";
							con.executequery(queryadr);
						} 
						if(bool) {
							//alle Felder wieder auf Null setzten um Doppelbuchungen zu vermeiden
							this.studentanl.setTextFieldName(null);
							this.studentanl.setTextFieldEmail(null);
							this.studentanl.setComboBoxHochschule(null);
							this.studentanl.setComboBoxStudiengruppe(null);
							this.studentanl.setTextFieldMatrikelnr(null);
							this.studentanl.setTextFieldStrasse(null);
							this.studentanl.setTextFieldHausnr(null);
							this.studentanl.setTextFieldPlz(null);
							this.studentanl.setTextFieldOrt(null);
							
							JOptionPane.showMessageDialog(new JFrame(), "Student " + student.getName() + " wurde mit folgender ID verbucht: " +idperson);
							con.disconnect();
						}
					
					}
					if(equalS == true && equalA == true) {
//TODO: 
						//Dann Dialogfeld ob Student trotzdem angelegt werden soll
						//Meldung: dass Name, etc übereinstimmt, nur keine Adresse vorhanden ist, dass fragen ob Adresse akualisiert werden soll
						//falls nein: Fehlermeldung
						//falls Ja: Student mit  neuer ID anlegen
						//autoincrement auslesen
						idperson = con.executequery_autoKey(query, true);	
					
						String query3 = "INSERT INTO student(ID_P, Studiengruppe, Matrikelnummer)" + "VALUES('" + idperson +"','"+ student.getStudiengruppe() + "', '" + student.getMatrikelnr() + "')";

						boolean bool2 = con.executequery(query3);
						if(studentstrasse != null && studenthausnr != null && studentplz != 0 && studentort != null) {
							String queryadr = "INSERT INTO adresse(ID_Person, Strasse, Hausnummer, PLZ, Ort)" + "VALUES('" + idperson +"','"+ studentstrasse + "', '" + studenthausnr +"','" +studentplz+ "', '" +studentort+ "')";
							con.executequery(queryadr);
						} 
						if(bool2) {
							//alle Felder wieder auf Null setzten um Doppelbuchungen zu vermeiden
							this.studentanl.setTextFieldName(null);
							this.studentanl.setTextFieldEmail(null);
							this.studentanl.setComboBoxHochschule(null);
							this.studentanl.setComboBoxStudiengruppe(null);
							this.studentanl.setTextFieldMatrikelnr(null);
							this.studentanl.setTextFieldStrasse(null);
							this.studentanl.setTextFieldHausnr(null);
							this.studentanl.setTextFieldPlz(null);
							this.studentanl.setTextFieldOrt(null);
							
							JOptionPane.showMessageDialog(new JFrame(), "Student " + student.getName() + " wurde mit folgender ID verbucht: " +idperson);
							con.disconnect();
					}
				
				}
				} catch (SQLException ex) {
					JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
				} catch (NullPointerException ex) {
					JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(new JFrame(),  ex.getMessage());
				}
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}	
	}
}
