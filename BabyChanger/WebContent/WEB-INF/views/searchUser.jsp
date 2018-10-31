<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Find User</title>
</head>
<body>
	<%@ include file="navigation.jsp"%>
	
	<c:if test="${searchForDisable }">
		<h1>Find User to Disable</h1>
	</c:if>
	
	<form action="">
		<input type="submit" value="List All Users">
	</form>
	<form action="">
	
		Search<input type="search" name="keywords" placeholder="tags: first name, last name, username, email, etc." >
		<input type="submit" value="Find Users">
	</form>
	
</body>
</html>