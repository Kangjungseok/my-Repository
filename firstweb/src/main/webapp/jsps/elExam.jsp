<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL(Expression Language)</title>
</head>
<body>
<!-- 
-->
<%
//각 영역 스코프에 값 세팅함.
application.setAttribute("url", request.getRequestURI());

session.setAttribute("id", "aaa");
session.setAttribute("pw", "1234");

String[] subject = {"국","영","수"};
session.setAttribute("subject", subject);

%>

<!-- 아래는 파라미터 정보를 EL에서 사용하도록 폼 정의함 -->
<form 
			  action="elOut.jsp" 
			  method="post" 
			  onsubmit="return check_form()"
			  name="reg_form">
			  
			  이름 : <input type="text" name="name" size="15"><br>
			  ID : <input type="text" name="id" size="15"><br>
			  PW : <input type="password" name="pw" size="15"><br>
			  tel : <input type="text" name="tel" size="15"><br>
			  
			  <input type="submit" value="회원가입">
		</form>










</body>
</html>