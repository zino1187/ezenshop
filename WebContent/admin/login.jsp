<%@page import="admin.domain.Admin"%>
<%@page import="org.apache.ibatis.session.SqlSession"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="mybatis.config.MybatisConfigManager" %>
<%!
	MybatisConfigManager configManager = MybatisConfigManager.getInstance();
%>
<%
	//넘겨받은 파라미터를 이용하여, 오라클의 데이터와 비교~~
	String id = request.getParameter("id");
	String pass = request.getParameter("pass");
	
	out.print(id);
	out.print("<br>");
	out.print(pass);
	
	//DTO에 파라미터를 받아 저장하자!!
	Admin admin = new Admin();
	admin.setId(id);
	admin.setPass(pass);
	
	//매번 커넥션을 연결하고 곧 바로 끊으면, 서버에 부하가 발생한다..
	//웹은 요청과 응답기반이기에...
	SqlSession sqlSession=configManager.getSqlSession();	
	Admin obj=(Admin)sqlSession.selectOne("admin.domain.Admin.select", admin);
	
	if(obj ==null){
		out.print("<script>");
		out.print("alert('로그인 실패');");
		out.print("history.back();");
		out.print("</script>");
	}else{
		//세션을 유지할 수 있는 보상을 해주자!!
		session.setAttribute("admin", obj); //세션에 저장!!
		// 포워딩까지는 필요없다.왜?? 세션을 쓰면 브라우저 닫지 않는 한, 계속
		//서버의 세션 객체를 참조할 수 있으므로..
		
		//브라우저로 하여금 지정한 url로 다시 접속유도
		//따라서 접속을 끊고 새롭고 또 들어오겜..
		response.sendRedirect("/admin/index.jsp");  
	}
	//out.print("mybatis  를 통해 반환된 결과 id "+obj.getId());
	
%>

















