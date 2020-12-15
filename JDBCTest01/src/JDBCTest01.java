import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;

public class JDBCTest01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//	1.ע������
		Connection conn =null;
		Statement stmt = null;
		try {
			Driver driver = new com.mysql.cj.jdbc.Driver();//����������ָ�������Ͷ���;
			DriverManager.registerDriver(driver);
			String url = "jdbc:mysql://127.0.0.1:3306/MySQL";
			//������Դ��λ��,������ĳ����Դ�ľ���·��HTTP����Э��,�����ǵ�ַ,���϶˿�

			//	2.����ͨ��
			String user = "root";
			String password = "zxc123";
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("��ȡ���ݿ�����:" + conn);

			//3.��ȡ�������ݿ����(Statementר��ִ��SQL���)
			stmt = conn.createStatement();
			//4.ִ��SQL
			String sql = "insert into takeout.goods(id, name, business_id, price, limit_num) values(100, 'asd', 1, 23, 2)";
			int count = stmt.executeUpdate(sql);
			System.out.print(count == 1? "����ɹ�" : "����ʧ��");
			//5.�����ѯ�����
			//6.�ر�ͨ��
			//Ϊ��֤�ɹ��ر�,������finall�б�����Դ
			//���Ҵ�С�ص���
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
