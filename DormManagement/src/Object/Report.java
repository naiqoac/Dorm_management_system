package Object;

import java.sql.Date;
import java.time.LocalDate;

public class Report {
	int StudentNumber;
	String adminAccount;
	Date reportDate;
	String decription;
	String state;
	int reportNumber;
	public Report() {}
	public Report(int studentNumber, String decription,int reportNumber) {
		this.StudentNumber = studentNumber;
		this.decription = decription;
		this.adminAccount=null;
		LocalDate localDate = LocalDate.now();
        this.reportDate = Date.valueOf(localDate);
        this.state="Unsolved";
        this.reportNumber=reportNumber;
	}
	public Report( String adminAccount, String decription,int reportNumber) {
		this.adminAccount = adminAccount;
		this.decription = decription;
		this.StudentNumber=-1;
		LocalDate localDate = LocalDate.now();
        this.reportDate = Date.valueOf(localDate);
        this.state="Unsolved";
        this.reportNumber=reportNumber;
	}
	public int getReportNumber() {
		return reportNumber;
	}
	public void setReportNumber(int reportNumber) {
		this.reportNumber = reportNumber;
	}
	public int getStudentNumber() {
		return StudentNumber;
	}
	public void setStudentNumber(int studentNumber) {
		StudentNumber = studentNumber;
	}
	public String getAdminAccount() {
		return adminAccount;
	}
	public void setAdminAccount(String adminAccount) {
		this.adminAccount = adminAccount;
	}
	public Date getReportDate() {
		return reportDate;
	}
	public void setReportDate(Date reportDate) {
		this.reportDate = reportDate;
	}
	public String getDecription() {
		return decription;
	}
	public void setDecription(String decription) {
		this.decription = decription;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
}
