<%@page import="product.domain.OrderDetail"%>
<%@page import="model.repository.OrderDetailtDAO"%>
<%@page import="product.domain.ProductForm"%>
<%@page import="java.util.List"%>
<%@page import="model.repository.OrderListDAO"%>
<%@page import="model.repository.CustomerDAO"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%request.setCharacterEncoding("utf-8"); %>
<jsp:useBean id="customer" class="product.domain.Customer"/>
<jsp:setProperty property="*" name="customer"/>
<jsp:useBean id="orderList" class="product.domain.OrderList"/>
<jsp:setProperty property="*" name="orderList"/>
<%!
	CustomerDAO customerDAO = new CustomerDAO();
	OrderListDAO orderListDAO = new OrderListDAO();
	OrderDetailtDAO orderDetailDAO = new OrderDetailtDAO();
%>
<%
	//넘겨받은 파라미터를 이용하여 
	//1.고객정보 등록
	int customer_id = customerDAO.insert(customer);
	out.print("고객 등록 결과 "+customer_id+"<br>");

	//2.주문 요약 등록
	orderList.setCustomer_id(customer_id); //고객 정보를 주문 요약에 넣어준다!!
	int orderlist_id = orderListDAO.insert(orderList);
	out.print("주문 요약 등록 결과 "+orderlist_id+"<br>");
	
	//3.주문 상세 정보 등록
	List<ProductForm> cartList = (List)session.getAttribute("cart");
	
	for(int i=0;i<cartList.size();i++){
		ProductForm product=cartList.get(i);
		//Product 장바구니에 있는 상품 orderDetail로 옮기기
		OrderDetail orderDetail = new OrderDetail();
		orderDetail.setOrderlist_id(orderlist_id); //orderlist_id 심기 
		orderDetail.setProduct_id(product.getProduct_id());//product_id 심기 
		orderDetail.setEa(product.getEa());//갯수 심기
		orderDetail.setColor(product.getColor()); //색상 심기
		orderDetail.setPsize(product.getPsize());//사이즈 심기
		
		orderDetailDAO.insert(orderDetail); //상세정보 등록!!!
	}
	
	//4.완료 이메일 발송
	
%>








