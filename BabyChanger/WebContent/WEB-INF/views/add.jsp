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
			<form:form action="adminAddsAddress.do" method="POST" modelAttribute="createAddressModel">
				<h5>Address</h5>
				<form:label path="street">*Street</form:label> 
				<form:input path="street" /> 
				<form:errors path="street" />
				<br> 
				<label>Street2</label> 
				<input type="text" name="street2" /> 
				<br> 
				<form:label path="city">*City</form:label>
				<form:input path="city" /> 
				<form:errors path="city" />
				<br>
				<form:label path="state">*State</form:label> 
				<form:input path="state" />
				<form:errors path="state" />
				<br> 
				<form:label path="zipCode">*Zip Code</form:label> 
				<form:input path="zipCode" /> 
				<form:errors path="zipCode" />
				<br> 
				<br>
				<input type="submit" value="Next" />
			</form:form>
		</c:if>
		<c:if test="${!loggedIn.admin }">
			<form:form action="userAddsAddress.do" method="POST" modelAttribute="createAddressModel">
				<h5>Address</h5>
				<form:label path="street">*Street</form:label> 
				<form:input path="street" /> 
				<form:errors path="street" />
				<br> 
				<form:label path="street2">Street2</form:label> 
				<form:input path="street2" /> 
				<form:errors path="street2"/>
				<br> 
				<form:label path="city">*City</form:label>
				<form:input path="city" /> 
				<form:errors path="city" />
				<br>
				<form:label path="state">*State</form:label> 
				<form:input path="state" />
				<form:errors path="state" />
				<br> 
				<form:label path="zipCode">*Zip Code</form:label> 
				<form:input path="zipCode" /> 
				<form:errors path="zipCode" />
				<br> 
				<br>
				<input type="submit" value="Next" />
			</form:form>
		</c:if>
	</c:if>

	<c:if test="${ addLocationNext}">
		<c:if test="${loggedIn.admin }">
			<form:form action="adminAddsLocation.do" method="POST" modelAttribute="createLocationModel">
				<input type="hidden" name="newAddress" value="${newAddress }">
				<h5>Location</h5>
				<form:label path="name">Name Of Location</form:label> 
				<form:input path="name" />
				<form:errors path="name" />
				<br>
				<label>Access Limits (e.g. Club membership required)</label>
				<input type="text" name="accessLimits" /> 
				<br> 
				<label>*Purchased Required?</label> 
				Yes<input type="radio" name="purchaseRequired" value="true" />
				No<input type="radio" name="purchaseRequired" value="false" checked /> 
				<br>
				<form:label path="phone">Phone Number(format like 555-555-5555)</form:label> 
				<form:input type="tel" path="phone" />
				<form:errors path="phone" />
				<br>
				<form:label path="openTime">*Open Time(24 hour format e.g. 15:30)</form:label> 
				<form:input path="openTime" />
				<form:errors path="openTime" />
				<br> 
				<form:label path="closeTime">*Close Time(24 hour format e.g. 23:30)</form:label>
				<form:input path="closeTime" /> 
				<form:errors path="closeTime" />
				<br> 
				<br> 
				<input type="submit" value="Next" />
			</form:form>
		</c:if>
		<c:if test="${!loggedIn.admin }">
			<form:form action="userAddsLocation.do" method="POST" modelAttribute="createLocationModel">
		
				<input type="hidden" name="newAddress" value="${newAddress }">
				<h5>Location</h5>
				<form:label path="name">Name Of Location</form:label> 
				<form:input path="name" />
				<form:errors path="name" />
				<br>
				<label>Access Limits (e.g. Club membership required)</label>
				<input type="text" name="accessLimits" /> 
				<br> 
				<label>*Purchased Required?</label> 
				Yes<input type="radio" name="purchaseRequired" value="true" />
				No<input type="radio" name="purchaseRequired" value="false" checked /> 
				<br>
				<form:label path="phone">Phone Number(format like 555-555-5555)</form:label> 
				<form:input type="tel" path="phone" />
				<form:errors path="phone" />
				<br>
				<form:label path="openTime">*Open Time(24 hour format e.g. 15:30)</form:label> 
				<form:input path="openTime" />
				<form:errors path="openTime" />
				<br> 
				<form:label path="closeTime">*Close Time(24 hour format e.g. 23:30)</form:label>
				<form:input path="closeTime" /> 
				<form:errors path="closeTime" /> 
				<br> 
				<br> 
				<input type="submit" value="Next" />
			</form:form>
		</c:if>
	</c:if>
	<c:if test="${ addRestroomNext}">
		<c:if test="${loggedIn.admin }">
			<form:form action="adminAddsRestroom.do" method="POST" modelAttribute="createRestroomModel">
				<input type="hidden" name="newLocation" value="${newLocation }">
				<input type="hidden" name="newAddress" value="${newAddress }">
				<h5>Restroom Information</h5>
	
				<form:label path="changingTable">*Changing Table Available?</form:label> 
				Yes <form:radiobutton path="changingTable" value="true"/> 
				No <form:radiobutton path="changingTable" value="false"/> 
				<form:errors path="changingTable" />
				<br> 
				<label>*Public?</label>
				Yes <input type="radio" name="pAccess" value="true" checked /> 
				No <input type="radio" name="pAccess" value="false" /> 
				<br> 
				<form:label path="gender">*Gender?</form:label>
				Male <form:radiobutton path="gender" value="M" /> 
				Female <form:radiobutton path="gender" value="F" /> 
				Unisex/Family <form:radiobutton path="gender" value="U" /> 
				<form:errors path="gender" />
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
			</form:form>
		</c:if>
		<c:if test="${!loggedIn.admin }">
			<form:form action="userAddsRestroom.do" method="POST" modelAttribute="createRestroomModel">
		
				<input type="hidden" name="newLocation" value="${newLocation }">
				<input type="hidden" name="newAddress" value="${newAddress }">
				<h5>Restroom Information</h5>
	
				<form:label path="changingTable">*Changing Table Available?</form:label> 
				Yes <form:radiobutton path="changingTable" value="true"/> 
				No <form:radiobutton path="changingTable" value="false"/> 
				<form:errors path="changingTable" />
				<br> 
				<label>*Public?</label>
				Yes <input type="radio" name="pAccess" value="true" checked /> 
				No <input type="radio" name="pAccess" value="false" /> 
				<br> 
				<form:label path="gender">*Gender?</form:label>
				Male <form:radiobutton path="gender" value="M" /> 
				Female <form:radiobutton path="gender" value="F" /> 
				Unisex/Family <form:radiobutton path="gender" value="U" /> 
				<form:errors path="gender" />
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
			</form:form>
		</c:if>	
	</c:if>
	<c:if test="${addingComment}">
		<c:if test="${loggedIn.admin }">
			<form action="addCommentAdmin.do" method="post">
		</c:if>
		<c:if test="${!loggedIn.admin }">
			<form action="addCommentUser.do" method="post">
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