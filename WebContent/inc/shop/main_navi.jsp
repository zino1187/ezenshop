<%@ page contentType="text/html; charset=UTF-8"%>
<%@page import="product.domain.TopCategory"%>
<%@page import="java.util.List"%>
<%@page import="model.repository.TopCategoryDAO"%>
<%! 
	TopCategoryDAO topDAO=new TopCategoryDAO();
%>
<%
	List<TopCategory> topList=topDAO.selectAll();
%>
<nav>
	<ul>
		<li><a href="index.html">Home</a></li>
		
		<%for(int i=0;i<topList.size();i++){ %>	
		<%TopCategory topCategory=topList.get(i); %>								
		<li><a href="shop.jsp?topcategory_id=<%=topCategory.getTopcategory_id()%>"><%=topCategory.getName() %></a></li>
		<%} %>
		
		<li><a href="blog-left-sidebar.html">Blog</a>
			<ul class="sub-menu">
				<li><a href="blog-right-sidebar.html">Blog Right Sidebar</a></li>
				<li><a href="blog-single.html">Blog Details</a></li>
			</ul>
		</li>
		<li><a href="#">Pages</a>
			<ul class="sub-menu">
				<li><a href="shop.html">Shop</a></li>
				<li><a href="shop.html">Men</a></li>
				<li><a href="shop.html">Women</a></li>
				<li><a href="shop.html">Kids</a></li>
				<li><a href="shop.html">Gift</a></li>
				<li><a href="about-us.html">About Us</a></li>
				<li><a href="single-product.html">Single Product</a></li>
				<li><a href="cart.html">Cart</a></li>
				<li><a href="checkout.html">Checkout</a></li>
				<li><a href="look-book.html">Look Book</a></li>
				<li><a href="404.html">Error 404</a></li>
			</ul>
		</li>
		<li><a href="contact.html">contact</a></li>
	</ul>
</nav>