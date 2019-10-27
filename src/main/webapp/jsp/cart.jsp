<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Subhash Paints-Cart</title>
<link href="<c:url value="/resources/styles/cart.css" />" rel="stylesheet">
</head>
<!--   <body> 
 <c:set var="t_amt" scope="request" value="${0}"/> 
<table style="width:100%">
  <tr>
    <th>Product Name</th>
    <th>Company</th> 
    <th>Size</th>
    <th>Price</th>
    <th>Qty</th>
    <th>Tprice</th>
  </tr>
  <tr>
    
  </tr>
  <tr>
  <c:if test="${not empty cartlist }">
    <c:forEach items = "${cartlist}" var = "item">
    <tr>
         <td>${item.getType()}</td>
         <td>${item.getCompany()}</td>
         <td>${item.getSize()}</td>
         <td>${item.getPrice()}</td>
         <td>${item.getQty()}</td>
         <td>${item.getTprice()}</td>
         <td><a href="<c:url value="/user/delcart/${item.getC_id()}"/>">delete</a></td>
         <c:set var="t_amt" scope="request" value="${t_amt + item.getTprice()}"/>  
         </tr>
      </c:forEach>
      <br>
      <br>
      Total amount: <c:out value="${t_amt}"/>
 </c:if>
 <c:if test="${empty cartlist }">
    Cart is empty!
</c:if>
 </tr>
</table>

  <c:if test="${not empty cartlist }">
<a href="<c:url value="/user/buy"/>">buy items</a>
 </c:if>
    <a href="<c:url value="/"/>">Home</a>
</body> -->






 <body>
    <c:if test="${not empty cartlist }">
     <c:set var="t_amt" scope="request" value="${0}"/> 
    <h1>My Cart</h1>
    <table>
      <thead>
        <tr class="table-headers">
          <th>Product Name</th>
          <th>Company</th>
          <th>Size</th>
          <th>Unit Price</th>
          <th>Quantity</th>
          <th>Total</th>
        </tr>
    </thead>
    <tbody>
        
    <c:forEach items = "${cartlist}" var = "item">
    <tr>
            <td>${item.getType()}</td>
            <td>${item.getCompany()}</td>
            <td>${item.getSize()}</td>
            <td>${item.getPrice()}</td>
            <td>${item.getQty()}</td>
            <td>${item.getTprice()}</td>
            <td><a href="<c:url value="/user/delcart/${item.getC_id()}"/>">delete</a></td>
            <c:set var="t_amt" scope="request" value="${t_amt + item.getTprice()}"/>  
    </tr>
    </c:forEach>
        
        
        <tr class="total">
          <td>Net Total</td>
          <td class="total" colspan="5"><c:out value="${t_amt}"/></td>
        </tr>
      </tbody>
    </table>
    <a href="<c:url value="/user/buy"/>">buy items</a>
 </c:if>
<c:if test="${empty cartlist }">
 <div class="emptycart">
       <h2> Cart is empty!</h2>
       
 </div>
</c:if>
<a href="<c:url value="/"/>"><h2>Home</h2></a>
  </body>
</html>
