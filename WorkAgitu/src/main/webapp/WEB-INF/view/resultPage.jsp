<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
</head>
<body>
<h1 align="center">Love Calculator</h1>
<h1>User Name is :</h1>${userInfo.userName}

<h1>Crush Name is :</h1>${userInfo.crushName}

<h2>Lucky numbers</h2>
<p>

<c:forEach var="temp" items="${userInfo.numbers}">
${temp}
</c:forEach>
</p>
<h1>Email:</h1><h1>${userInfo.communicationDTO.email}</h1>
<h1>Phone:</h1><h1>${userInfo.communicationDTO.phone}</h1>
<br>
<h1>Date</h1> <h1>${userInfo.date}</h1>
<br>
<h1>Credit Card :</h1> <h1>${userInfo.creditCard} </h1>
</body>
</html>