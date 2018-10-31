<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<title>Results</title>
</head>
<body>
		<%@ include file="navigation.jsp"%>
	<c:if test="${not empty allUsers }">
		<c:forEach items="${allUsers }" var="user">
			${user.id }
			${user.firstName }
			<br>
		</c:forEach>
	</c:if>
	
	<c:if test="${not empty allKeywords }">
		<c:forEach items="${allKeywords }" var="keywordSearch">
			<a href="detailedResults.do?locationId=${keywordSearch.id }">${keywordSearch.name }</a><br />
			${keywordSearch.address.street }
			<c:if test="${not empty keywordSearch.address.street2 }">
				${keywordSearch.address.street2 }
			</c:if><br />
			${keywordSearch.address.city }
			${keywordSearch.address.state }
			${keywordSearch.address.zipCode }<br />
			<c:if test="${not empty keywordSearch.openTime and not empty keywordSearch.closeTime }">
			${keywordSearch.openTime } - ${keywordSearch.closeTime }
			</c:if><br /><br />
		</c:forEach>
	</c:if>
	
	<c:if test="${not empty open }">
		<c:forEach items="${open }" var="openRestroom">
			<a href="detailedResults.do?locationId=${openRestroom.id }">${openRestroom.name }</a><br />
			${openRestroom.address.street }
			<c:if test="${not empty openRestroom.address.street2 }">
				${openRestroom.address.street2 }
			</c:if><br />
			${openRestroom.address.city }
			${openRestroom.address.state }
			${openRestroom.address.zipCode }<br />
			<c:if test="${not empty openRestroom.openTime and not empty openRestroom.closeTime }">
			${openRestroom.openTime } - ${openRestroom.closeTime }
			</c:if><br /><br />
		</c:forEach>
	</c:if> 
	
	<c:if test="${not empty allLocations }">
		<c:forEach items="${allLocations }" var="location">
			<a href="detailedResults.do?locationId=${location.id }">${location.name }</a><br />
			${location.address.street }
			<c:if test="${not empty location.address.street2 }">
				${location.address.street2 }
			</c:if><br />
			${location.address.city }
			${location.address.state }
			${location.address.zipCode }<br />
			<c:if test="${not empty location.openTime and not empty location.closeTime }">
			${location.openTime } - ${location.closeTime }
			</c:if>
			<br>
			<form action="adminUpdateLocation.do">
				<input type="hidden" name="id" value="${location.id }" >
				<input type="submit" value="update Location">
			</form>
		</c:forEach>
	</c:if> 
	
	<c:if test="${not empty flaggedRestrooms }">
	<h5>List all Flagged Restrooms</h5>
	<c:forEach items="${flaggedRestrooms }"    var="allFlaggedRestrooms">

	
	<a href="detailedResultsFlagged.do?restroomId=${allFlaggedRestrooms.id }">${allFlaggedRestrooms.location.name} Restroom ID: ${allFlaggedRestrooms.id }</a><br> 
	
	</c:forEach>
	</c:if>
	
	<c:if test="${noFlaggedRestrooms }">
	There are no flagged restrooms
	</c:if>
	
	<c:if test="${not empty locationUpdate }">
		
		${locationUpdate.name }<br />
		${locationUpdate.address.street }
		<c:if test="${not empty locationUpdate.address.street2 }">
			${locationUpdate.address.street2 }
		</c:if><br />
		${locationUpdate.address.city }
		${locationUpdate.address.state }
		${locationUpdate.address.zipCode }<br />
		<c:if test="${not empty locationUpdate.openTime and not empty locationUpdate.closeTime }">
			${location.openTime } - ${location.closeTime }
		</c:if>
		${locationUpdate.accessLimits }<br />
		${locationUpdate.purchaseRequired }<br />
		${locationUpdate.phone }<br />
		<br>
		
	</c:if>
	
	<c:if test="${not empty allUsersToDisableDelete }">
		<c:forEach items="${allUsersToDisableDelete }" var="user">
			First Name: <h3>${user.firstName }</h3>
			Last Name: <h3>${user.lastName }</h3>
			Username: <h3>${user.userName }</h3>
			Email: <h3>${user.email }</h3>
			
			<form action="deleteUserAdmin.do" method="post">
			
				<input type="hidden" name="userId" value="${user.id }">
				<input type="submit" value="Delete User">
			</form>
			<form action="disableUserAdmin.do" method="post">
			
				<input type="hidden" name="userId" value="${user.id }">
				<input type="submit" value="Disable User">
			</form>
		
		</c:forEach>
	</c:if> 
	
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
		integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
		crossorigin="anonymous"></script>
	

</body>
</html>