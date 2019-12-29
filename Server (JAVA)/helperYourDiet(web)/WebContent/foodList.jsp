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
      rs = stmt.executeQuery("SELECT * FROM 음식 WHERE 음식num=\'"+ findFoodNum +"\'");
		
      if(rs!=null){
         while(rs.next()){
	
			 type = rs.getString("음식타입");
			 name = rs.getString("음식이름");
			 amount = rs.getString("1회제공량");
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
