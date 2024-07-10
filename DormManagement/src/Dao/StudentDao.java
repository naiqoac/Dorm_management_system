package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Object.Student;

public class StudentDao {
	public static int addNewStudents(Connection con,Student student)throws Exception{
		String sql="insert into students(student_number,student_password,student_name,room_number,rent_time) values(?,?,?,?,?)";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setInt(1,student.getStudentNumber());
		ps.setString(2,student.getStudentPassword());
		ps.setString(3,student.getStudentName());
		ps.setInt(4,student.getRoomNumber());
		ps.setDate(5,student.getRentTime());
		return ps.executeUpdate();
	}
	public static Student login(Connection con,Student student)throws Exception{
		Student rsstudent=null;
		String sql="Select * from students where student_number=? and student_password=?";
		PreparedStatement pt=con.prepareStatement(sql);
		pt.setInt(1,student.getStudentNumber());
		pt.setString(2,student.getStudentPassword());
		ResultSet rs=pt.executeQuery();
		if(rs.next()) {
			rsstudent=new Student();
			rsstudent.setStudentNumber(rs.getInt("student_number"));
			rsstudent.setStudentPassword(rs.getString("student_password"));
			rsstudent.setStudentName(rs.getString("student_name"));
			rsstudent.setRoomNumber(rs.getInt("room_number"));
			rsstudent.setRentTime(rs.getDate("rent_time"));
		}
		return rsstudent;
	}
	public static boolean CheckPassword(Connection con,String pwd)throws Exception{
		String sql="Select * from students where student_password=?";
		PreparedStatement pt=con.prepareStatement(sql);
		pt.setString(1,pwd);
		ResultSet rs=pt.executeQuery();
		if(rs.next()) {
		return true;}
		return false;
	}
	public static boolean CheckStudentID(Connection con,Student student)throws Exception {
		String sql="Select * from students where student_number=?";	
		try {
			PreparedStatement pt=con.prepareStatement(sql);
			pt.setInt(1,student.getStudentNumber());
			ResultSet rs=pt.executeQuery();
			if(rs.next()) {
				return true;}
				return false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
	}
	public static int ChangePassword(Connection con,Student student, String newPassword)throws Exception {
		String sql="UPDATE students SET student_password =? WHERE ( student_number = ?)";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1,newPassword);
		ps.setInt(2,student.getStudentNumber());
		return ps.executeUpdate();
	}
}
