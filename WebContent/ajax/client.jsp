<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>
function getData(){
	//ajax 비동기방식으로 요청을 시도한다!!
	var xhttp=new XMLHttpRequest();//비동기객체
	xhttp.onreadystatechange = function() {
		//서버로부터 응답을 받았고, 그 응답이 정상적으로 처리되엇다면...
		if (this.readyState == 4 && this.status == 200) {
			document.getElementById("box").value=this.responseText;
		}	
	}
	
	xhttp.open("get", "server.jsp", true);
	xhttp.send();//요청 시작!!!
	
}
</script>
</head>
<body>
<input type="text" id="box"/>
<button onClick="getData()">서버에서 가져오기</button>
</body>
</html>



