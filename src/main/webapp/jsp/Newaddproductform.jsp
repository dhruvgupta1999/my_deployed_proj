<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
    <link href="<c:url value="/resources/styles/productform.css" />" rel="stylesheet">
<meta charset="UTF-8">
<title>Select Product</title>
</head>
<!--  <body>
<p><c:if test="${not empty msg}">${msg}</c:if></p>
<h1 id="banner">what do you need?</h1>  
<form:form modelAttribute="product" action="user/getproduct"
					method="POST">
			<table>
				<tr>
					<td>Type:</td>
					<td> <form:input type='text' path="Type" name='Type' /></td>
				</tr>
				<tr>
					<td>Size:</td>
					<td><form:input type='text' path="Size" name='Size' /></td>
				</tr>
				
				<tr>
					<td>Company:</td>
					<td><form:input type='text' path="Company" name='Company' /></td>
				</tr>
				
				<tr>
					<td>Quantity:</td>
					<td><form:input type='text' path="Quantity" name='Quantity' /></td>
				</tr>
				
				<tr>
					<td colspan="2">&nbsp;</td>
				</tr>
				<tr>
					<td colspan='2'><input type="submit" value="Submit" />&nbsp;<input name="reset" type="reset" /></td>
				</tr>
			</table>
		</form:form>
		

<a href="<c:url value="/"/>">home</a>
<a href="/log/user/cart">Mycart</a>
</body>
-->


<body>
<header>
<div class="mylinks">
    <a href="<c:url value="/"/>">home</a>
    <a href="/log/user/cart">Mycart</a>
</div>
</header>
<div class="form_p_container">
<div class="form_p" align="center">
		<div class="login">
 <form:form class="form" modelAttribute="product" action="user/getproduct" method="POST">
        <c:if test="${not empty error_message}"><p> ${error_message}</p></c:if>
        <c:if test="${not empty error_message2}"><p> ${error_message2}</p></c:if>
        <h2>Product</h2>
        <div class="group">
            <label for="user_id">Type:</label>
            <!-- <form:input type='text' path="Type" name='Type' /> -->
            <form:select name="Type" path="Type">
            <option value="Paint">Paint</option>
            <option value="Plaster">Plaster</option>
            <option value="Putty">Putty</option>
            <option value="Waterproofing">Waterproofing</option>
            </form:select>
        </div>
        <div class="group">
            <label for="user_password">Size:</label>
            <%-- <form:input type='text' path="Size" name='Size' /> --%>
            <form:select name="Size" path="Size">
            <option value="1kg">1kg</option>
            <option value="2kg">2kg</option>
            <option value="5kg">5kg</option>
            <option value="10kg">10kg</option>
            <option value="15kg">15kg</option>
            <option value="25kg">25kg</option>
            </form:select>
        </div>
        <div class="group">
            <label for="user_password">Company:</label>
            <form:select name="Company" path="Company">
            <c:forEach items="${Companylist}" var="item">
            <option value="${item}">${item}</option>
            </c:forEach> 
            </form:select>
           <!-- <form:input type='text' path="Company" name='Company<%--  --%>' />   -->
        </div>
        <div class="group">
            <label for="user_password">Quantity:</label>
            <%--  <form:input type='text' path="Quantity" name='Quantity' />--%>
            <form:select name="Quantity" path="Quantity">
            <option value="1">1</option>
            <option value="2">2</option>
            <option value="3">3</option>
            <option value="4">4</option>
            <option value="5">5</option>
            <option value="6">6</option>
            <option value="7">7</option>
            <option value="8">8</option>
            <option value="9">9</option>
            <option value="10">10</option>
            </form:select>
        </div>
        <div class="btn-group">
            <td colspan='2'><input name="submit" type="submit">&nbsp;<input name="reset" type="reset"></td>
        </div>
</form:form>

</div> 
</div>
</div>
<br>
<br>
		
</body>
</html>
