package Util;
 
import java.sql.*;
 /**
  * connect to local database
  */
public class dbUtil {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
    static final String DB_URL = "your database URL";
    static final String USER = "your user name";
    static final String PASS = "your password";
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
