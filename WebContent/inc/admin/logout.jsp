<%@ page contentType="text/html; charset=UTF-8"%>
<%
	//현재 사용자에게 할당된 세션 객체의 사용을 무효화 시키자!!!
	//참고) 세션 객체를 소멸은 안되며, 사용을 무효화 시켜야 한다..
	//session.validate()
	session.invalidate();
%>
<script>
alert("로그아웃 되었습니다.");
location.href="/admin/loginform.jsp";
</script>