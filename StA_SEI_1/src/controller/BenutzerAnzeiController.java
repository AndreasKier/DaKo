package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

import javax.swing.*;
import db_connection.*;
import view.*;

public class BenutzerAnzeiController implements ActionListener {
	private BenutzerAnzeiView benutzeranzei = new BenutzerAnzeiView(this);
	public JTableView tableview; 
	
	public void benutzeranzei() {
		try {
			benutzeranzei.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void actionPerformed(ActionEvent e) {
		benutzeranzei.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		try {
			if(e.getActionCommand().equals("Back")) {
				benutzeranzei.setVisible(false);
			}
		} catch (Exception e1){
			e1.printStackTrace();
		}
		
	}
	
	

}
