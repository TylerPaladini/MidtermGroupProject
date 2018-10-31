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
<title>Detailed Results View</title>

</head>
<body>
	<%@ include file="map.jsp"%>
	<%@ include file="navigation.jsp"%>

	<c:if test="${locationNotDeleted }">
		<h1>Error deleting location</h1>
	</c:if>
	<c:if test="${locationDisabled }">
		<h1>Location disabled</h1>
	</c:if>
	<c:if test="${not empty location }">
		<div style="background-color: lightyellow">
			<h1>Location Info</h1>
			<h2>${location.name }</h2>
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
			
			
			
			
			
			
				<div style="background-color: lightgreen">
					<h1>Restroom Info: ${restroom.description }</h1>
					<c:if test="${restroom.flagRestroom }">
					RESTROOM HAS BEEN FLAGGED
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
					<c:if test="${!loggedIn.admin }">
						<form action="flagRestroom.do" method="post">
							<input type="hidden" name="id" value="${restroom.id }"> 
							<input type="hidden" name="isFlag" value="true">
							<input type="text" name="flaggedReason" value="Why you flag?"> 
							<input type="submit" value="Flag Restroom">
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

						<c:if test="${comment.active }">
							<div style="background-color: lightblue">
								<c:if test="${comment.flagComment }">
									<p style="font-color: red">Flagged</p>
								</c:if>
								<h5>Date Created</h5>
								${comment.dateCreated }
								<h5>Rating</h5>
								${comment.rating } <br>
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
									<c:if test="${comment.user.id != loggedIn.id }">

										<c:if test="${loggedIn.admin }">
											<form action="updateFlagCommentAdmin.do" method="post">
										</c:if>
										<c:if test="${!loggedIn.admin }">
											<form action="updateFlagCommentUser.do" method="post">
										</c:if>

										<input type="hidden" name="id" value="${comment.id }">
										<input type="hidden" name="isFlag" value="true">
										<input type="submit" value="Report Comment">
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


	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
		integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
		crossorigin="anonymous"></script>
</body>
</html>
