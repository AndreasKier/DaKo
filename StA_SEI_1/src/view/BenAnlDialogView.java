package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;

public class BenAnlDialogView extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Create the dialog.
	 */
	public BenAnlDialogView(ActionListener listen) {
		setTitle("Professor oder Student anlegen");
		setBounds(100, 100, 783, 540);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblStudentOderProfessor = new JLabel("Student oder Professor anlegen?");
			lblStudentOderProfessor.setFont(new Font("Tahoma", Font.PLAIN, 35));
			lblStudentOderProfessor.setBounds(109, 47, 532, 43);
			contentPanel.add(lblStudentOderProfessor);
		}
		{
			JButton btnStudent = new JButton("Student");
			btnStudent.setFont(new Font("Tahoma", Font.PLAIN, 35));
			btnStudent.addActionListener(listen);
			btnStudent.setBounds(58, 179, 198, 43);
			contentPanel.add(btnStudent);
		}
		{
			JButton btnProfessor = new JButton("Professor");
			btnProfessor.setFont(new Font("Tahoma", Font.PLAIN, 35));
			btnProfessor.addActionListener(listen);
			btnProfessor.setBounds(408, 179, 198, 43);
			contentPanel.add(btnProfessor);
		}
		{
			JButton btnCancel = new JButton("Cancel");
			btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 30));
			btnCancel.addActionListener(listen);
			btnCancel.setBounds(575, 405, 150, 43);
			contentPanel.add(btnCancel);
		}
	}

}
