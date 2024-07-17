package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;

/**
 * display RA information for ecah floor
 */
public class RAInformationInterFr extends JInternalFrame {

	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RAInformationInterFr frame = new RAInformationInterFr();
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
	public RAInformationInterFr() {
		setResizable(true);
		setClosable(true);
		setTitle("Contact your RA");
		setBounds(100, 100, 451, 443);

		JLabel lblNewLabel = new JLabel("1001-1050:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel lblNewLabel_1 = new JLabel("Jack room number: 1005 email: jack@123.com");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel lblNewLabel_2 = new JLabel("1051-1100:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel lblNewLabel_3 = new JLabel("Amy room number: 1055 email: amy@123.com");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel lblNewLabel_4 = new JLabel("2001-2050:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel lblNewLabel_5 = new JLabel("Mike room number: 2005 email: mike@123.com");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel lblNewLabel_6 = new JLabel("2051-2100:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel lblNewLabel_7 = new JLabel("John room number: 2055 email: john@123.com");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel lblNewLabel_8 = new JLabel("3001-3049:");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel lblNewLabel_9 = new JLabel("Alan room number: 3005 email: alan@123.com");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel lblNewLabel_10 = new JLabel("3051-3100:");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel lblNewLabel_11 = new JLabel("Peter room number: 3055 email: peter@123.com");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel lblNewLabel_12 = new JLabel("4001-4050:");
		lblNewLabel_12.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel lblNewLabel_13 = new JLabel("Clay  room number: 4005 email: clay@123.com");
		lblNewLabel_13.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel lblNewLabel_14 = new JLabel("4051-4100:");
		lblNewLabel_14.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel lblNewLabel_15 = new JLabel("Carl room number: 4055 email: carl@123.com");
		lblNewLabel_15.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup()
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
						.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup().addContainerGap().addComponent(lblNewLabel,
								GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup().addContainerGap().addComponent(lblNewLabel_2,
								GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup().addContainerGap()
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(lblNewLabel_12, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
												GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(lblNewLabel_10, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
												GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(lblNewLabel_8, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
												GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(lblNewLabel_6, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
												GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(lblNewLabel_4, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 80,
												Short.MAX_VALUE)
										.addGroup(groupLayout.createSequentialGroup()
												.addComponent(lblNewLabel_14, GroupLayout.DEFAULT_SIZE,
														GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addGap(55))))
						.addGroup(groupLayout.createSequentialGroup().addGap(32).addComponent(lblNewLabel_3, 0, 0,
								Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup().addGap(33).addComponent(lblNewLabel_1,
								GroupLayout.PREFERRED_SIZE, 311, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup().addGap(31).addComponent(lblNewLabel_5,
								GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup().addGap(31).addComponent(lblNewLabel_7,
								GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup().addGap(29).addComponent(lblNewLabel_9,
								GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup().addGap(28).addComponent(lblNewLabel_11,
								GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup().addGap(28).addComponent(lblNewLabel_13,
								GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
						.addGroup(groupLayout.createSequentialGroup().addGap(29).addComponent(lblNewLabel_15,
								GroupLayout.PREFERRED_SIZE, 324, GroupLayout.PREFERRED_SIZE)))
				.addContainerGap(82, Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap().addComponent(lblNewLabel)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblNewLabel_1)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblNewLabel_2)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblNewLabel_3)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblNewLabel_4)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblNewLabel_5)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblNewLabel_6)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblNewLabel_7)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblNewLabel_8)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblNewLabel_9)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblNewLabel_10)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblNewLabel_11)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblNewLabel_12)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblNewLabel_13)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblNewLabel_14)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblNewLabel_15)
						.addContainerGap(40, Short.MAX_VALUE)));
		getContentPane().setLayout(groupLayout);

	}
}
