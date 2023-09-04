<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 이 페이지에서는 상품의 리스트를 보여주고, 버튼을 이용해서 카트에 담기 이벤트 시 
	세션에 상품을 담는 기능의 process 페이지를 연동, 해당작업을 수행토록 합니다.
 -->
 <%
 //모든 요소는 배열로 처리할게요.
 String[] img = {"curbie","dragonball","eve","groot","lacoon","leon","mario","monsterball","splatoon","yosi"};
 String[] name = {"curbie","dragonball","eve","groot","lacoon","leon","mario","monsterball","splatoon","yosi"};
 String[] price = {"10,000","11,000","12,000","13,000","14,000","15,000","16,000","17,000","18,000","19,000"};
 %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FullStack2 Shopping Mall</title>
<script type="text/javascript">
//여기서는 장바구니 추가 이벤트 시 세션에 담는 jangProcess.jsp 를 호출하면서, 파라미터로
//선택한 상품의 정보를 같이 넘기는 이벤트 처리 함수를 정의함.

function jang(name, price){
	location.href = './jangProcess.jsp?name=' + name + "&price=" + price;
}
//아래 함수는 장바구니 보기 클릭시 상페 페이지로 이동하도록 정의
function move_jang(){
	location.href = './baguni.jsp';
}
</script>
</head>
<body>
<!-- 여기서는 배열로 선언된 데이터를 뿌리는 list 작업을 합니다.
정렬된 형식으로 보이도록 테이블 사용합니다.
 -->
 	<h2>풀스택2기 쇼핑몰</h2>
 	
 	<table width="80%">
 		<tr>
 			<td align="right" colspan="3">
 				<input 
 				type="button" 
 				value="장바구니보기" 
 				onclick="move_jang();"
 				style='border:none'
 				>
 			</td>
 		</tr>
 		
 		<!-- 이 영역부터는 JSP 스크립트영역입니다. 중간중간 html 템플릿 사용 시 블락 잘 확인 바람 -->
 		
 		<% 
 		for(int i = 0; i<img.length;i++){
 			if(i % 3 == 0) out.println("<tr>"); // 각 low에 상품 3개씩만 보여주려고 삼...
 			out.println("<td><table border=0>");
 			out.println("<tr height ='100'><td align='center'>");
 			out.println("<img src='./imgs/" + img[i] + ".jpg' width='400' height='400'/>" );
 			out.println("</td></tr>");
 			
 			//로우 추가
 			out.println("<tr height ='20'><td align='center'>");
 			out.println("<B>" + name[i] + "</B></td></tr>");//물품명
 			//가격 로우 추가
 			out.println("<tr height='20'><td align='center'>");
 			out.println("가격 : " + price[i] + "원</td></tr>");
 			
 			out.println("<tr height='20'><td align='center'>");
 			
 			out.println("<input type='button' value='담기' onclick='jang(\""+name[i]+ "\",\""+price[i]+"\" )'/>");
 			
 			out.println("</td></tr></table></td>");
 			
 			if(i % 3 == 2) out.println("</tr>");
 			
 		}
 		%>
 	</table>
 	
 	
 	
</body>
</html>


