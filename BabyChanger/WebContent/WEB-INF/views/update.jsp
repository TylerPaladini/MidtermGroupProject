<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<title>UPDATE PROFILE</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="css/w3.css">
<link rel="stylesheet" href="css/body.css">
<link rel="stylesheet" href="css/diapers.css">
<link rel="icon" href="https://www.freeiconspng.com/uploads/changing-table-icon-18.png">


<body>

	<!-- Navbar (sit on top) -->
	<%@ include file="newNav.jsp"%>

	<header class="bgimg w3-display-container w3-grayscale-min" id="home">

	</header>
	
	<div class="w3-display-middle w3-left ">
	
	<c:if test="${updatingComment }">
	
		<c:if test="${loggedIn.admin }">
			<form action="updateCommentAdmin.do" method="post">
		</c:if>
		<c:if test="${!loggedIn.admin }">
			<form action="updateCommentUser.do" method="post">
		</c:if>
		Rating
		<div class="rating">
			    <input type="radio" id="star5" name="rating" value="5" ${updatedComment.rating.value == 5 ? 'checked' : '' }/>
			    <label for="star5" title="text">5 stars</label>
			    <input type="radio" id="star4" name="rating" value="4" ${updatedComment.rating.value == 4 ? 'checked' : '' }/>
			    <label for="star4" title="text">4 stars</label>
			    <input type="radio" id="star3" name="rating" value="3" ${updatedComment.rating.value == 3 ? 'checked' : '' }/>
			    <label for="star3" title="text">3 stars</label>
			    <input type="radio" id="star2" name="rating" value="2" ${updatedComment.rating.value == 2 ? 'checked' : '' }/>
			    <label for="star2" title="text">2 stars</label>
			    <input type="radio" id="star1" name="rating" value="1" ${updatedComment.rating.value == 1 ? 'checked' : '' }/>
			    <label for="star1" title="text">1 star</label>
 			</div>
		
		Comment
		<textarea rows="3" cols="10" name="comment" >${updatedComment.comment }</textarea>
		<input type="submit" value="submit">
		</form>
	</c:if>



	<!-- tests that what is being brought in is the updateuser, if not it will not display -->
	<c:if test="${updatedUser }"> 
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
	</c:if>
	
	<c:if test="${adminUpdatingLocation }">
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
			Yes<input type="radio" name="purchaseRequired" value="true" checked="${updateLocation.purchaseRequired == true ? 'checked' : ''}"/>
			No<input type="radio" name="purchaseRequired" value="false" checked="${updateLocation.purchaseRequired == false ? 'checked' : ''}" /> 
			<br>
			<form:label path="phone">Phone Number</form:label> 
			<form:input type="tel" path="phone" value="${updateLocation.phone }"/>
			<form:errors path="phone" />
			<br>
			<form:label path="openTime" >*Open Time</form:label> 
			<form:input path="openTime" value="${updateLocation.openTime }" />
			<form:errors path="openTime" />
			<br> 
			<form:label path="closeTime">*Close Time</form:label>
			<form:input path="closeTime" value="${updateLocation.closeTime }"/> 
			<form:errors path="closeTime" />
			<br> 
			<br>
			<input type="hidden" name="locationId" value="${updateLocation.id }" />
			<input type="submit" value="Next" />
		</form:form>
	</c:if> 
	
	<c:if test="${adminUpdateAddressNext }">
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
	
	<c:if test="${userUpdatingLocation }">
		<h5>Update Location</h5>
		<form:form action="userUpdateLocationUser.do" method = "POST" modelAttribute="userUpdateLocationModel">
			<form:label path="name" >Name: </form:label>
			<form:input path="name" value="${updateLocation.name }"/>
			<form:errors path="name" />
			<br>
			<label>Access Limits (e.g. Club membership required)</label>
			<input type="text" name="accessLimits" value="${updateLocation.accessLimits }"/> 
			<br> 
			<label>*Purchased Required?</label> 
			Yes<input type="radio" name="purchaseRequired" value="true" checked="${updateLocation.purchaseRequired == true ? 'checked' : ''}"/>
			No<input type="radio" name="purchaseRequired" value="false" checked="${updateLocation.purchaseRequired == false ? 'checked' : ''}" /> 
			<br>
			<form:label path="phone">Phone Number</form:label> 
			<form:input type="tel" path="phone" value="${updateLocation.phone }"/>
			<form:errors path="phone" />
			<br>
			<form:label path="openTime">*Open Time</form:label> 
			<form:input path="openTime" value="${updateLocation.openTime }" />
			<form:errors path="openTime" />
			<br> 
			<form:label path="closeTime">*Close Time</form:label>
			<form:input path="closeTime" value="${updateLocation.closeTime }"/> 
			<form:errors path="closeTime" />
			<br> 
			<br>
			<input type="hidden" name="locationId" value="${updateLocation.id }" />
			<input type="submit" value="Next" />
		</form:form>
	</c:if> 
	
	<c:if test="${userUpdateAddressNext }">
		<h5>Update Address</h5>
		<form:form action="userUpdateAddressUser.do" method = "POST" modelAttribute="userUpdateAddressModel">
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
	
	<c:if test="${userUpdatingRestroom }">
		<h5>Update Restroom</h5>
		<form:form action="userUpdateRestroomUser.do" method = "POST" modelAttribute="userUpdateRestroomModel">
			<form:label path="changingTable">*Changing Table Available?</form:label> 
			Yes <form:radiobutton path="changingTable" value="true" checked="${updateRestroom.changingTable == true ? 'checked':''}"/> 
			No <form:radiobutton path="changingTable" value="false" checked="${updateRestroom.changingTable == false ? 'checked':''}"/> 
			<form:errors path="changingTable" />
			<br> 
			<label>*Public?</label>
			Yes <input type="radio" name="pAccess" value="true" checked="${updateRestroom.pAccess == true ? 'checked':''}" /> 
			No <input type="radio" name="pAccess" value="false" checked="${updateRestroom.pAccess == false ? 'checked':''}"/> 
			<br> 
			<form:label path="gender">*Gender?</form:label>
			Male <form:radiobutton path="gender" value="M" checked="${updateRestroom.gender == 'M' ? 'checked':''}"/> 
			Female <form:radiobutton path="gender" value="F" checked="${updateRestroom.gender == 'F' ? 'checked':''}"/> 
			Unisex/Family <form:radiobutton path="gender" value="U" checked="${updateRestroom.gender == 'U' ? 'checked':''}"/> 
			<form:errors path="gender" />
			<br> 
			
			<div class="container">
				<div class="row">
					<div class="col-5">
				        <label for="comment">Description:</label>
				        <textarea class="form-control" rows="4" name="description" >${updateRestroom.description }</textarea>
					</div>
				</div>
				<br>
				<div class="row">
					<div class="col-5">
					    <label for="comment">Directions:</label>
					    <textarea class="form-control" rows="4" name="directions" >${updateRestroom.directions }</textarea>
					</div>
				</div>
			
			</div>
			<br>
			<input type="hidden" name="restroomId" value="${updateRestroom.id }"/>
			<input type="submit" value="Update" />
		</form:form>
	</c:if>
	
	<c:if test="${adminUpdatingRestroom }">
		<h5>Update Restroom</h5>
		<form:form action="adminUpdateRestroomAdmin.do" method = "POST" modelAttribute="adminUpdateRestroomModel">
			<form:label path="changingTable">*Changing Table Available?</form:label> 
			Yes <form:radiobutton path="changingTable" value="true" checked="${updateRestroom.changingTable == true ? 'checked':''}" /> 
			No <form:radiobutton path="changingTable" value="false" checked="${updateRestroom.changingTable == false ? 'checked':''}"/> 
			<form:errors path="changingTable" />
			<br> 
			<label>*Public?</label>
			Yes <input type="radio" name="pAccess" value="true" checked="${updateRestroom.pAccess == true ? 'checked':''}" /> 
			No <input type="radio" name="pAccess" value="false" checked="${updateRestroom.pAccess == false ? 'checked':''}"/> 
			<br> 
			<form:label path="gender">*Gender?</form:label>
			Male <form:radiobutton path="gender" value="M" checked="${updateRestroom.gender == 'M' ? 'checked':''}"/> 
			Female <form:radiobutton path="gender" value="F" checked="${updateRestroom.gender == 'F' ? 'checked':''}"/> 
			Unisex/Family <form:radiobutton path="gender" value="U" checked="${updateRestroom.gender == 'U' ? 'checked':''}"/> 
			<form:errors path="gender" />
			<br> 
			
			<div class="container">
				<div class="row">
					<div class="col-5">
				        <label for="comment">Description:</label>
				        <textarea class="form-control" rows="4" name="description" >${updateRestroom.description }</textarea>
					</div>
				</div>
				<br>
				<div class="row">
					<div class="col-5">
					    <label for="comment">Directions:</label>
					    <textarea class="form-control" rows="4" name="directions" >${updateRestroom.directions }</textarea>
					</div>
				</div>
			
			</div>
			<br>
			<input type="hidden" name="restroomId" value="${updateRestroom.id }"/>
			<input type="submit" value="Update" />
		</form:form>
	</c:if>

</div>	
	
</body>
</html>