<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="helperYourDiet.ConnectDB" %>
<% // �ڹ������� �ʿ��ϹǷ� �� �ڵ�ó�� ����Ʈ�մϴ�. %>
<%
	//�̱��� ������� �ڹ� Ŭ������ �ҷ��ɴϴ�.
	ConnectDB connectDB = ConnectDB.getInstance();
	
	String id = new String( request.getParameter("id"));
	String pwd = new String(request.getParameter("pwd"));
	System.out.println("���ޱ�");
	String returns = connectDB.connectionDB(id, pwd);
	System.out.println("��û ��� : " + returns);
%>