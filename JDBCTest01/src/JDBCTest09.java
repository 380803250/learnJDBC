import java.sql.*;
public class JDBCTest09 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn =null;
		PreparedStatement ps = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/MySQL?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC", "root", "zxc123");
			
			String sql = "Insert into jdbcuser.jdbcusers(userid, username, userpwd, userrlname) VALUES(?, ?, ?, ?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, "4");
			ps.setString(2, "pony");
			ps.setString(3, "12345678");
			ps.setString(4, "ÆÆÄá");
			int count = ps.executeUpdate();
			System.out.print(count);
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			try {
				if(ps != null) {
					ps.close();
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
			try {
				if(conn != null) {
					conn.close();
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
