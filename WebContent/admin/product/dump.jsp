<%@page import="product.domain.Product"%>
<%@page import="java.util.List"%>
<%@page import="java.io.File"%>
<%@page import="gui.ExcelManager"%>
<%@page import="java.io.IOException"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%!ExcelManager exManager=new ExcelManager(); %>
<%
	//넘겨받은 엑셀파일을 이용하여, 오라클에 insert!!
	String saveDir=application.getRealPath("/data/");
	out.print(saveDir);
	int maxSize=5*1024*1024; //2M 제한
	String encoding="utf-8";
	
	try{
		MultipartRequest multi=new MultipartRequest(request, saveDir,maxSize,encoding);
		//엑셀파일이 이미 업로드가 완료되었으므로, 분석을 하되 매니저에게 시킨다!!
		//즉 로직을 또 짜지 말고, 기존 소스 이용하자!!
		File file=multi.getFile("excelfile");
		List<Product> productList=exManager.parse(file.getAbsolutePath());//엑셀의 풀경로..
		
		//리스트에 들어있는 데이터만큼 오라클에 insert 하기!! + 이미지 복사!!(temp->data)
		out.print("업로드된 상품의 수는 "+productList.size());
		
	}catch(IOException e){
		out.print("파일 용량을 확인하세요..");
		e.printStackTrace();
	}
	
%>








