package Util;
 
import java.sql.*;
 
public class dbUtil {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://localhost:3306/system_data?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
    static final String USER = "root";
    static final String PASS = "&Million7";
    public static Connection getCon()throws Exception{
    	Class.forName(JDBC_DRIVER);
    	Connection con=DriverManager.getConnection(DB_URL,USER,PASS);
    	return con;
    }
     public static void closeCon(Connection con)throws Exception{
    	 if(con!=null) {
    		 con.close();
    	 }
     }
    
}