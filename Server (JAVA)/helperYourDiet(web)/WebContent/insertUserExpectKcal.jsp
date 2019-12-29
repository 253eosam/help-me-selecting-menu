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
			String fristMeal = new String(request.getParameter("fristMeal").getBytes("8859_1"), "utf-8");
			String secondMeal = new String(request.getParameter("secondMeal").getBytes("8859_1"), "utf-8");
			String thirdMeal = new String(request.getParameter("thirdMeal").getBytes("8859_1"), "utf-8");


			String sql = "insert into È¸¿ø¿¹»óÄ®·Î¸® values(?,?,?,?)";
		
			
			pstmt = conn.prepareStatement(sql);
			
			//¾ÆÀÌµð , Ã¹³¢, µÎ³¢ , ¼Â³¢
			pstmt.setString(1, userID);
			pstmt.setString(2, fristMeal);
			pstmt.setString(3, secondMeal);
			pstmt.setString(4, thirdMeal);
			
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
