package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.TitledBorder;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Vector;

import Dao.RoomDao;
import Dao.StudentDao;
import Object.Student;
import Util.DatePick;
import Util.RandomPwd;
import Util.StringUtil;
import Util.dbUtil;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class ManageStudentInterFr extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private JTextField StudentNumber;
	private JTextField RoomNumber;
	private JTextField RentDate;
	private JTextField studentNumber_1;
	private JTextField studentName;
	private JTextField roomNumber_1;
	private JTextField rentDate;

	/**
	 * Create the frame.
	 */
	public ManageStudentInterFr() {
		setIconifiable(true);
		setMaximizable(true);
		setClosable(true);
		setTitle("ManageStudents");
		setBounds(100, 100, 775, 570);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Search student", TitledBorder.LEADING, TitledBorder.TOP, null, null));

		JScrollPane scrollPane = new JScrollPane();

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Manage", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(33)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(panel_1, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
						.addComponent(scrollPane, Alignment.LEADING)
						.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 661, Short.MAX_VALUE))
					.addContainerGap(65, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(38)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
					.addGap(34)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
					.addGap(31)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(68, Short.MAX_VALUE))
		);

		JLabel lblNewLabel_3 = new JLabel("Student number:");

		studentNumber_1 = new JTextField();
		studentNumber_1.setEditable(false);
		studentNumber_1.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("Student name:");

		studentName = new JTextField();
		studentName.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("Room number:");

		roomNumber_1 = new JTextField();
		roomNumber_1.setColumns(10);

		JLabel lblNewLabel_6 = new JLabel("Rent date:");

		rentDate = new JTextField();
		rentDate.setColumns(10);

		JButton btnNewButton_2 = new JButton("Choose date");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rentDate.setText(new DatePick().Set_Picked_Date());
			}
		});

		JButton btnNewButton_3 = new JButton("Reset password");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ResetPsaaword(e);
			}
		});

		JButton btnNewButton_4 = new JButton("Submit");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentUpdate(e);
			}
		});
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(lblNewLabel_6)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(rentDate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnNewButton_2))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(lblNewLabel_3)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(studentNumber_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel_4)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(btnNewButton_4)
								.addComponent(studentName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(lblNewLabel_5)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(roomNumber_1, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnNewButton_3))
					.addContainerGap(122, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(studentNumber_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_4)
						.addComponent(studentName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_5)
						.addComponent(roomNumber_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_6)
						.addComponent(rentDate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_2)
						.addComponent(btnNewButton_3))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnNewButton_4)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);

		JLabel lblNewLabel = new JLabel("Student number:");

		StudentNumber = new JTextField();
		StudentNumber.setColumns(10);
		StudentNumber.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				String key = "0123456789";
				if (key.indexOf(e.getKeyChar()) < 0) {
					e.consume();
				}
			}
		});

		JLabel lblNewLabel_1 = new JLabel("Room number");

		RoomNumber = new JTextField();
		RoomNumber.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Rent date");

		RentDate = new JTextField();
		RentDate.setColumns(10);

		JButton btnNewButton = new JButton("Search");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String input = StudentNumber.getText();
				int studentNumber = -1;
				if (!StringUtil.Empty(input)) {
					studentNumber = Integer.parseInt(input);
				}
				int roomNumber = -1;
				input = RoomNumber.getText();
				if (!StringUtil.Empty(input)) {
					roomNumber = Integer.parseInt(input);
				}
				Date sqlDate = null;
				input = RentDate.getText();
				if (!StringUtil.Empty(input)) {
					try {
						sqlDate = Date.valueOf(input);
					} catch (Exception ex) {
						JOptionPane.showMessageDialog(null, "Date format incorrect, use yyyy-MM-dd format");
						return;
					}
				}
				Student student = new Student(studentNumber, roomNumber, sqlDate);
				fillTable(student);
			}
		});

		JButton btnNewButton_1 = new JButton("Choose date");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RentDate.setText(new DatePick().Set_Picked_Date());
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(gl_panel
				.createSequentialGroup().addContainerGap().addComponent(lblNewLabel)
				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				.addComponent(
						StudentNumber, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
				.addGroup(gl_panel.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup().addComponent(lblNewLabel_1)
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(RoomNumber, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(lblNewLabel_2))
						.addComponent(btnNewButton))
				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				.addGroup(gl_panel.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(btnNewButton_1)
						.addComponent(RentDate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addContainerGap(19, Short.MAX_VALUE)));
		gl_panel.setVerticalGroup(
				gl_panel.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup().addContainerGap()
								.addGroup(gl_panel.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(lblNewLabel)
										.addComponent(StudentNumber, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_1)
										.addComponent(RoomNumber, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_2).addComponent(
												RentDate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addGroup(gl_panel.createSequentialGroup()
												.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 17,
														Short.MAX_VALUE)
												.addComponent(btnNewButton).addContainerGap())
										.addGroup(gl_panel.createSequentialGroup()
												.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
												.addComponent(btnNewButton_1).addContainerGap()))));
		panel.setLayout(gl_panel);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Student number", "Student name", "Room number", "Rent date" }));
		table.getColumnModel().getColumn(0).setPreferredWidth(87);
		table.getColumnModel().getColumn(1).setPreferredWidth(82);
		table.getColumnModel().getColumn(2).setPreferredWidth(93);
		scrollPane.setViewportView(table);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				studentTableMouseClicked(e);
			}
		});
		getContentPane().setLayout(groupLayout);
		fillTable(new Student(-1, -1, null));

	}

	/**
	 * reset the password of selected student
	 * 
	 * @param e
	 */
	private void ResetPsaaword(ActionEvent e) {
		Connection con = null;
		try {
			con = dbUtil.getCon();
			String passwd = RandomPwd.getRandomPwd(con, 8);
			String inputNumber = this.studentNumber_1.getText();
			if (StringUtil.Empty(inputNumber)) {
				JOptionPane.showMessageDialog(null, "Select the record you want to modify");
				return;
			}
			int studentNumber = Integer.parseInt(inputNumber);
			Student student = new Student(studentNumber, passwd);
			int result = StudentDao.ChangePassword(con, student, passwd);
			if (result == 1) {
				JOptionPane.showMessageDialog(null, "New passwd: " + passwd);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * modify student information
	 * 
	 * @param e
	 */
	private void StudentUpdate(ActionEvent e) {
		String inputNumber = this.studentNumber_1.getText();
		if (StringUtil.Empty(inputNumber)) {
			JOptionPane.showMessageDialog(null, "Select the record you want to modify");
			return;
		}
		int studentNumber = Integer.parseInt(inputNumber);
		String studentName = this.studentName.getText();
		if (StringUtil.Empty(studentName)) {
			JOptionPane.showMessageDialog(null, "Student Name can not be empty");
			return;
		}
		inputNumber = this.roomNumber_1.getText();
		if (StringUtil.Empty(inputNumber)) {
			JOptionPane.showMessageDialog(null, "Room number can not be empty");
			return;
		}
		int roomNumber = Integer.parseInt(inputNumber);
		java.sql.Date sqlDate = null;
		try {
			sqlDate = Date.valueOf(this.rentDate.getText());
		}

		catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Date format incorrect, use yyyy-MM-dd format");
			return;
		}
		Connection con = null;
		int result = -1;
		try {
			con = dbUtil.getCon();
			if (RoomDao.checkRoomState(roomNumber, con) == false&&roomNumber!=StudentDao.getStudentRoomNumber(studentNumber, con)) {
				JOptionPane.showMessageDialog(null, "The room is not available now");
				return;
			}
			Student student = new Student(studentNumber, studentName, roomNumber, sqlDate);
			result = RoomDao.changeRoom(student, roomNumber, con);
			result = StudentDao.update(con, student);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		if (result != 1) {
			JOptionPane.showMessageDialog(null, "Failed");
		} else {
			JOptionPane.showMessageDialog(null, "Success");
			fillTable(new Student(-1, -1, null));
		}
	}

	/**
	 * fill the field with the information of selected student
	 * 
	 * @param e
	 */
	private void studentTableMouseClicked(MouseEvent e) {
		int row = this.table.getSelectedRow();
		this.studentNumber_1.setText(String.valueOf(table.getValueAt(row, 0)));
		this.studentName.setText((String) table.getValueAt(row, 1));
		this.roomNumber_1.setText(String.valueOf(table.getValueAt(row, 2)));
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = dateFormat.format(table.getValueAt(row, 3));
		this.rentDate.setText(dateString);
	}

	/**
	 * fill the table with students matched conditions
	 * 
	 * @param student
	 */
	private void fillTable(Student student) {
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		dtm.setRowCount(0);
		try {
			Connection con = dbUtil.getCon();
			ResultSet rs = StudentDao.list(con, student);
			if (rs == null) {
				return;
			}
			while (rs.next()) {
				Vector v = new Vector();
				v.add(rs.getInt("student_number"));
				v.add(rs.getString("student_name"));
				v.add(rs.getInt("room_number"));
				v.add(rs.getDate("rent_time"));
				dtm.addRow(v);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
