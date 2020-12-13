import java.sql.*;
public class JDBCTest02 {
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		try {
			Driver driver = new com.mysql.cj.jdbc.Driver();
			DriverManager.registerDriver(driver);
			String url = "jdbc:mysql://127.0.0.1:3306/MySQL";
			String user = "root";
			String password = "zxc123";
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("获取数据库连接:" + conn);
			
			stmt = conn.createStatement();
			
			String sql = "delete from takeout.goods where id = 100";
			int count = stmt.executeUpdate(sql);
			System.out.print(count == 1? "保存成功" : "保存失败");
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			if(stmt != null) {
				try {
					stmt.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}	
			}
			if(conn != null) {
				try {
					conn.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}	
			}
		}
	}
}
