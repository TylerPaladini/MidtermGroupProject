<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<title>Register</title>
</head>
<body>
<%@ include file="navigation.jsp"%> --%>

<!DOCTYPE html>
<html>
<title>DETAILED RESULTS</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
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
	<!-- <script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
		integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
		crossorigin="anonymous"></script> -->
</body>
</html>
