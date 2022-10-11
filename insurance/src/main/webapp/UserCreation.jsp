<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
	<!DOCTYPE html>
	<html>

	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
		<link rel="stylesheet" href="style.css">
	</head>

	<body>
		<div class="center">
			<h1>User Creation Page</h1>
			<form action="UserCreation" method="post">
				Enter the Username <br> <input type="text" name="username" id="" required><br>
				Enter the password <br> <input type="password" name="password" id="" required><br>
				Enter the Role <br>
				<select name="role">
					<option value="insured">Insured</option>
					<option value="agent">Agent</option>
					<option value="admin">Admin</option>
				</select> <br>
				<button type="submit">Submit</button>
			</form>
			<br>
                <a href="Homepage"> <button> Go Back to Homepage </button></a>
		</div>

	</body>

	</html>