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
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script type="text/javascript">
	
	$(document).ready(function() {
 
		$('#submitForm').submit(function(e) {
			var frm = $('#submitForm');
			e.preventDefault();
                       
 
		    var data = {}
		    var Form = this;
 
		    //Gather Data also remove undefined keys(buttons)
		    $.each(this, function(i, v){
		            var input = $(v);
		        data[input.attr("name")] = input.val();
		        delete data["undefined"];
		    });
        $.ajax({
            contentType : 'application/json; charset=utf-8',
            type: frm.attr('method'),
            url: frm.attr('action'),
            dataType : 'json',
            data : JSON.stringify(data),
            success : function(question){
            	 $('p').text("Ajax Worked!!");
                 alert(question.id);
                
            },
            error : function(){
                $(this).html("Error!");
            }
        });
		});
	});
</script>
  </head>
  <body>
      
      
  <h2>Add new Question </h2>
  <form name="questionForm" action="saveQuestion" method="POST" id="submitForm">
      <label>Content</label>
      
      <input type ="text" name="content" value="Question"/>
      <input type ="text" name="explanation" value="Explanation"/>
      <input type="submit" value="Save"/>
                      
  </form>
  <p></p>
          
  </body>
</html>

