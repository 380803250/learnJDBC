import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import utils.DBUtil;

public class JDBCTest14 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement ps = null;
		int count;
		
		try {
			conn = DBUtil.getConnection();
			conn.setAutoCommit(false);
			
			String sql ="update jdbcuser.jdbcusers set userpwd = 1234567 where userid = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, 1);
			
			count = ps.executeUpdate();
			
			System.out.print(count);
			
			
			conn.commit();
		}catch(SQLException e) {
			if(conn != null) {
				try {
					conn.rollback();
				}catch(SQLException e1) {
					e.printStackTrace();
				}
			}
		}finally {
			DBUtil.close(conn, ps, null);
		}
		
	}
}
