<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>
$(function(){
	$("button").click(function(){
		getData();		
	});
});

function getData(){
	//JQuery 가 지원하는 ajax
	$.ajax({
		url:"server.jsp",
		type:"get",
		success:function(data){
			$("#box").val(data);
		}	
	});	
}
</script>
</head>
<body>
<input type="text" id="box"/>
<button>서버에서 가져오기</button>
</body>
</html>



