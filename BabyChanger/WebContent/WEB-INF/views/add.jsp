<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
<title>Add Entry</title>
</head>
<body>
	<%@ include file="navigation.jsp"%>
	<h2>Add A New Entry</h2>
	<h6>* Required</h6>
	<c:if test="${newEntry }">
	
		<c:if test="${loggedIn.admin }">
			<form action="adminAddsAddress.do" method="POST">
		</c:if>
		<c:if test="${!loggedIn.admin }">
			<form action="userAddsAddress.do" method="POST">
		</c:if>
		
				<h5>Address</h5>
				<label>*Street</label> 
				<input type="text" name="street" required pattern=".{3,}" /> 
				<br> 
				<label>Street2</label> 
				<input type="text" name="street2" pattern=".{3,}" /> 
				<br> 
				<label>*City</label>
				<input type="text" name="city" required pattern=".{3,}" /> 
				<br>
				<label>*State</label> 
				<input type="text" name="state" required pattern=".{2,}" /> 
				<br> 
				<label>*Zip Code</label> 
				<input type="text" name="zipCode" required pattern=".{5,}" /> 
				<br> 
				<br>
				<input type="submit" value="Next" />
			</form>

	</c:if>

	<c:if test="${ addLocationNext}">
		<c:if test="${loggedIn.admin }">
			<form action="adminAddsLocation.do" method="POST">
		</c:if>
		<c:if test="${!loggedIn.admin }">
			<form action="userAddsLocation.do" method="POST">
		</c:if>
				<input type="hidden" name="newAddress" value="${newAddress }">
				<h5>Location</h5>
				<label>Name Of Location</label> 
				<input type="text" name="name" /> 
				<br>
				<label>Access Limits (e.g. Club membership required)</label>
				<input type="text" name="accessLimits" /> 
				<br> 
				<label>*Purchased Required?</label> 
				Yes<input type="radio" name="purchaseRequired" value="true" />
				No<input type="radio" name="purchaseRequired" value="false" checked /> 
				<br>
				<label>Phone Number(format like 555-555-5555)</label> 
				<input type="tel" name="phone" pattern="[0-9]{3}-[0-9]{3}-[0-9]{4}" /> 
				<br> <label>*Open Time(24 hour format e.g. 15:30)</label> 
				<input type="text" name="openTime" required pattern="(^([01]\d|2[0-3]):([0-5]\d)$"/> 
				<br> 
				<label>*Close Time(24 hour format e.g. 23:30)</label>
				<input type="text" name="closeTime" required pattern="^([01]\d|2[0-3]):([0-5]\d)$"> 
				<br> 
				<br> 
				<input type="submit" value="Next" />
			</form>
	</c:if>
	<c:if test="${ addRestroomNext}">
		<c:if test="${loggedIn.admin }">
			<form action="adminAddsRestroom.do" method="POST">
		</c:if>
		<c:if test="${!loggedIn.admin }">
			<form action="userAddsRestroom.do" method="POST">
		</c:if>
					<input type="hidden" name="newLocation" value="${newLocation }">
				<input type="hidden" name="newAddress" value="${newAddress }">
				<h5>Restroom Information</h5>
	
				<label>*Changing Table Available?</label> 
				Yes <input type="radio" name="changingTable" value="true" checked /> 
				No <input type="radio"name="changingTable" value="false" /> 
				<br> 
				<label>*Public?</label>
				Yes <input type="radio" name="pAccess" value="true" checked /> 
				No <input type="radio" name="pAccess" value="false" /> 
				<br> 
				<label>*Gender?</label>
				Male <input type="radio" name="gender" value="M" checked /> 
				Female <input type="radio" name="gender" value="F" /> 
				Unisex/Family <input type="radio" name="gender" value="U" /> 
				<br> 
				
				<div class="container">
					<div class="row">
						<div class="col-5">
					        <label for="comment">Description:</label>
					        <textarea class="form-control" rows="4" name="description"></textarea>
						</div>
					</div>
					<br>
					<div class="row">
						<div class="col-5">
						    <label for="comment">Directions:</label>
						    <textarea class="form-control" rows="4" name="directions"></textarea>
						</div>
					</div>
				
				</div>
				<br> 
				<br>
				<input type="submit" value="Submit Entry" />
				<input type="hidden" name="userId" value="${loggedIn.id }">
			</form>
				
	</c:if>
	<c:if test="${addingComment}">
		<c:if test="${loggedIn.admin }">
			<form action="addCommentAdmin.do" method="post">
		</c:if>
		<c:if test="${!loggedIn.admin }">
			<form action="">
		</c:if>
		
		Rating
		<input type="number" min=1 max=5 name="rating" value=1>
		
		Comment
		<textarea rows="3" cols="6" name="comment"></textarea>
		<input type="submit" value="submit">
		</form>
		
	
	</c:if>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
		integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
		crossorigin="anonymous"></script>
</body>
</html>