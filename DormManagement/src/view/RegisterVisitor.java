package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import Dao.GuestDao;
import Dao.visitRecordDao;
import Object.Guest;
import Object.visitRecord;
import Util.DatePick;
import Util.StringUtil;
import Util.dbUtil;

public class RegisterVisitor extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JTextField GuestID;
	private JTextField CheckOutDate;
	private JTextField HostStudentNumber;
	private JTextField GuestName;

	/**
	 * Create the frame.
	 */
	public RegisterVisitor() {
		setResizable(true);
		setMaximizable(true);
		setClosable(true);
		setTitle("Register visitor");
		setBounds(100, 100, 450, 300);

		JLabel lblNewLabel = new JLabel("Guest ID:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));

		JLabel lblNewLabel_1 = new JLabel("Check out date:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));

		GuestID = new JTextField();
		GuestID.setColumns(10);

		CheckOutDate = new JTextField();
		CheckOutDate.setColumns(10);

		JButton btnNewButton = new JButton("Choose date");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CheckOutDate.setText(new DatePick().Set_Picked_Date());
			}
		});

		JButton btnNewButton_1 = new JButton("Submit");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					RegisterVisitor(e);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 16));

		JLabel lblNewLabel_2 = new JLabel("Host student number:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));

		HostStudentNumber = new JTextField();
		HostStudentNumber.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Guest name:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));

		GuestName = new JTextField();
		GuestName.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Ask visitor to provide ID driving lience or Student card , passport etc.");
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(164)
					.addComponent(btnNewButton_1)
					.addContainerGap(187, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(24)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 353, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
								.addContainerGap())
							.addGroup(groupLayout.createSequentialGroup()
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addComponent(lblNewLabel_1)
									.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(GuestID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addContainerGap())
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(HostStudentNumber, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addGap(157))
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(CheckOutDate)
											.addGap(18)
											.addComponent(btnNewButton)
											.addGap(46))
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(GuestName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addContainerGap())))))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(42, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addPreferredGap(ComponentPlacement.RELATED))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(GuestID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_4)
					.addGap(37)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel_3)
							.addPreferredGap(ComponentPlacement.RELATED))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(GuestName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(14)))
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(HostStudentNumber, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(CheckOutDate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton))
					.addGap(15)
					.addComponent(btnNewButton_1)
					.addGap(21))
		);
		getContentPane().setLayout(groupLayout);

	}

	/**
	 * create a new visit record create a new customer if does not exists
	 * 
	 * @param e
	 * @throws Exception
	 */
	private void RegisterVisitor(ActionEvent e) throws Exception {
		String guestID = GuestID.getText();
		String inputNumber = HostStudentNumber.getText();
		String guestName = GuestName.getText();
		java.sql.Date sqlDate = null;
		try {
			sqlDate = Date.valueOf(this.CheckOutDate.getText());
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Date format incorrect, use yyyy-MM-dd format");
			return;
		}
		if (StringUtil.Empty(inputNumber) || StringUtil.Empty(guestID)) {
			JOptionPane.showMessageDialog(null, "please fill all the field");
			return;
		}
		Connection con = null;
		try {
			con = dbUtil.getCon();
		} catch (Exception ex) {
			ex.printStackTrace();
			return;
		}
		int hostStudentNumber = Integer.parseInt(inputNumber);
		boolean exist = GuestDao.checkExists(con, guestID);
		if (exist == true) {
			visitRecord vd = new visitRecord(guestID, hostStudentNumber, sqlDate);
			int result = visitRecordDao.addVisitRecord(con, vd);
			if (result == 1) {
				JOptionPane.showMessageDialog(null, "Sueecssed");
			} else {
				JOptionPane.showMessageDialog(null, "Failed");
			}
		} else {
			int result = JOptionPane.showConfirmDialog(null, "Guest doesn't exist, create new guest?");
			if (result == 0) {
				Guest guest = new Guest(guestID, guestName);
				GuestDao.creatNewGuest(con, guest);
				visitRecord vd = new visitRecord(guestID, hostStudentNumber, sqlDate);
				int result1 = visitRecordDao.addVisitRecord(con, vd);
				if (result1 == 1) {
					JOptionPane.showMessageDialog(null, "Sueecssed");
				} else {
					JOptionPane.showMessageDialog(null, "Failed");
				}
			} else {
				return;
			}
		}

	}
}
