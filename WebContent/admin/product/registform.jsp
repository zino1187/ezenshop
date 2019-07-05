<%@page import="product.domain.TopCategory"%>
<%@page import="java.util.List"%>
<%@page import="model.repository.TopCategoryDAO"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%!
	TopCategoryDAO topDAO=new TopCategoryDAO();
%>
<%
	List<TopCategory> topList=topDAO.selectAll();
%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body {font-family: Arial, Helvetica, sans-serif;}
* {box-sizing: border-box;}

input[type=text], select, textarea {
  width: 100%;
  padding: 12px;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
  margin-top: 6px;
  margin-bottom: 16px;
  resize: vertical;
}

input[type=button] {
  background-color: #4CAF50;
  color: white;
  padding: 12px 20px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

input[type=button]:hover {
  background-color: #45a049;
}

.container {
  border-radius: 5px;
  background-color: #f2f2f2;
  padding: 20px;
}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="//cdn.ckeditor.com/4.12.1/standard/ckeditor.js"></script>
<script>
$(function(){
	CKEDITOR.replace("content");
	
	$("select[name='topcategory_id']").on("change", function(){
		getSubList();
	});	
	
	var bt=$("input[type='button']");
	$(bt).click(function(){
		regist();
	});
});		

//서버로부터 하위 목록 가져오기!!
function getSubList(){
	//비동기로 요청!!
	$.ajax({
		url:"subcategory.jsp",
		type:"post",
		data:{
			topcategory_id:$("select[name=topcategory_id]").val()			
		},
		success:function(msg){
			var json=JSON.parse(msg);//문자열을 대상으로 제이슨 객체화 시키는 메서드!!
			//파싱 한 후부터 제이슨 객체이다!!, 하기전에는 json 문자열(String객체)..
			
			//화면 처리!! javascript로 HTML 제어할 수 있어야 한다...DOM
			//select DOM 의 api 활용하기!!!
			var sub=document.getElementsByName("subcategory_id")[0];
			
			//기존에 option 요소가 잇다면 먼저 싹~~비우기
			var len=sub.length;
			
			for(var i=0;i<len;i++){
				if (sub.length > 0) { //남아있는 요소가 있다면...
	  				sub.remove(0);
				}
			}
			
			//넘겨받은  json 길이만큼 옵션 객체 채워넣기!!
			for(var i=0;i<json.subList.length;i++){
				var obj=json.subList[i];
						
				var op=document.createElement("option");
				op.text=obj.name; //option 태그의 텍스트값
				op.value=obj.subcategory_id;//option 태그의 value값
				sub.add(op);
			}
		}
	});
}

function regist(){
	$("form").attr({
		method:"post",
		action:"regist.jsp",
		enctype:"multipart/form-data"
	});
	$("form").submit();
}
</script>
</head>
<body>

<h3>Contact Form</h3>

<div class="container">
  <form>
	
	<select name="topcategory_id">
		<option value="">최상위 분류</option>
		<%for(TopCategory top : topList){ // jdk 1.5 improved for%>
		<option value="<%=top.getTopcategory_id()%>"><%=top.getName() %></option>
		<%} %>
	</select>
	
	<select name="subcategory_id"></select>
    <input type="text" name="product_name" placeholder="상품명..">
    <input type="text" name="brand" placeholder="브랜드명..">
    <input type="text" name="price" placeholder="가격">
    <input type="text" name="color" placeholder="색상..">
    <input type="text" name="psize" placeholder="사이즈..">
    <input type="file" name="filename">
	<textarea name="content" id="content"></textarea>
    <input type="button" value="상품등록">
  </form>
</div>

</body>
</html>




