import java.util.*;
import java.sql.*;

public class JDBCTest06 {
	
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
		// TODO Auto-generated method stub
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
		String driver = bundle.getString("driver");
		String url = bundle.getString("url");
		String user = bundle.getString("user");
		String password = bundle.getString("password");
		String id = bundle.getString("id");
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
			
			stmt = conn.createStatement();
//			String sql = "SELECT * FROM jdbcuser.jdbcusers WHERE userid = "+id;
//			存在SQL注入问题
			String sql = "SELECT * FROM jdbcuser.jdbcusers WHERE username = '"+userLoginInfo.get("loginName")+"'AND userpwd = '"+userLoginInfo.get("loginPwd")+"'";
			String userid = null;
			String username = null;
			String userpwd = null;
			String userrlname = null;
			Boolean Status = false;
			rs = stmt.executeQuery(sql);
			boolean fg1 = rs.next();
			while(fg1) {
				System.out.println("id:"+rs.getString("userid"));
				System.out.println("username:"+rs.getString("username"));
				System.out.println("userpwd:"+rs.getString("userpwd"));
				System.out.println("userrlname:"+rs.getString("userrlname"));
				fg1 = rs.next();
				Status =true;
			}
//			while (fg1) {
//				userid = rs.getString("userid");
//				username = rs.getString("username");
//				userpwd = rs.getString("userpwd");
//				userrlname = rs.getString("userrlname");
//				
//				if (username.equals(userLoginInfo.get("loginName")) && userpwd.equals(userLoginInfo.get("loginPwd")) ) {
//					Status = true;
//					System.out.println("连接成功");
//					System.out.println("用户:"+userrlname);
//					System.out.println("用户id"+userid);
//				}else {
//					System.out.print("连接失败");
//				}
//				fg1 = rs.next();
//			}
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
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String, String> userLoginInfo = initUI();
		boolean loginSuccess = login(userLoginInfo);
		System.out.print(loginSuccess ? "登录成功" : "登录失败"); 
	}
}
