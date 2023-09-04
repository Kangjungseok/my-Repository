<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 각 영역 객체의 값을 EL 로 출력합니다. -->
Application 영역 객체의 값 : ${applicationScope.url }<br>
session 의 값1 : ${id }<br>
session 의 값2 : ${sessionScope.pw }<br>

요청파라미터 값(전번) : ${param.tel }<br>

배열의 값 찾기 : ${sessionScope.subject[0] }<br>

</body>
</html>