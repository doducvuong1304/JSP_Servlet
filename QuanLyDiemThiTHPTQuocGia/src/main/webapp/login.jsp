<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>LOGIN</title>
		<style><%@include file="/WEB-INF/css/styles.css"%></style>
	</head>
	
	<body>

		<h1>LOGIN</h1>
	
		<form action="LoginController" method="post">
	
			<label for="username">Username</label>
			<input type="text" id="username" name="username-text"> 
			
			<br>
			<br>
			
			<label for="password">Password</label> 
			<input type="password" id="password" name="password-text"> <br>
	
			<br>
			
			<p id="error"><%=request.getAttribute("loginErrorMessage")%></p>
	
			<button type="submit">LOGIN</button>
	
		</form>
		
	</body>
	
</html>