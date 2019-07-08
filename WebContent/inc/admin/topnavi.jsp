<%@page import="admin.domain.Admin"%>
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
<%
	Admin admin=(Admin)session.getAttribute("admin");
%>
<div style="text-align:right"><%=admin.getName() %>님  | <a href="/inc/admin/logout.jsp">로그아웃</a></div>
<div class="topnav">
	<a href="/shop" target="_blank">쇼핑몰</a>
	<%for(int i=0;i<link.length;i++){%>
	<a  <%if(request.getRequestURI().equals(link[i])){%>class="active"<%}%>  href="<%=link[i]%>"><%=menuTitle[i] %></a>
	<%} %> 
</div>













