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
      rs = stmt.executeQuery("SELECT * FROM ȸ��");
%>
<html><head><title>JSP DB Example</title></head>
<body>
<h2>JSP Scriptlet DB ���� ����</h2>
<br>
<br>
<h3>ȸ������</h3>
<table border="1">
<tr>
   <td><strong>userID</strong></td>
   <td><strong>password</strong></td>
   <td><strong>�̸�</strong></td>
   <td><strong>����</strong></td>
   <td><strong>����</strong></td>
   <td><strong>ü��</strong></td>
   <td><strong>ü��</strong></td>
   <td><strong>��ǥü��</strong></td>
   <td><strong>Ȱ����</strong></td>
   <td><strong>���Ϻ����뷮</strong></td>
     <td><strong>���Ϻ��Ļ�ð�</strong></td>
   <td><strong>���ϱ��強�뷮</strong></td>
</tr>
<%
      if(rs!=null){
         while(rs.next()){
			 id = rs.getString("userid");
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
