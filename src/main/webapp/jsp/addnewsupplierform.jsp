<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
<link href="<c:url value="/resources/styles/register.css" />" rel="stylesheet">
<meta charset="UTF-8">
<title>Register Page</title>
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
 <form:form class="form" modelAttribute="supplier" action="/log/admin/registersupplierprocess"
                    method="POST">
                    
                    <c:if test="${not empty msg}">${msg}<br></c:if>
                    <c:if test="${not empty new_msg}">${new_msg}</c:if>
                    <c:if test="${not empty user_error}">${user_error}</c:if>
                    <h2>Register your Account</h2>
                    <div class="group">
                        <label for="user_id">Company_id:</label>
                        <form:input type='text' path="Comp_id" name='Comp_id' />
                    </div>
                    <div class="group">
                        <label for="user_password">Company:</label>
                        <form:input type='text' path="Company" name='Company' />
                    </div>
                    <div class="group">
                        <label for="user_password">Location:</label>
                        <form:input type='text' path="Location" name='Location' />
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