import java.sql.*;
public class JDBCTest03 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//	1.ע������
		Connection conn =null;
		try {
			//��ȡ���ݿ����ӵĵ�һ�ַ���Driver driver = new com.mysql.cj.jdbc.Driver();//����������ָ�������Ͷ���;
			//�ڶ��ַ���ͨ���������������DRIVER���еľ�̬�����������ע��
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String url = "jdbc:mysql://127.0.0.1:3306/MySQL?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC";
			//������Դ��λ��,������ĳ����Դ�ľ���·��HTTP����Э��,�����ǵ�ַ,���϶˿�
			//	2.����ͨ��
			String user = "root";
			String password = "zxc123";
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("��ȡ���ݿ�����:" + conn);
			
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
