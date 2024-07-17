package Dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Object.Guest;
import Object.Room;
import Object.visitRecord;
import Util.StringUtil;

public class visitRecordDao {
	/**
	 * insert a new record into database
	 * 
	 * @param con
	 * @param record
	 * @return the result of sql updating
	 */
	public static int addVisitRecord(Connection con, visitRecord record) {
		String sql = "select * from visitRecord where guest_ID=?";
		PreparedStatement ps;
		ResultSet rs = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, record.getGuest_ID());
			rs = ps.executeQuery();
			while (rs.next()) {
				Date checkInDate = rs.getDate("checkInDate");
				if (checkInDate.compareTo(record.getCheckInDate()) == 0) {
					JOptionPane.showMessageDialog(null, "a guest can only register once per day");
					return -1;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}

		sql = "insert into visitRecord(guest_ID,hostStudent_number,checkInDate,checkoutDate) values(?,?,?,?)";

		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, record.getGuest_ID());
			ps.setInt(2, record.getHostStudentNumber());
			ps.setDate(3, record.getCheckInDate());
			ps.setDate(4, record.getCheckOutDate());
			return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
	}

	/**
	 * search all the visit records by certain conditions
	 * 
	 * @param con
	 * @param record
	 * @param guest
	 * @param room
	 * @return result set of visit record
	 */
	public static ResultSet list(Connection con, visitRecord record, Guest guest, Room room) {
		StringBuffer sb = new StringBuffer(
				"SELECT * FROM students stu JOIN visitRecord vr ON vr.hostStudent_number = stu.student_number JOIN guests g ON vr.guest_ID = g.guest_ID JOIN rooms r ON r.room_number = stu.room_number ");
		if (!StringUtil.Empty(record.getGuest_ID())) {
			sb.append(" and vr.guest_ID= '" + record.getGuest_ID() + "'");
		}
		if (record.getHostStudentNumber() != -1) {
			sb.append(" and vr.hostStudent_number=" + record.getHostStudentNumber());
		}
		if (room.getRoomNumber() != -1) {
			sb.append(" and r.room_number=" + room.getRoomNumber());
		}
		if (!StringUtil.Empty(guest.getName())) {
			sb.append(" and g.guest_name like '%" + guest.getName() + "%'");
		}
		if (record.getCheckInDate() != null) {
			sb.append(" and vr.checkInDate ='" + record.getCheckInDate() + "'");
		}
		if (record.getCheckOutDate() != null) {
			sb.append(" and vr.checkOutDate ='" + record.getCheckOutDate() + "'");
		}
		try {
			PreparedStatement pt = con.prepareStatement(sb.toString().replaceFirst("and", "where"));
			ResultSet rs = pt.executeQuery();
			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * modify check out date of visit record
	 * 
	 * @param con
	 * @param vr
	 * @return the result of sql updating
	 * @throws Exception
	 */
	public static int UpdateVisitRecord(Connection con, visitRecord vr) throws Exception {
		String sql = "update visitRecord set checkOutDate=? where hostStudent_number =? and guest_ID=? and checkInDate =?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setDate(1, vr.getCheckOutDate());
		ps.setInt(2, vr.getHostStudentNumber());
		ps.setString(3, vr.getGuest_ID());
		ps.setDate(4, vr.getCheckInDate());
		return ps.executeUpdate();
	}

	/**
	 * delete a record from database
	 * 
	 * @param con
	 * @param vr
	 * @return the result of sql updating
	 * @throws Exception
	 */
	public static int DeleteRecord(Connection con, visitRecord vr) throws Exception {
		String sql = "DELETE FROM visitrecord WHERE guest_ID= ? and hostStudent_number= ? and checkInDate = ? and checkOutDate = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, vr.getGuest_ID());
		ps.setInt(2, vr.getHostStudentNumber());
		ps.setDate(3, vr.getCheckInDate());
		ps.setDate(4, vr.getCheckOutDate());
		return ps.executeUpdate();
	}
}
