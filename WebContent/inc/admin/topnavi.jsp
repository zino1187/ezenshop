<%@ page contentType="text/html; charset=UTF-8"%>
<%
	String[] menuTitle={"Home","상품관리","회원관리","고객센터"};
	String[] link={
			"/admin/index.jsp",
			"/admin/product/index.jsp",
			"/admin/member/index.jsp",
			"/admin/cs/index.jsp"
	};
%>
<div class="topnav">
	<%for(int i=0;i<link.length;i++){%>
	<a  <%if(request.getRequestURI().equals(link[i])){%>class="active"<%}%>  href="<%=link[i]%>"><%=menuTitle[i] %></a>
	<%} %> 
</div>













