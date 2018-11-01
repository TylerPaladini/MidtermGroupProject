<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<title>PROFILE</title>
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

	<c:if test="${adminPowerOnUser }">
		<h1>Find User(s)</h1>


		<form action="getAllUsers.do" method="post">
			<input type="submit" value="List All Users">
		</form>
		<form action="getUsersByKeywords.do" method="post">

			Search<input type="search" name="keywords"
				placeholder="tags: first name, last name, username, email, etc.">
			<input type="submit" value="Find Users">
		</form>
	</c:if>
	<c:if test="${adminPowerOnLocation }">
		<h1>Find Location(s)</h1>


		<form action="listAllLocations.do" method="post">
			<input type="submit" value="List All Locations">
		</form>
		<form action="getLocationsByKeyword.do" method="post">

			Search<input type="search" name="keyword">
			<input type="submit" value="Find Location">
		</form>
	</c:if>


</div>

</body>
</html>


