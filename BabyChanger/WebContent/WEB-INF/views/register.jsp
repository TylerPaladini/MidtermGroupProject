<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<title>REGISTER</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="css/w3.css">
<link rel="stylesheet" href="css/body.css">

<body>

	<!-- Navbar (sit on top) -->
	<%@ include file="newNav.jsp"%>

	<header class="bgimg w3-display-container w3-grayscale-min" id="home">

	</header>
	
	<div class="w3-display-middle w3-center ">
	
	<h5>Create User</h5>
	<form:form action="createUser.do" method="POST" modelAttribute="registerUserModel">
	
		<form:label path="userName">User Name:</form:label>
		<form:input path="userName" />
		
		<form:errors path="userName" /><br />
		First Name:
		<input type="text" name="firstName"/><br />
		
		Last Name:
		<input type="text" name="lastName"/><br />
		
		<form:label path="email">Email:</form:label>
		<form:input path="email"/>
		<form:errors path="email" /><br />

		<form:label path="password">Password:</form:label>
		<form:password path="password" />
		<form:errors path="password"/><br />
		  
		<input type="Submit" value="Create User"/>
	</form:form>
	
	</div>
	
</body>
</html>
