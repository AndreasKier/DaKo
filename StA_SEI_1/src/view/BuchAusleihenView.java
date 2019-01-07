package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class BuchAusleihenView extends JFrame {

	private JPanel contentPane;
	private JTextField textField_IDBenutzer;
	private JTextField textField_IDBuch;

	/**
	 * Create the frame.
	 */
	public BuchAusleihenView(ActionListener listen) {
		setTitle("Buch ausleihen");
		setBounds(100, 100, 858, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBuchIdEingeben = new JLabel("Buch ID eingeben");
		lblBuchIdEingeben.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblBuchIdEingeben.setBounds(32, 136, 344, 53);
		contentPane.add(lblBuchIdEingeben);
		
		JLabel lblBenutzerIdEingeben = new JLabel("Benutzer ID eingeben");
		lblBenutzerIdEingeben.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblBenutzerIdEingeben.setBounds(34, 69, 365, 47);
		contentPane.add(lblBenutzerIdEingeben);
		
		textField_IDBenutzer = new JTextField();
		textField_IDBenutzer.setFont(new Font("Tahoma", Font.PLAIN, 35));
		textField_IDBenutzer.setBounds(480, 68, 229, 49);
		contentPane.add(textField_IDBenutzer);
		textField_IDBenutzer.setColumns(10);
		
		textField_IDBuch = new JTextField();
		textField_IDBuch.setFont(new Font("Tahoma", Font.PLAIN, 35));
		textField_IDBuch.setBounds(480, 138, 229, 49);
		contentPane.add(textField_IDBuch);
		textField_IDBuch.setColumns(10);
		
		JButton btnAusleihen = new JButton("ausleihen");
		btnAusleihen.setFont(new Font("Tahoma", Font.PLAIN, 35));
		btnAusleihen.addActionListener(listen);
		btnAusleihen.setBounds(494, 297, 194, 51);
		contentPane.add(btnAusleihen);
		
		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 35));
		btnBack.addActionListener(listen);
		btnBack.setBounds(82, 297, 176, 51);
		contentPane.add(btnBack);
	}

	public int getTextField_IDBenutzer() {
		int id = 0; 
		String idbenutzer = textField_IDBenutzer.getText();
		try {
			if(idbenutzer.length()>0) 
				id = Integer.parseInt(idbenutzer);
		} catch (NumberFormatException n) {
			id = 0;
		}
		return id;
	}

	public void setTextField_IDBenutzer(String idbenutzer) {
		this.textField_IDBenutzer.setText(idbenutzer);;
	}

	public int getTextField_IDBuch() {
		int id = 0;
		String idbuch = textField_IDBuch.getText();
		try {
			if(idbuch.length()>0)
				id = Integer.parseInt(idbuch);
		} catch (NumberFormatException n) {
			id = 0;
		}
		return id;
	}

	public void setTextField_IDBuch(String idbuch) {
		this.textField_IDBuch.setText(idbuch);;
	}
	
}
