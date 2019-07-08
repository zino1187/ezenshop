<%@page import="product.domain.ProductForm"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%request.setCharacterEncoding("utf-8"); %>
<jsp:useBean id="product" class="product.domain.ProductForm"/>
<jsp:setProperty property="*" name="product"/>
<%
	//유저가 전송한 상품 정보 1개를, 서버의 메모리에 담자!
	//request : 응답이 끝날때까지만..
	//session :  브라우저 닫을때 까지 ( 세션종료시까지)
	//application : 서버를 끌때까지.. form 객체
	
	//세션에 이미 cart 객체가 없다면 새로 만들고 있다면,
	//기존꺼 꺼내써야 한다!!
	/*
	System.out.println("product_id="+product.getProduct_id());
	System.out.println("product_name="+product.getProduct_name());
	System.out.println("brand="+product.getBrand());
	System.out.println("price="+product.getPrice());
	System.out.println("color="+product.getColor());
	System.out.println("psize="+product.getPsize());
	System.out.println("filename="+product.getFilename());
	System.out.println("content="+product.getContent());
	System.out.println("ea="+product.getEa());
	*/
	List<ProductForm> cart=null;
	if(session.getAttribute("cart")==null){//새로 만들기!!
		cart = new ArrayList();	
	}else{//이미 있는거 꺼내먹기!!
		cart = (List)session.getAttribute("cart");	
	}
	
	//이미 같은 상품이 장바구니에 있다면, 갯수의 증가만 있을뿐이다!!
	for(int i=0;i<cart.size();i++){
		ProductForm form=cart.get(i);
		
		//이미 담겨있던 form과 지금 막 담으려고 하는 product를 비교하여..처리..
		if(form.getProduct_id() == product.getProduct_id()){//중복상품 발견!!
			System.out.println(product.getProduct_id()+" 중복 발견됨!!");
		}else{
			//중복되지 않았으므로, 장바구니에 상품을 추가하자!!
			cart.add(product);
			System.out.println(product.getProduct_id()+" 추가됨");
		}
	}
	System.out.println("현재까지 장바구니에 들어있는 상품수는 "+cart.size());
%>








