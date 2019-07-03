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
<script>
$(function(){
	$("select[name='topcategory_id']").on("change", function(){
		getSubList();
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
			alert(msg);
			//화면 처리!!
			
		}
	});
}


</script>
</head>
<body>

<h3>Contact Form</h3>

<div class="container">
  <form method="post">
	
	<select name="topcategory_id">
		<option value="">최상위 분류</option>
		<%for(TopCategory top : topList){ // jdk 1.5 improved for%>
		<option value="<%=top.getTopcategory_id()%>"><%=top.getName() %></option>
		<%} %>
	</select>
	
	<select name="subcategory_id">
		<option value="">하위 분류</option>
		<option value="0">면바지</option>
	</select>
    <input type="text" name="product_name" placeholder="상품명..">
    <input type="text" name="brand" placeholder="브랜드명..">
    <input type="text" name="price" placeholder="가격">
    <input type="text" name="color" placeholder="색상..">
    <input type="text" name="psize" placeholder="사이즈..">
    <input type="file" name="filename">
	<textarea name="content"></textarea>
    <input type="button" value="상품등록">
  </form>
</div>

</body>
</html>




