<%@page import="product.domain.SubCategory"%>
<%@page import="java.util.List"%>
<%@page import="model.repository.SubCategoryDAO"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%!
	SubCategoryDAO subDAO = new SubCategoryDAO();
%>
<%
	String topcategory_id=request.getParameter("topcategory_id");
	List<SubCategory> subList=subDAO.selectAll(Integer.parseInt(topcategory_id));
	
	for( SubCategory subcategory : subList){
		out.print(subcategory.getName());
	}
%>








