<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="style.css">
</head>

<body>


	<div class="center">
		<form action="PolicyCreation">
			<h3>Select the user_name</h3>
			<select name="user_name" id="">
				<c:forEach var="insured" items="${insureds}">
					<option value="${insured.user_name}">${insured.user_name}</option>
				</c:forEach>
			</select>

			<button type="submit">select</button>
		</form>

		<c:if test="${param.user_name != null}">
			<h1>Policy Creation Form</h1>
			<div class="center">
				<h3>
					User Name :
					<c:out value="${param.user_name}"></c:out>
				</h3>
				<form action="PolicyCreation" method="post">
					insured user name : <input type="text" name="user_name"
						value="${param.user_name }" readonly="readonly"> <br>
					<table class="policyQuesTable">
						<tr>
							<th>question</th>
							<th>answer 1</th>
							<th>answer 2</th>
							<th>answer 3</th>
						</tr>
						<c:forEach var="question" items="${questions}">
							<tr>
								<td>"${question.pol_ques_desc}"</td>
								<td><input type="radio" name="${question.pol_ques_id}"
									value="${question.pol_ques_ans1_weightage}" required="required">
									"${question.pol_ques_ans1}"</td>

								<td><input type="radio" name="${question.pol_ques_id}"
									value="${question.pol_ques_ans2_weightage}" required="required">
									"${question.pol_ques_ans2}"</td>

								<td><input type="radio" name="${question.pol_ques_id}"
									value="${question.pol_ques_ans3_weightage}" required="required">
									"${question.pol_ques_ans3}"</td>
							</tr>
						</c:forEach>
					</table>
					<input type="submit" value="submit">

				</form>
			</div>
		</c:if>
		<br> <a href="Homepage">
			<button>Go Back to Homepage</button>
		</a>

	</div>
</body>

</html>