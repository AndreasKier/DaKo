
/*Erstmal ignorieren
war ein versuch die benutzeroberfläche anders zu gestalten ;)
*/



//package view;
//
//import java.awt.Font;
//
//import javax.swing.JLabel;
//import javax.swing.JPanel;
//import javax.swing.JScrollPane;
//import javax.swing.JTable;
//import javax.swing.JTabbedPane;
//
//public class ZBenutzerAnzeiView extends JPanel {
//	public JTableView tableview; 
//
//	public ZBenutzerAnzeiView() {
//		
//		JLabel lblAlleBenutzerAnzeigen = new JLabel("alle Benutzer anzeigen:");
//		lblAlleBenutzerAnzeigen.setFont(new Font("Tahoma", Font.PLAIN, 30));
//		lblAlleBenutzerAnzeigen.setBounds(21, 42, 332, 54);
//		panel_BenAnz.add(lblAlleBenutzerAnzeigen);
//		
//		if(tableview == null) {
//			tableview = new JTableView(getAllStudents());
//			JScrollPane scrollpane = new JScrollPane(tableview.getSQLTable());
//			scrollpane.setBounds(43, 120, 599,285);
//			panel_BenAnz.add(scrollpane);
//		}
//
//	}
//	
//	//define generic SQl query for table student (Ubungsblatt 5, Uebung_ButtonHandler, seite 3)
//			public static String getAllStudents() {
//				return "SELECT p.ID, name, email, Hochschule, Studiengruppe, Matrikelnummer  FROM student s, person p WHERE p.ID = s.ID_P;";
//		}
//
//}
