<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<!DOCTYPE html>
<html>
<head>
<link href="<c:url value="/resources/styles/empdetails.css" />" rel="stylesheet">
<meta charset="UTF-8">
<title>FAQ Page</title>

</head>
<body>


  <c:if test="${not empty custdetails }">
  <table>
  <caption>Your Details</caption>
    <tr>
    <th>Username</th>
    <th>Name</th>
    <th>Phone</th>
    <th>Email</th>
    <th>Address</th>
    </tr>

    <tr>
         <td>${custdetails.getUsername()}</td>
         <td>${custdetails.getName()}</td>
         <td>${custdetails.getPhone()}</td>
         <td>${custdetails.getEmail()}</td>
         <td>${custdetails.getAddress()}</td>
         
    </tr>

      </table>
      <br>
      <br>
 </c:if>
 <c:if test="${empty  custdetails}">
    No custdetails yet!
 </c:if>
 <a href="<c:url value="/"/>">Home</a>
 <a href="<c:url value="/user/updateprofile"/>">Update details</a>
 </body>
 </html>
