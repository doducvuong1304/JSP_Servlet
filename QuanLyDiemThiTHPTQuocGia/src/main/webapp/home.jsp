<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>HOME</title>
		<style><%@include file="/WEB-INF/css/styles.css"%></style>
	</head>
	
	<body>

		<h1>HOME</h1>

		<%
		String username = (String) session.getAttribute("usernameLoggedIn");
		String password = (String) session.getAttribute("passwordLoggedIn");

		if (session != null) {
		out.print("<h2>Hello " + username + "</h2>");
		out.print("<h2>Your password is " + password + "</h2>");
		}
		%>

		<form action="HomeController" method="post">

			<label for="ptaggenerate">Input number</label> 
			<input type="text" id="ptaggenerate" name="number-text">
		
			<br>
			<br>
			
			<p id="error"><%=request.getAttribute("homeErrorMessage")%></p>

			<button type="submit">SUBMIT</button>

		</form>

	</body>
</html>