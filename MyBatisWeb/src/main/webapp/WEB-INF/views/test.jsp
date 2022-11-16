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
		let bno = 155
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
			
			//$("#delBtn").click(function(){ //send 버튼을 클릭하고 나서 삭제가 보이므로 활성화가 안됨
			$("#commentList").on("click",".delBtn",function(){
				//commentList안에 있는 delBtn버튼에다가 클릭이벤트 걸어줌
				//alert("삭제버튼 클릭됨")
				let cno = $(this).parent().attr("data-cno")	//<li>태그는 <button>의 부모임
				let bno = $(this).parent().attr("data-bno")	//attr 중 사용자 정의 attr을 선택함
				
				$.ajax({
					type : 'DELETE',
					url : '/heart/comments/'+cno+'?bno='+bno, 
					success : function(result){
						alert(result)
						showList(bno)
					},
					error : function(){alert("error")}
				})				
			
			})
		
			
		})
		
		let toHtml = function(comments){
			let tmp = "<ul>"
			
			comments.forEach(function(comment){
			tmp += '<li data-cno=' + comment.cno
			tmp += ' data-bno=' + comment.bno
			tmp += ' data-pcno=' + comment.pcno +'>'
			tmp += ' commenter=<span class="commenter">'+comment.commenter +'</span>'
			tmp += ' comment=<span class="comment">'+comment.comment +'</span>'
			tmp += ' <button class="delBtn">삭제</button>'
			tmp += '</li>'
			})
		return tmp += "</ul>"
		}
	</script>
</body>
</html>