<%-- 
    Document   : index
    Created on : May 6, 2020, 1:12:01 PM
    Author     : dimiksonkha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Main CSS -->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">


    <title>BCS Preparation</title>
  </head>
  <body>
      
      <h2>40th BCS preliminary Exam</h2>
      <ol>
      <c:forEach var="question" items="${questions}">
          <li><b>${question.content}</b>?</li>

              <c:forEach var="ans" items="${question.answer}">
                <c:set var="isRight" scope="session" value="${ans.isRightAnswer}"/>
 
                <c:choose>
                    <c:when test="${isRight == true}">
                      <p>
                         <input type="radio" id="male" name="gender" value="${ans.content}">
                         <label for="male">${ans.content}</label><br>
                      </p>
                    </c:when>
     
                    <c:otherwise>
                        <p style="color: red">
                         <input type="radio" id="male" name="gender" value="${ans.content}">
                         <label for="male">${ans.content}</label><br>
                      </p>
                    </c:otherwise>
                  </c:choose>
                
                <p><b>Explanation:</b>${ans.explanation}</p>
      
                
              </c:forEach>
             
      </c:forEach>
      </ol>    
 
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
  </body>
</html>

