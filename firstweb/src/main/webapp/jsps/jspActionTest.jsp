<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="memDto" class="firstweb.dtos.FirstDTO" >
	<jsp:setProperty name="memDto" property="*"/>
	<jsp:setProperty name="memDto" property="password" param="pw" />
</jsp:useBean>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
ID : <jsp:getProperty property="id" name="memDto"/><br>
암호 : <%=memDto.getPassword() %><br>

</body>
</html>