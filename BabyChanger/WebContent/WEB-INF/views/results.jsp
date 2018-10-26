<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<c:if test="${not empty allUsers }">
		<c:forEach items="${allUsers }" var="user">
			${user.id }
			${user.firstName }
			<br>
		</c:forEach>
	</c:if>
	
	<c:if test="${not empty allCities }">
		<c:forEach items="${allCities }" var="city">
			${city.id }
			${city.name }
			<br>
		</c:forEach>
	</c:if>
	

</body>
</html>