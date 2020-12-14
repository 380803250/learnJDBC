import java.sql.*;
public class JDBCTest03 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//	1.注册驱动
		Connection conn =null;
		try {
			//获取数据库连接的第一种方法Driver driver = new com.mysql.cj.jdbc.Driver();//父类型引用指向子类型对象;
			//第二种方法通过反射机制来调用DRIVER类中的静态方法完成驱动注册
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String url = "jdbc:mysql://127.0.0.1:3306/MySQL?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC";
			//网络资源定位符,网络上某个资源的绝对路径HTTP网络协议,数字是地址,加上端口
			//	2.连接通道
			String user = "root";
			String password = "zxc123";
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("获取数据库连接:" + conn);
			
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
