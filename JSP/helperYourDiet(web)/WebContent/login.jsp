<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ page import="java.sql.*"%>
<%
	String id = new String(request.getParameter("id"));
	String check_pwd = new String(request.getParameter("pwd"));

	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;

	String  pwd, name, age, sex, h, w, target, act, amount, time, RDA;
	

	try {
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/helperyourdiet", "root", "dltjdwns");
		String query= "SELECT * FROM ȸ�� where userID = ";
		String queryID = "'" + id + "'";
		query = query + queryID;
		stmt = conn.createStatement();
		rs = stmt.executeQuery(query);
		System.out.println(query);
		if (rs != null) {
			 while(rs.next()){
				 pwd = rs.getString("password");
				 name = rs.getString("�̸�");
				 age = rs.getString("����");
				 sex = rs.getString("����");
				 h = rs.getString("ü��");
				 w = rs.getString("ü��");
				 target = rs.getString("��ǥü��");
				 act = rs.getString("Ȱ����");
				 amount = rs.getString("���Ϻ����뷮");
				 time = rs.getString("���Ϻ��Ļ�ð�");
				 RDA = rs.getString("���ϱ��強�뷮");
				 if(check_pwd.equals(pwd)){
					 out.println("success" + "&" + id + "&" + pwd + "&" + name + "&" + age + "&" + sex  
							 + "&" + h + "&" + w + "&" + target + "&" + act + "&" + amount + "&" + time + "&" + RDA);
					 System.out.println("success" + "&" + id + "&" + pwd + "&" + name + "&" + age + "&" + sex  
							 + "&" + h + "&" + w + "&" + target + "&" + act + "&" + amount + "&" + time + "&" + RDA);
				 }
				 else{
					 out.println("fail");
					 System.out.println("fail");
				 }
				 
			 }	// end while
		} //end if
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