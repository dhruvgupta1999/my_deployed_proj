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
<script >

function setVisibility(id, visibility) {
	document.getElementById(id).style.display = visibility;
	}
    
  </script>


<style type="text/css">

#myDIV {
  padding:3px;
  width:2000px;
  position:relative;  
  display:none;
}


</style>
</head>
<body>


  <c:if test="${not empty employees }">
  <table>
  <caption>Employee list</caption>
    <tr>
    <th>Username</th>
    <th>Name</th>
    <th>Phone</th>
    <th>Salary</th>
    <th>Address</th>
    </tr>
    <c:forEach items = "${employees}" var = "item">
    <tr>
         <td>${item.getUsername()}</td>
         <td>${item.getName()}</td>
         <td>${item.getPhone()}</td>
         <td>${item.getSalary()}</td>
         <td>${item.getAddress()}</td>
         <td><input type=button name=type value='update salary' onclick="setVisibility('myDIV${item.getUsername()}', 'inline');"/></td>
    </tr>
  <style type="text/css">

#myDIV${item.getUsername()} {
  padding:3px;
  width:2000px;
  position:relative;  
  display:none;
}


</style>
  
  <tr>
  <td>
<div id="myDIV${item.getUsername()}">
     
    <form action="<c:url value='/admin/newempsalary/${item.getUsername()}'/>" id="form">
      <p><input type="text" placeholder="" id="newsalary" name="newsalary"/></p>
      <p><input type="submit" value="Submit" /></p>
    </form>
</div>
    </td>
    </tr>
    </c:forEach>
      </table>
      <br>
      <br>
 </c:if>
 <c:if test="${empty  employees}">
    No employees yet!
 </c:if>
 <a href="<c:url value="/"/>">Home</a>
 </body>
 </html>
