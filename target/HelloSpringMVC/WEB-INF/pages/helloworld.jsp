<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<title>Spring MVC -HelloWorld</title>
</head>


<body>
	<textarea class="comment-input"></textarea>
	<button class="comment-button">bình luận</button>
<script type="text/javascript">
	const commentInput = document.querySelector(".comment-input");
	const commentButton = document.querySelector(".comment-button")
	commentButton.onclick = function(){
		const id = commentInput.value
		const data = JSON.stringify(value);
			$.ajax({
				method: "POST",
				contentType: "application/json; charset=utf-8",
				url: `${location.origin}/ComicMVC/comment`,
				data: data,
				success: function(result) {
					console.log(result)
					
				},
				error: function(e) {
					console.log("Error: ", e);
				}
			})
		}
	
</script>
</body>


</html>