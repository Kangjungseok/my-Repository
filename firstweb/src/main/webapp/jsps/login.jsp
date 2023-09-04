<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!--
이 페이지는 세션으로 통해 넘어오는 ID가 존재할 때 그 값을 설정하는 페이지  
-->
<%
String id = (String)session.getAttribute("id"); //request.getParameter("id");
if(id==null) id = ""; //ID 파라미터가 없을 시에 이처럼 초기화 하지 않을 경우
//사용 시에 nullpointerexception이 발생할 수 있음. 따라서 초기화 함.
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
</head>
<body>
	<h2>Login Page</h2>
	<!-- 사용자가 로그인 요청을 하면 인증을 수행하는 로직을 처리하는 process.jsp 로 액션처리 -->
	<form action="login_Process.jsp" method="post" name="login_form">
		ID : <input type="text" name="id" size="15" value="<%= id%>"><br>
		PW : <input type="password" name="pw" size="15" ><br>
		<input type="submit" value="로그인">
	</form>
</body>
</html>