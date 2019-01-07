/*ebenfalls ignorieren
 * Versuch die oberfläche anders zu gestalten
 */

//package view;
//
//import java.awt.BorderLayout;
//import java.awt.EventQueue;
//
//import javax.swing.Icon;
//import javax.swing.ImageIcon;
//import javax.swing.JFrame;
//import javax.swing.JPanel;
//import javax.swing.JTable; 
//import javax.swing.JScrollPane;
//import javax.swing.border.EmptyBorder;
//import javax.swing.JTabbedPane;
//import java.awt.Font;
//import javax.swing.JLabel;
//import javax.swing.JTextField;
//import javax.swing.JButton;
//
//public class ZStartBibView extends JFrame {
//
//	private JPanel contentPane;
//	private JTextField textField_IDBen;
//	private JTextField textField_IDBuch;
////	public JTableView tableview; 
//
//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ZStartBibView frame = new ZStartBibView();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
//
//	/**
//	 * Create the frame.
//	 */
//	public ZStartBibView() {
//		setTitle("Informationssystem der Bib HM");
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(100, 100, 1192, 881);
//		contentPane = new JPanel();
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//		setContentPane(contentPane);
//		contentPane.setLayout(null);
//		
//		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.RIGHT);
//		tabbedPane.setBounds(0, 0, 1166, 810);
//		contentPane.add(tabbedPane);
//		
//		Icon buch = new ImageIcon(getClass().getResource("buch.png"));
//		
//		JPanel panel_BenAnz = new JPanel();
//		tabbedPane.addTab("Benutzer anzeigen", null, panel_BenAnz, null);
//		panel_BenAnz.setLayout(null);
//		
////		JPanel panel_BenAnz = new JPanel();
////		tabbedPane.addTab("Benutzer anzeigen", null, panel_BenAnz, null);
////		panel_BenAnz.setLayout(null);
////		
////		JLabel lblAlleBenutzerAnzeigen = new JLabel("alle Benutzer anzeigen:");
////		lblAlleBenutzerAnzeigen.setFont(new Font("Tahoma", Font.PLAIN, 30));
////		lblAlleBenutzerAnzeigen.setBounds(21, 42, 332, 54);
////		panel_BenAnz.add(lblAlleBenutzerAnzeigen);
////		
////		if(tableview == null) {
////			tableview = new JTableView(getAllStudents());
////			JScrollPane scrollpane = new JScrollPane(tableview.getSQLTable());
////			scrollpane.setBounds(43, 120, 599,285);
////			panel_BenAnz.add(scrollpane);
////		}
//		
//		
//		JPanel panel_BucAnz = new JPanel();
//		tabbedPane.addTab("Buch anzeigen", null, panel_BucAnz, null);
//		
//		JPanel panel_BenAnl = new JPanel();
//		tabbedPane.addTab("Benutzer anlegen", null, panel_BenAnl, null);
//		
//		JPanel panel_BucInv = new JPanel();
//		tabbedPane.addTab("Buch inventarisieren", null, panel_BucInv, null);
//		
//		JPanel panel_Aus = new JPanel();
//		tabbedPane.addTab("Ausleihe", null, panel_Aus, null);
//		panel_Aus.setLayout(null);
//		
//		JLabel lblBenutzerIdEingeben = new JLabel("Benutzer ID eingeben");
//		lblBenutzerIdEingeben.setFont(new Font("Tahoma", Font.PLAIN, 35));
//		lblBenutzerIdEingeben.setBounds(75, 160, 411, 50);
//		panel_Aus.add(lblBenutzerIdEingeben);
//		
//		JLabel lblBuchIdEingeben = new JLabel("Buch ID eingeben:");
//		lblBuchIdEingeben.setFont(new Font("Tahoma", Font.PLAIN, 35));
//		lblBuchIdEingeben.setBounds(75, 266, 335, 50);
//		panel_Aus.add(lblBuchIdEingeben);
//		
//		textField_IDBen = new JTextField();
//		textField_IDBen.setFont(new Font("Tahoma", Font.PLAIN, 35));
//		textField_IDBen.setBounds(509, 157, 228, 50);
//		panel_Aus.add(textField_IDBen);
//		textField_IDBen.setColumns(10);
//		
//		textField_IDBuch = new JTextField();
//		textField_IDBuch.setFont(new Font("Tahoma", Font.PLAIN, 35));
//		textField_IDBuch.setBounds(509, 263, 228, 50);
//		panel_Aus.add(textField_IDBuch);
//		textField_IDBuch.setColumns(10);
//		
//		JButton btnAusleihen = new JButton("ausleihen");
//		btnAusleihen.setFont(new Font("Tahoma", Font.PLAIN, 35));
//		btnAusleihen.setBounds(509, 401, 228, 50);
//		panel_Aus.add(btnAusleihen);
//		
//		JPanel panel_Wil = new JPanel();
//		panel_Wil.setFont(new Font("Tahoma", Font.PLAIN, 21));
//		tabbedPane.addTab("Willkommen", null, panel_Wil, null);
//		panel_Wil.setLayout(null);
//		
//		JLabel lblWillkommen = new JLabel("Willkommen");
//		lblWillkommen.setFont(new Font("Tahoma", Font.PLAIN, 30));
//		lblWillkommen.setBounds(174, 91, 237, 50);
//		panel_Wil.add(lblWillkommen);
//		
//		JLabel lblImInformationssystemDer = new JLabel("im Informationssystem der Bibliothek");
//		lblImInformationssystemDer.setFont(new Font("Tahoma", Font.PLAIN, 30));
//		lblImInformationssystemDer.setBounds(243, 182, 558, 50);
//		panel_Wil.add(lblImInformationssystemDer);
//		
//		JLabel lblDerHochschuleMnchen = new JLabel("der Hochschule M\u00FCnchen");
//		lblDerHochschuleMnchen.setFont(new Font("Tahoma", Font.PLAIN, 30));
//		lblDerHochschuleMnchen.setBounds(121, 280, 372, 50);
//		panel_Wil.add(lblDerHochschuleMnchen);
//		
//		JLabel bild = new JLabel(buch);
//		bild.setBounds(458, 400, 435, 384);
//		panel_Wil.add(bild);
//		
//	}
////	//define generic SQl query for table student (Ubungsblatt 5, Uebung_ButtonHandler, seite 3)
////		public static String getAllStudents() {
////			return "SELECT p.ID, name, email, Hochschule, Studiengruppe, Matrikelnummer  FROM student s, person p WHERE p.ID = s.ID_P;";
////	}
//}
