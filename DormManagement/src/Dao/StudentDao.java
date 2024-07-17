package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Object.Student;

public class StudentDao {
	/**
	 * insert a new student into database
	 * 
	 * @param con
	 * @param guest
	 * @return the result of sql updating
	 */
	public static int addNewStudents(Connection con, Student student) throws Exception {
		String sql = "insert into students(student_number,student_password,student_name,room_number,rent_time) values(?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, student.getStudentNumber());
		ps.setString(2, student.getStudentPassword());
		ps.setString(3, student.getStudentName());
		ps.setInt(4, student.getRoomNumber());
		ps.setDate(5, student.getRentTime());
		return ps.executeUpdate();
	}

	/**
	 * function of student login
	 * 
	 * @param con
	 * @param student
	 * @return current student
	 * @throws Exception
	 */
	public static Student login(Connection con, Student student) throws Exception {
		Student rsstudent = null;
		String sql = "Select * from students where student_number=? and student_password=?";
		PreparedStatement pt = con.prepareStatement(sql);
		pt.setInt(1, student.getStudentNumber());
		pt.setString(2, student.getStudentPassword());
		ResultSet rs = pt.executeQuery();
		if (rs.next()) {
			rsstudent = new Student();
			rsstudent.setStudentNumber(rs.getInt("student_number"));
			rsstudent.setStudentPassword(rs.getString("student_password"));
			rsstudent.setStudentName(rs.getString("student_name"));
			rsstudent.setRoomNumber(rs.getInt("room_number"));
			rsstudent.setRentTime(rs.getDate("rent_time"));
		}
		return rsstudent;
	}

	/**
	 * check if the password already exists, make sure there is no duplicate when
	 * initializing students' password
	 * 
	 * @param con
	 * @param pwd
	 * @return true if it already exists, false if not
	 * @throws Exception
	 */
	public static boolean CheckPassword(Connection con, String pwd) throws Exception {
		String sql = "Select * from students where student_password=?";
		PreparedStatement pt = con.prepareStatement(sql);
		pt.setString(1, pwd);
		ResultSet rs = pt.executeQuery();
		if (rs.next()) {
			return true;
		}
		return false;
	}

	/**
	 * check if the this student already exists
	 * 
	 * @param con
	 * @param student
	 * @return true if exits, false if not
	 * @throws Exception
	 */
	public static boolean CheckStudentID(Connection con, Student student) throws Exception {
		String sql = "Select * from students where student_number=?";
		try {
			PreparedStatement pt = con.prepareStatement(sql);
			pt.setInt(1, student.getStudentNumber());
			ResultSet rs = pt.executeQuery();
			if (rs.next()) {
				return true;
			}
			return false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * used by student to change password
	 * 
	 * @param con
	 * @param student
	 * @param newPassword
	 * @return the result of sql updating
	 * @throws Exception
	 */
	public static int ChangePassword(Connection con, Student student, String newPassword) throws Exception {
		String sql = "UPDATE students SET student_password =? WHERE ( student_number = ?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, newPassword);
		ps.setInt(2, student.getStudentNumber());
		return ps.executeUpdate();
	}

	/**
	 * search all the students with certain conditions
	 * 
	 * @param con
	 * @param student
	 * @return result set of students
	 */
	public static ResultSet list(Connection con, Student student) {
		StringBuffer sb = new StringBuffer("select * from students where student_number>0");
		if (student.getStudentNumber() != -1) {
			sb.append(" and student_number=" + student.getStudentNumber());
		}
		if (student.getRoomNumber() != -1) {
			sb.append(" and room_number=" + student.getRoomNumber());
		}
		if (student.getRentTime() != null) {
			sb.append(" and rent_time='" + student.getRentTime() + "'");
		}
		try {
			PreparedStatement pt = con.prepareStatement(sb.toString());
			ResultSet rs = pt.executeQuery();
			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * modify student information
	 * 
	 * @param con
	 * @param student
	 * @return the result of sql updating
	 * @throws Exception
	 */
	public static int update(Connection con, Student student) throws Exception {
		String sql = "update students set student_name=?,rent_time=?,room_number=? where student_number=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, student.getStudentName());
		ps.setDate(2, student.getRentTime());
		ps.setInt(3, student.getRoomNumber());
		ps.setInt(4, student.getStudentNumber());
		return ps.executeUpdate();
	}

	/**
	 * get student's room number of given student number
	 * 
	 * @param studentNumber
	 * @param con
	 * @return room number
	 * @throws Exception
	 */
	public static int getStudentRoomNumber(int studentNumber, Connection con) throws Exception {
		String sql = "Select * from students where student_number=?";
		PreparedStatement pt = con.prepareStatement(sql);
		pt.setInt(1, studentNumber);
		ResultSet rs = pt.executeQuery();
		rs.next();
		int roomNumber = rs.getInt("room_number");
		return roomNumber;
	}
}
