<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<title>ADMIN PROFILE</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="css/w3.css">
<link rel="stylesheet" href="css/body.css">
<link rel="stylesheet" href="css/diapers.css">
<link rel="icon" href="https://www.freeiconspng.com/uploads/changing-table-icon-18.png">


<body>

	<!-- Navbar (sit on top) -->
	<%@ include file="newNav.jsp"%>

	<header class="bgimg w3-display-container w3-grayscale-min" id="home">

	</header>
	
	<div class="w3-display-middle w3-left ">

<c:if test="${disableSuccess}">
	<h1>Disable Successful</h1>
</c:if>
<c:if test="${deleteSuccess }">
	<h1>Delete Successful</h1>
</c:if>
<c:if test="${profileUpdateSuccess }">
	<h1>Profile Update Success</h1>
</c:if>
<c:if test="${locationDeletedSuccess }">
		<h1>Location has been deleted</h1>
</c:if>
<c:if test="${deleteUserSuccess}">
		<h1>User has been deleted</h1>
</c:if>
<c:if test="${disableUserSuccess}">
		<h1>User has been disabled</h1>
</c:if>
<c:if test="${activateUserSuccess}">
		<h1>User has been Activated</h1>
</c:if>
<c:if test="${gavePowerToUser}">
		<h1>User has been Made an Admin</h1>
</c:if>
<c:if test="${takePowerFromUser}">
		<h1>User has been stripped of Admin privileges</h1>
</c:if>
<h1>Admin Profile</h1>


${loggedIn.firstName}
${loggedIn.lastName}

	<form action="updateProfilePageAdmin.do">
		<input type="submit" value="Edit Profile">
	</form>
	
	<form action="adminAddsAddressLocationRestroom.do">
		<input type="Submit" value="Add Location" />
	</form>
	<form action="listAllFlaggedRestrooms.do">
		<input type="Submit" value="Show Flagged Restrooms"/>
	</form>
	<form action="listAllFlaggedComments.do">
		<input type="Submit" value="Show Flagged Comments"/>
	</form>
	
	<form action="locationEditSearchPage.do" method="post">
		<input type="Submit" value="Use Admin Privileges On Locations"/>
	</form>
	<form action="userEditSearchPage.do" method="post">
		<input type="Submit" value="Use Admin Privileges On Users"/>
	</form>

	

<!-- <script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
		integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
		crossorigin="anonymous"></script> -->
</div>		
</body>
</html>