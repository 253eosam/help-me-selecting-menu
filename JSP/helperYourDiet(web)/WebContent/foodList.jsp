<%@ page language="java" contentType="text/html;charset=EUC-KR" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.*"%>

<%   
   Connection conn = null;   
   Statement stmt = null;
   ResultSet rs = null;
   
   String findFoodNum = new String(request.getParameter("findFoodNum"));
   String data = "";
	String  type, name, amount, kcal;
	ArrayList<String> foodList = new ArrayList<String>();
   int counter = 0;
   try{
      Class.forName("com.mysql.jdbc.Driver");
      conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/helperyourdiet","root","dltjdwns");
      stmt = conn.createStatement();
      rs = stmt.executeQuery("SELECT * FROM ���� WHERE ����num=\'"+ findFoodNum +"\'");
		
      if(rs!=null){
         while(rs.next()){
	
			 type = rs.getString("����Ÿ��");
			 name = rs.getString("�����̸�");
			 amount = rs.getString("1ȸ������");
			 kcal = rs.getString("kcal");
			 
			 data =  name + "," + amount + "(g)," + kcal + "(kcal)";
         }
         System.out.println(data);
         out.println(data);
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
