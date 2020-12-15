import java.sql.*;

import utils.DBUtil;

public class JDBCTest13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = DBUtil.getConnection();
			conn.setAutoCommit(false);
			
			String sql ="select * from jdbcuser.jdbcusers where userid = ? for update";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, 1);
			
			rs = ps.executeQuery();
			while(rs.next()) {
				System.out.print(rs.getString("username")+" "+rs.getInt("userid")+" "+rs.getString("userrlname"));
			}
			
			
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
			DBUtil.close(conn, ps, rs);
		}
		
	}

}
