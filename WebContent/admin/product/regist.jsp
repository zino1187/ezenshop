<%@page import="product.domain.Product"%>
<%@page import="model.repository.ProductWebDAO"%>
<%@page import="util.FileManager"%>
<%@page import="java.io.File"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%!
	ProductWebDAO productDAO = new ProductWebDAO();
%>
<%
	String saveDir=application.getRealPath("/data");
	int maxSize=5*1024*1024; //5M
	String encoding="utf-8";
	
	out.print(saveDir+"<br>");
	
	MultipartRequest multi=new MultipartRequest(request,saveDir,maxSize,encoding);
	//업로드된 파일명을 우리가 정한 시간 규칙으로 변경한다!!!
	File file = multi.getFile("filename"); //업로드된 그 파일!!!
	out.print("업로드된 파일명은 "+file.getName()+"<br>");
	
	String name=Long.toString(System.currentTimeMillis());
	String ext = FileManager.getExt(file.getName());
	out.print("새롭게 제조될 파일명은 "+name+"."+ext+"<br>");
	
	//변경될 이름으로 기존 파일의 이름을 바꾸자!!!
	String newName=name+"."+ext;
	file.renameTo(new File(saveDir+"/"+newName));

	//넘겨받은 파라미터값들을 이용하여, 오라클에 insert + 파일업로드!!
	Product product = new Product();
	
	String subcategory_id = multi.getParameter("subcategory_id");
	product.getSubCategory().setSubcategory_id(Integer.parseInt(subcategory_id));//하위카테고리 pk
	product.setProduct_name(multi.getParameter("product_name"));
	product.setBrand(multi.getParameter("brand"));
	product.setPrice(Integer.parseInt(multi.getParameter("price")));
	product.setColor(multi.getParameter("color"));
	product.setPsize(multi.getParameter("psize"));
	product.setFilename(newName);
	product.setContent(multi.getParameter("content"));
	
	int result=productDAO.insert(product);
	out.print(result);
%>














