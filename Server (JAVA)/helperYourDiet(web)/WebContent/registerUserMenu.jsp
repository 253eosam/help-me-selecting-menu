<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="java.sql.*"%>

	<%
		Connection conn = null;
		PreparedStatement pstmt = null;
		String url = "jdbc:mysql://121.151.244.47:3306/helperyourdiet";
		String id = "root";
		String pw = "dltjdwns";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, id, pw);
			String userID = new String(request.getParameter("userID"));
			String foodName = new String(request.getParameter("foodName").getBytes("8859_1"), "utf-8");
			String foodAmount = new String(request.getParameter("foodAmount"));
			String foodType = new String(request.getParameter("foodType").getBytes("8859_1"), "utf-8");
			String foodKcal = new String(request.getParameter("foodKcal"));
			String date = new String(request.getParameter("date"));
			String meal = new String(request.getParameter("meal").getBytes("8859_1"), "utf-8");
			
			
			String sql = "insert into 회원식단( 회원id, 음식이름, 음식분류, 음식1회섭취량, 음식kcal ,날짜, 끼니) values (?,?,?,?,?,?,?)";
		
			pstmt = conn.prepareStatement(sql);
			
			//첫끼 두끼 셋끼 순서로 진행하고나서 다음 날짜로 넘어가기 
			// 매끼니마다 2~ 5 번갈라가면서 넣기
			// 칼로리는 100 ~ 600 
			
			pstmt.setString(1, userID);	//아이디
			pstmt.setString(2, foodName);			//음식 이름     <---
			pstmt.setString(3,foodType );			//음식 타입
			pstmt.setString(4,foodAmount );			//음식 1회 섭취량   
			pstmt.setString(5, foodKcal);			//음식 칼로리  (100~600)       <-----
			pstmt.setString(6, date);			//음식 날짜  (6월 7일까지)           <----
			pstmt.setString(7, meal);			//음식 끼니 (첫끼,두끼,셋끼)    <----
			
			
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
