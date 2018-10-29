<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
    rel="stylesheet"
    integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
    crossorigin="anonymous">
<title>Detailed Results View</title>

</head>
<body>
	<%@ include file="navigation.jsp"%>

	<c:if test="${not empty location }">
		<h1>Location Info</h1>
		<h2>${location.name }</h2>
		<h6>Date Created: </h6>
		<em>${location.dateCreated }</em>
		<br>
		<h4>Phone Number:</h4>
		${location.phone }
		<br>
		<h4>Hours of Operation: </h4>
		${location.openTime } - ${location.closeTime }
		<br>
		<h4>Address:</h4>
		<p>
			${location.address.street }
			${location.address.street2 }
			${location.address.city }
			${location.address.state }
			${location.address.zipCode }
		</p>
		<br>
		<h4>Access Limits</h4>
		${location.accessLimits }
		<br>
		<h4>Purchase Required</h4>
		${location.purchaseRequired }
		<br>
		<br>
		<br>
		<br>

		<c:if test="${not empty location.restrooms }">

			<c:forEach items="${location.restrooms }" var="restroom">
				<h1>Restroom Info</h1>
				<h5>Changing Table?</h5>
				${restroom.changingTable }
				<br>
				<h5>Gender:</h5>
				${restroom.gender }
				<br>
				<h5>Public Restroom?</h5>
				${restroom.pAccess }
				<br>
				<h5>Description:</h5>
				${restroom.description }
				<br>
				<h5>Directions:</h5>
				${restroom.directions }
				<br>
				<form action="">
				
					<input type="submit" value="Add Comment">
				</form>
				<c:if test="${empty restroom.comments }">
					<h3>No comments posted for this restroom</h3>
				</c:if>
				
				<c:if test="${not empty restroom.comments }">
					<h3>Comments</h3>
					<c:forEach items="${restroom.comments }" var="comment">
						<h5>Date Created</h5>
						${comment.dateCreated }
						<h5>Rating</h5>
						${comment.rating }
						<br>
						<p>${comment.comment }</p>
						<hr>
	
					</c:forEach>
				</c:if>
			<br>
			<br>
			<br>
			<br>
			<hr>
			</c:forEach>

		</c:if>


	</c:if>

	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
		integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
		crossorigin="anonymous"></script>
</body>
</html>
