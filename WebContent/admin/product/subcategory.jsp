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
	
	StringBuilder sb = new StringBuilder(); 
	sb.append("{");
	sb.append("\"subList\":[");
	for(int i=0;i<subList.size();i++){	
		SubCategory subcategory=subList.get(i);
		sb.append("{");
		sb.append("\"subcategory_id\":"+subcategory.getSubcategory_id()+",");
		sb.append("\"name\":\""+subcategory.getName()+"\"");
		if( i< subList.size()-1){
			sb.append("},");
		}else{
			sb.append("}");
		}
	}
	sb.append("]");
	sb.append("}");	
	
	out.print(sb.toString());
	
	
		//out.print(subcategory.getName()+"_$!");
	
%>








