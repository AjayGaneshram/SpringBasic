<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1 align="center">Love Calculator</h1>
<p>
User Name is :${userInfo.userName}</p>

<p>
User Name is :${userInfo.crushName}

</p>
<h2>Lucky numbers</h2>
<p>

<c:forEach var="temp" items="${userInfo.numbers}">
${temp}
</c:forEach>
</p>
<h1>${userInfo.communicationDTO.email}</h1>
<h1>${userInfo.communicationDTO.phone}</h1>
</body>
</html>