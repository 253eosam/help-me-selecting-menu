<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="helperYourDiet.ConnectDB" %>
<% // 자바파일이 필요하므로 위 코드처럼 임포트합니다. %>
<%
	//싱글톤 방식으로 자바 클래스를 불러옵니다.
	ConnectDB connectDB = ConnectDB.getInstance();
	
	String id = new String( request.getParameter("id"));
	String pwd = new String(request.getParameter("pwd"));
	System.out.println("값받기");
	String returns = connectDB.connectionDB(id, pwd);
	System.out.println("요청 결과 : " + returns);
%>