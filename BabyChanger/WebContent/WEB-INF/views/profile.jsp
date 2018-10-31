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
<title>User Profile</title>
</head>
<body>
	<%@ include file="navigation.jsp"%>
	
	<c:if test="${updateUserSuccess }">
		<h1>Update successful</h1>
	</c:if>
	<c:if test="${updateUserFailed }">
		<h1>Update Failed</h1>
	</c:if>
	<c:if test="${addLocationSuccess }">
		<h1>Adding Location Successful</h1>
	</c:if>
	
	<c:if test="${not empty locationDeleted }">
		<h1>Location has been deleted</h1>
	</c:if>
	
	<h1>User Profile</h1>

	${loggedIn.id}
	${loggedIn.firstName}
	${loggedIn.lastName}
	
	<c:if test="${loggedIn.admin }">
		<form action="updateProfilePageAdmin.do">
	
	</c:if>
	<c:if test="${!loggedIn.admin }">
		<form action="updateProfilePageUser.do">
	
	</c:if>
		<input type="submit" value="Edit Profile">
	</form>
	
	<form action="userAddsAddressLocationRestroom.do">
		<input type="Submit" value="Add Location" />
	</form>
	
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
		integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
		crossorigin="anonymous"></script>
</body>
</html>