package utils;
import java.sql.*;

public class DBUtil {
	
	private DBUtil (){}
	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static Connection getConnection() throws SQLException{
		return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/MySQL?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC", "root", "zxc123");
	}
	
	public static void close(Connection conn, Statement stmt, ResultSet rs) {
		try {
			if(rs != null) {
				rs.close();
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		try {
			if(stmt != null) {
				stmt.close();
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		try {
			if(conn != null) {
				conn.close();
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
}
