import java.sql.Connection;
import java.util.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * ʵ�ʿ����в���������ݿ���Ϣд����뵱��
 */
public class JDBCTest04 {
	public static void main(String[] args) {
		//ʹ����Դ���������������ļ�
		ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
		
		String driver = bundle.getString("driver");
		String url = bundle.getString("url");
		String user = bundle.getString("user");
		String password = bundle.getString("password");
		
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
			System.out.print("���ݿ����ӳɹ�"+conn);
			
			stmt = conn.createStatement();
			String sql = "delete from takeout.goods where id = 100";
			//countΪ����������
			int count = stmt.executeUpdate(sql);
			System.out.print(count == 1? "ɾ���ɹ�" : "ɾ��ʧ��");
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e){
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