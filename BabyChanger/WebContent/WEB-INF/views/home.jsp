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
<title>Baby Changing Table Finder</title>
</head>
<body>
	<%@ include file="navigation.jsp"%>
	<h1>Baby Changer</h1>


	<form action="getLocationsByKeywordSearch.do" method="GET">
		<input type="search" name="keyword" size="30" /> <input type="submit"
			name="search" value="Search" />
	</form>
	<br>


	

	<form action="confirmDeleteAdmin.do" method="POST">
		<input type="number" name="userId" /><br> <input type="Submit"
			value="Delete" />
	</form>

	<form action="getAllUsersAdmin.do">
		<input type="Submit" value="all users" />
	</form>

	<form action="addAddressLocationRestroom.do">
		<input type="Submit" value="Add Location" />
	</form>

	<form action="searchOpenLocations.do">
		<input type="Submit" value="Open Locations" />
	</form>



	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
		integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
		crossorigin="anonymous"></script>
</body>
</html>