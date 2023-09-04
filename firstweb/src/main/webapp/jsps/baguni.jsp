<%@page import="firstweb.dtos.JangBaguni"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- 장바구니 상페 페이지입니다.
기본 로직은 세션에 정의된 정보를 가져와서 for 를 통해 상품명, 갯수, 가격을 출력시킵니다.
 -->

<%
ArrayList<JangBaguni> baguni = null;

Object obj = session.getAttribute("jang");

if(obj == null)
	baguni = new ArrayList<JangBaguni>();
else
	baguni = (ArrayList) obj;









%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>장바구니 상세내역</h2>
<table width="80%" border="1">
	<tr>
		<th width="10%">
			번호
		</th>
		<th width="40%">
			제품명
		</th>
		<th width="15%">
			수량
		</th>
		<th width="15%">
			가격(ea)
		</th>
		<th width="20%">
			total
		</th>
	</tr>
	<% 
	if(baguni.size() == 0){//담긴 물건 없음.
	%>
	<tr><td align="center" colspan="5">
		<b>담긴 물건이 없습니다.</b>
	</td></tr>
	<%	
	}else{//담긴 물건이 있다면...
		//담긴 상품의 총액을 담을 변수 선언.
		int total = 0;
		int number = 1;
		for(JangBaguni item : baguni){
	%>
	<tr>
		<td align="center">
		<%=number++ %>
		</td>
		<td align="center">
		<%=item.getName() %>
		</td>
		<td align="center">
		<%=item.getCnt() %>
		</td>
		<td align="right">
		<%=item.getPrice() %>
		</td>
		<td align="right">
		<%=item.getPrice() * item.getCnt() %> 원.
		</td>
	</tr>
	
	
	<%
		total += item.getPrice() * item.getCnt();
		}//End of for... 하나의 item의 정보를 모두 출력하는 for
	%>
	<tr>
		<td colspan="4" align="center">
			총합계
		</td>
		<td align="center">
			<%=total %>원
		</td>
	</tr>
	<% 
	}//End of else...
	%>
</table>



</body>
</html>























