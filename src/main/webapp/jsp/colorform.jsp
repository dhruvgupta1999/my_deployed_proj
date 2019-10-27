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
<c:if test="${empty ceilcolor }">
		
		<form:form class="form" modelAttribute="mywallcolor" action="/log/user/colorforsubmit/"
					method="POST">
					<c:if test="${not empty error_msg}"><br><br><br>${error_msg}</c:if>
				<h2>Expert Advice</h2>	
			
				 <div class="group">
                        <label for="user_id">Please Enter Your Wall color:</label>
                        <form:input type='text' path="mystring" name='mystring'  />
                   </div>
				   <div class="btn-group">
					<td colspan='2'><input type="submit" value="Submit" />&nbsp;<input name="reset" type="reset" /></td>
				   </div>
			
		</form:form>
</c:if>
<c:if test="${not empty ceilcolor }"><h2>Suitable ceiling color for ${wallcolor} colored walls are ${ceilcolor} colored ceilings.
Get Best quality of ${ceilcolor} paints from Subhash stores.</h2></c:if>
<a href="<c:url value="/"/>">Home</a>
</body>

</html>