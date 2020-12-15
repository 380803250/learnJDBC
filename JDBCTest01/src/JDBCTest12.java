import java.sql.*;


import utils.DBUtil;

public class JDBCTest12 {
	public static void main(String[] arg) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			//获取链接
			conn = DBUtil.getConnection();
			//获取预编译处理的对象
			String sql = "select username from jdbcuser.jdbcusers where username like ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, "_a%");
			rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getString("username"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			//释放资源
			DBUtil.close(conn, ps, rs);
		}
	}
}
