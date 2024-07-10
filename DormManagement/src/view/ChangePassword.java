package view;

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
import javax.swing.JPasswordField;
import javax.swing.LayoutStyle.ComponentPlacement;

import Dao.StudentDao;
import Object.Student;
import Util.StringUtil;
import Util.dbUtil;

public class ChangePassword extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JPasswordField OldPassword;
	private JPasswordField NewPassword;
	private JPasswordField ConfirmNewPassword;


	/**
	 * Create the frame.
	 */
	public ChangePassword(Student currentStudent) {
		setClosable(true);
		setResizable(true);
		setMaximizable(true);
		setTitle("Change Password");
		setBounds(100, 100, 450, 300);
		
		JLabel lblNewLabel = new JLabel("Enter old password:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblNewLabel_1 = new JLabel("Enter new password:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblNewLabel_2 = new JLabel("Confirm new password:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		OldPassword = new JPasswordField();
		
		NewPassword = new JPasswordField();
		
		JButton btnNewButton = new JButton("Confirm");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChangeNewPassword(e,currentStudent);
			}
		});
		
		ConfirmNewPassword = new JPasswordField();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(28)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(lblNewLabel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(lblNewLabel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE))
								.addGroup(groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblNewLabel_2)))
							.addGap(2)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(ConfirmNewPassword)
								.addComponent(NewPassword)
								.addComponent(OldPassword, GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(140)
							.addComponent(btnNewButton)))
					.addContainerGap(107, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(43)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addComponent(OldPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(28)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel_1)
						.addComponent(NewPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(33)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel_2)
						.addComponent(ConfirmNewPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
					.addComponent(btnNewButton)
					.addGap(34))
		);
		getContentPane().setLayout(groupLayout);

	}


	private void ChangeNewPassword(ActionEvent e, Student currentStudent) {
		String oldPassword=new String(this.OldPassword.getPassword());
		String newPassword=new String(this.NewPassword.getPassword());
		String confirmPassword=new String(this.ConfirmNewPassword.getPassword());
		if(StringUtil.Empty(confirmPassword)||StringUtil.Empty(newPassword)||StringUtil.Empty(oldPassword)) {
			JOptionPane.showMessageDialog(null, "Please fill all the fields");
			return;
		}
		if(!oldPassword.equals(currentStudent.getStudentPassword())) {
			JOptionPane.showMessageDialog(null, "old password is incorrect");
			return;
		}
		if(!newPassword.equals(confirmPassword)) {
			JOptionPane.showMessageDialog(null, "Two new passwords are different");
			return;
		}
		Connection con=null;
		int result=-1;
		try {
			con=dbUtil.getCon();
			result=StudentDao.ChangePassword(con, currentStudent, newPassword);
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		if(result==1) {
			JOptionPane.showMessageDialog(null, "Password is changed successfully");
			ResetTextField();
			return;
		}
		else {
			JOptionPane.showMessageDialog(null, "Failed");
			return;
		}
	}
	private void ResetTextField() {
		OldPassword.setText(null);
		NewPassword.setText(null);
		ConfirmNewPassword.setText(null);
	}
}
