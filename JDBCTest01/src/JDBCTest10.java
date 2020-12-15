import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCTest10 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn =null;
		PreparedStatement ps = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/MySQL?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC", "root", "zxc123");
			
			String sql = "update jdbcuser.jdbcusers set username = ? where userid = ?";
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, "jack2");
			ps.setInt(2, 2);
			int count = ps.executeUpdate();
			System.out.println(count);
			
			ps.setString(1, "tom2");
			ps.setInt(2, 3);
			count = ps.executeUpdate();
			System.out.println(count);
			
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
