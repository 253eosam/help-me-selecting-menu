<%@ page language="java" contentType="text/html;charset=EUC-KR" %>
<%@ page import="java.sql.*" %>

<%   
   Connection conn = null;   
   Statement stmt = null;
   ResultSet rs = null;

	String num , id, name, type, amount, kcal, date , meal;

   int counter = 0;
   try{
      Class.forName("com.mysql.jdbc.Driver");
      conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/helperyourdiet","root","dltjdwns");
      stmt = conn.createStatement();
      rs = stmt.executeQuery("SELECT * FROM 회원식단");
%>
<html><head><title>JSP DB Example</title></head>
<body>
<h2>JSP Scriptlet DB 연동 예제</h2>
<br>
<br>
<h3>회원 식단 정보</h3>
<table border="1">
<tr>
 <td><strong>식단num</strong></td>
   <td><strong>userID</strong></td>
   <td><strong>음식 이름</strong></td>
   <td><strong>음식분류</strong></td>
   <td><strong>음식 1회 섭취량</strong></td>
   <td><strong>음식 kcal</strong></td>
   <td><strong>날짜</strong></td>
   <td><strong>끼니</strong></td>
</tr>
<%
      if(rs!=null){
         while(rs.next()){
			 num = rs.getString("식단num");
			 id = rs.getString("회원id");
			 name = rs.getString("음식이름");
			 type = rs.getString("음식분류");
			 amount = rs.getString("음식1회섭취량");
			 kcal = rs.getString("음식kcal");
			 date = rs.getString("날짜");
			 meal = rs.getString("끼니");
%>
<tr>
<td><%= num %></td>
<td><%= id %></td>
<td><%= name %></td>
<td><%= type %></td>
<td><%= amount %></td>
<td><%= kcal %></td>
<td><%= date %></td>
<td><%= meal %></td>
<%
            counter++;
         }//end while

      }//end if
%>

</tr>
</table>
<BR>
<BR>
total records : <%= counter %> 
<%
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
