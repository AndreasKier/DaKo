package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;

import view.*;

public class BenAnlDialogController implements ActionListener {
	private BenAnlDialogView benanldialog = new BenAnlDialogView(this);
	
	public void benanldialog() {
		try {
			benanldialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
 	}

	@Override
	public void actionPerformed(ActionEvent e) {
		benanldialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		try {
			if(e.getActionCommand().equals("Student")) {
				StudentAnlController studentanlco = new StudentAnlController();
				studentanlco.studentanl();
				benanldialog.setVisible(false);
			} else if(e.getActionCommand().equals("Professor")) {
				ProfessorAnlController professoranlco = new ProfessorAnlController();
				professoranlco.professoranl();
				benanldialog.setVisible(false);
			} else if(e.getActionCommand().equals("Cancel")) {
				benanldialog.setVisible(false);
			}
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		
	}

}
