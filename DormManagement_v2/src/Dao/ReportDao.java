package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Object.Report;
import Object.Student;
import Util.StringUtil;

public class ReportDao {
	/**
	 * Make a new report with into database
	 * 
	 * @param con
	 * @param guest
	 * @return the result of sql updating
	 */
	public static int addNewReport(Connection con, Report report) throws Exception {
		String sql = "insert into reports(report_number,student_number,admin_account,report_time,describtion,reply) values(?,?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, report.getReportNumber());
		if (report.getStudentNumber() == -1) {
			ps.setString(2, null);
		} else {
			ps.setInt(2, report.getStudentNumber());
		}
		ps.setString(3, report.getAdminAccount());
		ps.setDate(4, report.getReportDate());
		ps.setString(5, report.getDecription());
		ps.setString(6, "Unsolved");
		return ps.executeUpdate();
	}

	/**
	 * assign a index number to the new report
	 * 
	 * @param con
	 * @return the latest index
	 * @throws Exception
	 */
	public static int assignReportNumber(Connection con) throws Exception {
		int reportNumber;
		String sql = "SELECT MAX(report_number) as newestnumber from reports";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			reportNumber = rs.getInt("newestnumber") + 1;
		} else {
			reportNumber = 1;
		}
		return reportNumber;
	}

	/**
	 * check all the report made by the target student
	 * 
	 * @param con
	 * @param student
	 * @return result set of reports
	 * @throws Exception
	 */
	public static ResultSet list(Connection con, Student student) throws Exception {
		String sql = "Select * from reports where student_number=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, student.getStudentNumber());
		ResultSet rs = ps.executeQuery();
		return rs;
	}

	/**
	 * search all the report by certain conditions
	 * 
	 * @param con
	 * @param report
	 * @return result set of reports
	 */
	public static ResultSet list(Connection con, Report report) {
		StringBuffer sb = new StringBuffer("select * from reports where report_number>0");
		if (!StringUtil.Empty(report.getAdminAccount())) {
			sb.append(" and admin_account= '" + report.getAdminAccount() + "'");
		}
		if (report.getStudentNumber() != -1) {
			sb.append(" and student_number=" + report.getStudentNumber());
		}
		if (!StringUtil.Empty(report.getDecription())) {
			sb.append(" and describtion like '%" + report.getDecription() + "%'");
		}
		if (!StringUtil.Empty(report.getReply())) {
			sb.append(" and reply like '%" + report.getReply() + "%'");
		}
		if (report.getReportDate() != null) {
			sb.append(" and report_time ='" + report.getReportDate() + "'");
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
	 * used by admin to reply reports
	 * 
	 * @param con
	 * @param report
	 * @return result of updating
	 * @throws Exception
	 */
	public static int update(Connection con, Report report) throws Exception {
		String sql = "update reports set reply=? where report_number=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, report.getReply());
		ps.setInt(2, report.getReportNumber());
		return ps.executeUpdate();
	}
}
