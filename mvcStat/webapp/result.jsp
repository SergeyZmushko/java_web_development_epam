<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Result page</title>
</head>
<body>
${operation}(
<c:forEach var = "stat" items = "${stats}" varStatus="status">
	${stat}
	<c:if test="${not status.last}">
		, 
	</c:if>
</c:forEach>
) is ${result}

	<br />
	<a href="<c:url value='/'/>">Main</a>
</body>
</html>