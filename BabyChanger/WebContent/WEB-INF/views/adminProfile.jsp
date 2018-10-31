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

<c:if test="${disableSuccess}">
	<h1>Disable Successful</h1>
</c:if>
<c:if test="${deleteSuccess }">
	<h1>Delete Successful</h1>
</c:if>
<c:if test="${profileUpdateSuccess }">
	<h1>Profile Update Success</h1>
</c:if>
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
	
	<form action="listAllLocations.do">
		<input type="Submit" value="Update Location"/>
	</form>
	
	<form action="listAllFlaggedRestrooms.do">
		<input type="Submit" value="Show Flagged Restrooms"/>
	</form>
	
	<form action="deleteConfirmation.do">
		<input type="hidden" name="id" value="${location.id }">
		<input type="Submit" value="Delete Location"/>
	</form>
	<form action="disableDelete.do" method="post">
		<input type="Submit" value="Disable/Delete User"/>
	</form>
	

<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
		integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
		crossorigin="anonymous"></script>
</body>
</html>