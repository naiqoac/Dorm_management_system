package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import Dao.ReportDao;
import Object.Report;
import Object.Student;
import Util.StringUtil;
import Util.dbUtil;

public class CreateReportStudentInterFr extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JTextArea desc;

	/**
	 * Create the frame.
	 */
	public CreateReportStudentInterFr(Student currentStudent) {
		setResizable(true);
		setClosable(true);
		setTitle("Create new report");
		setBounds(100, 100, 450, 300);

		JLabel lblNewLabel = new JLabel("description(If you meet emergancy case please contact RA immediately)");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));

		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				subbmitReport(e, currentStudent);
			}
		});
		desc = new JTextArea();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(170).addComponent(btnNewButton)
						.addContainerGap(252, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup().addGap(21)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 379, Short.MAX_VALUE)
								.addComponent(desc, GroupLayout.PREFERRED_SIZE, 399, GroupLayout.PREFERRED_SIZE))
						.addContainerGap()));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap()
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(desc, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(btnNewButton)
						.addContainerGap(12, Short.MAX_VALUE)));
		getContentPane().setLayout(groupLayout);

	}

	/**
	 * submit a report by student
	 * 
	 * @param e
	 * @param currentStudent
	 */
	private void subbmitReport(ActionEvent e, Student currentStudent) {
		String description = this.desc.getText();
		if (StringUtil.Empty(description)) {
			JOptionPane.showMessageDialog(null, "You can not submission empty report");
			return;
		}
		Connection con = null;
		int reportNumber = -1;
		try {
			con = dbUtil.getCon();
			reportNumber = ReportDao.assignReportNumber(con);
			Report report = new Report(currentStudent.getStudentNumber(), description, reportNumber);
			int result = -1;
			result = ReportDao.addNewReport(con, report);
			if (result == 1) {
				JOptionPane.showMessageDialog(null,
						"Report submitted successfully\n" + "Report time" + report.getReportDate());
				ResetTextField();
			} else {
				JOptionPane.showMessageDialog(null, "submission failed");
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	private void ResetTextField() {
		desc.setText(null);
	}
}
