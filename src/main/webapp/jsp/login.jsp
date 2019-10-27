<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<html>
<head>
<link href="<c:url value="/resources/styles/login.css" />" rel="stylesheet">

</head>

	<body>
		 <header>
<div class="mylinks">
		<a href="<c:url value="/register"/>">Sign Up</a>
		<a href="<c:url value="/"/>">Home</a>
</div>
</header>
<div class="form_p_container">
<div class="form_p" align="center">
		<div class="login">
    <form action="<c:url value='j_spring_security_check'/>" class="form" method="POST">
        <h2>Login</h2>
        <div class="group">
            <label for="user_id">Username:</label>
            <input type='text' name='j_username' />
        </div>
        <div class="group">
            <label for="user_password">Password:</label>
            <input type='password' name='j_password'>
        </div>
        <div class="btn-group">
            <td colspan='2'><input name="submit" type="submit">&nbsp;<input name="reset" type="reset"></td>
        </div>
    </form>

</div> 
</div>
</div>
		<br>
		<br>
		
	</body>
</html>
