<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>DETAIL</title>
		<style><%@include file="/WEB-INF/css/styles.css"%></style>
	</head>

	<body>
	
		<h1>DETAIL</h1>
	
		<%
		String username = (String) session.getAttribute("usernameLoggedIn");
		String password = (String) session.getAttribute("passwordLoggedIn");
		
		if (session != null) {
			out.print("<h2>Hello " + username + "</h2>");
			out.print("<h2>Your password is " + password + "</h2>");
		}
		
		String number = (String) session.getAttribute("numberInputed");
		int numberParseToInteger = Integer.parseInt(number);
		for (int i = 1; i < numberParseToInteger + 1; i++){
			out.print("<p>" + i + "</p>");
		}
		%>
		
		<h3><a href="LogoutController">LOG OUT</a></h3>
	
	</body>
	
</html>