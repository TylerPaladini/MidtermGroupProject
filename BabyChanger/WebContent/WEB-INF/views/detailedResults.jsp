<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link>
<<<<<<< HEAD
    href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
    rel="stylesheet"
    integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
    crossorigin="anonymous">
<title>Detailed Results View</title>
=======
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<title>Insert title here</title>
>>>>>>> 82fb18805b3730706c9cf315504f0517aa41e0c3
</head>
<body>
	<%@ include file="navigation.jsp"%>

	<c:if test="${not empty location }">
		<h1>Location Info</h1>
		<h2>${location.name }</h2>
		<h6>Date Created: <em>${location.dateCreated }</em></h6>
		<br>
		Phone Number:<h4>${location.phone }</h4>
		<br>
		Hours of Operation: <h4>${location.openTime }-
			${location.closeTime }</h4>
		<br>
		Address:<h4>${location.address.street }</h4>
		<h4>${location.address.street2 }</h4>
		<h4>${location.address.city }</h4>
		<h4>${location.address.state }</h4>
		<h4>${location.address.zipCode }</h4>
		<br>
		Access Limits<h4>${location.accessLimits }</h4>
		<br>
		Purchase Required <h4>${location.purchaseRequired }</h4>
		<br>

		<%-- <c:if test="${not empty location.restrooms }">

			<h1>Restroom Info</h1>
			<c:forEach items="${location.restrooms }" var="restroom">
				Changing Table? <h5>${restroom.changingTable }</h5>
				<br>
				Gender:<h5>${restroom.gender }</h5>
				<br>
				Public Restroom? <h5>${restroom.pAccess }</h5>
				<br>
				Description:<h5>${restroom.description }</h5>
				<br>
				Directions:<h5>${restroom.directions }</h5>
				<br>
				<c:if test="${not empty location.restrooms.comments }">

					<h1>Comments</h1>
					<c:forEach items="${location.restrooms.comments }" var="comment">
						<h5>${comment.dateCreated }</h5>
						<h5>${comment.rating }</h5>
						<p>${comment.comment }</p>

					</c:forEach>

				</c:if>

			</c:forEach>

		</c:if> --%>


	</c:if>

	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
		integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
		crossorigin="anonymous"></script>
</body>
</html>
