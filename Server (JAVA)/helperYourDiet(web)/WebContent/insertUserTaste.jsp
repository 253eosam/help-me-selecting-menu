<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ page import="java.sql.*"%>

	<%
		Connection conn = null;
		PreparedStatement pstmt = null;
		String url = "jdbc:mysql://localhost:3306/helperyourdiet";
		String id = "root";
		String pw = "dltjdwns";

		try {
			int n = 1;
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, id, pw);
			
			String userID = new String(request.getParameter("userID"));
			String userTasteMeal = new String(request.getParameter("userTasteMeal").getBytes("8859_1"), "utf-8");


			String sql = "insert into 회원음식취향 values(?,?)";
		
			
			pstmt = conn.prepareStatement(sql);
			
			//아이디 , 음식취향
			pstmt.setString(1, userID);
			pstmt.setString(2, userTasteMeal);
			
			
			int result = pstmt.executeUpdate();
			
			if (result >= 0) {
				out.println("success taste");
				System.out.println("success taste");
				
			} else {
				out.println("fail taste");
				System.out.println("fail taste");
			}

			
		} catch (Exception e) {

			out.println(e.getMessage());
		} finally {
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException sqle) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException sqle) {
				}
		}
	%>
