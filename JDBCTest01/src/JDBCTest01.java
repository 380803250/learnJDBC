import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;

public class JDBCTest01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//	1.注册驱动
		Connection conn =null;
		Statement stmt = null;
		try {
			Driver driver = new com.mysql.cj.jdbc.Driver();//父类型引用指向子类型对象;
			DriverManager.registerDriver(driver);
			String url = "jdbc:mysql://127.0.0.1:3306/MySQL";
			//网络资源定位符,网络上某个资源的绝对路径HTTP网络协议,数字是地址,加上端口

			//	2.连接通道
			String user = "root";
			String password = "zxc123";
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("获取数据库连接:" + conn);

			//3.获取操作数据库对象(Statement专门执行SQL语句)
			stmt = conn.createStatement();
			//4.执行SQL
			String sql = "insert into takeout.goods(id, name, business_id, price, limit_num) values(100, 'asd', 1, 23, 2)";
			int count = stmt.executeUpdate(sql);
			System.out.print(count == 1? "保存成功" : "保存失败");
			//5.处理查询结果集
			//6.关闭通道
			//为保证成功关闭,必须在finall中保存资源
			//并且从小关到大
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
