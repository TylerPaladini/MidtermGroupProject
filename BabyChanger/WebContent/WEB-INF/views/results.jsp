<!DOCTYPE html>
<html>
<title>RESULTS</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
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

	<!-- <div class="w3-top w3-hide-small">
  <div class="w3-bar w3-xlarge w3-black w3-opacity w3-hover-opacity-off" id="myNavbar">
    <a href="home.do" class="w3-bar-item w3-button">HOME</a>
    <a href="loginPage.do" class="w3-bar-item w3-button">LOGIN</a>
    <a href="registerPage.do" class="w3-bar-item w3-button">REGISTER</a>
  </div>

</div> -->

	<!-- Header with image -->


	<header class="bgimg w3-display-container w3-grayscale-min" id="home">

	</header>

	<div class="w3-display-middle w3-center ">
		<div class="container" >
			<BR><BR><BR><BR><BR><BR><BR>
			<BR><BR><BR><BR><BR><BR><BR>
			<BR><BR><BR><BR><BR><BR><BR>
			<BR><BR><BR><BR><BR><BR><BR>
			<BR><BR><BR><BR><BR><BR><BR> 
			
		</div>

	<c:if test="${not empty allUsers }">
			<c:forEach items="${allUsers }" var="user">
			${user.id }
			${user.firstName }
			<br>
			</c:forEach>
	</c:if>

	<c:if test="${not empty allKeywords }">
			<c:forEach items="${allKeywords }" var="keywordSearch">
				<a href="detailedResults.do?locationId=${keywordSearch.id }">${keywordSearch.name }</a>
				<br />
			${keywordSearch.address.street }
			<c:if test="${not empty keywordSearch.address.street2 }">
				${keywordSearch.address.street2 }
			</c:if>
				<br />
			${keywordSearch.address.city }
			${keywordSearch.address.state }
			${keywordSearch.address.zipCode }<br />
				<c:if
					test="${not empty keywordSearch.openTime and not empty keywordSearch.closeTime }">
			${keywordSearch.openTime } - ${keywordSearch.closeTime }
			</c:if>
				<br />
				<br />
			</c:forEach>
	</c:if>

	<c:if test="${not empty open }">
			<c:forEach items="${open }" var="openRestroom">
				<a href="detailedResults.do?locationId=${openRestroom.id }">${openRestroom.name }</a>
				<br />
			${openRestroom.address.street }
			<c:if test="${not empty openRestroom.address.street2 }">
				${openRestroom.address.street2 }
			</c:if>
				<br />
			${openRestroom.address.city }
			${openRestroom.address.state }
			${openRestroom.address.zipCode }<br />
				<c:if
					test="${not empty openRestroom.openTime and not empty openRestroom.closeTime }">
			${openRestroom.openTime } - ${openRestroom.closeTime }
			</c:if>
				<br />
				<br />
			</c:forEach>
	</c:if>

	<c:if test="${not empty allLocations }">
			<c:forEach items="${allLocations }" var="location">
				<a href="detailedResults.do?locationId=${location.id }">${location.name }</a>
				<br />
			${location.address.street }
			<c:if test="${not empty location.address.street2 }">
				${location.address.street2 }
			</c:if>
				<br />
			${location.address.city }
			${location.address.state }
			${location.address.zipCode }<br />
				<c:if
					test="${not empty location.openTime and not empty location.closeTime }">
			${location.openTime } - ${location.closeTime }
			</c:if>
				<br>
				<form action="adminUpdateLocation.do">
					<input type="hidden" name="id" value="${location.id }"> <input
						type="submit" value="update Location">
				</form>
			</c:forEach>
	</c:if>

	<c:if test="${not empty flaggedRestrooms }">
			<h5>All Flagged Restrooms</h5>
			<c:forEach items="${flaggedRestrooms }" var="allFlaggedRestrooms">


				<a
					href="detailedResultsFlagged.do?restroomId=${allFlaggedRestrooms.id }">${allFlaggedRestrooms.location.name}
					Restroom ID: ${allFlaggedRestrooms.id }</a>
				<br>

			</c:forEach>
	</c:if>

	<c:if test="${noFlaggedRestrooms }">
		There are no flagged restrooms
	</c:if>



	<c:if test="${not empty flaggedComments }">
			<h5>All Flagged Comments</h5>
			<hr>
			<c:forEach items="${flaggedComments }" var="comment">
				<h4>User: ${comment.user.userName }</h4>
				<h4>User First Name: ${comment.user.firstName }</h4>
				<h4>User Last Name: ${comment.user.lastName }</h4>
				<p>Comment: ${comment.comment }</p>
				<h4>Rating: ${comment.rating }</h4>

				<form action="unflagComment.do" method="post">
					<input type="submit" value="unflag comment"> <input
						type="hidden" value="${comment.id }" name="commentId">
				</form>
				<hr>
			</c:forEach>
	</c:if>

	<c:if test="${noFlaggedCommetns }">
		There are no flagged Comments
	</c:if>



	<c:if test="${not empty allUsersToDisableDelete }">
			<c:forEach items="${allUsersToDisableDelete }" var="user">
			First Name: <h3>${user.firstName }</h3>
			Last Name: <h3>${user.lastName }</h3>
			Username: <h3>${user.userName }</h3>
			Email: <h3>${user.email }</h3>

			
			<form action="deleteUserAdmin.do" method="post">
			
				<input type="hidden" name="userId" value="${user.id }">
				<input type="submit" value="Delete User">
			</form>
			<form action="disableUserAdmin.do" method="post">
			
				<input type="hidden" name="userId" value="${user.id }">
				<input type="submit" value="Disable User">
			</form>
		
		</c:forEach>
	</c:if> 
	
	<c:if test="${not empty locations }">
		<c:forEach items="${locations }" var="location">
			<a href="detailedResults.do?locationId=${location.id }">${location.name }</a>
			<br />
			${location.address.street }
			<c:if test="${not empty location.address.street2 }">
				${location.address.street2 }
			</c:if>
			<br />
			${location.address.city }
			${location.address.state }
			${location.address.zipCode }<br />
				<c:if
					test="${not empty location.openTime and not empty location.closeTime }">
			${location.openTime } - ${location.closeTime }
			</c:if>
			<c:if test="${deleteDisableOption }">
				<form action="deleteConfirmation.do">
					<input type="submit" value="Delete Location">
					<input type="hidden" name="id" value="${location.id }">
				</form>
			
			</c:if>
			<c:if test="${updateOption }">
				<form action="adminUpdateLocation.do">
					<input type="submit" value="Update Location">
					<input type="hidden" name="id" value="${location.id }">
				</form>
			
			</c:if>
		</c:forEach> 
	
	</c:if>
	
	
    
  	</div>



</body>
</html>