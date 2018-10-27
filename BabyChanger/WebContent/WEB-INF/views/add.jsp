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
<title>Add Entry</title>
</head>
<body>
	<%@ include file="navigation.jsp"%>
	<h2>Add A New Entry</h2>
	<h6>* Required</h6>
	
	<form action="">
	
		<h5>Address</h5>
		<label>*Street</label>
		<input type="text" name="street" required pattern=".{3,}"/>
		<br>
		<label>*Street2</label>
		<input type="text" name="street2" required pattern=".{3,}"/>
		<br>
		<label>*City</label>
		<input type="text" name="city" required pattern=".{3,}"/>
		<br>
		<label>*State</label>
		<input type="text" name="state" required pattern=".{3,}"/>
		<br>
		<label>*Zip Code</label>
		<input type="number" name="state" required pattern=".{5,}"/>
		<br>
		<br>
		<h5>Location</h5>
		<label>Name Of Location</label>
		<input type="text" name="name"/>
		<br>
		<label>Access Limits (e.g. Club membership required)</label>
		<input type="text" name="accessLimits"/>
		<br>
		<label>*Purchased Required?</label>
		Yes<input type="radio" name="purchasedRequired" value="true"/>
		No<input type="radio" name="purchasedRequired" value="false" checked/>
		<br>
		<label>Phone Number (format as 555-555-5555)</label>
		<input type="tel" name="phone"  pattern="[0-9]{3}-[0-9]{3}-[0-9]{4}"/>
		<br>
		<label>Open Time</label>
		<input type="time" name="openTime"/>
		<br>
		<label>Close Time</label>
		<input type="time" name="closeTime"/>
		<br>
		<br>
		<h5>Restroom Information</h5>
		
		<label>*Changing Table Available?</label>
		Yes<input type="radio" name="changingTable" value="true"checked/>
		No<input type="radio" name="changingTable" value="false"/>
		<br>
		<label>*Public?</label>
		Yes<input type="radio" name="pAccess" value="true"checked/>
		No<input type="radio" name="pAccess" value="false"/>
		<br>
		<label>*Gender?</label>
		Male<input type="radio" name="gender" value="M" checked/>
		Female<input type="radio" name="pAccess" value="F"/>
		Unisex/Family<input type="radio" name="pAccess" value="U"/>
		<br>
		<label>Description Of Restroom</label>
		<input type="text" name="description"/>
		<br>
		<label>Directions To Restroom</label>
		<input type="text" name="directions"/>
		<br>
		<br>
		<input type="submit" value="Submit Entry"/>
		
		
	</form>
	
	
	
	
	<script
        src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
        integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
        crossorigin="anonymous"></script>
</body>
</html>