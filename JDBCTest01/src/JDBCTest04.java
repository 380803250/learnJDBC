import java.sql.Connection;
import java.util.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * 实际开发中不建议把数据库信息写入代码当中
 */
public class JDBCTest04 {
	public static void main(String[] args) {
		//使用资源绑定器绑定属性配置文件
		ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
		
		String driver = bundle.getString("driver");
		String url = bundle.getString("url");
		String user = bundle.getString("user");
		String password = bundle.getString("password");
		
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
			System.out.print("数据库连接成功"+conn);
			
			stmt = conn.createStatement();
			String sql = "delete from takeout.goods where id = 100";
			//count为处理总行数
			int count = stmt.executeUpdate(sql);
			System.out.print(count == 1? "删除成功" : "删除失败");
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e){
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