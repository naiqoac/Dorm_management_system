package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import Dao.ReportDao;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import Object.Admin;
import Object.Report;
import Util.StringUtil;
import Util.dbUtil;

public class CreateReportAdmin extends JInternalFrame {

	JTextArea textArea = new JTextArea();
	private static final long serialVersionUID = 1L;

	/**
	 * Create the frame.
	 */
	public CreateReportAdmin(Admin currentAdmin) {
		setResizable(true);
		setClosable(true);
		setBounds(100, 100, 450, 300);

		JButton btnNewButton = new JButton("submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				submitReport(e, currentAdmin);
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup().addGap(73).addComponent(textArea,
										GroupLayout.PREFERRED_SIZE, 282, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup().addGap(163).addComponent(btnNewButton)))
						.addContainerGap(79, Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(23)
						.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE).addGap(43)
						.addComponent(btnNewButton).addContainerGap(49, Short.MAX_VALUE)));
		getContentPane().setLayout(groupLayout);

	}
	/**
	 * submit a new report by admin
	 * @param e
	 * @param currentAdmin
	 */
	private void submitReport(ActionEvent e, Admin currentAdmin) {
		String description = this.textArea.getText();
		if (StringUtil.Empty(description)) {
			JOptionPane.showMessageDialog(null, "You can not submission empty report");
			return;
		}
		Connection con = null;
		int reportNumber = -1;
		try {
			con = dbUtil.getCon();
			reportNumber = ReportDao.assignReportNumber(con);
			Report report = new Report(currentAdmin.getAdminAccount(), description, reportNumber);
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
	/**
	 * clear all the fields
	 */
	private void ResetTextField() {
		this.textArea.setText(null);
	}
}
