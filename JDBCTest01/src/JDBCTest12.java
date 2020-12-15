import java.sql.*;


import utils.DBUtil;

public class JDBCTest12 {
	public static void main(String[] arg) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			//��ȡ����
			conn = DBUtil.getConnection();
			//��ȡԤ���봦��Ķ���
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
			//�ͷ���Դ
			DBUtil.close(conn, ps, rs);
		}
	}
}
