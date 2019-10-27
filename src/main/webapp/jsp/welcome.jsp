<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Subhash Store</title>
        <link href="<c:url value="/resources/styles/welcome.css" />" rel="stylesheet">
    </head>
  
    <body>
        <header>
          <nav>
            <ul>
              <li><a href="login">Login</a></li>
              <li><a href="register">Register</a></li>
            </ul>
          </nav>
          <br>
          <br>
          <br>
          <div class="Title"><h1>SUBHASH PAINT STORE</h1></div>
        </header>
        <section class="features">
          <!--   You'll notice the img urls are LONG, I had to upload them to google drive   -->
          <figure>
            <img src="<c:url value="/resources/styles/product_img_new.jpeg" />" alt="amazing fresh baked bread" />
            <figcaption>Buy Products</figcaption>
          </figure>
          <figure>
            <img src="<c:url value="/resources/styles/faq_img.png" />" alt="amazing fresh baked coffee" />
            <figcaption>Ask Your Query</figcaption>
          </figure>
          <figure>
            <img src="<c:url value="/resources/styles/expert_advice.jpeg" />" alt="home goods" />
            <figcaption>Expert Advice</figcaption>
          </figure>
        </section>
      
        <footer>
          221 Main Street Pasighat, Kolkata â¢ 555-555-5555 â¢Â us@me.com
        </footer>
      </body>
     </html> 