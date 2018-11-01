<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
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
<%@ include file="navigation.jsp"%> --%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<title>ADMIN PROFILE</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="css/w3.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Amatic+SC">
<style>
body, html {
	height: 100%
}

body, h1, h2, h3, h4, h5, h6 {
	font-family: "Amatic SC", sans-serif;
	font-size: 30px
}

.menu {
	display: none
}

.bgimg {
	background-repeat: no-repeat;
	background-size: cover;
	/*     background-image: url("https://media.giphy.com/media/tJ4oUTsMHbqAZyqsBo/giphy.gif");*/
	min-height: 90%;
}
</style>
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
<h1>Admin Profile</h1>


${loggedIn.firstName}
${loggedIn.lastName}

	<form action="updateProfilePageAdmin.do">
		<input type="submit" value="Edit Profile">
	</form>
	
	<form action="adminAddsAddressLocationRestroom.do">
		<input type="Submit" value="Add Location" />
	</form>
	
	<form action="searchLocationsToUpdatePage.do" method="get">
		<input type="Submit" value="Update Location"/>
	</form>
	
	<form action="listAllFlaggedRestrooms.do">
		<input type="Submit" value="Show Flagged Restrooms"/>
	</form>
	<form action="listAllFlaggedComments.do">
		<input type="Submit" value="Show Flagged Comments"/>
	</form>
	
	<form action="searchLocationsToDeletePage.do" method="get">
		<input type="Submit" value="Delete Location"/>
	</form>
	<form action="disableDeleteUserSearch.do" method="post">
		<input type="Submit" value="Disable/Delete User"/>
	</form>

	

<!-- <script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
		integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
		crossorigin="anonymous"></script> -->
</div>		
</body>
</html>