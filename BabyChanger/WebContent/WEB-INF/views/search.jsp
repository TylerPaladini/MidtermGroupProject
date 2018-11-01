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

</div>

</body>
</html>


