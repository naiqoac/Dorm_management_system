package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import Dao.RoomDao;
import Dao.StudentDao;
import Object.Student;
import Util.DatePick;
import Util.RandomPwd;
import Util.StringUtil;
import Util.dbUtil;

public class AddNewStudentInterFr extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JTextField StudentNumber;
	private JTextField StudentName;
	private JTextField RentDate;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddNewStudentInterFr frame = new AddNewStudentInterFr();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AddNewStudentInterFr() {
		setTitle("Add New Student");
		setClosable(true);
		setIconifiable(true);
		setBounds(100, 100, 450, 300);
		
		JLabel lblNewLabel = new JLabel("Student Number");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
		
		JLabel lblNewLabel_1 = new JLabel("Student Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		
		JLabel lblNewLabel_2 = new JLabel("Rent Date");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 22));
		
		StudentNumber = new JTextField();
		StudentNumber.setColumns(10);
		StudentNumber.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				
				String key="0123456789";
				if(key.indexOf(e.getKeyChar())<0){
					e.consume();
				}
			}
		});
		
		StudentName = new JTextField();
		StudentName.setColumns(10);
		
		RentDate = new JTextField();
		RentDate.setColumns(10);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddNewStudent(e);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 24));
		
		JButton btnNewButton_1 = new JButton("Choose Date");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RentDate.setText(new DatePick().Set_Picked_Date());
			}
		});
		
		JLabel lblNewLabel_3 = new JLabel("Use yyyy-MM-dd format");
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(177)
					.addComponent(btnNewButton)
					.addContainerGap(184, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(39)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.RELATED))
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE))
									.addGap(13)))
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(RentDate, GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
								.addComponent(StudentName, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
								.addComponent(StudentNumber, GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnNewButton_1)
							.addGap(1))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(44)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(StudentNumber, GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
						.addComponent(lblNewLabel))
					.addGap(19)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(StudentName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(19)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(RentDate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnNewButton_1))
						.addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
					.addGap(24))
		);
		getContentPane().setLayout(groupLayout);
		

	}

	private void AddNewStudent(ActionEvent e){
		String inputNumber=this.StudentNumber.getText();
		if(StringUtil.Empty(inputNumber)) {
			JOptionPane.showMessageDialog(null, "Student Number can not be empty");
			return;
		}
		int studentNumber=Integer.parseInt(inputNumber);
		String studentName=this.StudentName.getText();
		if(StringUtil.Empty(studentName)) {
			JOptionPane.showMessageDialog(null, "Student Name can not be empty");
			return;
		}
		else if((int)(Math.log(studentNumber)/Math.log(10)+1)!=8) {
			JOptionPane.showMessageDialog(null, "Student Number has to be 8 digits");
			return;
		}
		java.sql.Date sqlDate=null;
		try {
		sqlDate = Date.valueOf(this.RentDate.getText());}
		
		catch(Exception ex) {
			JOptionPane.showMessageDialog(null, "Date format incorrect, use yyyy-MM-dd format");
			return;
		}
		Connection con=null;
		try {
			con=dbUtil.getCon();
			int roomnumber=RoomDao.findAvailableRoom(con);
			if(roomnumber==-1) {
				JOptionPane.showMessageDialog(null, "no room available");
				return;
			}
			String studentPasswd=RandomPwd.getRandomPwd(con,8);
			Student student=new Student(studentNumber,studentPasswd,studentName,roomnumber,sqlDate);	
			if(StudentDao.CheckStudentID(con, student)) {
				JOptionPane.showMessageDialog(null, "Student already exists");
				return;
			}
			int result=StudentDao.addNewStudents(con, student);
			if(result==1) {
				JOptionPane.showMessageDialog(null,"Add new student successfully\n"
						+ "student number: "+studentNumber+"\n"
						+ "student name: "+studentName+"\n"
						+ "original password: "+studentPasswd+"\n"
						+ "room numer: "+ roomnumber+"\n"
						+ "rent date until:"+sqlDate+"\n");
				RoomDao.updateRoomState(con, roomnumber,true);
				ResetTextField();
			}
			else {
				JOptionPane.showMessageDialog(null,"Failed to add");
			}
		}
		catch(Exception ex) {JOptionPane.showMessageDialog(null,"Failed to add");
		ex.printStackTrace();}
		finally {
			try {
				dbUtil.getCon();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}
	private void ResetTextField() {
		StudentNumber.setText(null);
		StudentName.setText(null);
		RentDate.setText(null);
	}
}
