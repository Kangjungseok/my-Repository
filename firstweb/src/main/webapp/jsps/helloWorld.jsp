<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<%@ page import="java.util.Date, java.util.ArrayList, firstweb.dtos.FirstDTO" %>

<%!
	//스크립트 내부의 코드 주석은 자바의 그것과 같음..
	//이 스크립트는 선언스크립트라고 합니다. 이 코드에 나열된 메서드, 필드는 모두 멤버필드로 편입되어집니다.
	//잘 쓰이지는 않습니다.
	
/* 	private int total = 0;
	
	private void cal() {
		for(int i = 0 ; i<=10; i++){
			this.total += i;
		}
	} */
	
%>

<!--
JSP : Java Server Page or Server Side Script Page

서블릿의 단점을 극복하고자 만든 서버사이드 스크립트. 말이 스크립트지, 문법만 스크립트이고, 내부적으로는
서블릿으로 컴파일되어짐.

먼저 여러분이 알아야 할 것은 서버사이드에서 실행된다는 것이 뭘 의미 하는지 아는 것.

서버사이드에서 실행은 실행 과정 등이 모두 클라이언트에게는 보여지지 않는다는 것을 의미함.

클라이언트가 볼 수 있는 것은 서버에서 실행된 결과를 담은 HTML 요소로 채워진 html 문서만 보게 됨.

모든 서버사이드 언어, 스크립트는 같은 결과를 도출합니다.

servlet 은 응답 시 html 문서를 생성할 때 문자열로 태그를 직접 나열해서 만들었던 불편함은, jsp로
해소됨. 

때문에 jsp 문서를 보면, jsp 스크립트와, html 템플릿요소(Tag, contents) 등이 구분되어져 있음.

따라서 여러분은 jsp로 서버에서 수행할 로직만 작성하고, 그 결과는 html 템플릿 코드를 이용해서 데이터만
감싸서 응답해주면 됨.

jsp는 다음과 같은 구조로 되어있음...반드시 기억!!!!

1. page Directive : 페이지 지시어 : 페이지 전반에 걸친 정보를 선언할 때 사용함, 내부에는 많은 속성이 
있는데, 대부분의 속성은 사용하지 않음...자주 사용하는 것은 강의시간에 알게 됨

2. Declaration : 선언부 스크립트. 이 스크립트를 이용해서 선언된 모든 것들은 멤버로 컴파일되어짐

3. Scriptlet : 스크립트릿 : jsp 가 컴파일 된 후 편입되는 지역 메서드 내에 정의하는 로직을 표현하는 스크립트.
주의할 것은 이를 이용할 경우 모두 지역메서드 내의 로직으로 변환됨

4. Action Tag : 나중에 배우겠지만, xml 형식을 이용한 동적 자바 객체를 이용하는 xml 태그 

5. EL(Expression Language) : 나중에 배울 출력을 위한 커스텀 태그

6. JSTL(Jsp Standard Tag Library) : JSP 의 유용한 기능을 Library 로 정의한 후에 xml 태그 형식으로 
배포한 객체 핸들링 태그...나중에 배움...이걸 잘 알아둬야 함... 스프링부트 시 다시 나옴... 다른 이름으로...

-->
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Hello JSP World!</h2>
	
<%
	//이 스크립트는 scriptlet 이라고 합니다. 컴파일된 서블릿의 ...Service() 메서드의 내용으로
	//편입이 되면 이 내부에 정의된 모든 변수 등은 지역 변수화 됩니다.
	int result = 0;
	//멤버로 선언된 메서드 호출
	//cal();
	//result = this.total;
	for(int i = 0; i<=10; i++){
%>
	<%=i %><br>
<%		
		result += i;
	}
	
	//내장객체중에 출력을 담당하는 출력객체부터 알아봅니다.
	out.println("1~10 까지의 누적합 : " + result);
	
%>


<!-- 아래는 jsp의 표현식입니다. 오로지 출력만 담당하며, 간단한 연산식은 적용가능합니다.
	보통 변수의 값을 출력할 때 사용합니다.
 -->
 <!-- <%= result %> -->
<%--얘는 JSP 출력문 주석.. 1~10 까지의 누적합 : <%= result %> --%><br>























</body>
</html>