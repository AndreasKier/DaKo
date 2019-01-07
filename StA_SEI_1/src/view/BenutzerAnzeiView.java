package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;
import java.awt.Font;
import javax.swing.JLabel;

public class BenutzerAnzeiView extends JFrame {

	private JPanel contentPane;
	public JTableView tableview;

	/**
	 * Create the frame.
	 */
	public BenutzerAnzeiView(ActionListener listen) {
		setTitle("Benutzer anzeigen");
		setBounds(100, 100, 704, 659);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 35));
		btnBack.addActionListener(listen);
		btnBack.setBounds(21, 525, 172, 42);
		contentPane.add(btnBack);
		
		JLabel lblAlleBenutzer = new JLabel("alle Benutzer:");
		lblAlleBenutzer.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblAlleBenutzer.setBounds(21, 21, 253, 42);
		contentPane.add(lblAlleBenutzer);
		
	
		if(tableview == null) {
			tableview = new JTableView(getAllUsers());
			JScrollPane scrollpane = new JScrollPane(tableview.getSQLTable());
			scrollpane.setBounds(43, 120, 599,285);
			contentPane.add(scrollpane);
	
		}
	}
	
	//define generic SQl query for table student (Ubungsblatt 5, Uebung_ButtonHandler, seite 3)
	public static String getAllUsers() {
		return "SELECT * FROM person";
	}
}
