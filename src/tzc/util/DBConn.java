package tzc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConn {
	private static final String driver="oracle.jdbc.driver.OracleDriver";
	private static final String url="jdbc:oracle:thin:@localhost:1521:orcl";
	private static final String username="scott";
	private static final String password="tiger";

	public static Connection getConnection() {
		Connection conn=null;
		try {
			Class.forName(driver);			
			conn = DriverManager.getConnection(url,username,password);
		} catch (ClassNotFoundException e) {	
			e.printStackTrace();										
		} catch (SQLException e) {				
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void close(Connection conn) {
		if(conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public static void close(PreparedStatement stmt) {
		if(stmt != null) {	
			try {
				stmt.close();	
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public static void close(ResultSet rs) {
		if(rs != null) {
			try {
				rs.close();	
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}