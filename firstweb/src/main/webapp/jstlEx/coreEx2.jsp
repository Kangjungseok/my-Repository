<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!--
JSTL TAG : JSP 에 응용되는 커스텀 태그의 하나. Apache 에서 개발환 태그로 jsp 내에선 자주 쓰임
이러한 커스텀 태그는 spec을 TLD 라는 xml 에 정의해서 해당 xml 의 규칙에 준수해서 사용하도록 정의함
Java Web 계열에서는 이러한 Tag의 종류가 많으며, 나중에 스프링부트에도 비슷한 태그가 사용됨

형식은 action tag 와 유사하며, 각 tag는 내부에 특정 객체와 binding 되어 사용됨.

대표적인 태그로는 core tag 가 있으며, 아래는 해당 태그의 속성 및 간단한 설명.

1. 선언 및 사용법 : page 지시 태그에 tablib = ......core 로 선언하고, 사용될 prefix 를 c 로 선언
2. 위처럼 선언하면, 해당 페이지내에서는 core 를 사용해서 아래와 같은 기능을 사용 가능하게 함

a. set(tag 명) : 특정 영역을 지정하여 변수를 선언할 때 사용함.
속성 : var(변수명), value(변수에 할당할 값), target(특정 내장객체에 할당 시 대상 객체명)
property(특정 속성에 값을 할당 시 속성명 지정), scope(영역객체에 지정 시 객체명 할당)

b. remove(특정 영역에 할당된 변수 삭제)
속성 : var(삭제 대상 변수명), scope(삭제 대상의 영역 scope)

c. out(화면의 출력)
속성 : value(출력할 값), default(value 속성이 없울 시 출력 기본값)

d. param(파라미터로 데이터를 전달 시 파라미터 key)
속성 : name(파람 이름), value(해당 값)

e. import(include 액션 Tag 처럼 동적인 페이지를 가져올 때 사용됨...)
속성 : url(포함시킬 페이지나 절대 경로 URL), vars(include 된 페이지를 버퍼에 담아 이 변수에 할당함,
	이 때, 페이지의 내용은 출력되어지지 않음), scope(해당 vars 가 존재할 scope), varReader(reader 객체로
	해당 페이지에 접근 시 사용), charEncoding:include 되는 페이지의 문자셋 세팅

f. redirect(redirect)
속성 : url(요청 재작성 대상 url), context(url 속성값이 '/' 로 시작되는 경로 시 context 루트 지정함)

g. url(import 되는 대상 페이지의 url 만 관리하는 객체) 
속성 : value(경로를 페이지 이름이나 절대 경로로 지정), var(저장되는 경로 지정 변수), scope(영역대상) 

h. catch(예외를 처리하여 변수로 관리하는 객체)
속성 : var(예외 발생 시 예외 객체의 ref 하는 변수명)

i. if(조건문 처리)
속성 : test(조건식 기술 속성), var(test에 기술된 조건의 결과 담는 변수), scope(영역대상)

j. choose(switch case)와 비슷하게 사용함. 여러 조건중 하나를 선택하는 조건문

k. when(choose) 와 같이 사용되며, 조건을 분기시 사용
속성 : test(분기될 조건식 속성)

l. otherwise(choose 식에서 else 와 같음. , when에서 걸러지지 않은 조건을 처리 시 사용함)

