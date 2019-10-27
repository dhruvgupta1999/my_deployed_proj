<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Subhash Paints-Supplier Details</title>
<link href="<c:url value="/resources/styles/cart.css" />" rel="stylesheet">
</head>

 <body>
    <c:if test="${not empty supplierdetails }">
    <h1>Supplier Details</h1>
    <table>
      <thead>
        <tr class="table-headers">
          <th>Company Id</th>
          <th>Company</th>
          <th>Location</th>
        </tr>
    </thead>
    <tbody>
        
    <c:forEach items = "${supplierdetails}" var = "item">
    <tr>
            <td>${item.getComp_id()}</td>
            <td>${item.getCompany()}</td>
            <td>${item.getLocation()}</td>  
    </tr>
    </c:forEach>
        
      </tbody>
    </table>
    <a href="<c:url value="/admin/addsupplier"/>">Add a new Supplier</a>
 </c:if>
<c:if test="${empty supplierdetails }">
 <div class="emptycart">
       <h2> No suppliers currently!</h2>
       
 </div>
</c:if>
<a href="<c:url value="/"/>"><h2>Home</h2></a>
  </body>
</html>
