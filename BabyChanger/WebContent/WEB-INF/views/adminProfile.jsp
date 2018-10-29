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
<title>Admin Profile</title>
</head>
<body>
<%@ include file="navigation.jsp"%>

<h1>Admin Profile</h1>

${loggedIn.id}
${loggedIn.firstName}
${loggedIn.lastName}

	<form action="updateProfilePageAdmin.do">
		<input type="submit" value="Edit Profile">
	</form>
	
	<form action="adminAddsAddressLocationRestroom.do">
		<input type="Submit" value="Add Location" />
	</form>
	
	<form action="confirmDeleteAdmin.do">
	<input type="Submit" value="Delete Location"/>
	</form>
	
	<form action="listAllLocations.do">
	<input type="Submit" value="Update Location"/>
	</form>

<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
		integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
		crossorigin="anonymous"></script>
</body>
</html>