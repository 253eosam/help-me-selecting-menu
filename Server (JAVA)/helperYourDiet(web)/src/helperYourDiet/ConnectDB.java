package helperYourDiet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectDB {
	// �̱��� �������� ��� �ϱ��� �� �ڵ��
	private static ConnectDB instance = new ConnectDB();

	public static ConnectDB getInstance() {
		return instance;
	}

	public ConnectDB() {

	}

	String jdbcUrl = "jdbc:mysql://localhost:3306/example"; // MySQL ����
	String dbId = "������ ��� root"; // MySQL ����
	String dbPw = "mysql ��ġ �� ������ ��й�ȣ"; // ��й�ȣ
	Connection conn = null;
	PreparedStatement pstmt = null;
	PreparedStatement pstmt2 = null;
	ResultSet rs = null;
	String sql = "";
	String sql2 = "";
	String returns = "b";

	// �����ͺ��̽��� ����ϱ� ���� �ڵ尡 ����ִ� �޼���
	public String connectionDB(String id, String pwd) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			// ��� ����                                        
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/example", "root", "dltjdwns");
			sql = "select * from ȸ�� where idȸ�� = ?";// ��ȸ
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				// ������ �ִµ� �̹� ������ ������ ���(ȸ�������� �Ұ����� ���
				returns = "ȸ������ �Ұ�";

			} else {
				// �ְ��� �ϴ� ������ ���� ��� (ȸ�������� ������ ���)
				sql2 = "insert into ȸ�� values(?,?)"; // ����
				pstmt2 = conn.prepareStatement(sql2);
				pstmt2.setString(1, id);
				pstmt2.setString(2, pwd);
				pstmt2.executeUpdate();
				returns = "ȸ������ ����";
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (pstmt2 != null)try {pstmt2.close();	} catch (SQLException ex) {}
			if (pstmt != null)try {pstmt.close();} catch (SQLException ex) {}
			if (conn != null)try {conn.close();	} catch (SQLException ex) {	}
		}
		return returns;
	}

}