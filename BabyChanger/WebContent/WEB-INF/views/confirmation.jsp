<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<title>Confirmation</title>
</head>
<body>

	<%@ include file="navigation.jsp"%>
	
	<h4>Confirm Deletion</h4>
	Are you sure you want to delete:
	${locationToDelete.name }
	<form action="deleteLocation.do">
		<input type="hidden" name="id" value="${locationToDelete.id }">
		<input type="submit" value="Confirm">
	</form>
	<form action="detailedResults.do" method="GET">
		<input type="hidden" name="locationId" value="${locationToDelete.id }">
		<input type="Submit" value="Cancel"/>
	</form>
	
	<c:if test="${restroomFlagged }">
		restroom flagged
	</c:if>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
		integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
		crossorigin="anonymous"></script>
</body>
</html>