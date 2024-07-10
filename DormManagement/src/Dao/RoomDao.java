package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RoomDao {
	public static int initializeRoom(Connection con) {
		int result=0;
		for(int i = 1;i<5;i++) {
			for(int j =1;j<101;j++) {
				String sql="insert into rooms(room_number,room_state) values(?,?)";
				PreparedStatement ps;
				try {
					ps = con.prepareStatement(sql);
					ps.setInt(1,1000*i+j);
					ps.setString(2,"Available");
					result += ps.executeUpdate();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
			}
		}
		return result;
	}
	public static int findAvailableRoom(Connection con) {
		String sql="Select * from rooms where room_state=?";
		PreparedStatement pt;
		try {
			pt = con.prepareStatement(sql);
			pt.setString(1,"Available");
			ResultSet rs=pt.executeQuery();
			if(rs.next()) {
				int roomnumber = rs.getInt("room_number");
				return roomnumber;
			}
			return -1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}
	public static int updateRoomState(Connection con,int roomnumber,boolean isMoveIn) {
		String sql="UPDATE rooms SET room_state =? where room_number=?";
		try {
		PreparedStatement ps=con.prepareStatement(sql);
		if(isMoveIn) {
			ps.setString(1,"Occupied");
		}
		else {
			ps.setString(1,"Available");
		}
		ps.setInt(2,roomnumber);
		return ps.executeUpdate();}
		catch(Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
}
