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
      rs = stmt.executeQuery("SELECT * FROM ȸ���Ĵ�");
%>
<html><head><title>JSP DB Example</title></head>
<body>
<h2>JSP Scriptlet DB ���� ����</h2>
<br>
<br>
<h3>ȸ�� �Ĵ� ����</h3>
<table border="1">
<tr>
 <td><strong>�Ĵ�num</strong></td>
   <td><strong>userID</strong></td>
   <td><strong>���� �̸�</strong></td>
   <td><strong>���ĺз�</strong></td>
   <td><strong>���� 1ȸ ���뷮</strong></td>
   <td><strong>���� kcal</strong></td>
   <td><strong>��¥</strong></td>
   <td><strong>����</strong></td>
</tr>
<%
      if(rs!=null){
         while(rs.next()){
			 num = rs.getString("�Ĵ�num");
			 id = rs.getString("ȸ��id");
			 name = rs.getString("�����̸�");
			 type = rs.getString("���ĺз�");
			 amount = rs.getString("����1ȸ���뷮");
			 kcal = rs.getString("����kcal");
			 date = rs.getString("��¥");
			 meal = rs.getString("����");
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
