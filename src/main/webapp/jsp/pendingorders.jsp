<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Subhash Paints-Pending Orders</</title>
<link href="<c:url value="/resources/styles/cart.css" />" rel="stylesheet">
</head>
<body>
 <c:set var="t_amt" scope="request" value="${0}"/> 
 <c:if test="${not empty pending_orders }">
<table style="width:100%">
  <tr>
    <th>Name</th>
    <th>Order_Date</th>
    <th>Product Name</th>
    <th>Company</th> 
    <th>Size</th>
    <th>Unit Price</th>
    <th>Quantity</th>
    <th>Total price</th>
    <th>Deliver at</th>
  </tr>
  <tr>
    
  </tr>
  <tr>
  
    <c:forEach items = "${pending_orders}" var = "item">
    <tr>
         <td>${item.getName()}</td>
         <td>${item.getDate()}</td>
         <td>${item.getType()}</td>
         <td>${item.getCompany()}</td>
         <td>${item.getSize()}</td>
         <td>${item.getPrice()}</td>
         <td>${item.getQty()}</td>
         <td>${item.getTprice()}</td>
         <td>${item.getAddress()}</td>
         <td><a href="<c:url value="/emp/setorderstatus/${item.getO_id()}"/>">Dispatch</a></td>
         <c:set var="t_amt" scope="request" value="${t_amt + item.getTprice()}"/>  
         </tr>
      </c:forEach>
      <br>
      <br>
      
 
 
  </tr>
</table>
</c:if>
<c:if test="${empty pending_orders }">
     <h2>No pending Orders!</h2>
 </c:if>
    <a href="<c:url value="/"/>">Home</a>
</body>
</html>