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
<title>Update</title>
</head>
<body>
	<%@ include file="navigation.jsp"%>

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
	
	<h5>Update Location</h5>
	<c:if test="${loggedIn.admin }">
		<form action="adminUpdateLocationAdmin.do" method="POST">
		
	</c:if>
	<c:if test="${!loggedIn.admin }">
		<form action="userUpdateLocationUser.do" method="POST">
		
	</c:if>
		<input type="hidden" name="id" value="${location.id }"/>
		Location Name: <input type="text" name="name" value="${location.name }" />
		<br> 
		Street Address: <input type="text" name="street" value="${location.address.street}"/>
		<br> 
		Street Address2 <input type="text" name="street2" value="${location.address.street2 }"/>
		<br> 
		City: <input type="text" name="city" value="${location.address.city }"/>
		<br> 
		State: <input type="text" name="state" value="${location.address.state }"/>
		<br> 
		Zipcode: <input type="text" name="zipCode" value="${location.address.zipCode}"/>
		<br>
		Access Limits: <input type="text" name="accessLimits" value="${location.accessLimits}"/>
		<br>
		Is Purchase Required: <input type="text" name="purchaseRequired" value="${location.purchaseRequired}"/>
		<br>
		Phone: <input type="text" name="phone" value="${location.phone}"/>
		<br>
		Open Time: <input type="text" name="openTime" value="${location.openTime}"/>
		<br>
		Close Time: <input type="text" name="closeTime" value="${location.closeTime}"/>
		<br>
		<input type="hidden" name="dateCreated" value="${location.dateCreated}"/>
		<input type="Submit" value="update" />
	</form>
	
	
	
	
	
	
	

	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
		integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
		crossorigin="anonymous"></script>
</body>
</html>