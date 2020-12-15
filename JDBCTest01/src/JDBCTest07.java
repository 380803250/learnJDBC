import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Scanner;

public class JDBCTest07 {
	private static Map<String, String> initUI(){
		Scanner s = new Scanner (System.in);
		System.out.print("请输入用户名:");
		String loginName = s.nextLine();
		System.out.print("请输入密码:");
		String loginPwd = s.nextLine();
		
		Map<String, String> userLoginInfo = new HashMap<>();
		userLoginInfo.put("loginName", loginName);
		userLoginInfo.put("loginPwd", loginPwd);
		s.close();
		
		return userLoginInfo;
	}
	

	private static boolean login(Map<String, String> userLoginInfo) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
		String driver = bundle.getString("driver");
		String url = bundle.getString("url");
		String user = bundle.getString("user");
		String password = bundle.getString("password");
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
			//SQL 的?表示一个占位符,并且不可以用''括起来.
			String sql = "SELECT * FROM jdbcuser.jdbcusers WHERE username = ? AND userpwd = ?";
			//程序执行到此处,会发送SQL语句给DMBS进行预编译处理,编译语句如果没有变化那么只编译一次,速度变快
			ps = conn.prepareStatement(sql);
			//下标从1开始,并且在编译阶段做类型的安全检查
			ps.setString(1, userLoginInfo.get("loginName"));
			ps.setString(2, userLoginInfo.get("loginPwd"));

			Boolean Status = false;
			rs = ps.executeQuery();
			boolean fg1 = rs.next();
			while(fg1) {
				System.out.println("id:"+rs.getString("userid"));
				System.out.println("username:"+rs.getString("username"));
				System.out.println("userpwd:"+rs.getString("userpwd"));
				System.out.println("userrlname:"+rs.getString("userrlname"));
				fg1 = rs.next();
				Status =true;
			}
			return Status;
			
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) {
					rs.close();
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
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
		return false;
	}

	public static void main(String[] args) {
		Map<String, String> userLoginInfo = initUI();
		boolean loginSuccess = login(userLoginInfo);
		System.out.print(loginSuccess ? "登录成功" : "登录失败"); 
	}
}
