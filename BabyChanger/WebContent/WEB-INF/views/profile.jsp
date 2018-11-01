<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<title>PROFILE</title>
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
	
	<c:if test="${updateUserSuccess }">
		<h1>Update successful</h1>
	</c:if>
	<c:if test="${updateUserFailed }">
		<h1>Update Profile Failed</h1>
	</c:if>
	<c:if test="${profileUpdateSuccess }">
		<h1>Update Profile success</h1>
	</c:if>

	<h1>User Profile</h1>


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
	
	<c:if test="${!loggedIn.admin}">
		<form action="disableUser.do">
		<input type="hidden" name="userId" value="${loggedIn.id }">
		<input type="Submit" value="Delete Account">
		</form>
	</c:if>
		
		
	
	
	<!-- removed from here and placed in the home.jsp -->
	<!-- <form action="userAddsAddressLocationRestroom.do">
		<input type="Submit" value="Add Location" />
	</form> -->
	
<!-- 	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
		integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
		crossorigin="anonymous"></script> -->

</div>
		
</body>
</html>