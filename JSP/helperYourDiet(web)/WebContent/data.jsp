<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="UTF-8"%>

<%
	String id = new String(request.getParameter("id"));
	String pwd = new String(request.getParameter("pwd"));
	
	
	if(id.equals("rain483") && pwd.equals("1234")) {
		out.print("a");
		
		System.out.println('a');
	} else {
		out.print("b");
		System.out.println('b');
	}
%>