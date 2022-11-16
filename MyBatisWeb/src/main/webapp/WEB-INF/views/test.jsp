<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://code.jquery.com/jquery-1.11.3.js"></script>
	<title>comment list</title>
</head>
<body>
	<h2>Comment Test</h2>
	<button id="sendBtn" type="button">SEND</button>
	<div id ="commentList"></div>
	
	<script>
		let bno = 155;
		let showList = function(bno){
			$.ajax({
				type: 'get',
				url: '/heart/comments?bno='+bno,
				success : function(result){
					$("#commentList").html(toHtml(result))
				},
				error : function(){alert("error")}
			})
		}
		$(document).ready(function(){
			$("#sendBtn").click(function(){
				showList(bno)
			})
		})
		
		let toHtml = function(comments){
			let tmp += '<ul>'
			
			comments.forEach(function(comment){
				tmp += "<ul>"
				tmp += '<li data-cno=>' + comment.cno
				tmp += 'data-bno=' + comment.bno
				tmp += 'data-pcno=' + comment.pcno +'>'
				tmp += 'commenter=<span class="commenter">'+comment.commenter +'</span>'
				tmp += 'comment=<span class="comment">'+comment.comment +'</span>'
				tmp += '</li>'
			})
				return tmp += "</ul>"
		}
	</script>
</body>
</html>