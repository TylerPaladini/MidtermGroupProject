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
	

</body>
</html>