<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dashboard</title>
<link href="<c:url value="/resources/styles/dashboard.css" />" rel="stylesheet">
</head>
<body>


<c:if test="${(user_role == 'ROLE_ADMIN')}">
 <header>
    
    <nav>
      <ul>
        <li>
          <a href="admin/custdetails">Customer details</a>
        </li>
        <li>
          <a href="admin/empdetails">Employee details</a>
        </li>
        <li>
          <a href="admin/registeremp">Register new Employee</a>
        </li>
        <li>
          <a href="admin/showsupplierdetails">Suppliers</a>
        </li>
        <li>
          <a href="logout">Logout</a>
        </li>
      </ul>
    </nav>
    <h1>Welcome ${user_name} !</h1>
  </header>
 <section class="features">
    <!--   You'll notice the img urls are LONG, I had to upload them to google drive   -->
    <figure>
      <img src="<c:url value="/resources/styles/faq_img.png" />" alt="amazing fresh baked bread" />
      <figcaption><a href="emp/faq">FAQ</a></figcaption>
    </figure>
    <figure>
      <img src="<c:url value="/resources/styles/product_img_new.jpeg" />" alt="amazing fresh baked coffee" />
      <figcaption><a href="emp/addproduct">Add a new Product!</a></figcaption>
    </figure>
    <figure>
      <img src="<c:url value="/resources/styles/expert_advice.jpeg" />" alt="home goods" />
      <figcaption><a href="emp/pendingorders">Pending Orders</a></figcaption>
    </figure>
 </section>
</c:if>
<c:if test="${(user_role == 'ROLE_USER' )}" >
 <header>

    <nav>
      <ul>
        <li>
          <a href="<c:url value="/"/>"><h2>Home</h2></a>
        </li>
        
        <li>
          <a href="user/cart"><h2>My Cart</h2></a>
        </li>
        <li>
          <a href="user/details"><h2>My Details</h2></a>
        </li>
        <li>
          <a href="user/orders"><h2>Orders</h2></a>
        </li>
        <li>
          <a href="logout"><h2>Logout</h2></a>
        </li>
      </ul>
    </nav>
     <h1>Hey ${user_name} Welcome to Subhash Paints!</h1>
  </header>
  <section class="features">
    <!--   You'll notice the img urls are LONG, I had to upload them to google drive   -->
    <figure>
      <img src="<c:url value="/resources/styles/product_img_new.jpeg" />" alt="amazing fresh baked bread" />
      <figcaption><a href="user/productform">Product</a></figcaption>
    </figure>
    <figure>
      <img src="<c:url value="/resources/styles/faq_img.png" />" alt="amazing fresh baked coffee" />
      <figcaption><a href="user/faq">FAQ</a></figcaption>
    </figure>
    <figure>
      <img src="<c:url value="/resources/styles/expert_advice.jpeg" />" alt="home goods" />
      <figcaption><a href="user/expertadvice">Expert Advice</a></figcaption>
    </figure>
  </section>
</c:if>

<c:if test="${(user_role == 'ROLE_EMP' )}" >
<header>
<nav>
      <ul>
        <li>
          <a href="logout">Logout</a>
        </li>
      </ul>
    </nav>
<h1>Welcome ${user_name} !</h1></header>
 <section class="features">
    <!--   You'll notice the img urls are LONG, I had to upload them to google drive   -->
    <figure>
      <img src="<c:url value="/resources/styles/faq_img.png" />" alt="amazing fresh baked bread" />
      <figcaption><a href="emp/faq">FAQ</a></figcaption>
    </figure>
    <figure>
      <img src="<c:url value="/resources/styles/product_img_new.jpeg" />" alt="amazing fresh baked coffee" />
      <figcaption><a href="emp/addproduct">Add a new Product!</a></figcaption>
    </figure>
    <figure>
      <img src="<c:url value="/resources/styles/pending_img.jpeg" />"  alt="home goods" />
      <figcaption><a href="emp/pendingorders">Pending Orders</a></figcaption>
    </figure>
 </section>

</c:if>


<footer>
    221 Main Street Pasighat, Kolkata  555-555-5555  us@me.com
</footer>



</body>
</html>