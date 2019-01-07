package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import view.*;
import anwendung.*;

public class BuchAnzController implements ActionListener {
	private BuchAnzView buchanz = new BuchAnzView(this);
//	private Status status = buchanz.getComboBoxStatus();
//	private JTableView tableview;
	
	public void buchanz() {
		try {
			buchanz.setVisible(true);;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void actionPerformed(ActionEvent e) {
		buchanz.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		try {
			if(e.getActionCommand().equals("Back")) {
				buchanz.setVisible(false);
			}
			
			if(e.getActionCommand().equals("alle anzeigen")) {
				buchanz.createTableall();
			}
			if(e.getActionCommand().equals("anzeigen")) {
				try {
					Status status = buchanz.getComboBoxStatus();
					if(status.equals(Status.ausleihbar)) {
						buchanz.createTableausleihbar();
					}
					if(status.equals(Status.ausgeliehen)) {
						buchanz.createTableausgeliehen();
					}
					if(status.equals(Status.nicht_ausleihbar)) {
						buchanz.createTablenichta();
					}
					if(status.equals(null)) {
						JOptionPane.showMessageDialog(new JFrame(), "Wählen Sie einen Status aus");
					}
				}
				catch (Exception ex) {
					ex.printStackTrace();
				}
					
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
	}
	
//	public Status getStatus() {
//		return status;
//	}
//
//	public void setStatus(Status status) {
//		this.status = status;
//	}

	//define generic SQl query for table student (Ubungsblatt 5, Uebung_ButtonHandler, seite 3)
	public static String getAllBooks() {
//		return "SELECT ID_Buch, Titel, Autor, ISBN, Status  FROM buch";
		return "SELECT ID_Bex, Titel, Autor, b.ISBN, Seriennummer, Status FROM buch b, buchexemplar ex WHERE b.ISBN = ex.ISBN";
	}
	
	public static String getBooksausgeliehen() {
//		return  "SELECT ID_Buch, Titel, Autor, ISBN, Status  FROM buch WHERE Status = 'ausgeliehen'";
		return "SELECT ID_Bex, Titel, Autor, b.ISBN, Seriennummer, Status FROM buch b, buchexemplar ex WHERE ((b.ISBN = ex.ISBN) AND (Status = 'ausgeliehen'))";

	}
	
	public static String getBooksausleihbar() {
//		return "SELECT ID_Buch, Titel, Autor, ISBN, Status  FROM buch WHERE Status = 'ausleihbar'";
		return "SELECT ID_Bex, Titel, Autor, b.ISBN, Seriennummer, Status FROM buch b, buchexemplar ex WHERE ((b.ISBN = ex.ISBN) AND (Status = 'ausleihbar'))";
	}
	
	public static String getBooksnichta() {
//		return "SELECT ID_Buch, Titel, Autor, ISBN, Status  FROM buch WHERE Status = 'nicht_ausleihbar'";
		return "SELECT ID_Bex, Titel, Autor, b.ISBN, Seriennummer, Status FROM buch b, buchexemplar ex WHERE ((b.ISBN = ex.ISBN) AND (Status = 'nicht_ausleihbar'))";
	}
	
//	public void selectEnum() {
//		if(status.equals(Status.ausleihbar)) {
//			tableview = new JTableView(getBooksausleihbar());
//		}
//		if(status.equals(Status.ausgeliehen)) {
//			tableview = new JTableView(getBooksausgeliehen());
//		}
//		if(status.equals(Status.nicht_ausleihbar)) {
//			tableview = new JTableView(getBooksnichta());
//		}
//		else{
//			JOptionPane.showMessageDialog(new JFrame(), "Wählen Sie einen Status aus");
//		}
//	}
//
//	public JTableView getTableview() {
//		return tableview;
//	}
//
//	public void setTableview(JTableView tableview) {
//		this.tableview = tableview;
//	}
//	
//	
//	
//	public String selectEnum() {
//		String st = null;
//		if(status.equals(Status.ausleihbar)) {
//			st = getBooksausleihbar();
//		}
//		if(status.equals(Status.ausgeliehen)) {
//			st = getBooksausgeliehen();
//		}
//		if(status.equals(Status.nicht_ausleihbar)) {
//			st = getBooksnichta();
//		}
//		else{
//			JOptionPane.showMessageDialog(new JFrame(), "Wählen Sie einen Status aus");
//		}
//		return st;
//	}
	
//	public String getEnum() {
//		String sqlcommand = null;
//		BuchAnzController object = new BuchAnzController();
//		Status sta = object.status;
//		if(sta.equals(Status.ausgeliehen)) {
//			sqlcommand = "SELECT ID_Buch, Titel, Autor, ISBN, Status  FROM buch WHERE Status = ausgeliehen";
//		}
//		
//		if(sta.equals(Status.ausleihbar)) {
//			sqlcommand = "SELECT ID_Buch, Titel, Autor, ISBN, Status  FROM buch WHERE Status = ausleihbar";
//		}
//		
//		if(sta.equals(Status.nicht_ausleihbar)) {
//			sqlcommand = "SELECT ID_Buch, Titel, Autor, ISBN, Status  FROM buch WHERE Status = nicht_ausleihbar";
//		}
//		
//		else {
//			JOptionPane.showMessageDialog(new JFrame(), "Wählen Sie einen Status aus");
//		}
//		return sqlcommand;
//	}
}
