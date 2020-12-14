import java.sql.*;
import java.util.*;
public class JDBCTest05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
		String driver = bundle.getString("driver");
		String url = bundle.getString("url");
		String user = bundle.getString("user");
		String password = bundle.getString("password");
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
			
			stmt = conn.createStatement();
			String sql = "SELECT id as idddd, name, price FROM takeout.goods";
			String id = null;
			String name = null;
			double price = 0;
			rs = stmt.executeQuery(sql);//ר��ִ��DQL���ķ���,����Boolean����.
			
			Boolean fg1 = rs.next();
			System.out.print(fg1);
			while(fg1){
				id = rs.getString("idddd");
				name = rs.getString(2);//�����Ĳ����������±�Ҳ�����ü�ֵ,ע���±��һ��ʼ
				price = rs.getDouble("price");
				System.out.println(id+","+name+","+(price+100));
				fg1 = rs.next();
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
	}

}
