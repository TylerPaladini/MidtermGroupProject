<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<title>ADD</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="css/w3.css">
<link rel="stylesheet" href="css/body.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Amatic+SC">
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
	
	<div class="w3-display-middle w3-left ">
	
	<c:if test="${addLocationFailed }">
		<h1>Add Location Failed</h1>
	</c:if>
	<h6>* Required</h6>
	<c:if test="${newEntry }">
		<h2>Add A New Entry</h2>
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
				<form:label path="name">*Name Of Location</form:label> 
				<form:input path="name" />
				<form:errors path="name" />
				<br>
				<label>*Access Limits</label>
				<input type="text" name="accessLimits" placeholder="e.g. Club membership required"/> 
				<br> 
				<label>*Purchased Required?</label> 
				Yes<input type="radio" name="purchaseRequired" value="true" />
				No<input type="radio" name="purchaseRequired" value="false" checked /> 
				<br>
				<form:label path="phone">*Phone Number</form:label> 
				<form:input type="tel" path="phone" placeholder="555-555-5555"/>
				<form:errors path="phone" />
				<br>
				<form:label path="openTime" >*Open Time</form:label> 
				<form:input path="openTime" placeholder="e.g. 06:00:00"/>
				<form:errors path="openTime" />
				<br> 
				<form:label path="closeTime" >*Close Time</form:label>
				<form:input path="closeTime" placeholder="e.g. 23:30:00"/> 
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
				<form:label path="name">*Name Of Location</form:label> 
				<form:input path="name" />
				<form:errors path="name" />
				<br>
				<label>Access Limits </label>
				<input type="text" name="accessLimits" placeholder="e.g. Club membership required"/> 
				<br> 
				<label>*Purchased Required?</label> 
				Yes<input type="radio" name="purchaseRequired" value="true" />
				No<input type="radio" name="purchaseRequired" value="false" checked /> 
				<br>
				<form:label path="phone">*Phone Number</form:label> 
				<form:input type="tel" path="phone" placeholder="555-555-5555"/>
				<form:errors path="phone" />
				<br>
				<form:label path="openTime" >*Open Time</form:label> 
				<form:input path="openTime" placeholder="e.g. 06:00:00"/>
				<form:errors path="openTime" />
				<br> 
				<form:label path="closeTime" >*Close Time</form:label>
				<form:input path="closeTime" placeholder="e.g. 23:30:00"/> 
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
				Yes <form:radiobutton path="changingTable" value="true" checked="checked"/> 
				No <form:radiobutton path="changingTable" value="false" /> 
				<form:errors path="changingTable" />
				<br> 
				<label>*Public?</label>
				Yes <input type="radio" name="pAccess" value="true" checked="checked" /> 
				No <input type="radio" name="pAccess" value="false" /> 
				<br> 
				<form:label path="gender">*Gender?</form:label>
				Male <form:radiobutton path="gender" value="M" /> 
				Female <form:radiobutton path="gender" value="F" /> 
				Unisex/Family <form:radiobutton path="gender" value="U" checked="checked"/> 
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
				Yes <form:radiobutton path="changingTable" value="true" checked="checked"/> 
				No <form:radiobutton path="changingTable" value="false"/> 
				<form:errors path="changingTable" />
				<br> 
				<label>*Public?</label>
				Yes <input type="radio" name="pAccess" value="true" checked="checked" /> 
				No <input type="radio" name="pAccess" value="false" /> 
				<br> 
				<form:label path="gender">*Gender?</form:label>
				Male <form:radiobutton path="gender" value="M" /> 
				Female <form:radiobutton path="gender" value="F" /> 
				Unisex/Family <form:radiobutton path="gender" value="U" checked="checked"/> 
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
			<!-- <input type="number" min=1 max=5 name="rating" value=1> -->
			<div class="rating">
			    <input type="radio" id="star5" name="rating" value="5" />
			    <label for="star5" title="text">5 stars</label>
			    <input type="radio" id="star4" name="rating" value="4" />
			    <label for="star4" title="text">4 stars</label>
			    <input type="radio" id="star3" name="rating" value="3" />
			    <label for="star3" title="text">3 stars</label>
			    <input type="radio" id="star2" name="rating" value="2" />
			    <label for="star2" title="text">2 stars</label>
			    <input type="radio" id="star1" name="rating" value="1" />
			    <label for="star1" title="text">1 star</label>
 			</div>
			
			Comment
			<textarea rows="3" cols="6" name="comment"></textarea>
			<input type="submit" value="submit">
		</form>
		
	
	</c:if>
</div>
</body>
</html>