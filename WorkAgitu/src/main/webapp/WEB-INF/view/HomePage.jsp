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
text-align: left;
margin-left:30px;
}
body{
color:white;
background-color:black;
}
label{
font: 2em;
font-weight: bold;
}
.submitbutton{
color:white;
background-color: blue;

}
form{
width:25%;
text-align:center;
margin-left:35%;
border:4px solid white;
flex:wrap

}
</style>
</head>
<body>
 <h1 align="center">User Information</h1>
 <form:form action="/WorkAgitu/love.com/process-homepage" method="get" modelAttribute="userInfo">
 <div align="center">
 <p>
 <label for ="name1">Name :</label>
 <form:input id="name1" path="name"/>
 <form:errors path="name" cssClass="error"/>
 <br>
  <br>
 <label for ="name">Your Name :</label>
 <form:input id="name" path="userName"/>
 <form:errors path="userName" cssClass="error"/>
 
 <br>
 <br>
  <label for ="partner">Father Name :</label>
  <form:input  id="partner" path="crushName"/>
  <form:errors path="crushName" cssClass="error"/><br>
 <br>
  <br>
 <label>Select lucky number :</label>

 1<form:checkbox label="1" value="1" path="numbers"></form:checkbox>
 2<form:checkbox label="2" value="2" path="numbers"></form:checkbox>
 3<form:checkbox label="3" value="3" path="numbers"></form:checkbox>
 <br>
   <br>
  <label>Age :</label>
  <form:input  path="age"/>
  <form:errors path="age" cssClass="error"/>
  <br>
   <br>
  <label>Date :</label>
  <form:input  path="date"/>
  <br>
   <br>
  <label>Credit Card :</label>
  <form:input  path="creditCard"/>
  <br>
   <br>
  <label>Amount :</label>
  <form:input  path="amount"/>
  <br>
  <br>
  <label>Email :</label>
  <form:input  path="communicationDTO.email"/>
  <br>
   <br>
  <form:errors path="communicationDTO.email" cssClass="error"/>
  <br>
  <label>Phone :</label>
  <form:input path="communicationDTO.phone"/><br>
  <form:checkbox  path="agreement" id="check"></form:checkbox>
  <label>I Agreed to the policy</label>
  <form:errors path="agreement" cssClass="error"/>
  <br>
  <input  class="submitbutton" type="submit" value="calculate">
 </p>
 </div>
 </form:form>
</body>
</html>