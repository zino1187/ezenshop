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
		session.setAttribute("cart", cart);//넣은 적이 없다면 넣어둔다
	}else{//이미 있는거 꺼내먹기!!
		cart = (List)session.getAttribute("cart");	
	}
	
	if(cart.size()<1){//장바구니 최초 이용이면, 무조건 상품 하나 등록함!!
		cart.add(product);
	}else{
		int count=0;//장바구니에 동일 상품이 있는지 체크하는 용도...
		
		//이미 같은 상품이 장바구니에 있다면, 갯수의 증가만 있을뿐이다!!
		for(int i=0;i<cart.size();i++){
			ProductForm form=cart.get(i);
			
			//이미 담겨있던 form과 지금 막 담으려고 하는 product를 비교하여..처리..
			if(form.getProduct_id() == product.getProduct_id()){//중복상품 발견!!
				System.out.println(product.getProduct_id()+" 중복 발견됨!!");
				count++;	
				//ea +1 처리..
				int ea = form.getEa();
				form.setEa(ea+1);
			}
		}
		//for문이 모두 수행된 후 결론짓다!!(추가(0이면)할지,  말지(1이상이면))
		if(count<1){
			cart.add(product);
		}
	}
	
	System.out.println("최종결과");
	for(int i=0;i<cart.size();i++){
		ProductForm form=cart.get(i);
		int product_id=form.getProduct_id();
		int ea=form.getEa();
		
		System.out.println("상품 product_id : "+product_id + ", ea:"+ea);
	}
	
%>





















