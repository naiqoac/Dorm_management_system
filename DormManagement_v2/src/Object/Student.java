package Object;

import java.sql.Date;

public class Student {
	private int studentNumber;
	private String studentPassword;
	private int roomNumber;
	private String studentName;
	private java.sql.Date rentTime;

	public Student(int studentNumber, int roomNumber, Date rentTime) {
		this.studentNumber = studentNumber;
		this.roomNumber = roomNumber;
		this.rentTime = rentTime;
	}

	public Student(int studentNumber, String studentName, int roomNumber, Date rentTime) {
		this.studentNumber = studentNumber;
		this.roomNumber = roomNumber;
		this.studentName = studentName;
		this.rentTime = rentTime;
	}

	public Student(int studentNumber, String studentPassword, String studentName, int roomNumber, Date rentTime) {
		this.studentNumber = studentNumber;
		this.studentPassword = studentPassword;
		this.roomNumber = roomNumber;
		this.studentName = studentName;
		this.rentTime = rentTime;
	}

	public Student(int studentNumber, String studentPassword) {
		this.studentNumber = studentNumber;
		this.studentPassword = studentPassword;
	}

	public Student() {
	}

	public int getStudentNumber() {
		return studentNumber;
	}

	public void setStudentNumber(int studentNumber) {
		this.studentNumber = studentNumber;
	}

	public String getStudentPassword() {
		return studentPassword;
	}

	public void setStudentPassword(String studentPassword) {
		this.studentPassword = studentPassword;
	}

	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public Date getRentTime() {
		return rentTime;
	}

	public void setRentTime(Date rentTime) {
		this.rentTime = rentTime;
	}
}
