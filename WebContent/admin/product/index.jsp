<%@ page contentType="text/html; charset=UTF-8"%>
<%
	int totalRecord=26;//총 레코드 수
	int pageSize=10;//페이지당 보여질 레코드 수
	int totalPage =(int)Math.ceil((float)totalRecord/pageSize);
%>
<%="totalRecord "+totalRecord+"<br>" %>
<%="pageSize "+pageSize+"<br>" %>
<%="totalPage "+totalPage+"<br>" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body {
	margin: 0;
	font-family: Arial, Helvetica, sans-serif;
}
</style>
<link rel="stylesheet" type="text/css" href="/shop/css/topnavi.css" />
<link rel="stylesheet" type="text/css" href="/shop/css/table.css" />
</head>
<body>
	<%@ include file="/inc/admin/topnavi.jsp"%>

	<table>
		<tr>
			<th>No</th>
			<th>사진</th>
			<th>하위분류</th>
			<th>상품명</th>
			<th>브랜드</th>
			<th>가격</th>
			<th>색상</th>
			<th>사이즈</th>
		</tr>
		<%for(int i=1;i<=pageSize;i++){ %>
		<tr>
			<td>1</td>
			<td><img src="/data/1562125805034.jpg" height="35px"></td>
			<td>7</td>
			<td>JB청바지</td>
			<td>리바이스</td>
			<td>23,000</td>
			<td>red,blue,yellow</td>
			<td>28,29,30,31</td>
		</tr>
		<%} %>
		<tr>
			<td colspan="3">
				<button onClick="location.href='registform.jsp'">상품등록</button>
			</td>
		</tr>
		
	</table>


</body>
</html>









