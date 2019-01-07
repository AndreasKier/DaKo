package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTable; 
import javax.swing.DefaultComboBoxModel;

import anwendung.Hochschule;
import anwendung.Status;
import controller.BuchAnzController;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;

public class BuchAnzView extends JFrame {

	private JPanel contentPane;
	public JTableView tableview;
	public JComboBox comboBoxStatus;

	/**
	 * Create the frame.
	 */
	public BuchAnzView(ActionListener listen) {
		setTitle("Buch anzeigen");
		setBounds(100, 100, 886, 653);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBuchMitStatus = new JLabel("Buch mit Status ");
		lblBuchMitStatus.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblBuchMitStatus.setBounds(21, 108, 267, 39);
		contentPane.add(lblBuchMitStatus);
		
		comboBoxStatus = new JComboBox();
		comboBoxStatus.setFont(new Font("Tahoma", Font.PLAIN, 30));
		comboBoxStatus.setModel(new DefaultComboBoxModel(Status.values()));
		comboBoxStatus.setSelectedItem(null);
		comboBoxStatus.setBounds(292, 110, 257, 39);
		contentPane.add(comboBoxStatus);
		
		JButton btnAnzeigen = new JButton("anzeigen");
		btnAnzeigen.addActionListener(listen);
		btnAnzeigen.setFont(new Font("Tahoma", Font.PLAIN, 35));
		btnAnzeigen.setBounds(584, 102, 183, 51);
		contentPane.add(btnAnzeigen);
		
		JButton btnAlleAnzeigen = new JButton("alle anzeigen");
		btnAlleAnzeigen.addActionListener(listen);
		btnAlleAnzeigen.setFont(new Font("Tahoma", Font.PLAIN, 35));
		btnAlleAnzeigen.setBounds(500, 38, 267, 51);
		contentPane.add(btnAlleAnzeigen);
		
		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 35));
		btnBack.addActionListener(listen);
		btnBack.setBounds(21, 522, 159, 39);
		contentPane.add(btnBack);
		
		
	}
	
	public Status getComboBoxStatus() {
		Status status = (Status) comboBoxStatus.getSelectedItem();
		return status;
	}

	public void setComboBoxStatus(Status status) {
		this.comboBoxStatus.setSelectedItem(null);;
	}
	
	public void createTableall() {
		//if(tableview == null) {
			tableview = new JTableView(BuchAnzController.getAllBooks());
			JScrollPane scrollpane = new JScrollPane(tableview.getSQLTable());
			scrollpane.setBounds(40, 180, 700,285);
			contentPane.add(scrollpane);
		//}
	}
	
	public void createTableausgeliehen() {
		tableview = new JTableView(BuchAnzController.getBooksausgeliehen());
		JScrollPane scrollpane = new JScrollPane(tableview.getSQLTable());
		scrollpane.setBounds(40, 180, 700,285);
		contentPane.add(scrollpane);
	}
	
	public void createTableausleihbar() {
		tableview = new JTableView(BuchAnzController.getBooksausleihbar());
		JScrollPane scrollpane = new JScrollPane(tableview.getSQLTable());
		scrollpane.setBounds(40, 180, 700,285);
		contentPane.add(scrollpane);
	}
	
	public void createTablenichta() {
		tableview = new JTableView(BuchAnzController.getBooksnichta());
		JScrollPane scrollpane = new JScrollPane(tableview.getSQLTable());
		scrollpane.setBounds(40, 180, 700,285);
		contentPane.add(scrollpane);
	}
}
