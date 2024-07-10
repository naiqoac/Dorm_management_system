package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Dao.AdminDao;
import Dao.StudentDao;
import Object.Admin;
import Object.Student;
import Util.StringUtil;
import Util.dbUtil;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.awt.event.ActionEvent;

public class StudentLoginFr extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField StudentNumber;
	private JPasswordField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentLoginFr frame = new StudentLoginFr();
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
	public StudentLoginFr() {
		setTitle("Student Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Student Number");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		
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
		
		password = new JPasswordField();
		
		JButton btnNewButton = new JButton("Log in");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				studentLogIn(e);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JButton btnNewButton_1 = new JButton("Administrator log in page ");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				LoginFr frame = new LoginFr();
				frame.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addContainerGap()
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(StudentNumber, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_contentPane.createSequentialGroup()
								.addContainerGap()
								.addComponent(btnNewButton)
								.addGap(18)
								.addComponent(btnNewButton_1, 0, 0, Short.MAX_VALUE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(password)))
					.addContainerGap(153, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(47)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(StudentNumber, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
					.addGap(29)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel_1)
						.addComponent(password, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 94, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_1)
						.addComponent(btnNewButton))
					.addGap(40))
		);
		contentPane.setLayout(gl_contentPane);
		//set the window at center
				this.setLocationRelativeTo(null);
	}

	private void studentLogIn(ActionEvent e) {
		String inputNumber=this.StudentNumber.getText();
		if(StringUtil.Empty(inputNumber)) {
			JOptionPane.showMessageDialog(null, "Student Number can not be empty");
			return;
		}
		int studentNumber=Integer.parseInt(inputNumber);
		String studentPassword=new String(this.password.getPassword());
		if(StringUtil.Empty(studentPassword)) {
			JOptionPane.showMessageDialog(null,"Password can not be empty");
			return;
		}
		Student student=new Student(studentNumber,studentPassword);	
		Connection con=null;
		try { 
			con=dbUtil.getCon();
			Student currentstudent=StudentDao.login(con, student);
			if(currentstudent!=null) {
				dispose();
				JOptionPane.showMessageDialog(null,"Welcome"+currentstudent.getStudentName());
				new StudentMainFr(currentstudent).setVisible(true);
			}
			else {
				JOptionPane.showMessageDialog(null,"Student number or password is incorrect");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
