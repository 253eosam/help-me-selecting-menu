<%@ page language="java" contentType="text/html;charset=EUC-KR" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.*"%>

<%   
   Connection conn = null;   
   Statement stmt = null;
   ResultSet rs = null;
   PreparedStatement pstmt = null;

   String userID = new String(request.getParameter("userID"));
   String date = new String(request.getParameter("date"));
   
   String[] day = date.split("-");
   int today = Integer.parseInt(day[2]);
   today -= 7;
   if(today < 1)
	   today = 1;
   String todayStr = Integer.toString(today);
   if(today < 10)
	   todayStr = "0" + todayStr;
   
	String dday, kcal;
	ArrayList<String> foodList = new ArrayList<String>();
   int counter = 0;
   try{
      Class.forName("com.mysql.jdbc.Driver");
      conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/helperyourdiet","root","dltjdwns");
      String sql = "SELECT * FROM ȸ���Ĵ� WHERE ȸ��id = ? AND ��¥ BETWEEN ? AND ? ";                        // sql ����
      pstmt = conn.prepareStatement(sql);                          // prepareStatement���� �ش� sql�� �̸� �������Ѵ�.
      pstmt.setString(1,userID);
      pstmt.setString(3,date);
      pstmt.setString(2,todayStr);
     
      rs = pstmt.executeQuery(); 

      if(rs!=null){
         while(rs.next()){
        	 dday = rs.getString("��¥");
        	 kcal = rs.getString("����kcal");
				
			 String data = dday + "," + kcal + "`";
			 foodList.add(data);
         }
         String tempStr = "";
         for(String s : foodList)
        	 tempStr += s;
         System.out.println(tempStr);
         out.println(tempStr);
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
