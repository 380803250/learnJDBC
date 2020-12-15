import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCTest08 {
//	public static void main(String[] args) {
//	// TODO Auto-generated method stub
//	Connection conn = null;
//	PreparedStatement ps = null;
//	ResultSet rs =null;
//	
//	String Sort =""; 
//	try {
//		Scanner s = new Scanner(System.in);
//		System.out.println("请输入排序方式,升序为:desc 降序为:asc");
//		Sort = s.nextLine();
//		
//		Class.forName("com.mysql.cj.jdbc.Driver");
//		conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/MySQL?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC","root", "zxc123");
//		String sql = "Select * From jdbcuser.jdbcusers ORDER BY userid ?";
//		ps = conn.prepareStatement(sql);
//		ps.setString(1, Sort);
//		//此方法会带有双引号,SQL语句出现错误
//		rs = ps.executeQuery();
//		while(rs.next()) {
//			System.out.print(rs.getString("id"));
////			System.out.print(rs.getString(2));
////			System.out.print(rs.getString(3));
////			System.out.print(rs.getString(4));
//		}
//		
//	}catch(SQLException e) {
//		e.printStackTrace();
//	}catch(ClassNotFoundException e) {
//		e.printStackTrace();
//	}finally {
//		try {
//			if(rs != null) {
//				rs.close();
//			}
//		}catch(SQLException e){
//			e.printStackTrace();
//		}
//		try {
//			if(ps != null) {
//				ps.close();
//			}
//		}catch(SQLException e){
//			e.printStackTrace();
//		}
//		try {
//			if(conn != null) {
//				conn.close();
//			}
//		}catch(SQLException e){
//			e.printStackTrace();
//		}
//	}
//}

public static void main(String[] args) {
	// TODO Auto-generated method stub
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs =null;
	
	String Sort =""; 
	try {
		Scanner s = new Scanner(System.in);
		System.out.println("请输入排序方式,升序为:desc 降序为:asc");
		Sort = s.nextLine();
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/MySQL?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC","root", "zxc123");
		String sql = "Select * From jdbcuser.jdbcusers ORDER BY userid "+Sort;
		stmt = conn.createStatement();
		//此方法会带有双引号,SQL语句出现错误
		rs = stmt.executeQuery(sql);
		while(rs.next()) {
			System.out.print(rs.getString(1)+" ");
			System.out.print(rs.getString(2)+" ");
			System.out.print(rs.getString(3)+" ");
			System.out.print(rs.getString(4)+" ");
			System.out.println("");
		}
		
	}catch(SQLException e) {
		e.printStackTrace();
	}catch(ClassNotFoundException e) {
		e.printStackTrace();
	}finally {
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
}
