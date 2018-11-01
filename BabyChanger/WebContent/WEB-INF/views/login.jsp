<!DOCTYPE html>
<html>
<title>LOGIN</title>
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
	
<div class="w3-display-middle w3-center ">

<c:if test="${notCurrentUser}">
Please Create an Account

</c:if>


<form action="login.do" method="POST">


	<label for="userName">Username: <font face="verdana"><input type="text" name="userName"></font></label>
	<br>
	<label for="password">Password:&nbsp&nbsp  <font face="verdana"><input type="password" name="password"></font></label>
	<br>
	<input type="Submit" value="Login">

</form>


</div>

</body>
</html>