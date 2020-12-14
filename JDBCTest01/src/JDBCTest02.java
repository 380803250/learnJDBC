import java.sql.*;
public class JDBCTest02 {
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/MySQL?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC", "root", "zxc123");
			System.out.print("数据库连接成功"+conn);
			
			stmt = conn.createStatement();
			String sql = "delete from takeout.goods where id = 100";
			//count为处理总行数
			int count = stmt.executeUpdate(sql);
			System.out.print(count == 1? "保存成功" : "保存失败");
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(stmt != null) {
					stmt.close();
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
