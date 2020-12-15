import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCTest11 {
/*
 * SQL语句
 * drop table if exists t_act;
 * create table t_cat(
 * 		actno int,
 * 		balance double(7,2)
 * );
 * insert into t_cat(actno, balance) VALUES(111, 20000);
 * insert into t_cat(actno, balance) VALUES(222, 0);
 * commit;
 * select * from t_act;
 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn =null;
		PreparedStatement ps = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/MySQL?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC", "root", "zxc123");
			conn.setAutoCommit(false);//开启事务
			String sql = "update jdbcuser.t_act set balance = ? where actno = ?";
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, 10000);
			ps.setInt(2, 111);
			int count = ps.executeUpdate();
			
			ps.setInt(1, 10000);
			ps.setInt(2, 222);
			count += ps.executeUpdate();
			
			conn.commit();//提交事务
			System.out.print(count == 2 ?"转账成功" : "转账失败");
			
		}catch(SQLException e) {
			if(conn != null) {
				try {
					conn.rollback();//回滚事务
				}catch(SQLException e1) {
					e.printStackTrace();
				}
			}
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
