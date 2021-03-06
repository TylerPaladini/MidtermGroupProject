<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<title>REGISTER</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="css/w3.css">
<link rel="stylesheet" href="css/body.css">
<link rel="stylesheet" href="css/diaper.css">
<link rel="icon" href="https://www.freeiconspng.com/uploads/changing-table-icon-18.png">


<body>

	<!-- Navbar (sit on top) -->
	<%@ include file="newNav.jsp"%>

	<header class="bgimg w3-display-container w3-grayscale-min" id="home">

	</header>
	
	<div class="w3-display-middle w3-left ">
	
	<h5>Create User</h5>
	<form:form action="createUser.do" method="POST" modelAttribute="registerUserModel">
	
		<form:label path="userName">User Name:</form:label>
		 <font face="verdana"><form:input path="userName" /></font>
		
		<form:errors path="userName" /><br />
		First Name:
		 <font face="verdana"><input type="text" name="firstName"/></font><br />
		
		Last Name:
		 <font face="verdana"><input type="text" name="lastName"/></font><br />
		
		<form:label path="email">Email:</form:label>
		 <font face="verdana"><form:input path="email"/></font>
		<form:errors path="email" /><br />

		<form:label path="password">Password:</form:label>
		 <font face="verdana"><form:password path="password" /></font>
		<form:errors path="password"/><br />
		  
		<input type="Submit" value="Create User"/>
	</form:form>
	
	</div>
	
</body>
</html>
