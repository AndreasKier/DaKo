package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import anwendung.Hochschule;
import anwendung.Studiengruppe;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class StudentAnlView extends JFrame {

	private JPanel contentPane;
	private JTextField textField_Name;
	private JTextField textField_Matrikelnr;
	private JTextField textField_Email;
	private JTextField textField_Strasse;
	private JTextField textField_Hausnr;
	private JTextField textField_PLZ;
	private JTextField textField_Ort;
	private JComboBox comboBox;
	private JComboBox comboBox_1;

	/**
	 * Create the frame.
	 */
	public StudentAnlView(ActionListener listen) {
		setTitle("neuen Benutzer Student anlegen");
		setBounds(100, 100, 885, 715);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblName.setBounds(21, 71, 116, 37);
		contentPane.add(lblName);
		
		JLabel lblMatrikelnummer = new JLabel("Matrikelnr.");
		lblMatrikelnummer.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblMatrikelnummer.setBounds(21, 126, 240, 40);
		contentPane.add(lblMatrikelnummer);
		
		JLabel lblHochschule = new JLabel("Hochschule");
		lblHochschule.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblHochschule.setBounds(21, 187, 226, 35);
		contentPane.add(lblHochschule);
		
		JLabel lblNewLabel = new JLabel("Studiengruppe");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblNewLabel.setBounds(21, 243, 240, 40);
		contentPane.add(lblNewLabel);
		
		JLabel lblEmail = new JLabel("E-Mail");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblEmail.setBounds(21, 304, 140, 42);
		contentPane.add(lblEmail);
		
		textField_Name = new JTextField();
		textField_Name.setFont(new Font("Tahoma", Font.PLAIN, 35));
		textField_Name.setBounds(282, 68, 201, 43);
		contentPane.add(textField_Name);
		textField_Name.setColumns(10);
		
		textField_Matrikelnr = new JTextField();
		textField_Matrikelnr.setFont(new Font("Tahoma", Font.PLAIN, 35));
		textField_Matrikelnr.setBounds(282, 124, 201, 42);
		contentPane.add(textField_Matrikelnr);
		textField_Matrikelnr.setColumns(10);
		

		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(Hochschule.values()));
		comboBox.setSelectedItem(null);
		comboBox.setBounds(282, 187, 201, 42);
		contentPane.add(comboBox);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(Studiengruppe.values()));
		comboBox_1.setSelectedItem(null);
		comboBox_1.setBounds(282, 241, 201, 42);
		contentPane.add(comboBox_1);
		
		textField_Email = new JTextField();
		textField_Email.setFont(new Font("Tahoma", Font.PLAIN, 35));
		textField_Email.setBounds(282, 304, 201, 42);
		contentPane.add(textField_Email);
		textField_Email.setColumns(10);
		
		JLabel lblAdresse = new JLabel("Adresse");
		lblAdresse.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblAdresse.setBounds(21, 351, 140, 47);
		contentPane.add(lblAdresse);
		
		JLabel lblStrasse = new JLabel("Strasse");
		lblStrasse.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblStrasse.setBounds(282, 357, 157, 35);
		contentPane.add(lblStrasse);
		
		JLabel lblHausnummer = new JLabel("Hausnummer");
		lblHausnummer.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblHausnummer.setBounds(282, 408, 226, 35);
		contentPane.add(lblHausnummer);
		
		textField_Strasse = new JTextField();
		textField_Strasse.setFont(new Font("Tahoma", Font.PLAIN, 35));
		textField_Strasse.setBounds(506, 353, 201, 42);
		contentPane.add(textField_Strasse);
		textField_Strasse.setColumns(10);
		
		JLabel lblPlz = new JLabel("PLZ");
		lblPlz.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblPlz.setBounds(282, 464, 92, 32);
		contentPane.add(lblPlz);
		
		JLabel lblOrt = new JLabel("Ort");
		lblOrt.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblOrt.setBounds(282, 517, 107, 35);
		contentPane.add(lblOrt);
		
		textField_Hausnr = new JTextField();
		textField_Hausnr.setFont(new Font("Tahoma", Font.PLAIN, 35));
		textField_Hausnr.setBounds(506, 409, 201, 42);
		contentPane.add(textField_Hausnr);
		textField_Hausnr.setColumns(10);
		
		textField_PLZ = new JTextField();
		textField_PLZ.setFont(new Font("Tahoma", Font.PLAIN, 35));
		textField_PLZ.setBounds(506, 461, 201, 42);
		contentPane.add(textField_PLZ);
		textField_PLZ.setColumns(10);
		
		textField_Ort = new JTextField();
		textField_Ort.setFont(new Font("Tahoma", Font.PLAIN, 35));
		textField_Ort.setBounds(505, 513, 202, 42);
		contentPane.add(textField_Ort);
		textField_Ort.setColumns(10);
		
		JButton btnspeichern = new JButton("Speichern");
		btnspeichern.setFont(new Font("Tahoma", Font.PLAIN, 35));
		btnspeichern.addActionListener(listen);
		btnspeichern.setBounds(515, 579, 192, 47);
		contentPane.add(btnspeichern);
		
		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 35));
		btnBack.addActionListener(listen);
		btnBack.setBounds(21, 581, 179, 42);
		contentPane.add(btnBack);
		
		JLabel lblDatenStudentEingeben = new JLabel("Daten Student eingeben:");
		lblDatenStudentEingeben.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblDatenStudentEingeben.setBounds(21, 21, 435, 47);
		contentPane.add(lblDatenStudentEingeben);
		
		JLabel lbloptional = new JLabel("(optional)");
		lbloptional.setBounds(31, 408, 92, 26);
		contentPane.add(lbloptional);
	}

	//getter/setter Enums
	
	public Hochschule getComboBoxHochschule() {
		Hochschule hochschule = (Hochschule) comboBox.getSelectedItem();
		return hochschule; 
	}
	
	public void setComboBoxHochschule(Hochschule hochschule) {
		this.comboBox.setSelectedItem(null);
	}
	
	public Studiengruppe getComboBoxStudiengruppe() {
		Studiengruppe studiengruppe = (Studiengruppe) comboBox_1.getSelectedItem();
		return studiengruppe; 
	}
	
	public void setComboBoxStudiengruppe(Studiengruppe studiengruppe) {
		this.comboBox_1.setSelectedItem(null);
	}
	
	//getter/setter Eingabefelder
	public String getTextFieldName() {
		String name = textField_Name.getText();
		return name;
	}

	public void setTextFieldName(String name) {
		this.textField_Name.setText(name);
	}

	public String getTextFieldMatrikelnr() {
		String matrikelnr = textField_Matrikelnr.getText();
		return matrikelnr;
	}

	public void setTextFieldMatrikelnr(String matrikelnr) {
		this.textField_Matrikelnr.setText(matrikelnr);
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

//	public String getTextFieldPlz() {
//		String plz = textField_PLZ.getText();
//		return plz;
//	}
	public int getTextFieldPlz() {
		int plz = 0; 
		String stringplz = textField_PLZ.getText();
		try {
			if(stringplz.length()>0) 
				plz = Integer.parseInt(stringplz);
		} catch (NumberFormatException n) {
			plz = 0;
		}
		return plz; 
	}
	

	public void setTextFieldPlz(String plz) {
		this.textField_PLZ.setText(plz);;
	}

	public String getTextFieldOrt() {
		String ort = textField_Ort.getText();
		return ort;
	}

	public void setTextFieldOrt(String ort) {
		this.textField_Ort.setText(ort);;
	}
}
