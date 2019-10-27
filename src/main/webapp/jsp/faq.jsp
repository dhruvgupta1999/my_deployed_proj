<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<!DOCTYPE html>
<html>
<head>
<link href="<c:url value="/resources/styles/faq.css" />" rel="stylesheet">
<meta charset="UTF-8">
<title>FAQ Page</title>
<!--  <script >

function setVisibility(id, visibility) {
	document.getElementById(id).style.display = visibility;
	}
    
  </script>


 <style type="text/css">
#myDIV {
  padding:3px;
  width:2000px;
  z-index:10;
  position:relative;  
  display:none;
}

#myDiv form input{
background-color:#FFF;
    height: 1.5em;
}


</style> 
-->
</head>
<body>
<c:if test="${(user_role == 'ROLE_EMP') || (user_role == 'ROLE_ADMIN')}">

 <!--    <c:if test="${not empty pending_questions }">
  <table>
  <caption>Pending Questions</caption>
    <c:forEach items = "${pending_questions}" var = "item">
    <tr>
         <td>${item.getQuestion()}</td>
         <td><input type=button name=type value='answer' onclick="setVisibility('myDIV', 'inline');"/></td>
         <td><a href="<c:url value="/emp/del_q/${item.getQ_id()}"/>">delete</a></td> 
    </tr>
    <tr>
    <td>
    <div id="myDIV">
     
    <form action="<c:url value='/emp/ans_q/${item.getQ_id()}'/>" id="form">
      <p><input type="text" placeholder="" id="Answer" name="Answer" /></p>
      <p><input type="submit" value="Submit"  /></p>
    </form>
   </div>
   </td>
   </tr>
</c:forEach>
      </table>
      <br>
      <br>
 </c:if>
 <c:if test="${empty  pending_questions}">
    No pending Questions!
 </c:if> -->
 
 
  <div class="content">
        <h1>FAQs</h1>       
           <c:if test="${not empty pending_questions }">
           <c:forEach items = "${pending_questions}" var = "item">
           <div>
                <input type="checkbox" id="question9" name="q" class="questions">
                <div class="plus">+</div>
                <label for="question9" class="question">
                        ${item.getQuestion()}
                        <a href="<c:url value="/emp/del_q/${item.getQ_id()}"/>">delete</a>
                </label>
                
                     <form class="answers" action="<c:url value='/emp/ans_q/${item.getQ_id()}'/>" id="form">
                        <p><input type="text" placeholder="" id="Answer" name="Answer" size="300"/></p>
                        <p><input type="submit" value="Submit"  /></p>
                </form>
                
           </div>
           </c:forEach>
        </c:if>
        <c:if test="${empty  pending_questions}">
           No pending Questions!
        </c:if>
    </div> 
</c:if>

<c:if test="${(user_role == 'ROLE_USER')}">

<!--    <c:if test="${not empty answered_questions }">
  <table>
  <caption>Pending Questions</caption>
    <c:forEach items = "${answered_questions}" var = "item">
    <tr>
         <td>${item.getQuestion()}</td>
         <td>${item.getAnswer()}</td> 
    </tr>
    </c:forEach>
      </table>
      <br>
      <br>
 </c:if>
 <c:if test="${empty  answered_questions}">
    No Questions have been asked yet!
 </c:if>
 <td>Have a Question?  <a href="<c:url value="/user/ask_q"/>">Ask here!</a></td> -->
 
 
 <c:if test="${not empty answered_questions }">
            
            <c:set var="x" scope="request" value="${0}"/>
        <c:forEach items = "${answered_questions}" var = "item">
        <div>
                <c:set var="x" scope="request" value="${x+1}"/>
                <input type="checkbox" id="question${x}" name="q" class="questions">
                <div class="plus">+</div>
                <label for="question${x}" class="question">
                        ${item.getQuestion()}
                </label>
                <div class="answers">
                    <p>${item.getAnswer()}</p>
                    
                </div>
        </div>
        </c:forEach>
            
 </c:if>
    <c:if test="${empty  answered_questions}">
              No Questions have been asked yet!
    </c:if>
     Have a Question?  <a href="<c:url value="/user/ask_q"/>">Ask here!</a>
</c:if>


<a href="<c:url value="/"/>">Home</a>
</body>
</html>