package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Object.Guest;

public class GuestDao {
	/**
	 * Insert a new guest with guest id and guest name into database
	 * @param con
	 * @param guest
	 * @return the result of sql updating
	 */
	public static int creatNewGuest(Connection con,Guest guest) {
		String sql="insert into guests(guest_ID,guest_name) values(?,?)";
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1,guest.getID());
			ps.setString(2,guest.getName());
			return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
		
	}
	/**
	 * check if the guest exists when registering a new guest
	 * @param con
	 * @param guestID
	 * @return true if exists false if doesn't exists
	 * @throws Exception
	 */
	public static boolean checkExists(Connection con,String guestID) throws Exception {
		String sql="Select * from guests where guest_ID=?";
		PreparedStatement pt=con.prepareStatement(sql);
		pt.setString(1,guestID);
		ResultSet rs=pt.executeQuery();
		if(rs.next()) {
		return true;}
		return false;
	}
}
