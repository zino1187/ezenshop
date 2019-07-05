<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%
	String saveDir=application.getRealPath("/data");
	int maxSize=5*1024*1024; //5M
	String encoding="utf-8";
	
	out.print(saveDir);
	
	MultipartRequest multi=new MultipartRequest(request,saveDir,maxSize,encoding);
%>
<%
	//넘겨받은 파라미터값들을 이용하여, 오라클에 insert + 파일업로드!!
	
	
	
%>