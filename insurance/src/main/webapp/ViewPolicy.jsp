<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>

<div class="center">
	<table class="centerTable designTable">
	<tr>
	<th>Policy Number </th>
	<th>Policy premium </th>
	<th>Account Number </th>
	<th> Action </th>
	</tr>
	<c:forEach var="policy" items="${policies}">
		<tr>
		<td> ${policy.policy_number } </td>
		<td> ${policy.policy_premium } </td>
		<td> ${policy.account_number } </td>
		<td> <a href="view?polNum=${policy.policy_number}"> View Details</a> </td>
		</tr>
	</c:forEach>
	</table>
	

	<br>
	<a href="Homepage">
		<button>Go Back to Homepage</button>
	</a>
</div>
</body>
</html>