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
	
	 <%-- <form:form method="POST" action="adminUpdateLocationAdmin.do" modelAttribute="adminUpdateLocation">
		 <form:label path="name" >Location Name</form:label>
		 <form:input path="name" />
		 <form:errors path="name" />
		 <form:label path="street" >Street</form:label>
		 <form:input path="street"/>
		 <form:errors path="street" />
		 <form:label path="phone" >Phone</form:label>
		 <form:input path="phone"/>
		 <form:errors path="phone" />
		 
		 <input type="hidden" name="locationId" value="${updateLocation.id }" />
		 <input type="submit" value="Update"/>
	 
	 
	 </form:form>  --%>
	
	
	<%-- <%-- <c:if test="${loggedIn.admin }">
=======
	<c:if test="${loggedIn.admin }">
>>>>>>> 8be2f789276291106576b4521c5953a2109c93db
		<form action="adminUpdateLocationAdmin.do" method="POST">
		
	</c:if>
	<c:if test="${!loggedIn.admin }">
		<form action="userUpdateLocationUser.do" method="POST">
		
	</c:if>
		<input type="hidden" name="locationId" value="${updateLocation.id }"/>
		<p>${updateLocation.id }</p>
		<p>${updateLocation.address.street }</p>
		<p>${updateLocation.address.city }</p>
		
		Location Name: <input type="text" name="name" value="${updateLocation.name }" />
		<br> 
<<<<<<< HEAD
		Street Address: <input type="text" name="street" value="${updateLocation.address.street}"/>
=======
		Street Address: <input type="text" name="address.street" value="${updateLocation.address.street}"/>
>>>>>>> 69bce625f31bcc695f249cd5522dbc6222975ca8
		<br> 
		Street Address2 <input type="text" name="address.street2" value="${updateLocation.address.street2 }"/>
		<br> 
		City: <input type="text" name="address.city" value="${updateLocation.address.city }"/>
		<br> 
		State: <input type="text" name="address.state" value="${updateLocation.address.state }"/>
		<br> 
<<<<<<< HEAD
		Zipcode: <input type="text" name="zipCode" value="${updateLocation.address.zipCode}"/>
=======
		Zipcode: <input type="text" name="address.zipCode" value="${updateLocation.address.zipCode}"/>
>>>>>>> 69bce625f31bcc695f249cd5522dbc6222975ca8
		<br>
		Access Limits: <input type="text" name="accessLimits" value="${updateLocation.accessLimits}"/>
		<br>
		Is Purchase Required:
		
		<c:if test="${updateLocation.purchaseRequired }">
		 	Yes<input type="radio" name="purchaseRequired" value="true" checked/>
			No<input type="radio" name="purchaseRequired" value="false"/>
		
		</c:if>
		<c:if test="${!updateLocation.purchaseRequired }">
			 Yes<input type="radio" name="purchaseRequired" value="true"/>
			 No<input type="radio" name="purchaseRequired" value="false" checked/>
		
		</c:if>
		<br>
		Phone: <input type="text" name="phone" value="${updateLocation.phone}"/>
		<br>
		Open Time: <input type="text" name="openTime" value="${updateLocation.openTime}"/>
		<br>
		Close Time: <input type="text" name="closeTime" value="${updateLocation.closeTime}"/>
		<br>
		<input type="hidden" name="dateCreated" value="${updateLocation.dateCreated}"/>
		<input type="Submit" value="update" />
	</form>
	 --%>
	
	
	
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
		integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
		crossorigin="anonymous"></script>
</body>
</html>