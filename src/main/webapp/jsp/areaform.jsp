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
<title>Ask your Question</title>
</head>

<body>
<c:if test="${empty paint }">
		<h1 id="banner">Ask your Question</h1>  
		<form:form class="form" modelAttribute="myareaholder" action="/log/user/materialprint/"
					method="POST">
			
			<c:if test="${not empty error_msg}"><br><br><br>${error_msg}</c:if>
				<h2>Expert Advice</h2>	
			
				 <div class="group">
                        <label for="user_id">Please Enter Wall Area to get estimated Material required(in sqft):</label>
                        <form:input type='text' path="mystring" name='mystring'  />
                   </div>
				   <div class="btn-group">
					<td colspan='2'><input type="submit" value="Submit" />&nbsp;<input name="reset" type="reset" /></td>
				   </div>
		</form:form>
</c:if>
<c:if test="${not empty paint }">
<h2>For Area : ${area} sqft Estimated
Plaster Required : ${plaster} kg
Putty Required : ${putty} kg
Paint Required : ${paint} kg
</h2>
</c:if>
<a href="<c:url value="/"/>">Home</a>
</body>

</html>