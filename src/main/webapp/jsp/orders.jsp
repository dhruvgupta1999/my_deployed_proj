<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Subhash Paints - Orders</title>
<link href="<c:url value="/resources/styles/cart.css" />" rel="stylesheet">
</head>
<!--
<body>
 

<table style="width:100%">
  <tr>
    <th>Date</th>
    <th>Product Name</th>
    <th>Company</th> 
    <th>Size</th>
    <th>Unit Price</th>
    <th>Quantity</th>
    <th>Total price</th>
    <th>Status</th>
  </tr>
  <tr>
    
  </tr>
  <tr>
  <c:if test="${not empty orderlist }">
    <c:forEach items = "${orderlist}" var = "item">
    <tr>
         <td>${item.getDate()}</td>
         <td>${item.getType()}</td>
         <td>${item.getCompany()}</td>
         <td>${item.getSize()}</td>
         <td>${item.getPrice()}</td>
         <td>${item.getQty()}</td>
         <td>${item.getTprice()}</td>
         <td>${item.getStatus()}</td>
          
         </tr>
      </c:forEach>
      <br>
      <br>
 </c:if>

 <c:if test="${empty orderlist }">
    No orders!
 </c:if>
  </tr>
</table>

<a href="<c:url value="/"/>">Home</a>
    
</body> -->





<body>
<h1>My Orders</h1>
        <c:if test="${not empty orderlist }">
        <table>
          <thead>
            <tr class="table-headers">
              <th>Date</th>
              <th>Product Category</th>
              <th>Company</th>
              <th>Size</th>
              <th>Unit Price</th>
              <th>Quantity</th>
              <th>Total</th>
              <th>Status</th>
            </tr>
        </thead>
        <tbody>
            
        <c:forEach items = "${orderlist}" var = "item">
        <tr>
                <td>${item.getDate()}</td>
         <td>${item.getType()}</td>
         <td>${item.getCompany()}</td>
         <td>${item.getSize()}</td>
         <td>${item.getPrice()}</td>
         <td>${item.getQty()}</td>
         <td>${item.getTprice()}</td>
         <td>${item.getStatus()}</td>  
        </tr>
        </c:forEach>
        </tbody>
        </table>
        </c:if>
    <c:if test="${empty orderlist }">
            No Orders Yet!
    </c:if>
    <a href="<c:url value="/"/>"> <h3>Home</h3></a>
      </body>
    </html>
    
