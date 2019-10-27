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
<title>Insert title here</title>
</head>
<body>
<header>
<div class="mylinks">
    <a href="<c:url value="/"/>">home</a>
</div>
</header>

<div class="form_p_container">
<div class="form_p" align="center">
		<div class="login">
<form:form class="form" modelAttribute="product" action="/log/emp/addproductprocess"
					method="POST">
			<c:if test="${not empty error_message}"><p> ${error_message}</p></c:if>
        <c:if test="${not empty error_message2}"><p> ${error_message2}</p></c:if>
        <p><c:if test="${update_iter > 0}">product has been added successfully!</c:if></p>
        <h2>Enter details of product to add</h2>
        <div class="group">
            <label for="user_password">Product Id:</label>
            <form:input type='text' path="P_id" name='P_id' />
        </div>
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
        <div>
           <label for="user_password">Price:</label>
           <form:input type='text' path="Price" name='Price' />
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

<a href="<c:url value="/"/>">home</a>
</body>
</html>