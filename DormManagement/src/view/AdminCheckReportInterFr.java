package view;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import Dao.ReportDao;
import Dao.RoomDao;
import Dao.StudentDao;
import Object.Admin;
import Object.Report;
import Object.Student;
import Util.DatePick;
import Util.StringUtil;
import Util.dbUtil;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminCheckReportInterFr extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private JTextField Report_Date_Search;
	private JTextField Reporter_Search;
	private JTextField Description_Search;
	private JTextField Reply_Search;
	JTextArea description = new JTextArea();
	JTextArea Reply = new JTextArea();
	private JTextField ReportNumber;

	/**
	 * Create the frame.
	 */
	public AdminCheckReportInterFr(Admin currentAdmin) {
		setMaximizable(true);
		setClosable(true);
		setIconifiable(true);
		setBounds(100, 100, 951, 523);

		JScrollPane scrollPane = new JScrollPane();

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Search", TitledBorder.LEADING, TitledBorder.TOP, null, null));

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Description", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(32)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 837, Short.MAX_VALUE)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 837, Short.MAX_VALUE)
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 837, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(35)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
					.addGap(34)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
					.addGap(27)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(29, Short.MAX_VALUE))
		);

		description.setEditable(false);
		ReportNumber = new JTextField();
		ReportNumber.setEditable(false);
		ReportNumber.setColumns(10);

		JButton btnNewButton = new JButton("Reply");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				upateReport(e);
			}
		});

		JLabel lblNewLabel_4 = new JLabel("Index:");

		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING).addGroup(gl_panel_1
				.createSequentialGroup().addContainerGap()
				.addGroup(gl_panel_1
						.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
								.addComponent(description, GroupLayout.DEFAULT_SIZE, 383, Short.MAX_VALUE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(Reply, GroupLayout.PREFERRED_SIZE, 398, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup().addComponent(lblNewLabel_4)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(ReportNumber, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addGap(222).addComponent(btnNewButton)))
				.addContainerGap()));
		gl_panel_1.setVerticalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup().addGap(5)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(description, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
								.addComponent(Reply, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE).addComponent(btnNewButton)
								.addComponent(lblNewLabel_4).addComponent(ReportNumber, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addContainerGap()));
		panel_1.setLayout(gl_panel_1);

		JLabel lblNewLabel = new JLabel("Report date");

		JLabel lblNewLabel_1 = new JLabel("Reporter");

		Report_Date_Search = new JTextField();
		Report_Date_Search.setColumns(10);

		Reporter_Search = new JTextField();
		Reporter_Search.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Description");

		Description_Search = new JTextField();
		Description_Search.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Reply");

		Reply_Search = new JTextField();
		Reply_Search.setColumns(10);

		JButton btnNewButton_1 = new JButton("Search");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SearchReport(e);
			}
		});

		JButton btnNewButton_2 = new JButton("Choose date");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Report_Date_Search.setText(new DatePick().Set_Picked_Date());
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel
				.createSequentialGroup().addContainerGap()
				.addGroup(gl_panel.createParallelGroup(Alignment.LEADING).addComponent(btnNewButton_2)
						.addGroup(gl_panel.createSequentialGroup().addComponent(lblNewLabel)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(Report_Date_Search, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblNewLabel_1)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(Reporter_Search, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblNewLabel_2)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(Description_Search, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblNewLabel_3)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(Reply_Search, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED).addComponent(btnNewButton_1)))
				.addContainerGap(177, Short.MAX_VALUE)));
		gl_panel.setVerticalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup().addContainerGap()
								.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel)
										.addComponent(Report_Date_Search, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_1)
										.addComponent(Reporter_Search, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_2)
										.addComponent(Description_Search, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_3)
										.addComponent(Reply_Search, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(btnNewButton_1))
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 18,
										GroupLayout.PREFERRED_SIZE)));
		panel.setLayout(gl_panel);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Index", "Report date", "Reporter", "Description", "Reply" }) {
			boolean[] columnEditables = new boolean[] { false, false, false, true, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(table);
		getContentPane().setLayout(groupLayout);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				reportTableClick(e);
			}
		});
		fillTable(new Report(-1, null, null, null, null));
	}
	/**
	 * fill the table with the reports matched given conditions
	 * @param e
	 */
	private void SearchReport(ActionEvent e) {
		String description = Description_Search.getText();
		String reply = Reply_Search.getText();
		Date sqlDate = null;
		String input = Report_Date_Search.getText();
		if (!StringUtil.Empty(input)) {
			try {
				sqlDate = Date.valueOf(input);
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Date format incorrect, use yyyy-MM-dd format");
				return;
			}
		}
		input = Reporter_Search.getText();
		int studentNumber = -1;
		String adminAccount = null;
		try {
			studentNumber = Integer.parseInt(input);
		} catch (Exception ex) {
			adminAccount = input;
		}
		Report report = null;
		report = new Report(studentNumber, adminAccount, sqlDate, description, reply);
		fillTable(report);
	}
	/**
	 * update selected report 
	 * @param e
	 */
	private void upateReport(ActionEvent e) {
		Connection con = null;
		int result = -1;
		try {
			con = dbUtil.getCon();
			String reply = Reply.getText();
			if (reply == null) {
				JOptionPane.showMessageDialog(null, "Reply can not be empty");
				return;
			}
			int reportNumber = Integer.parseInt(ReportNumber.getText());
			Report report = new Report(reply, reportNumber);
			result = ReportDao.update(con, report);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		if (result != 1) {
			JOptionPane.showMessageDialog(null, "Failed");
		} else {
			JOptionPane.showMessageDialog(null, "Success");
			fillTable(new Report(-1, null, null, null, null));
		}
	}
	/**
	 * fill the field with information of selected report
	 * @param e
	 */
	private void reportTableClick(MouseEvent e) {
		int row = this.table.getSelectedRow();
		ReportNumber.setText(String.valueOf(table.getValueAt(row, 0)));
		description.setText((String) table.getValueAt(row, 3));
		Reply.setText((String) table.getValueAt(row, 4));
	}
	/**
	 * fill table with given conditions
	 * @param report
	 */
	private void fillTable(Report report) {
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		dtm.setRowCount(0);
		try {
			Connection con = dbUtil.getCon();
			ResultSet rs = ReportDao.list(con, report);
			if (rs == null) {
				return;
			}
			while (rs.next()) {
				Vector v = new Vector();
				v.add(rs.getInt("report_number"));
				v.add(rs.getDate("report_time"));
				String reporter = rs.getString("admin_account");
				if (reporter == null) {
					reporter = String.valueOf(rs.getInt("student_number"));
				}
				v.add(reporter);
				v.add(rs.getString("describtion"));
				v.add(rs.getString("reply"));
				dtm.addRow(v);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
