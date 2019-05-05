<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ page import="java.sql.*"%>
<%
	String id = new String(request.getParameter("id"));
	String pwd = new String(request.getParameter("pwd"));

	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;


	try {
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/helperyourdiet", "root", "dltjdwns");
		String query= "SELECT password FROM 회원 where userID = ";
		String queryID = "'" + id + "'";
		query = query + queryID;
		stmt = conn.createStatement();
		rs = stmt.executeQuery(query);
		System.out.println(query);
		if (rs != null) {
			 while(rs.next()){
				String checkPwd = rs.getString("password");
				if(checkPwd.equals(pwd)){
					out.println("success login");		
					System.out.println("success login");
				}else{
					System.out.println("fail login 틀린 비밀번호");	
					out.println("fail login");
				}
			 }
		} //end if
		else{
			System.out.println("fail login 없는 아이디");	
			out.println("fail login");
		}
	 }catch(SQLException sqlException){
	      System.out.println("sql exception");
	   }catch(Exception exception){
	      System.out.println("exception");
	   }finally{
	      if( rs != null ) 
	         try{ rs.close(); } catch(SQLException ex) {}
	      if( stmt != null ) 
	         try { stmt.close(); } catch(SQLException ex) {}
	      if( conn != null ) 
	         try{ conn.close(); } catch(Exception ex){}
	   }
%>