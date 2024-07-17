package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Dao.AdminDao;
import Object.Admin;
import Util.StringUtil;
import Util.dbUtil;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class LoginFr extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField Admin_Account;
	private JPasswordField Admin_Password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFr frame = new LoginFr();
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
	public LoginFr() {
		setTitle("Admin Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		JLabel lblNewLabel = new JLabel("Dorm management system");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));

		JLabel lblNewLabel_1 = new JLabel("Admin Account:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));

		JLabel lblNewLabel_2 = new JLabel("Admin Password:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));

		Admin_Account = new JTextField();
		Admin_Account.setColumns(10);

		JButton btnNewButton = new JButton("Login");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login(e);
			}

		});

		JButton btnNewButton_1 = new JButton("Student Login Page");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				StudentLoginFr studentLoginFr = new StudentLoginFr();
				studentLoginFr.setVisible(true);
			}
		});

		Admin_Password = new JPasswordField();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING).addGroup(gl_contentPane
				.createSequentialGroup().addContainerGap()
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
						.addComponent(lblNewLabel_1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(Admin_Account, GroupLayout.PREFERRED_SIZE, 152,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(Admin_Password))
						.addComponent(btnNewButton_1))
				.addGap(134))
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup().addGap(47).addComponent(lblNewLabel)
						.addContainerGap(171, Short.MAX_VALUE)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup().addContainerGap().addComponent(lblNewLabel).addGap(33)
				.addGroup(gl_contentPane
						.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_1).addComponent(Admin_Account,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(33)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_2)
						.addComponent(Admin_Password, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(btnNewButton)
						.addComponent(btnNewButton_1))
				.addGap(41)));
		contentPane.setLayout(gl_contentPane);
		// set the window at center
		this.setLocationRelativeTo(null);
	}

	/**
	 * admin login
	 * 
	 * @param evt
	 */
	private void login(ActionEvent evt) {
		String adminAccount = this.Admin_Account.getText();
		String adminPassword = new String(this.Admin_Password.getPassword());
		if (StringUtil.Empty(adminAccount)) {
			JOptionPane.showMessageDialog(null, "Admin Account can not be empty");
			return;
		}
		if (StringUtil.Empty(adminPassword)) {
			JOptionPane.showMessageDialog(null, "Password can not be empty");
			return;
		}
		Admin admin = new Admin(adminAccount, adminPassword);
		Connection con = null;
		try {
			con = dbUtil.getCon();
			Admin currentadmin = AdminDao.login(con, admin);
			if (currentadmin != null) {
				dispose();
				new MainFr(currentadmin).setVisible(true);
			} else {
				JOptionPane.showMessageDialog(null, "Account or password is incorrect");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
