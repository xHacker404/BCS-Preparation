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
      
      <h2>Question List</h2>
      <input type='button' value="Add Question"  onclick="window.location.href='showFormForAdd'; return false;"/>
      <ol>
      <c:forEach var="question" items="${questions}">
          <!-- construct an "update" link with customer id -->
        <c:url var="updateLink" value="/question/showFormForUpdate">
                <c:param name="questionId" value="${question.id}" />
        </c:url>
          
         <c:url var="deleteLink" value="/question/delete">
                <c:param name="questionId" value="${question.id}" />
        </c:url>
          
          <li><b>${question.content}</b>
          <!-- display the update link -->
          <a href="${updateLink}">Update</a></li>| <a href="${deleteLink}" onclick="if (!(confirm('Are you sure you want to delete this customer?'))) return false">Delete</a></li>
             
      </c:forEach>
      </ol>    
 
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
  </body>
</html>

