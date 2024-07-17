package Object;

import java.sql.Date;
import java.time.LocalDate;

public class visitRecord {
	private String guest_ID;
	private int hostStudentNumber;
	private Date checkInDate;
	private Date checkOutDate;

	public visitRecord(String guest_ID, int hostStudentNumber, Date checkOutDate) {
		this.guest_ID = guest_ID;
		this.hostStudentNumber = hostStudentNumber;
		this.checkOutDate = checkOutDate;
		LocalDate localDate = LocalDate.now();
		this.checkInDate = Date.valueOf(localDate);
	}

	public visitRecord(String guest_ID, int hostStudentNumber, Date checkInDate, Date checkOutDate) {
		this.guest_ID = guest_ID;
		this.hostStudentNumber = hostStudentNumber;
		this.checkInDate = checkInDate;
		this.checkOutDate = checkOutDate;
	}

	public String getGuest_ID() {
		return guest_ID;
	}

	public void setGuest_ID(String guest_ID) {
		this.guest_ID = guest_ID;
	}

	public int getHostStudentNumber() {
		return hostStudentNumber;
	}

	public void setHostStudentNumber(int hostStudentNumber) {
		this.hostStudentNumber = hostStudentNumber;
	}

	public Date getCheckInDate() {
		return checkInDate;
	}

	public void setCheckInDate(Date checkInDate) {
		this.checkInDate = checkInDate;
	}

	public Date getCheckOutDate() {
		return checkOutDate;
	}

	public void setCheckOutDate(Date checkOutDate) {
		this.checkOutDate = checkOutDate;
	}

}