m. forEach(중요) : 컬렉션이나 배열 등 수치에 의한 반복에 사용..for 와 같음.
속성 : var(for 구문의 초기화 변수 기능), items(반복대상 객체), begin(start value 기술)
end(end value 기술), step(증가폭 기술), varStatus(start 와 end 와 무관하게 루프의 순서를 관리하는 객체

-->

<%-- 
<% //구현체(로직정의) %>
<%=//출력문 %>
<%!//서블릿의 인스턴스 변수나 메서드를 사용하는 구문 %>
${expression language : 내부적으로 jsp 에서 사용하는 내장객체를 객체명으로 사용가능하며, 
객체니깐 메서드, 속성이 있을거고, 그것을 사용할 수 있도록 간단히 정의한 태그입니다.
단, 이 el 에서는 메서드나, 속성을 호출 시엔 모두 속성처럼 호출합니다.
ex>request.getAttribute("id") -- requestScope.id 이런 식으로
또한 내부적으로 간단히 사용하는 연산자 등도 있는데, 그건 사용 시에 설명할게요...(매우 쉬움)
}
<jsp:useBean/>
jstl : 위에 있는 모든 태그중에 el, useBean tag 과 같이 사용하는게 일반적입니다.
--%>

<!-- Java EE Spec(Enterprise Edition) 에서 사용되는 특정 기능을 수행하는 순수 자바 코드
이 순수 자바 코드는 서블릿 등이 첨가되지 않은 자바를 뜻합니다.
이러한 모든 자바 클래스를 instance 화 한 
애들을(클래스 or instance 모두) 자바 Beans 라고 칭합니다. 기억하세요!
 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 

<c:set var="x" value="100" />
<!--<c:set var="y" value="100" scope="session"/>-->
<c:set var="y" value="100" scope="request"/>

<c:set var="z" value="${requestScope.data }"/> 


<jsp:useBean id="ap" class="firstweb.dtos.FirstDTO">
	<c:set target="${ap }" property="name" value="강정석"/>
</jsp:useBean>

<%= ap.getName() %>

<c:out value="<h2>JSTL</h2>" default="값이 없네요" escapeXml="true" /><br>
<c:remove var="y" scope="request"/>
<c:out value="${requestScope.y }"/>

<% 
//클라이언트의 요청 헤더이름을 알아볼게요.
Enumeration<String> en = request.getHeaderNames();

while(en.hasMoreElements()){
	out.println("헤더 이름 : " + en.nextElement() + "<br>");
}
%>



<!-- 요청 파라미터의 이름만 알고 있다면, 그게 헤더라도, value 를 JSTL 과 EL 을 통해 쉽게 get 가능함 -->
<c:set var="browHeader" value="${header['user-agent'] }" />
<c:out value="${browHeader }"/>


<!-- switch case 와 같은 choose when test 를 봅니다. 그리고 if 조건도 같이 볼게요 -->
<%

%>
<c:set var="country" value="${'korea' }"/>
<c:if test="${country != null }" >
	<p><c:out value="${country }"/> 의 겨울이 점점 따뜻해지고 있습니다...
</c:if>

<!-- xy 변수에 값을 10을 담고, request 스코프영역으로 지정하는 set을 정의해보세요 -->
<c:set var="xy" value="100" scope="request"/>
<!-- if에 속성중에 var와 scope 입니다. 그리고 test 내부에 적용되는 조건식도 익숙해지세요. -->
<c:if test="${not empty (requestScope.xy) && (requestScope.xy % 2 == 0)  }" var="res" scope="request" >
	template 영역...html 영역...<br>
	결과는 = <c:out value="${requestScope.res }"/><br>
</c:if>

<c:set var="x" value="ab" scope="request"/>
<c:set var="y" value="10" scope="request"/>

<!--  c:catch 는 예외가 발생하면 예외 객체를 바인딩하는 Tag 입니다. -->
<c:catch var="kk">
	<c:choose>
		<c:when test="${requestScope.x % 2 == 0 }">
			<c:out value="짝수입니다."/>
		</c:when>
		<c:when test="${requestScope.x % 2 != 0 }">
			<c:out value="홀수입니다."/>
		</c:when>
		<c:otherwise>
			<c:out value="수가 아닌 값을 나누기 때문에 예외 발생함"/><br><br>
		</c:otherwise>
	</c:choose>
</c:catch>

<c:out value="${kk }"/> <hr>
<c:catch var="ex">
	<%Integer.parseInt("abac"); %>
</c:catch>

<c:out value="${ex }"/>











<hr>
<!-- 배열이나 Collection 루프문 forEach 구문 -->
<!-- 대부분 커플 태그로 구성합니다. 내부의 사용된 속성값은 루프 전체에서 사용 가능합니다. -->
<c:forEach var="i" begin="1" end="9" step="2">
	9 * <c:out value="${i }"/> = <c:out value="${9*i }"/> <br>
</c:forEach>



<!-- forEach 의 상태객체 status : 이 객체는 컬렉션 등을 루핑할 때 상태를 나타내는 속성을 
가지고 있습니다. 속성명은 count 로 현재 값으로는 수행중인 collection 의 idx 를 리턴합니다.

그리고 items 라는 속성은 일반 루프가 아닌 배열이나 컬렉션을 돌 때 그 대상명을 나타냅니다.
따라서 사용되는 형태는 반드시 컬렉션이나 배열 객체가 바인딩되어야 하기 때문에 리터럴을 사용하면 
절대 안 됩니다. EL 을 사용하거나 객체가 리턴되는 다른 수식을 사용해야 합니다.
 -->

<%
ArrayList<String> list = new ArrayList<>();
list.add("아현");list.add("한울");list.add("지호");list.add("기열");
pageContext.setAttribute("list", list);//pageScope 영역에 저장함..
%>
<c:set var="list" value="${list }"/>
${list }<br>

<h3>Collection get 하기 (ForEach)</h3>

<!-- begin,end 다 안 적으면 루프를 다 돔. end는 size보다 큰 수를 써도 변함 없음. begin은 변함. -->
<c:forEach var="collect" items="${pageScope.list }"  varStatus="cnt">
	<c:out value="${cnt.count }"/>  :	<c:out value="${collect }"/> <br>
</c:forEach>






















</body>
</html>





