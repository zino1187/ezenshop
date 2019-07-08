<%@page import="util.FileManager"%>
<%@page import="java.io.FileOutputStream"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="model.repository.ProductWebDAO"%>
<%@page import="product.domain.Product"%>
<%@page import="java.util.List"%>
<%@page import="java.io.File"%>
<%@page import="gui.ExcelManager"%>
<%@page import="java.io.IOException"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%!
	ExcelManager exManager=new ExcelManager();
	ProductWebDAO webDAO = new ProductWebDAO();
%>
<%
	//넘겨받은 엑셀파일을 이용하여, 오라클에 insert!!
	String temp=application.getRealPath("/temp/");//대량 업로드용 이미지 원본위치
	String saveDir=application.getRealPath("/data/");
	//out.print(saveDir);
	int maxSize=5*1024*1024; //2M 제한
	String encoding="utf-8";
	
	try{
		MultipartRequest multi=new MultipartRequest(request, saveDir,maxSize,encoding);
		//엑셀파일이 이미 업로드가 완료되었으므로, 분석을 하되 매니저에게 시킨다!!
		//즉 로직을 또 짜지 말고, 기존 소스 이용하자!!
		File file=multi.getFile("excelfile");
		List<Product> productList=exManager.parse(file.getAbsolutePath());//엑셀의 풀경로..
		
		//리스트에 들어있는 데이터만큼 오라클에 insert 하기!! + 이미지 복사!!(temp->data)
		//out.print("업로드된 상품의 수는 "+productList.size());
		
		for(int i=0;i<productList.size();i++){
			Product product = productList.get(i);
			//새롭게 만들어질 파일명 구하기!!
			long time = System.currentTimeMillis();
			String ext = FileManager.getExt(product.getFilename());//조사할 파일명
			
			FileManager.copy(temp+product.getFilename(), saveDir+time+"."+ext);
			
			//DTO에 새롭게 생성된 파일명으로 대체!!
			product.setFilename(time+"."+ext);
			webDAO.insert(product);
		}	
		
	}catch(IOException e){
		out.print("파일 용량을 확인하세요..");
		e.printStackTrace();
	}	
%>








