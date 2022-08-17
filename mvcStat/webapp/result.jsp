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

<c:out value="${operation}("/>

<c:forEach var = "number" items = "${stats}" varStatus="loop">
	${number}
	<c:if test="${!loop.last}">, </c:if>
</c:forEach>

<c:out value=") is ${result}"/>
	<br />
	<a href="/mvcStat/">Main</a>
</body>
</html>