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
<title>Baby Changing Table Finder</title>
</head>
<body>
<%@ include file="navigation.jsp"%>
	<h1>POOP</h1>
	
	
<form action="getBathrooms.do" method="GET">
  <input type="text" name="id"/>
  <input type="Submit" value="Get Bathroom"/>
</form><br>
	
	<h5>Create User</h5>
<form action="createUserAdmin.do" method="POST">

User Name:
<input type="text" name="userName"/><br>
First Name:
  <input type="text" name="firstName"/><br>
  LastName:
  <input type="text" name="lastName"/><br>
  Email:
  <input type="text" name="email"/><br>
  Password:
  <input type="password" name="password"/><br>
  
  <input type="Submit" value="Create User"/>
</form>


	<h5>Update User</h5>
<form action="updateUserAdmin.do" method="POST">
ID#
<input type="number" name="id"/><br>
User Name:
<input type="text" name="userName"/><br>
First Name:
  <input type="text" name="firstName"/><br>
  LastName:
  <input type="text" name="lastName"/><br>
  Email:
  <input type="text" name="email"/><br>
  Password:
  <input type="password" name="password"/><br>
  
  <input type="Submit" value="update"/>
</form>





<form action="confirmDeleteAdmin.do" method="POST">
  <input type="number" name="userId"/><br>
  <input type="Submit" value="Delete"/>
</form>

<form action="getAllUsersAdmin.do">
  <input type="Submit" value="all users"/>

</form>



	
	
	<script
        src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
        integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
        crossorigin="anonymous"></script>
</body>
</html>