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
<title>Update Page</title>
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
 <form:form class="form" modelAttribute="user" action="/log/user/updateprofileprocess"
                    method="POST">
                    
                    <c:if test="${not empty msg}">${msg}<br></c:if>
                    <c:if test="${not empty new_msg}">${new_msg}</c:if>
                    <c:if test="${not empty user_error}">${user_error}</c:if>
                    <h2>Update your Account</h2>
                    <div class="group">
                        <label for="user_password">Password:</label>
                        <form:input type='password' path="Password" name='Password' />
                    </div>
                    <div class="group">
                        <label for="user_password">Name:</label>
                        <form:input type='text' path="Name" name='Name' />
                    </div>
                    <div class="group">
                        <label for="user_password">Address:</label>
                        <form:input type='text' path="Address" name='Address'/>
                    </div>
                    <div class="group">
                            <label for="user_password">Email:</label>
                            <form:input type='text' path="Email" name='Email' />
                    </div>
                    <div class="group">
                            <label for="user_password">Phone:</label>
                            <form:input type='text' path="Phone" name='Phone' />
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