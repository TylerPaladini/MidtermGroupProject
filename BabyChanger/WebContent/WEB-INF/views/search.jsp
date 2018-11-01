<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
<title>Find User</title>
</head>
<body>
	<%@ include file="navigation.jsp"%>

	<c:if test="${searchForDisableDelete }">
		<h1>Find User to Disable/Delete</h1>


		<form action="getAllUsers.do" method="post">
			<input type="submit" value="List All Users">
		</form>
		<form action="getUsersByKeywords.do" method="post">

			Search<input type="search" name="keywords"
				placeholder="tags: first name, last name, username, email, etc.">
			<input type="submit" value="Find Users">
		</form>
	</c:if>
	<c:if test="${searchLocationUpdate }">
		<h1>Find Location to Update</h1>


		<form action="listAllLocationsUpdate.do" method="post">
			<input type="submit" value="List All Locations">
		</form>
		<form action="getLocationsByKeywordToUpdate.do" method="post">

			Search<input type="search" name="keyword">
			<input type="submit" value="Find Location">
		</form>
	</c:if>
	<c:if test="${searchLocationDelete }">
		<h1>Find User to Disable/Delete</h1>


		<form action="listAllLocationsDelete.do" method="post">
			<input type="submit" value="List All Locations">
		</form>
		<form action="getLocationsByKeywordToDelete.do" method="post">

			Search<input type="search" name="keyword">
			<input type="submit" value="Find Location">
		</form>
	</c:if>

	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
		integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
		crossorigin="anonymous"></script>

</body>
</html>


