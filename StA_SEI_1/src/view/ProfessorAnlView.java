package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import anwendung.Fakultaet;
import anwendung.Hochschule;
import anwendung.Studiengruppe;
import java.awt.Font;

public class ProfessorAnlView extends JFrame {

	private JPanel contentPane;
	private JTextField textField_Name;
	private JTextField textField_Email;
	private JTextField textField_Strasse;
	private JTextField textField_Hausnr;
	private JTextField textField_Plz;
	private JTextField textField_Ort;
	private JComboBox comboBox;
	private JComboBox comboBox_1;

	/**
	 * Create the frame.
	 */
	public ProfessorAnlView(ActionListener listen) {
		setTitle("neuen Benutzer Professor anlegen");
		setBounds(100, 100, 887, 726);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblName.setBounds(21, 106, 116, 37);
		contentPane.add(lblName);
		
		JLabel lblMatrikelnummer = new JLabel("Fakultaet");
		lblMatrikelnummer.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblMatrikelnummer.setBounds(21, 165, 165, 37);
		contentPane.add(lblMatrikelnummer);
		
		JLabel lblHochschule = new JLabel("Hochschule");
		lblHochschule.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblHochschule.setBounds(21, 223, 208, 45);
		contentPane.add(lblHochschule);
		
		JLabel lblEmail = new JLabel("E-Mail");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblEmail.setBounds(21, 283, 140, 37);
		contentPane.add(lblEmail);
		
		textField_Name = new JTextField();
		textField_Name.setFont(new Font("Tahoma", Font.PLAIN, 35));
		textField_Name.setBounds(300, 102, 208, 45);
		contentPane.add(textField_Name);
		textField_Name.setColumns(10);
		
		comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 35));
		comboBox.setModel(new DefaultComboBoxModel(Hochschule.values()));
		comboBox.setSelectedItem(null);
		comboBox.setBounds(300, 223, 208, 45);
		contentPane.add(comboBox);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 35));
		comboBox_1.setModel(new DefaultComboBoxModel(Fakultaet.values()));
		comboBox_1.setSelectedItem(null);
		comboBox_1.setBounds(300, 167, 208, 45);
		contentPane.add(comboBox_1);
		
		textField_Email = new JTextField();
		textField_Email.setFont(new Font("Tahoma", Font.PLAIN, 35));
		textField_Email.setBounds(301, 279, 207, 45);
		contentPane.add(textField_Email);
		textField_Email.setColumns(10);
		
		JLabel lblAdresse = new JLabel("Adresse");
		lblAdresse.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblAdresse.setBounds(21, 345, 140, 37);
		contentPane.add(lblAdresse);
		
		JLabel lblStrasse = new JLabel("Strasse");
		lblStrasse.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblStrasse.setBounds(322, 345, 140, 37);
		contentPane.add(lblStrasse);
		
		JLabel lblHausnummer = new JLabel("Hausnummer");
		lblHausnummer.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblHausnummer.setBounds(322, 402, 216, 37);
		contentPane.add(lblHausnummer);
		
		textField_Strasse = new JTextField();
		textField_Strasse.setFont(new Font("Tahoma", Font.PLAIN, 35));
		textField_Strasse.setBounds(549, 341, 207, 45);
		contentPane.add(textField_Strasse);
		textField_Strasse.setColumns(10);
		
		JLabel lblPlz = new JLabel("PLZ");
		lblPlz.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblPlz.setBounds(322, 460, 92, 37);
		contentPane.add(lblPlz);
		
		JLabel lblOrt = new JLabel("Ort");
		lblOrt.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblOrt.setBounds(322, 521, 106, 37);
		contentPane.add(lblOrt);
		
		textField_Hausnr = new JTextField();
		textField_Hausnr.setFont(new Font("Tahoma", Font.PLAIN, 35));
		textField_Hausnr.setBounds(549, 398, 207, 45);
		contentPane.add(textField_Hausnr);
		textField_Hausnr.setColumns(10);
		
		textField_Plz = new JTextField();
		textField_Plz.setFont(new Font("Tahoma", Font.PLAIN, 35));
		textField_Plz.setBounds(549, 459, 207, 45);
		contentPane.add(textField_Plz);
		textField_Plz.setColumns(10);
		
		textField_Ort = new JTextField();
		textField_Ort.setFont(new Font("Tahoma", Font.PLAIN, 35));
		textField_Ort.setBounds(549, 517, 207, 45);
		contentPane.add(textField_Ort);
		textField_Ort.setColumns(10);
		
		JButton btnSpeichern = new JButton("Speichern");
		btnSpeichern.setFont(new Font("Tahoma", Font.PLAIN, 35));
		btnSpeichern.addActionListener(listen);
		btnSpeichern.setBounds(592, 589, 200, 45);
		contentPane.add(btnSpeichern);
		
		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 35));
		btnBack.addActionListener(listen);
		btnBack.setBounds(21, 589, 179, 45);
		contentPane.add(btnBack);
		
		JLabel lblDatenStudentEingeben = new JLabel("Daten Professor eingeben:");
		lblDatenStudentEingeben.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblDatenStudentEingeben.setBounds(21, 21, 433, 37);
		contentPane.add(lblDatenStudentEingeben);
		
		JLabel lbloptional = new JLabel("(optional)");
		lbloptional.setBounds(31, 388, 106, 32);
		contentPane.add(lbloptional);
	}

	//getter/setter Enum
			
	public Fakultaet getComboBoxFakultaet() {
		Fakultaet fakultaet = (Fakultaet) comboBox_1.getSelectedItem();
		return fakultaet; 
	}
		
	public void setComboBoxFakultaet(Fakultaet fakultaet) {
		this.comboBox.setSelectedItem(null);
	}
	
	public Hochschule getComboBoxHochschule() {
		Hochschule hochschule = (Hochschule) comboBox.getSelectedItem();
		return hochschule; 
	}
		
	public void setComboBoxHochschule(Hochschule hochschule) {
		this.comboBox.setSelectedItem(null);
	}
		
	//getter/setter Eingabefelder
	public String getTextFieldName() {
		String name = textField_Name.getText();
		return name;
	}

	public void setTextFieldName(String name) {
		this.textField_Name.setText(name);
	}

	public String getTextFieldEmail() {
		String email = textField_Email.getText();
		return email;
	}

	public void setTextFieldEmail(String email) {
		this.textField_Email.setText(email);
	}

	public String getTextFieldStrasse() {
		String strasse = textField_Strasse.getText();
		return strasse;
	}

	public void setTextFieldStrasse(String strasse) {
		this.textField_Strasse.setText(strasse);;
	}

	public String getTextFieldHausnr() {
		String hausnr = textField_Hausnr.getText();
		return hausnr;
	}

	public void setTextFieldHausnr(String hausnr) {
		this.textField_Hausnr.setText(hausnr);;
	}

//		public String getTextFieldPlz() {
//			String plz = textField_PLZ.getText();
//			return plz;
//		}
	public int getTextFieldPlz() {
		int plz = 0; 
		String stringplz = textField_Plz.getText();
		try {
			if(stringplz.length()>0) 
				plz = Integer.parseInt(stringplz);
		} catch (NumberFormatException n) {
			plz = 0;
		}
		return plz; 
	}
		
	public void setTextFieldPlz(String plz) {
		this.textField_Plz.setText(plz);;
	}

	public String getTextFieldOrt() {
		String ort = textField_Ort.getText();
		return ort;
	}

	public void setTextFieldOrt(String ort) {
		this.textField_Ort.setText(ort);;
	}
}