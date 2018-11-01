<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<title>UPDATE PROFILE</title>
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


	
	<h4>Confirm Deletion</h4>
	Are you sure you want to delete:
	${locationToDelete.name }
	<form action="deleteLocation.do">
		<input type="hidden" name="id" value="${locationToDelete.id }">
		<input type="submit" value="Confirm">
	</form>
	<form action="detailedResults.do" method="GET">
		<input type="hidden" name="locationId" value="${locationToDelete.id }">
		<input type="Submit" value="Cancel"/>
	</form>
	
	<c:if test="${restroomFlagged }">
		restroom flagged
	</c:if>

</div>	
</body>
</html>