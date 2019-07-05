<%@page import="product.domain.Product"%>
<%@page import="java.util.List"%>
<%@page import="model.repository.ProductWebDAO"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%!
	ProductWebDAO productDAO=new ProductWebDAO();
%>
<%
	List<Product> pList=productDAO.selectAll();

	int currentPage=1; //유저가 현재 보고있는 페이지!!
	
	//최초에 들어온 경우는 그냥 1페이지를 보게..아래 로직은 수행하지 말자
	//유저가 링크를 눌렀다면..그때만~~~
	if(request.getParameter("currentPage")!=null){ 
		currentPage = Integer.parseInt(request.getParameter("currentPage"));
	}
	int totalRecord=pList.size();//총 레코드 수
	int pageSize=10;//페이지당 보여질 레코드 수
	int totalPage =(int)Math.ceil((float)totalRecord/pageSize);
	int blockSize=10;//블럭당 보여질 페이지 수
	int firstPage=currentPage - ((currentPage-1)%blockSize);
	int lastPage = firstPage + (blockSize-1);
	int curPos=(currentPage-1)*pageSize; //페이지당 시작 index (of ArrayList) 
	int num= totalRecord - curPos; //페이지당 시작 번호!!
%>
<%//="currentPage "+currentPage+"<br>" %>
<%//="totalRecord "+totalRecord+"<br>" %>
<%//="pageSize "+pageSize+"<br>" %>
<%//="totalPage "+totalPage+"<br>" %>
<%//="blockSize "+blockSize+"<br>" %>
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
.num{
	font-size:25px;
	color:blue;
	font-weight:bold;
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
		<%if(num<1)break; %>
		<%Product product=pList.get(curPos++); %>
		<tr>
			<td><%=num--%></td>
			<td><img src="/data/<%=product.getFilename() %>" height="35px"></td>
			<td><%=product.getSubCategory().getSubcategory_id() %></td>
			<td><%=product.getProduct_name() %></td>
			<td><%=product.getBrand() %></td>
			<td><%=product.getPrice() %></td>
			<td><%=product.getColor() %></td>
			<td><%=product.getPsize() %></td>
		</tr>
		<%} %>
		<tr>
			<td colspan="8">
				<button onClick="location.href='registform.jsp'">상품등록</button>
				
				<%if(firstPage-1 >1){ %>
					<a href="index.jsp?currentPage=<%=firstPage-1%>">◀</a>
				<%}else{%>
					<a href="javascript:alert('처음페이지 입니다');">◀</a>
				<%}%>
				
				<%for(int i=firstPage;i<=lastPage;i++){%>
					<%if(i>totalPage)break;%>
					<a   <%if(currentPage==i){%>class="num"<%}%>   href="index.jsp?currentPage=<%=i%>">[<%=i%>]</a>
				<%}%>
				
				<%if(lastPage<totalPage){%>
					<a href="index.jsp?currentPage=<%=lastPage+1%>">▶</a>
				<%}else{ %>
					<a href="javascript:alert('마지막 페이지입니다');">▶</a>
				<%} %>
			</td>
		</tr>
		
	</table>


</body>
</html>









