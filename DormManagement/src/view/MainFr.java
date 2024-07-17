package view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Object.Admin;

/**
 * main page for admin
 */
public class MainFr extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JDesktopPane table = new JDesktopPane();

	/**
	 * Create the frame.
	 */
	public MainFr(Admin admin) {
		setTitle("Dorm Management System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("Management");
		menuBar.add(mnNewMenu);

		JMenu mnNewMenu_1 = new JMenu("Student management");
		mnNewMenu.add(mnNewMenu_1);

		JMenuItem mntmNewMenuItem = new JMenuItem("Add student");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddNewStudentInterFr adduserinterfr = new AddNewStudentInterFr();
				adduserinterfr.setVisible(true);
				table.add(adduserinterfr);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem);

		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Manage student");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManageStudentInterFr fr = new ManageStudentInterFr();
				fr.setVisible(true);
				table.add(fr);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_1);

		JMenu mnNewMenu_4 = new JMenu("Guest managemrnt");
		mnNewMenu.add(mnNewMenu_4);

		JMenuItem mntmNewMenuItem_2 = new JMenuItem("register guest");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegisterVisitor fr = new RegisterVisitor();
				fr.setVisible(true);
				table.add(fr);
			}
		});
		mnNewMenu_4.add(mntmNewMenuItem_2);

		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Manage guest");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManageGuestInterFr fr = new ManageGuestInterFr();
				fr.setVisible(true);
				table.add(fr);
			}
		});
		mnNewMenu_4.add(mntmNewMenuItem_3);

		JMenu mnNewMenu_2 = new JMenu("Report management");
		mnNewMenu.add(mnNewMenu_2);

		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Create new report");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CreateReportAdmin fr = new CreateReportAdmin(admin);
				fr.setVisible(true);
				table.add(fr);
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_4);

		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Manage report");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminCheckReportInterFr fr = new AdminCheckReportInterFr(admin);
				fr.setVisible(true);
				table.add(fr);
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_5);

		JMenu mnNewMenu_3 = new JMenu("Log out");
		mnNewMenu.add(mnNewMenu_3);

		JMenuItem mntmNewMenuItem_6 = new JMenuItem("Exit");
		mntmNewMenuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "Do you want to exit?");
				if (result == 0) {
					System.exit(0);
				}
			}
		});
		mnNewMenu_3.add(mntmNewMenuItem_6);

		JMenuItem mntmNewMenuItem_7 = new JMenuItem("Switch account");
		mntmNewMenuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "Do you want to switch account?");
				if (result == 0) {
					dispose();
					LoginFr loginfr = new LoginFr();
					loginfr.setVisible(true);
				}
			}
		});
		mnNewMenu_3.add(mntmNewMenuItem_7);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		contentPane.add(table, BorderLayout.CENTER);
		// set the window at center
		this.setLocationRelativeTo(null);
	}
}
