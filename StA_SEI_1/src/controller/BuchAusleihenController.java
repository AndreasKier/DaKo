package controller;

import view.*;
import anwendung.*;
import db_connection.DB_Connection;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/* TODO:
 * Exceptions fehlen noch
 * es sollen Dialogfelder mit der Fehlermeldung ausgegeben werden
 * verschiedenen Eingaben prüfen/testen
 * soll es von hier aus die Möglichkeit geben, eine Person/Buch anzulegen und dann den Prozess ausleihe fortzuführen?
 */

public class BuchAusleihenController implements ActionListener {
	private BuchAusleihenView buchausl = new BuchAusleihenView(this);
	private Buchexemplar buchexemplar;
	
	public void buchausl() {
		try {
			buchausl.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void actionPerformed(ActionEvent e) {
		buchausl.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		try {
			if(e.getActionCommand().equals("Back")) {
				buchausl.setVisible(false);
			} 
			if(e.getActionCommand().equals("ausleihen")) {
				int idbuchex = buchausl.getTextField_IDBuch();
				int idbenutzer = buchausl.getTextField_IDBenutzer();
//				try {
					if(idbuchex != 0 && idbenutzer != 0) {
						//Datenbankanbindung! (Beispiel aus uebung 5 ButtonHandler methode actionPerformed
						DB_Connection con = DB_Connection.getDbConnection();
						
//						String queryp = "SELECT p.ID, Name, email, Hochschule From person p, ausleihen a WHERE (p.ID = a.ID_Person)";
//						String queryb = "SELECT e.ID_Bex, Titel, Autor, ISBN, Status FROM buchexemplar e, buch b, ausleihen a WHERE (e.ID_Bex = a.ID_Buchex) AND (e.ID_B = b.ID_Buch)";
						
						String queryp = "SELECT ID, Name, email, Hochschule, counter From person WHERE (ID = '"+idbenutzer+"')";
						String queryb = "SELECT e.ID_Bex, Titel, Autor, b.ISBN, Status FROM buch b, buchexemplar e WHERE (e.ID_Bex = '"+idbuchex+"') AND (b.ISBN = e.ISBN)";
						
						
						ResultSet rsperson = con.executequery_rs(queryp);
						ResultSet rsbuch  = con.executequery_rs(queryb);
						
						Hochschulperson person = new Hochschulperson();
						while(rsperson.next()) { 
							person.setID(rsperson.getInt("ID"));
							person.setName(rsperson.getString("Name"));
							person.setEMail(rsperson.getString("email"));
							person.setHochschule(Hochschule.valueOf(rsperson.getString("Hochschule")));
							person.setCounter(rsperson.getInt("counter"));
							
						}
						
						Buchexemplar bex = new Buchexemplar();
						while(rsbuch.next()) {
							bex.setId_bex(rsbuch.getInt("ID_Bex"));
							bex.setTitel(rsbuch.getString("Titel"));
							bex.setAutor(rsbuch.getString("Autor"));
							bex.setISBN(rsbuch.getString("ISBN"));
							bex.setStatus(Status.valueOf(rsbuch.getString("Status")));
						}
						
						// Prüfen ob Buch bereits ausgeliehen ist und ob Benutzer bereits zwei bücher ausgeliehen hat
//							String queryanzahl = "SELECT counter FROM Person WHERE (ID = '" + person.getID() +"')";
//							ResultSet rsanzahl = con.executequery_rs(queryanzahl);
						
//							rsanzahl.first();
//							int anzahl = rsanzahl.getInt(1);
							int anzahl = person.getCounter();
							boolean an = person.ausleihen(anzahl);
						
//							String querystatus = "SELECT status FROM buchexemplar WHERE (ID_Bex = '" + bex.getStatus() + " ')";
//							ResultSet rsstatus = con.executequery_rs(querystatus);
						
//							rsstatus.first();
//							String sta = rsstatus.getString(1);
							Status sta = bex.getStatus();
							boolean st = bex.ausleihen(sta);
							
							String query = "INSERT INTO ausleihen(ID_Person, ID_Buchex)" + "VALUES('"+ idbenutzer + " ', '"+ idbuchex  +"')";
							
							
							if(an == true && st == true) {
								boolean bool = con.executequery(query);
								int count = person.ausgeliehen(anzahl);
								Status stat = bex.ausgeliehen();
								String queryUpAn = "UPDATE person SET counter = '" + count + " ' WHERE (ID = '" + person.getID() + "')";
								String queryUpSt = "UPDATE buchexemplar SET Status = '" + stat + " ' WHERE (ID_Bex = '" + bex.getId_bex() + " ')";	
								boolean bool1 = con.executequery(queryUpAn);
								boolean bool2 = con.executequery(queryUpSt);
								
							if(bool) {
								//alle Felder wieder auf Null setzten um Doppelbuchungen zu vermeiden
								this.buchausl.setTextField_IDBuch(null);
								this.buchausl.setTextField_IDBenutzer(null);
							
								JOptionPane.showMessageDialog(new JFrame(), "Der Benutzer " + person.getName() + ", mit ID " + person.getID() + " hat das Buch " + bex.getTitel() + " mit der ID "+ bex.getId_bex() + " ausgeliehen");
								con.disconnect();
							}
							//folgendes mit Exceptions lösen????
//						} else if(bex.getStatus().equals(Status.ausgeliehen)) {
//							JOptionPane.showMessageDialog(new JFrame(), "Der Benutzer " + person.getName() + " kan dieses Buch " + bex.getTitel() +" nicht ausleihen. Es ist als ausgeliehen markiert!");
//
//						} else if(anzahl>= 2) {
//							JOptionPane.showMessageDialog(new JFrame(), "Der Benutzer " + person.getName() + " hat die maximale Anzahl an ausleihbaren Büchern überschritten. Buch " + bex.getTitel() +" wurde nicht ausgeliehen!");
						}
	
						else {
							throw new IOException("Überprüfe die Eingabe!");
						}
					} else
						throw new NullPointerException();
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

}
