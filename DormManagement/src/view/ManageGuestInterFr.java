package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Vector;
import java.sql.Date;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import Dao.ReportDao;
import Dao.RoomDao;
import Dao.StudentDao;
import Dao.visitRecordDao;
import Object.Guest;
import Object.Room;
import Object.Student;
import Object.visitRecord;
import Util.DatePick;
import Util.StringUtil;
import Util.dbUtil;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ManageGuestInterFr extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private JTextField StudentNumberSearch;
	private JTextField GuestIDSearch;
	private JTextField CheckInDateSearch;
	private JTextField CheckOutDateSearch;
	private JTextField GuestNameSearch;
	private JTextField StudentNumber;
	private JTextField GuestID;
	private JTextField CheckInDate;
	private JTextField CheckOutDate;
	private JTextField GuestName;
	private JTextField RoomNumberSearch;
	private JTextField RoomNumber;


	/**
	 * Create the frame.
	 */
	public ManageGuestInterFr() {
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 806, 514);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Search", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JScrollPane scrollPane = new JScrollPane();
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Modify", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		JLabel lblNewLabel_5 = new JLabel("Student Number:");
		
		StudentNumber = new JTextField();
		StudentNumber.setEditable(false);
		StudentNumber.setColumns(10);
		StudentNumber.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                String key = "0123456789";
                if (key.indexOf(e.getKeyChar()) < 0) {
                    e.consume();
                }
            }
        });
		
		JLabel lblNewLabel_1_1 = new JLabel("Guest ID:");
		
		GuestID = new JTextField();
		GuestID.setEditable(false);
		GuestID.setColumns(10);
		
		JLabel lblNewLabel_2_1 = new JLabel("Guest name:");
		
		JLabel lblNewLabel_3_1 = new JLabel("Check in date:");
		
		CheckInDate = new JTextField();
		CheckInDate.setEditable(false);
		CheckInDate.setColumns(10);
		
		JLabel lblNewLabel_4_1 = new JLabel("Check out date:");
		
		CheckOutDate = new JTextField();
		CheckOutDate.setColumns(10);
		
		JButton btnNewButton_1_1 = new JButton("Choose date");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CheckOutDate.setText(new DatePick().Set_Picked_Date());
			}
		});
		
		GuestName = new JTextField();
		GuestName.setEditable(false);
		GuestName.setColumns(10);
		
		JButton btnNewButton_3 = new JButton("Submit");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateVisitRecord(e);
			}
		});
		
		JButton btnNewButton_5 = new JButton("Delete");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteRecord(e);
			}
		});
		
		JLabel lblNewLabel_7 = new JLabel("Room number:");
		
		RoomNumber = new JTextField();
		RoomNumber.setEditable(false);
		RoomNumber.setColumns(10);
		RoomNumber.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                String key = "0123456789";
                if (key.indexOf(e.getKeyChar()) < 0) {
                    e.consume();
                }
            }
        });
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(lblNewLabel_5)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(StudentNumber, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel_1_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(GuestID, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel_2_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(GuestName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel_7)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(RoomNumber, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(lblNewLabel_3_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(CheckInDate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(btnNewButton_3)
									.addGap(70)
									.addComponent(btnNewButton_5))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addGap(97)
									.addComponent(lblNewLabel_4_1)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(CheckOutDate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnNewButton_1_1)))))
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_5)
						.addComponent(StudentNumber, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1_1)
						.addComponent(GuestID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2_1)
						.addComponent(GuestName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_7)
						.addComponent(RoomNumber, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3_1)
						.addComponent(CheckInDate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(CheckOutDate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_1_1)
						.addComponent(lblNewLabel_4_1))
					.addPreferredGap(ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_3)
						.addComponent(btnNewButton_5))
					.addContainerGap())
		);
		panel_1.setLayout(gl_panel_1);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addGap(90)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(scrollPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 626, Short.MAX_VALUE)
								.addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
					.addGap(74))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(22)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(33))
		);
		
		JLabel lblNewLabel = new JLabel("Student Number:");
		
		StudentNumberSearch = new JTextField();
		StudentNumberSearch.setColumns(10);
		StudentNumberSearch.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                String key = "0123456789";
                if (key.indexOf(e.getKeyChar()) < 0) {
                    e.consume();
                }
            }
        });
		
		JLabel lblNewLabel_1 = new JLabel("Guest ID:");
		
		GuestIDSearch = new JTextField();
		GuestIDSearch.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Guest name:");
		
		JLabel lblNewLabel_3 = new JLabel("Check in date:");
		
		CheckInDateSearch = new JTextField();
		CheckInDateSearch.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Check out date:");
		
		CheckOutDateSearch = new JTextField();
		CheckOutDateSearch.setColumns(10);
		
		JButton btnNewButton = new JButton("Choose date");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CheckInDateSearch.setText(new DatePick().Set_Picked_Date());
			}
		});
		
		JButton btnNewButton_1 = new JButton("Choose date");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CheckOutDateSearch.setText(new DatePick().Set_Picked_Date());
			}
		});
		
		GuestNameSearch = new JTextField();
		GuestNameSearch.setColumns(10);
		
		JButton btnNewButton_4 = new JButton("Search");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Search(e);
			}
		});
		
		JLabel lblNewLabel_6 = new JLabel("Room number:");
		
		RoomNumberSearch = new JTextField();
		RoomNumberSearch.setColumns(10);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblNewLabel)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(StudentNumberSearch, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblNewLabel_1)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(GuestIDSearch, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblNewLabel_2)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(GuestNameSearch, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblNewLabel_6)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(RoomNumberSearch, GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblNewLabel_3)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(CheckInDateSearch, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnNewButton)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblNewLabel_4)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(CheckOutDateSearch, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnNewButton_1))))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(238)
							.addComponent(btnNewButton_4)))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(StudentNumberSearch, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1)
						.addComponent(GuestIDSearch, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2)
						.addComponent(GuestNameSearch, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_6)
						.addComponent(RoomNumberSearch, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(CheckInDateSearch, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(CheckOutDateSearch, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_4)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnNewButton_4)
					.addContainerGap(12, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				GuestMousePressed(e);
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Host student number", "Guset ID", "Guset name", "Check In Date", "Check Out Date", "Room number"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, true, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(table);
		getContentPane().setLayout(groupLayout);
		fillTable(new visitRecord(null,-1,null,null),new Room(-1),new Guest(null,null));
	}
	/**
	 * delete a visit record from database
	 * @param e
	 */
	private void DeleteRecord(ActionEvent e) {
		String inputNumber=this.StudentNumber.getText();
		if(StringUtil.Empty(inputNumber)) {
			JOptionPane.showMessageDialog(null, "Select the record you want to modify");
			return;
		}
		int studentNumber=Integer.parseInt(inputNumber);
		String guestID=this.GuestID.getText();
		if(StringUtil.Empty(guestID)) {
			JOptionPane.showMessageDialog(null, "Guest ID can not be empty");
			return;
		}
		Date checkInDate =null;
		Date checkOutDate =null;
		try {
			checkInDate = Date.valueOf(this.CheckInDate.getText());
		    checkOutDate = Date.valueOf(this.CheckOutDate.getText());}
			catch(Exception ex) {
				JOptionPane.showMessageDialog(null, "Date format incorrect, use yyyy-MM-dd format");
				return;
			}
		Connection con=null;
		int result=-1;
		try {
			con=dbUtil.getCon();
			visitRecord vr = new visitRecord(guestID,studentNumber,checkInDate,checkOutDate);
			result=visitRecordDao.DeleteRecord(con, vr);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		if(result!=1) {
			JOptionPane.showMessageDialog(null, "Failed");
		}
		else {
			JOptionPane.showMessageDialog(null, "Success");
			fillTable(new visitRecord(null,-1,null,null),new Room(-1),new Guest(null,null));
		}
	}
	/**
	 * update visit record 
	 * @param e
	 */
	private void UpdateVisitRecord(ActionEvent e) {
		String inputNumber=this.StudentNumber.getText();
		if(StringUtil.Empty(inputNumber)) {
			JOptionPane.showMessageDialog(null, "Select the record you want to modify");
			return;
		}
		int studentNumber=Integer.parseInt(inputNumber);
		String guestID=this.GuestID.getText();
		if(StringUtil.Empty(guestID)) {
			JOptionPane.showMessageDialog(null, "Guest ID can not be empty");
			return;
		}
		Date checkInDate =null;
		Date checkOutDate =null;
		try {
			checkInDate = Date.valueOf(this.CheckInDate.getText());
		    checkOutDate = Date.valueOf(this.CheckOutDate.getText());}
			catch(Exception ex) {
				JOptionPane.showMessageDialog(null, "Date format incorrect, use yyyy-MM-dd format");
				return;
			}
		Connection con=null;
		int result=-1;
		try {
			con=dbUtil.getCon();
			visitRecord vr = new visitRecord(guestID,studentNumber,checkInDate,checkOutDate);
			result=visitRecordDao.UpdateVisitRecord(con, vr);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		if(result!=1) {
			JOptionPane.showMessageDialog(null, "Failed");
		}
		else {
			JOptionPane.showMessageDialog(null, "Success");
			fillTable(new visitRecord(null,-1,null,null),new Room(-1),new Guest(null,null));
		}
	}
	/**
	 * fill the field with the information of selected record
	 * @param e
	 */
	private void GuestMousePressed(MouseEvent e) {
		int row = this.table.getSelectedRow();
        this.StudentNumber.setText(String.valueOf(table.getValueAt(row, 0)));
        this.GuestID.setText((String) table.getValueAt(row, 1));
        this.GuestName.setText(String.valueOf(table.getValueAt(row, 2)));
        this.RoomNumber.setText(String.valueOf(table.getValueAt(row, 5)));
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = dateFormat.format(table.getValueAt(row, 3));
        this.CheckInDate.setText(dateString);
        dateString = dateFormat.format(table.getValueAt(row, 4));
        this.CheckOutDate.setText(dateString);
	}
	/**
	 * search record by certain conditions
	 * @param e
	 */
	private void Search(ActionEvent e) {
		String studentNumberInput=StudentNumberSearch.getText();
		int studentNumber=-1;
		 if (!StringUtil.Empty(studentNumberInput)) {
			 studentNumber=Integer.parseInt(studentNumberInput);
		 }
		String guestID=GuestIDSearch.getText();
		String guestName=GuestNameSearch.getText();
		Date checkInDate=null;
		Date checkOutDate=null;
		String checkIn=CheckInDateSearch.getText();
		String checkOut=CheckOutDateSearch.getText();
		if (!StringUtil.Empty(checkIn)) {
            try {
                checkInDate= Date.valueOf(checkIn);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Check in date format incorrect, use yyyy-MM-dd format");
                return;
            }
        }
		if (!StringUtil.Empty(checkOut)) {
            try {
                checkOutDate= Date.valueOf(checkOut);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Check out date format incorrect, use yyyy-MM-dd format");
                return;
            }
        }
		int roomNumber=-1;
		String roomNumberInput=RoomNumberSearch.getText();
		if (!StringUtil.Empty(roomNumberInput)) {
			 roomNumber=Integer.parseInt(roomNumberInput);
		 }
		visitRecord vr = new visitRecord(guestID,studentNumber,checkInDate,checkOutDate);
		Guest guest = new Guest(guestID,guestName);
		Room room = new Room(roomNumber);
		fillTable(vr,room,guest);
	}
	/**
	 * fill table with records matched the given conditions
	 * @param record
	 * @param room
	 * @param guest
	 */
	private void fillTable(visitRecord record,Room room,Guest guest) {
        DefaultTableModel dtm = (DefaultTableModel) table.getModel();
        dtm.setRowCount(0);
        try {
            Connection con = dbUtil.getCon();
            ResultSet rs=visitRecordDao.list(con, record, guest, room);
            if (rs == null) {
                return;
            }
            while (rs.next()) {
                Vector v = new Vector();
                v.add(rs.getInt("vr.hostStudent_number")); 
                v.add(rs.getString("g.guest_ID"));
                v.add(rs.getString("g.guest_name"));
                v.add(rs.getDate("vr.checkInDate"));
                v.add(rs.getDate("vr.checkOutDate")); v.add(rs.getInt("r.room_number"));
                dtm.addRow(v);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
