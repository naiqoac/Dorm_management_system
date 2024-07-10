package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Object.Admin;

public class AdminDao {
	public static Admin login(Connection con,Admin admin)throws Exception{
		Admin rsadmin=null;
		String sql="Select * from admin where admin_account=? and admin_password=?";
		PreparedStatement pt=con.prepareStatement(sql);
		pt.setString(1,admin.getAdminAccount());
		pt.setString(2,admin.getAdminPassword());
		ResultSet rs=pt.executeQuery();
		if(rs.next()) {
			rsadmin=new Admin();
			rsadmin.setAdminAccount(rs.getString("admin_account"));
			rsadmin.setAdminName(rs.getString("admin_name"));
			rsadmin.setAdminPassword(rs.getString("admin_password"));
		}
		return rsadmin;
	}
}
