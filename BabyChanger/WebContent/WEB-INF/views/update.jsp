<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
<title>Update</title>
</head>
<body>
	<%@ include file="navigation.jsp"%>
	
	<c:if test="${updatingComment }">
	
		<c:if test="${loggedIn.admin }">
			<form action="updateCommentAdmin.do" method="post">
		</c:if>
		<c:if test="${!loggedIn.admin }">
			<form action="updateCommentUser.do" method="post">
		</c:if>
		Rating
		<input type="number" min=1 max=5 name="rating" value="${updatedComment.rating.value }">
		
		Comment
		<textarea rows="3" cols="6" name="comment" value="${updatedComment.comment }"></textarea>
		<input type="submit" value="submit">
		</form>
	</c:if>

	<h5>Update Profile</h5>
	
	<c:if test="${loggedIn.admin }">
		<form action="updateUserAdmin.do" method="POST">
		
	</c:if>
	<c:if test="${!loggedIn.admin }">
		<form action="updateUser.do" method="POST">
		
	</c:if>
		<input type="hidden" name="id" value="${loggedIn.id }"/>
		
		User Name: <input type="text" name="userName" value="${loggedIn.userName }" />
		<br> 
		First Name: <input type="text" name="firstName" value="${loggedIn.firstName }"/>
		<br> 
		LastName: <input type="text" name="lastName" value="${loggedIn.lastName }"/>
		<br> 
		Email: <input type="text" name="email" value="${loggedIn.email }"/>
		<br> 
		Password: <input type="password" name="password" value="${loggedIn.password }"/>
		<br> 
		<input type="Submit" value="update" />
	</form>
	
	<c:if test="${updatingLocation }">
		<h5>Update Location</h5>
		<form:form action="adminUpdateLocationAdmin.do" method = "POST" modelAttribute="adminUpdateLocationModel">
			<form:label path="name" >Name: </form:label>
			<form:input path="name" value="${updateLocation.name }"/>
			<form:errors path="name" />
			<br>
			<label>Access Limits (e.g. Club membership required)</label>
			<input type="text" name="accessLimits" value="${updateLocation.accessLimits }"/> 
			<br> 
			<label>*Purchased Required?</label> 
			Yes<input type="radio" name="purchaseRequired" value="true" />
			No<input type="radio" name="purchaseRequired" value="false" /> 
			<br>
			<form:label path="phone">Phone Number(format like 555-555-5555)</form:label> 
			<form:input type="tel" path="phone" value="${updateLocation.phone }"/>
			<form:errors path="phone" />
			<br>
			<form:label path="openTime">*Open Time(24 hour format e.g. 15:30)</form:label> 
			<form:input path="openTime" value="${updateLocation.openTime }" />
			<form:errors path="openTime" />
			<br> 
			<form:label path="closeTime">*Close Time(24 hour format e.g. 23:30)</form:label>
			<form:input path="closeTime" value="${updateLocation.closeTime }"/> 
			<form:errors path="closeTime" />
			<br> 
			<br>
			<input type="hidden" name="locationId" value="${updateLocation.id }" />
			<input type="submit" value="Next" />
		</form:form>
	</c:if> 
	
	<c:if test="${updateAddressNext }">
		<h5>Update Address</h5>
		<form:form action="adminUpdateAddressAdmin.do" method = "POST" modelAttribute="adminUpdateAddressModel">
			<form:label path="street" >Street: </form:label>
			<form:input path="street" value="${updateAddress.street }"/>
			<form:errors path="street" />
			<br> 
			<label>Street2</label> 
			<input type="text" name="street2" value="${updateAddress.street2 }" /> 
			<br> 
			<form:label path="city">*City</form:label>
			<form:input path="city" value="${updateAddress.city }"/> 
			<form:errors path="city" />
			<br>
			<form:label path="state">*State</form:label> 
			<form:input path="state" value="${updateAddress.state }"/>
			<form:errors path="state" />
			<br> 
			<form:label path="zipCode">*Zip Code</form:label> 
			<form:input path="zipCode" value="${updateAddress.zipCode }"/> 
			<form:errors path="zipCode" />
			<input type="hidden" name="addressId" value="${updateAddress.id }" />
			<input type="submit" value="Update" />
		</form:form>
	</c:if> 
	
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
		integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
		crossorigin="anonymous"></script>
</body>
</html>