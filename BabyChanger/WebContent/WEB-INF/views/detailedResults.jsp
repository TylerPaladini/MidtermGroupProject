<!DOCTYPE html>
<html>
<title>DETAILED RESULTS</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="css/w3.css">
<link rel="stylesheet" href="css/body.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Amatic+SC">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
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
	
<!-- <body> -->
<%-- 	<%@ include file="map.jsp"%> --%>
	<%-- <%@ include file="locater.jsp"%> --%>
<%-- 	<%@ include file="newNav.jsp"%> --%>
	<div class="w3-display-topmiddle w3-left ">
		<div class="container" >

			<BR><BR>
			

		</div>
		
	
	<c:if test="${not empty locationUpdateSuccess }">
		<h2>Update Location Successful</h2>
	</c:if>
	<c:if test="${locationNotDeleted }">
		<h1>Error deleting location</h1>
	</c:if>
	<c:if test="${commentAdded }">
		<h1>Successfully added comment</h1>
		</c:if>
	<c:if test="${locationDisabled }">
		<h1>Location disabled</h1>
	</c:if>
	<c:if test="${updateComment }">
		<h1>Comment Updated</h1>
	</c:if>
	<c:if test="${disabledComment }">
		<h1>Comment Deleted</h1>
	</c:if>
	<c:if test="${flaggedComment }">
		<h1>Comment Reported</h1>
	</c:if>
	<c:if test="${updateRestroomSuccess }">
		<h1>Update Restroom Successful</h1>
	</c:if>
	<c:if test="${addLocationSuccess }">
		<h1>Adding Location Successful</h1>
	</c:if> 
	<c:if test="${unflagSuccess }">
		<h1>Unflagged Restroom success</h1>
	</c:if> 
	<c:if test="${unflagCommentSuccess }">
		<h1>Unflagged Comment success</h1>
	</c:if> 
	<c:if test="${restroomFlagged }">
		<h1>Restroom Flagged Successful</h1>
	</c:if> 
	<c:if test="${not empty location }">
		<div style="background-color: lightyellow">
			<h1>Location Info</h1>
			<h2>${location.name }</h2>
			<h2>Average Rating:${averageRating == null ? 0 : averageRating }</h2>
			<span class="fa fa-star ${averageRating >= 0.5 ? 'checked': ''}"></span>
			<span class="fa fa-star ${averageRating >= 1.5 ? 'checked': ''}"></span>
			<span class="fa fa-star ${averageRating >= 2.5 ? 'checked': ''}"></span>
			<span class="fa fa-star ${averageRating >= 3.5 ? 'checked': ''}"></span>
			<span class="fa fa-star ${averageRating >= 4.5 ? 'checked': ''}"></span>
			<h6>Date Created:</h6>
			<em>${location.dateCreated }</em> <br>
			<h4>Phone Number:</h4>
			${location.phone } <br>
			<h4>Hours of Operation:</h4>
			${location.openTime } - ${location.closeTime } <br>
			<h4>Address:</h4>
			<p>${location.address.street }${location.address.street2 }
				${location.address.city } ${location.address.state }
				${location.address.zipCode }</p>
			<br>
			<h4>Access Limits</h4>
			${location.accessLimits } <br>
			<h4>Purchase Required</h4>
			${location.purchaseRequired }

	
		</div>
		<c:if test="${ not empty loggedIn }">
			<form action="userUpdateLocation.do">
				<input type="hidden" name="id" value="${location.id }" /> <input
					type="submit" value="Update" />
			</form>
			<c:if test="${loggedIn.admin }">
				<form action="deleteConfirmation.do">
					<input type="hidden" name="id" value="${location.id }">
					<input type="Submit" value="Delete Location"/>
				</form>
			</c:if>
		</c:if>
		<c:if test="${empty loggedIn }">
			<h4>Register to update locations</h4>
		</c:if>
		<br>
		<br>
		<br>
		<br>

		<c:if test="${not empty location.restrooms }">






			<c:forEach items="${location.restrooms }" var="restroom">
			
			
			
			
			
			
				<div style="background-color: lightgray">
					<h1>Restroom Info: ${restroom.description }</h1>
					<c:if test="${restroom.flagRestroom }">
					RESTROOM HAS BEEN FLAGGED FOR ${restroom.flaggedReason }
					</c:if> 
					<h5>Changing Table?</h5>
					${restroom.changingTable } <br>
					<h5>Gender:</h5>
					${restroom.gender } <br>
					<h5>Public Restroom?</h5>
					${restroom.pAccess } <br>
					<h5>Description:</h5>
					${restroom.description } <br>
					<h5>Directions:</h5>
					${restroom.directions } <br>
				</div>
				
				
				
				
				
				
				<c:if test="${ not empty loggedIn }">
					<c:if test="${loggedIn.admin }">
						<form action="addedCommentPageAdmin.do">
					</c:if>
					<c:if test="${!loggedIn.admin }">
						<form action="addedCommentPageUser.do">
					</c:if>
					<input type="hidden" name="restroomId" value="${restroom.id }">
					<input type="submit" value="Add Comment">

					</form>
					<c:if test="${!loggedIn.admin && !restroom.flagRestroom}">
						<form action="flagRestroom.do" method="post">
							<input type="hidden" name="id" value="${restroom.id }"> 
							<input type="hidden" name="isFlag" value="true">
							<input type="text" name="flaggedReason" placeholder="reason for flag"> 
							<input type="submit" value="Flag Restroom">
						</form>
					</c:if>
					<c:if test="${loggedIn.admin && restroom.flagRestroom }">
						<form action="unflagRestroom.do" method="post">
							<input type="text" name="unflaggedReason" placeholder="reason for unflag"> 
							<input type="hidden" name="restroomId" value="${restroom.id }"> 
							<input type="submit" value="Unflag Restroom">
							
						</form>
					</c:if>

					
					<c:if test="${loggedIn.admin }">
						<form action="adminUpdateRestroom.do" >
					</c:if>
					<c:if test="${!loggedIn.admin }">
						<form action="userUpdateRestroom.do" >
					</c:if>
							<input type="hidden" name="restroomId" value="${restroom.id }">
							<input type="hidden" name="locationId" value="${location.id }">
							<input type="Submit" value="Update Restroom">
					</form>



				</c:if>
				
				
				
				
				
				
				
				<c:if test="${empty loggedIn }">
					<h4>Register to add, update and report restrooms</h4>
				</c:if>





				<c:if test="${empty restroom.comments }">
					<h3>No comments posted for this restroom</h3>
				</c:if>
				
				
				
				<c:if test="${not empty restroom.comments }">

					<h3>Comments</h3>
					<hr>
					<c:forEach items="${restroom.comments }" var="comment">

						<c:if test="${comment.active}">
							<div style="background-color: lightblue">
								<c:if test="${comment.flagComment }">
									<p style="font-color: red">Flagged</p>
								</c:if>
								<h5>Date Created</h5>
								${comment.dateCreated }
								<h5>Rating: ${comment.rating.value }</h5>
								
								<span class="fa fa-star ${comment.rating.value >= 1 ? 'checked': ''}"></span>
								<span class="fa fa-star ${comment.rating.value >= 2 ? 'checked': ''}"></span>
								<span class="fa fa-star ${comment.rating.value >= 3 ? 'checked': ''}"></span>
								<span class="fa fa-star ${comment.rating.value >= 4 ? 'checked': ''}"></span>
								<span class="fa fa-star ${comment.rating.value >= 5 ? 'checked': ''}"></span>
								 <br>
								<p>${comment.comment }</p>
								
								
								
								
								
								<c:if test="${ not empty loggedIn }">
									<c:if test="${comment.user.id == loggedIn.id }">


										<c:if test="${loggedIn.admin }">
											<form action="updateCommentPageAdmin.do">
										</c:if>
										<c:if test="${!loggedIn.admin }">
											<form action="updateCommentPageUser.do">
										</c:if>

										<input type="hidden" name="commentId" value="${comment.id }">
										<input type="submit" value="update Comment">
										</form>




										<c:if test="${loggedIn.admin }">
											<form action="disableCommentAdmin.do" method="post">
										</c:if>
										<c:if test="${!loggedIn.admin }">
											<form action="disableCommentUser.do" method="post">
										</c:if>

										<input type="hidden" name="id" value="${comment.id }">
										<input type="submit" value="delete Comment">
										</form>



									</c:if>
									<c:if test="${comment.user.id != loggedIn.id && !comment.flagComment}">

										<c:if test="${loggedIn.admin }">
											<form action="updateFlagCommentAdmin.do" method="post">
										</c:if>
										<c:if test="${!loggedIn.admin }">
											<form action="updateFlagCommentUser.do" method="post">
										</c:if>

										<input type="hidden" name="id" value="${comment.id }">
										<input type="hidden" name="isFlag" value="true">
										<input type="submit" value="Flag Comment">
										</form>


									</c:if>
									<hr>
								</c:if>
								
								
								
								
								
								<c:if test="${empty loggedIn }">
									<h4>Register to add, update and report comments</h4>
								</c:if>
							</div>
						</c:if>
					</c:forEach>
					
					
					
					
					
				</c:if>







			</c:forEach>
		</c:if>
		<br>
		<br>
		<br>
		<br>
		<hr>

	</c:if>

</div>

<!-- 	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
		integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
		crossorigin="anonymous"></script> -->
</body>
</html>
