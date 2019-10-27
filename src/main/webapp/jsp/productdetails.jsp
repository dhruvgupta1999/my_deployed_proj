<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product Details</title>
<link href="<c:url value="/resources/styles/productform.css" />" rel="stylesheet">
</head>


<!--    <body>
<c:if test="${empty error_message}">
<h1>Product details</h1>

<p>type : ${type }</p>
<p>size : ${size }</p>
<p>company : ${company }</p>
<p>price : ${price }</p>
<p>qty : ${qty }</p>
<p>tprice : ${tprice }</p>
<a href="<c:url value="/user/addtocart?pid=${pid}&qty=${qty}"/>">add to cart</a>
<a href="<c:url value="/user/productform"/>">cancel</a>
</c:if>
<p>${error_message }</p>


</body> -->


<body>
<header>
</header>
        <div class="form_p_container">
        <div class="form_p" align="center">
                <div class="login">
            <div class="form">
                <h2>Product Details</h2>
                <div class="group">
                   
                </div>
                <div class="group">
                    <h3>type : ${type }</h3>
                </div>
                <div class="group">
                    <h3>size : ${size }</h3>
                </div>
                <div class="group">
                        <h3>company : ${company }</h3>
                </div>
                <div class="group">
                        <h3>price : ${price }</h3>
                </div>
                <div class="group">
                        <h3>quantity : ${qty }</h3>
                </div>
                <div class="group">
                        <h3>total price : ${tprice }</h3>
                </div>
                <div class="group">
                    <a href="<c:url value="/user/addtocart?pid=${pid}&qty=${qty}"/>">add to cart</a>
                    <a href="<c:url value="/user/productform"/>">cancel</a>
                </div>
        </div>
        
        </div> 
        </div>
        </div>
        <br>
        <br>
                
        </body>
    </html>

