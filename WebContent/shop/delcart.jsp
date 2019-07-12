<%@page import="product.domain.ProductForm"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%
	int product_id = Integer.parseInt(request.getParameter("product_id"));

	//카트안의 List에 들어있는 ProductForm을 찾아내서 일치하는 것을 지우자!
	List<ProductForm> cartList=(List)session.getAttribute("cart");

	for(int i=0;i<cartList.size();i++){
		ProductForm product=cartList.get(i);
		if(product.getProduct_id() == product_id){//찾음!!!
			cartList.remove(i);//제거!!
		}
	}
%>
<script>
alert("장바구니에서 상품이 삭제되었습니다");
location.href="cart.jsp";
</script>





