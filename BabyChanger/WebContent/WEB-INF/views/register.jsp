<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<form action="createUserAdmin.do" method="POST">

User Name:
<input type="text" name="userName"/><br>
First Name:
  <input type="text" name="firstName"/><br>
  LastName:
  <input type="text" name="lastName"/><br>
  Email:
  <input type="text" name="email"/><br>
  Password:
  <input type="password" name="password"/><br>
  
  <input type="Submit" value="Create User"/>
</form>

</body>
</html>