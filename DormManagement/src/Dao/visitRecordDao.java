package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import Object.visitRecord;

public class visitRecordDao {
	public static int addVisitRecord(Connection con,visitRecord record) {
		String sql="insert into visitRecord(guest_ID,hostStudent_number,checkInDate,checkoutDate) values(?,?,?,?)";
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1,record.getGuest_ID());
			ps.setInt(2,record.getHostStudentNumber());
			ps.setDate(3,record.getCheckInDate());
			ps.setDate(4, record.getCheckOutDate());
			return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
	}
}
