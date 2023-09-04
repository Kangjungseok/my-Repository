<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!-- fmt 태그 지역, 통화, 날짜, 시간 등의 특정 포맷이 필요할 때 사용하는 formatter 입니다.
매우 많은 속성을 가지고 있는데, 이를 다 보기는 어려우니 몇 가지만 볼게요. 나머지는 필요 시 구글링하세요.
 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<fmt:requestEncoding value="utf-8"/>

<fmt:setLocale value="ko_kR"/>
<!-- 넘버포맷보기 -->
<fmt:formatNumber value="1234.56"/><br>
<fmt:formatNumber value="1234.56" type="number"/><br>
<fmt:formatNumber value="1234.56" type="currency" currencySymbol="$"/><br>
<fmt:formatNumber value="1234333.5678" type="percentage" pattern="#,###.0"/><br>

<fmt:formatNumber value="1234333.5678" maxIntegerDigits="5"/><br>

<fmt:parseNumber var="i" value="1234.567" integerOnly="true"/>


<fmt:formatDate value="<%=new java.util.Date() %>" type="date" dateStyle="full"/><br>
<fmt:formatDate value="<%=new java.util.Date() %>" type="time" dateStyle="full"/><br>
<fmt:formatDate value="<%=new java.util.Date() %>" type="both" dateStyle="full"/><br>

<fmt:parseDate value="20230821155959" pattern="yyyyMMddHHmmss" var="mystyledate"/>
<fmt:formatDate value="${mystyledate }" pattern="yy-M-dd HH:mm:ss" />






</body>
</html>