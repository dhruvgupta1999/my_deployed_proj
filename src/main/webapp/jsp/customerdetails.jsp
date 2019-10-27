<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<!DOCTYPE html>
<html>
<head>
<link href="<c:url value="/resources/styles/cart.css" />" rel="stylesheet">
<meta charset="UTF-8">
<title>FAQ Page</title>

</head>
<body>


  <c:if test="${not empty customers }">
  <table>
  <caption>Customer list</caption>
    <tr>
    <th>Username</th>
    <th>Name</th>
    <th>Phone</th>
    <th>Email</th>
    <th>Address</th>
    </tr>
    <c:forEach items = "${customers}" var = "item">
    <tr>
         <td>${item.getUsername()}</td>
         <td>${item.getName()}</td>
         <td>${item.getPhone()}</td>
         <td>${item.getEmail()}</td>
         <td>${item.getAddress()}</td>
    </tr>
    </c:forEach>
      </table>
      <br>
      <br>
 </c:if>
 <c:if test="${empty  customers}">
    No customers yet!
 </c:if>
 <a href="<c:url value="/"/>">Home</a>
 </body>
 </html>
