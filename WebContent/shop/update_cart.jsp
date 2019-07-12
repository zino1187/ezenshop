<%@page import="product.domain.ProductForm"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%
	//파라미터가 이름이 동일하므로, 배열로 받자!!
	String[] product_id=request.getParameterValues("product_id");
	String[] ea=request.getParameterValues("ea");
	
	List<ProductForm> cartList =(List)session.getAttribute("cart");
	
	for(int i=0;i<product_id.length;i++){
		ProductForm product=cartList.get(i);
		
		//넘겨받은 상품의 id와 장바구니에 들어잇는 상품의 id가 일치하는 경우라면..
		//갯수의 수정 대상이 된다..
		if(product.getProduct_id() == Integer.parseInt(product_id[i])){
			product.setEa(Integer.parseInt(ea[i]));	
		}
		out.print(product_id[i]+"번째 상품의 갯수를 "+ea[i]+" 개로 수정할께요<br>");
	}
%>
<script>
alert("장바구니 정보가 수정되었습니다");
location.href="cart.jsp";
</script>













