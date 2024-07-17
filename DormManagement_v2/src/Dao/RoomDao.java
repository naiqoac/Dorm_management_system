package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Object.Student;

public class RoomDao {
	/**
	 * find the available room when a student move in
	 * 
	 * @param con
	 * @return room number
	 */
	public static int findAvailableRoom(Connection con) {
		String sql = "Select * from rooms where room_state=?";
		PreparedStatement pt;
		try {
			pt = con.prepareStatement(sql);
			pt.setString(1, "Available");
			ResultSet rs = pt.executeQuery();
			if (rs.next()) {
				int roomnumber = rs.getInt("room_number");
				return roomnumber;
			}
			return -1;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return 0;
	}

	/**
	 * update room state to occupied or available
	 * 
	 * @param con
	 * @param room     number
	 * @param isMoveIn
	 * @return
	 */
	public static int updateRoomState(Connection con, int roomnumber, boolean isMoveIn) {
		String sql = "UPDATE rooms SET room_state =? where room_number=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			if (isMoveIn) {
				ps.setString(1, "Occupied");
			} else {
				ps.setString(1, "Available");
			}
			ps.setInt(2, roomnumber);
			return ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}

	/**
	 * check room state
	 * 
	 * @param roomNumber
	 * @param con
	 * @return true if available false if occupied
	 * @throws Exception
	 */
	public static boolean checkRoomState(int roomNumber, Connection con) throws Exception {
		String sql = "select room_state from rooms where room_number=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, roomNumber);
		ResultSet rs = ps.executeQuery();
		rs.next();
		boolean state;
		if (rs.getString("room_state").equals("Available")) {
			state = true;
		} else {
			state = false;
		}
		return state;
	}

	/**
	 * move a student to a new room,set the new room to occupied and old room to
	 * available
	 * 
	 * @param student
	 * @param newRoomNumber
	 * @param con
	 * @return result of sql updating
	 * @throws Exception
	 */
	public static int changeRoom(Student student, int newRoomNumber, Connection con) throws Exception {
		String sql = "select room_number from students where student_number=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, student.getStudentNumber());
		ResultSet rs = ps.executeQuery();
		rs.next();
		int oldRoomNumber = rs.getInt("room_number");
		int result = updateRoomState(con, oldRoomNumber, false);
		result = updateRoomState(con, newRoomNumber, true);
		return result;
	}
}
