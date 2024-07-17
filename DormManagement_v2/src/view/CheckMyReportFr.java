package view;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Dao.ReportDao;
import Object.Student;
import Util.dbUtil;

public class CheckMyReportFr extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JTable ReportTable;


	/**
	 * Create the frame.
	 */
	public CheckMyReportFr(Student student) {
		setMaximizable(true);
		setClosable(true);
		setIconifiable(true);
		setBounds(100, 100, 450, 300);
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(31)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 206, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(33, Short.MAX_VALUE))
		);
		
		ReportTable = new JTable();
		ReportTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Report date", "Description", "Reply"
			}
		));
		scrollPane.setViewportView(ReportTable);
		getContentPane().setLayout(groupLayout);	
		fillTable(student);
	}

	/**
	 * fill the table with the reports of this student
	 * @param student
	 */
	private void fillTable(Student student) {
		DefaultTableModel dtm =(DefaultTableModel) ReportTable.getModel();
		dtm.setRowCount(0);
		try {
			Connection con= dbUtil.getCon();
			ResultSet rs= ReportDao.list(con, student);
			while(rs.next()){
				Vector v = new Vector();
				v.add(rs.getDate("report_time"));
				v.add(rs.getString("describtion"));
				v.add(rs.getString("reply"));
				dtm.addRow(v);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
