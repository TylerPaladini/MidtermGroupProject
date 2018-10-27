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
<title>Login</title>
</head>
<body>
<%@ include file="navigation.jsp"%>

<c:if test="${ loginFailed}">
	<h2>Login Failed. Please Try Again</h2>
</c:if>
<form action="login.do" method="POST">
	<input type="text" name="userName">
	<input type="password" name="password">
	<input type="Submit" value="Login">
	

</form>




</body>
</html>