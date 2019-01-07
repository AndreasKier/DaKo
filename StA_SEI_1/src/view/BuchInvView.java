package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import anwendung.Status;
import javax.swing.JTextArea;
import java.awt.event.ActionEvent;
import java.awt.Font;



	/*
	 * evtl. Oberfläche ändern bei Eingabe nur von Exemplar und nicht buchtype
	 * 
	 */
public class BuchInvView extends JFrame {

	private JPanel contentPane;
	private JTextField textField_isbn;
	private JTextField textField_titel;
	private JTextField textField_autor;
	private JTextField textField_seriennr;
	private JComboBox comboBox;

	/**
	 * Create the frame.
	 */
	public BuchInvView(ActionListener listen) {
		setTitle("Buch inventarisieren");
		setBounds(100, 100, 885, 640);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitel = new JLabel("Titel");
		lblTitel.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblTitel.setBounds(48, 44, 135, 43);
		contentPane.add(lblTitel);
		
		JLabel lblAutor = new JLabel("Autor");
		lblAutor.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblAutor.setBounds(48, 113, 107, 37);
		contentPane.add(lblAutor);
		
		JLabel lblIsbn = new JLabel("ISBN");
		lblIsbn.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblIsbn.setBounds(48, 177, 107, 37);
		contentPane.add(lblIsbn);
		
		JLabel lblStatus = new JLabel("Status");
		lblStatus.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblStatus.setBounds(48, 305, 135, 37);
		contentPane.add(lblStatus);
		
		JButton btnSpeichern = new JButton("Speichern");
		btnSpeichern.setFont(new Font("Tahoma", Font.PLAIN, 35));
		btnSpeichern.addActionListener(listen);
		btnSpeichern.setBounds(594, 497, 218, 51);
		contentPane.add(btnSpeichern);
		
		JButton btnback = new JButton("Back");
		btnback.setFont(new Font("Tahoma", Font.PLAIN, 35));
		btnback.addActionListener(listen);
		btnback.setBounds(21, 497, 162, 51);
		contentPane.add(btnback);
		
		comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 35));
		comboBox.setModel(new DefaultComboBoxModel(Status.values()));
		comboBox.setSelectedItem(null); //die Auswahlbox ist leer vor der Eingabe
		comboBox.setBounds(243, 302, 196, 43);
		contentPane.add(comboBox);
			
		textField_isbn = new JTextField();
		textField_isbn.setFont(new Font("Tahoma", Font.PLAIN, 35));
		textField_isbn.setBounds(243, 174, 196, 43);
		contentPane.add(textField_isbn);
		textField_isbn.setColumns(10);
		
		textField_titel = new JTextField();
		textField_titel.setFont(new Font("Tahoma", Font.PLAIN, 35));
		textField_titel.setBounds(243, 42, 196, 45);
		contentPane.add(textField_titel);
		textField_titel.setColumns(10);
		
		textField_autor = new JTextField();
		textField_autor.setFont(new Font("Tahoma", Font.PLAIN, 35));
		textField_autor.setBounds(243, 110, 196, 43);
		contentPane.add(textField_autor);
		textField_autor.setColumns(10);
		
		JLabel lblSeriennummer = new JLabel("Seriennr.");
		lblSeriennummer.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblSeriennummer.setBounds(48, 235, 196, 37);
		contentPane.add(lblSeriennummer);
		
		textField_seriennr = new JTextField();
		textField_seriennr.setFont(new Font("Tahoma", Font.PLAIN, 35));
		textField_seriennr.setBounds(243, 238, 196, 43);
		contentPane.add(textField_seriennr);
		textField_seriennr.setColumns(10);
		
	}
	
	
	//Textfelder in Status/String umwandeln
	public Status getComboBoxstatus() {
		Status status = (Status) comboBox.getSelectedItem();
		return status;
	}
	
	public void setComboBoxStatus(Status status) {
		this.comboBox.setSelectedItem(null);
	}
	
	public String getTextFieldIsbn() {
		String isbn = textField_isbn.getText();
		return isbn; 
	}

	public void setTextFieldIsbn(String isbn) {
		this.textField_isbn.setText(isbn);
	}

	public String getTextFieldTitel() {
		String titel = textField_titel.getText();
		return titel;
	}

	public void setTextFieldTitel(String titel) {
		this.textField_titel.setText(titel);
	}

	public String getTextFieldAutor() {
		String autor = textField_autor.getText();
		return autor;
	}

	public void setTextFieldAutor(String autor) {
		this.textField_autor.setText(autor);
	}

	public String getTextFieldSeriennr() {
		String seriennr = textField_seriennr.getText();
		return seriennr;
	}

	public void setTextFieldSeriennr(String seriennr) {
		this.textField_seriennr.setText(seriennr);
	}
	
}
