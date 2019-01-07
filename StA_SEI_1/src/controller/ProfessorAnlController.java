package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import anwendung.*;
import db_connection.DB_Connection;
import view.*;

/*stimmt so noch nicht 
 * TODO:
 * muss dann angepasst werden wie in student
 *(Doppelanlegung abfragen/Prüfen etc. 
 * 
 */

public class ProfessorAnlController implements ActionListener {
	private ProfessorAnlView professoranl = new ProfessorAnlView(this);
	private Professor professor;
	
	public void professoranl() {
		try {
			professoranl.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void actionPerformed(ActionEvent e) {
		professoranl.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		try {
			if(e.getActionCommand().equals("Back")) {
				professoranl.setVisible(false);
			}
			if(e.getActionCommand().equals("Speichern")) {
				try {
					String professorname = professoranl.getTextFieldName();
					String professoremail = professoranl.getTextFieldEmail();
					Fakultaet professorfakultaet = professoranl.getComboBoxFakultaet();
					Hochschule professorhochschule = professoranl.getComboBoxHochschule();
					String professorstrasse = professoranl.getTextFieldStrasse();
					String professorhausnr = professoranl.getTextFieldHausnr(); 
					int professorplz = professoranl.getTextFieldPlz();
					String professorort = professoranl.getTextFieldOrt();
					int counter = 0;
					
					if(professorstrasse == null && professorhausnr == null && professorplz == 0 && professorort == null)
						professor = new Professor(professorname, professoremail, professorhochschule, professorfakultaet, counter);
					else if(professorstrasse != "" && professorhausnr != "" && professorplz != 0 && professorort != "")
						professor = new Professor(professorname, professoremail, professorhochschule, professorfakultaet, professorstrasse, professorhausnr, professorplz, professorort, counter);
					
					//Datenbankanbindung! (Beispiel aus uebung 5 ButtonHandler methode actionPerformed
					DB_Connection con = DB_Connection.getDbConnection();
					String query = "INSERT INTO person(Name, email, Hochschule)" + "VALUES('"+ professor.getName() + " ', '"+ professor.getEMail() + "', '"+professor.getHochschule() +"')";
					int idperson = 0;
					idperson = con.executequery_autoKey(query, true);
					String query2 = "INSERT INTO professor(ID_P, Fakultaet)" + "VALUES('" + idperson +"','"+ professor.getFakultaet() + "')";
					boolean bool = con.executequery(query);
					
					if(professorstrasse != null && professorhausnr != null && professorplz != 0 && professorort != null) {
						String queryadr = "INSERT INTO adresse(ID_Person, Strasse, Hausnummer, PLZ, Ort)" + "VALUES('" + idperson +"','"+ professorstrasse + "', '" + professorhausnr +"','" +professorplz+ "', '" +professorort+ "')";
						con.executequery(queryadr);
					}
					
						if(bool) {
							//alle Felder wieder auf Null setzten um Doppelbuchungen zu vermeiden
							this.professoranl.setTextFieldName(null);
							this.professoranl.setTextFieldEmail(null);
							this.professoranl.setComboBoxHochschule(null);
							this.professoranl.setComboBoxFakultaet(null);
							this.professoranl.setTextFieldStrasse(null);
							this.professoranl.setTextFieldHausnr(null);
							this.professoranl.setTextFieldPlz(null);
							this.professoranl.setTextFieldOrt(null);
						
							JOptionPane.showMessageDialog(new JFrame(), "Professor " + professor.getName() + " wurde mit folgender ID verbucht: "+idperson);
							con.disconnect();
						}
			
				} catch (SQLException ex) {
					JOptionPane.showMessageDialog(new JFrame(), ex);
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
