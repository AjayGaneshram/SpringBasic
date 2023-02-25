<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
.error{
color:red;
position:fixed;
text-align: left
}

</style>
</head>
<body>
 <h1 align="center">Astrology calculator</h1>
 <form:form action="/WorkAgitu/love.com/process-homepage" method="get" modelAttribute="userInfo">
 <div align="center">
 <p >
 <label for ="name">Your Name</label>
 <form:input id="name" path="userName"/>
 <form:errors path="userName" cssClass="error"/>
 
 <br>
 <br>
  <label for ="partner">Your Partner</label>
 <form:input  id="partner" path="crushName"/><br>
 <br>
 <label>Select lucky number :</label>

 1<form:checkbox label="1" value="1" path="numbers"></form:checkbox>
 2<form:checkbox label="2" value="2" path="numbers"></form:checkbox>
 3<form:checkbox label="3" value="3" path="numbers"></form:checkbox>
 <br>
  <form:checkbox  path="agreement" id="check"></form:checkbox>
  <label>I Agreed to the policy</label>
  <form:errors path="agreement" cssClass="error"/>
  <br>
  <label>Email</label>
  <form:input  path="communicationDTO.email"/>
  <label>Phone</label>
  <form:input path=""/>
 <input type="submit" value="calculate">
 </p>
 </div>
 </form:form>
</body>
</html>