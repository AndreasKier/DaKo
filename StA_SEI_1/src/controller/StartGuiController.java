package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import view.*;

/*soll GUI noch verschönert werden?
 * 
 */

public class StartGuiController implements ActionListener{
	
	private StartGUIView startgui;
	
	public void startGui () {
		try {
			startgui = new StartGUIView(this);
			startgui.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void actionPerformed(ActionEvent e) {
		startgui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		try {
			//neues Fenster oeffnen bei Buch inventarisieren
			if(e.getActionCommand().equals("Buch inventarisieren")) {
				BuchInvController buchinvco = new BuchInvController();
				buchinvco.buchinv();
			}
			//neues Fenster oeffnen bei Benutzer anlegen
			//Dialogfeld: Möchten Sie einen Studenten oder Professor anlegen
			if(e.getActionCommand().equals("Benutzer anlegen")) {
				BenAnlDialogController benanldialogco = new BenAnlDialogController();
				benanldialogco.benanldialog();
			}
			//neues Fenster oeffnen bei Buch anzeigen
			if(e.getActionCommand().equals("Buch anzeigen")) {
				BuchAnzController buchanzco = new BuchAnzController();
				buchanzco.buchanz();
			}
			//neues Fenster oeffnen bei Benutzer anzeigen
			if(e.getActionCommand().equals("Benutzer anzeigen")) {
				BenutzerAnzeiController benutzeranzeico = new BenutzerAnzeiController();
				benutzeranzeico.benutzeranzei();
			}
			//neues Fenster oeffnen bei Buch ausleihen
			if(e.getActionCommand().equals("Buch ausleihen")) {
				BuchAusleihenController buchauslco = new BuchAusleihenController();
				buchauslco.buchausl();
			}
			
		} catch (NullPointerException ex) {
			throw new NullPointerException("Fehler");
		}
	}
	
}
