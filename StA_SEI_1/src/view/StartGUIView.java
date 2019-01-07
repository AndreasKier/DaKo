package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTabbedPane;
import javax.swing.JToggleButton;
import javax.swing.JTree;
import java.awt.List;
import javax.swing.JMenuBar;
import javax.swing.JProgressBar;
import javax.swing.JInternalFrame;

public class StartGUIView extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public StartGUIView(ActionListener listen) {
		setTitle("Informationssystem der HM-Bibliothek");
		//setBounds(100, 100, 686, 490);
		setBounds(3000,3000,1079,731);
		setLocation(500,500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnBuchInventarisieren = new JButton("Buch inventarisieren");
		btnBuchInventarisieren.setBounds(58, 142, 325, 45);
		btnBuchInventarisieren.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnBuchInventarisieren.addActionListener(listen);
		contentPane.setLayout(null);
		contentPane.add(btnBuchInventarisieren);
		
		JButton btnStudentAnlegen = new JButton("Benutzer anlegen");
		btnStudentAnlegen.setBounds(488, 142, 297, 45);
		btnStudentAnlegen.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnStudentAnlegen.addActionListener(listen);
		contentPane.add(btnStudentAnlegen);
		
		JButton btnBuchAnzeigen = new JButton("Buch anzeigen");
		btnBuchAnzeigen.setBounds(58, 250, 325, 45);
		btnBuchAnzeigen.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnBuchAnzeigen.addActionListener(listen);
		contentPane.add(btnBuchAnzeigen);
		
		JButton btnBenutzerAnzeigen = new JButton("Benutzer anzeigen");
		btnBenutzerAnzeigen.setBounds(488, 250, 297, 45);
		btnBenutzerAnzeigen.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnBenutzerAnzeigen.addActionListener(listen);
		contentPane.add(btnBenutzerAnzeigen);
		
		JButton btnBuchAusleihen = new JButton("Buch ausleihen");
		btnBuchAusleihen.setBounds(229, 382, 291, 45);
		btnBuchAusleihen.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnBuchAusleihen.addActionListener(listen);
		contentPane.add(btnBuchAusleihen);
		
		JLabel lblBuch = new JLabel("Buch");
		lblBuch.setBounds(156, 50, 87, 35);
		lblBuch.setFont(new Font("Tahoma", Font.PLAIN, 35));
		contentPane.add(lblBuch);
		
		JLabel lblBenutzer = new JLabel("Benutzer");
		lblBenutzer.setBounds(551, 46, 149, 43);
		lblBenutzer.setFont(new Font("Tahoma", Font.PLAIN, 35));
		contentPane.add(lblBenutzer);
		
	}
}
