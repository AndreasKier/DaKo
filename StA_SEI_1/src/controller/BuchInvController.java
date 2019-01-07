package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import view.*;
import anwendung.*;
import db_connection.DB_Connection; 

/*Wie soll es bei vorhandenen Buchtyp eingegeben werden?
 * reicht es dann den Titel einzugeben zu an auszuwählen?
 * TODO:
 * Exceptions werfen mit Fehler im Dialogfeld
 * 
 */

public class BuchInvController implements ActionListener{
	private BuchInvView buchinv = new BuchInvView(this);
	private Buchexemplar buchexemplar; 
	
	public void buchinv() {
		try {
			buchinv.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		buchinv.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		try {
			if(e.getActionCommand().equals("Back")) {
				buchinv.setVisible(false);
			} 
			if(e.getActionCommand().equals("Buch anlegen")) {
				//neues Object Buchexemplar erzeugen
			}
			if(e.getActionCommand().equals("Speichern")) {
				String buchtitel = buchinv.getTextFieldTitel();
				String buchautor = buchinv.getTextFieldAutor();
				String buchisbn = buchinv.getTextFieldIsbn(); 
				Status buchstatus = buchinv.getComboBoxstatus();
				int buchseriennr = Integer.parseInt(buchinv.getTextFieldSeriennr()); 
				buchexemplar = new Buchexemplar(buchtitel, buchautor, buchisbn, buchstatus, buchseriennr);
				
				//Prüfen ob das Buch bereits vorhanden ist, 
				//evtl nur Buchexemplar anlegen wenn Buch bereits vorhanden ist
				//Exemplaranzahl in die Tabelle einfügen?
				
				//Datenbankanbindung! (Beispiel aus uebung 5 ButtonHandler methode actionPerformed
				DB_Connection con = DB_Connection.getDbConnection();
				String query = "INSERT INTO buch(Titel, Autor, ISBN, Status)" + "VALUES('"+ buchexemplar.getTitel() + " ', '"+ buchexemplar.getAutor() + "', '"+buchexemplar.getISBN() +"','"+ buchexemplar.getStatus() +"')";
				
				int idbuch = 0;
				idbuch = con.executequery_autoKey(query, true);	
				
				String query2 = "INSERT INTO buchexemplar(ID_B, Seriennummer)" + "VALUES('" + idbuch +"','"+ buchexemplar.getSeriennr() + "')";
				
				boolean bool = con.executequery(query2);
					if(bool) {
						//alle Felder wieder auf Null setzten um Doppelbuchungen zu vermeiden
						this.buchinv.setTextFieldTitel(null);
						this.buchinv.setTextFieldAutor(null);
						this.buchinv.setTextFieldIsbn(null);
						this.buchinv.setComboBoxStatus(null);
						this.buchinv.setTextFieldSeriennr(null);
						
						JOptionPane.showMessageDialog(new JFrame(), "Buch " + buchexemplar.getTitel() + " wurde mit folgender ID verbucht: " + idbuch);
						con.disconnect();
					}
			}
		} catch (Exception e1) {
				e1.printStackTrace();
			
		}
	}	

}
