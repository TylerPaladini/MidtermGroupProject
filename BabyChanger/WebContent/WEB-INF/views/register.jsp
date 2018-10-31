<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
    content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link
    href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
    rel="stylesheet"
    integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
    crossorigin="anonymous">
<title>Register</title>
</head>
<body>
<%@ include file="navigation.jsp"%>
	<h5>Create User</h5>
	<form:form action="createUser.do" method="POST" modelAttribute="registerUserModel">
	
		<form:label path="userName">User Name:</form:label>
		<form:input path="userName" />
		<form:errors path="userName" /><br />
		First Name:
		<input type="text" name="firstName"/><br />
		Last Name:
		<input type="text" name="lastName"/><br />
		
		<form:label path="email">Email:</form:label>
		<form:input path="email"/>
		<form:errors path="email" /><br />
		<form:label path="password">Password:</form:label>
		<form:password path="password" />
		<form:errors path="password"/><br />
		  
		<input type="Submit" value="Create User"/>
	</form:form>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
		integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
		crossorigin="anonymous"></script>
</body>
</html>
