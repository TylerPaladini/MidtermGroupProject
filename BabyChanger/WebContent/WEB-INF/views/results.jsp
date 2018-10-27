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
		<c:forEach items="${open }" var="open">
			${open.id }<br />
			${open.name }<br />
			${open.address.street }<br />
			${open.address.city }<br />
			${open.address.state }<br />
			${open.address.zipCode }<br />
			${open.accessLimits }<br />
			${open.purchaseRequired }<br />
			${open.phone }<br />
			${open.openTime }<br />
			${open.closeTime }<br />
		</c:forEach>
	</c:if> 
	
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
		integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
		crossorigin="anonymous"></script>
	

</body>
</html>