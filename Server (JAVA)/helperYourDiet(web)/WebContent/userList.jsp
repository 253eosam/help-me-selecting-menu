<%@ page language="java" contentType="text/html;charset=EUC-KR" %>
<%@ page import="java.sql.*" %>

<%   
   Connection conn = null;   
   Statement stmt = null;
   ResultSet rs = null;

	String id, pwd , name, age, sex, h, w, target, act, amount, time, RDA;

   int counter = 0;
   try{
      Class.forName("com.mysql.jdbc.Driver");
      conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/helperyourdiet","root","dltjdwns");
      stmt = conn.createStatement();
      rs = stmt.executeQuery("SELECT * FROM 회원");
%>
<html><head><title>JSP DB Example</title></head>
<body>
<h2>JSP Scriptlet DB 연동 예제</h2>
<br>
<br>
<h3>회원정보</h3>
<table border="1">
<tr>
   <td><strong>userID</strong></td>
   <td><strong>password</strong></td>
   <td><strong>이름</strong></td>
   <td><strong>나이</strong></td>
   <td><strong>성별</strong></td>
   <td><strong>체형</strong></td>
   <td><strong>체중</strong></td>
   <td><strong>목표체중</strong></td>
   <td><strong>활동량</strong></td>
   <td><strong>끼니별섭취량</strong></td>
     <td><strong>끼니별식사시간</strong></td>
   <td><strong>일일권장섭취량</strong></td>
</tr>
<%
      if(rs!=null){
         while(rs.next()){
			 id = rs.getString("userid");
			 pwd = rs.getString("password");
			 name = rs.getString("이름");
			 age = rs.getString("나이");
			 sex = rs.getString("성별");
			 h = rs.getString("체형");
			 w = rs.getString("체중");
			 target = rs.getString("목표체중");
			 act = rs.getString("활동량");
			 amount = rs.getString("끼니별섭취량");
			 time = rs.getString("끼니별식사시간");
			 RDA = rs.getString("일일권장섭취량");
%>
<tr>
<td><%= id %></td>
<td><%= pwd %></td>
<td><%= name %></td>
<td><%= age %></td>
<td><%= sex %></td>
<td><%= h %></td>
<td><%= w %></td>
<td><%= target %></td>
<td><%= act %></td>
<td><%= amount %></td>
<td><%= time %></td>
<td><%= RDA %></td>
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
