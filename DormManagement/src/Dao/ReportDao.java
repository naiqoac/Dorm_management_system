package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Object.Report;

public class ReportDao {
	public static int addNewReport(Connection con,Report report)throws Exception{
		String sql="insert into reports(report_number,student_number,admin_account,report_time,describtion) values(?,?,?,?,?)";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setInt(1,report.getReportNumber());
		if(report.getStudentNumber()==-1) {
			ps.setString(2,null);
		}
		else {
			ps.setInt(2,report.getStudentNumber());}
		ps.setString(3,report.getAdminAccount());
		ps.setDate(4,report.getReportDate());
		ps.setString(5,report.getDecription());
		return ps.executeUpdate();
	}
	public static int assignReportNumber(Connection con)throws Exception {
		int reportNumber;
		String sql="SELECT MAX(report_number) as newestnumber from reports";
		PreparedStatement ps=con.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		if(rs.next()) {
			reportNumber=rs.getInt("newestnumber")+1;
		}
		else {
			reportNumber=1;
		}
		return reportNumber;
	}
}
