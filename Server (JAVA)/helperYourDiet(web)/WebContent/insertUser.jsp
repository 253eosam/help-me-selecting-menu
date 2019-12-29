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
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, id, pw);
			String userID = new String(request.getParameter("userID"));
			String userPassword = new String(request.getParameter("userPassword"));
			String userName = new String(request.getParameter("userName").getBytes("8859_1"), "utf-8");
			String userAge = new String(request.getParameter("userAge"));
			String userSex = new String(request.getParameter("userSex"));
			String userHeight = new String(request.getParameter("userHeight"));
			String userWeight = new String(request.getParameter("userWeight"));
			String userTargetWeight = new String(request.getParameter("userTargetWeight"));
			String userActivity = new String(request.getParameter("userActivity"));
			String amountMeal = new String(request.getParameter("amountMeal"));
			String timeMeal = new String(request.getParameter("timeMeal").getBytes("8859_1"), "utf-8");
			String RDA = new String(request.getParameter("RDA"));

			String sql = "insert into 회원 values(?,?,?,?,?  ,?,?,?,?,?,  ?,?)";
		
			
			pstmt = conn.prepareStatement(sql);

			//아이디 , 패스워드 , 이름, 나이 ,성별
			pstmt.setString(1, userID);
			pstmt.setString(2, userPassword);
			pstmt.setString(3, userName);
			pstmt.setString(4, userAge);
			pstmt.setString(5, userSex);

			//체형 , 체중	,목표체중	,활동량	,끼니별 섭취량
			pstmt.setString(6, userHeight);
			pstmt.setString(7, userWeight);
			pstmt.setString(8, userTargetWeight);
			pstmt.setString(9, userActivity);
			pstmt.setString(10, amountMeal);

			//식사시간	, 일일 권장 칼로리
			pstmt.setString(11, timeMeal);
			pstmt.setString(12, RDA);
			int result = pstmt.executeUpdate();
			if (result >= 0) {
				out.println("success registe");
				System.out.println("success registe");
				
			} else {
				out.println("fail registe");
				System.out.println("fail registe");
				
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
