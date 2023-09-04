<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
//이 페이지는 로그인을 한 사용자만 볼 수 있는 페이지입니다.
//두 가지를 구현할텐데, 첫 번째는 forward()를 이용해서 요청 전달을 했기 때문에
//파라미터가 전달되는지 여부와, 두 번째는 세션 정보를 확인해서 로그인한 사용자인지를 검증 후
//아닌 경우엔 로그인 페이지로 되돌리도록 합니다.
//String id = request.getParameter("id");

if(session.getAttribute("id") == null){
	response.sendRedirect("login.jsp");
}

//RequestDispatcher 객체의 메서드는 2개임.
//forward : 요청을 전달해서, 출력 결과는 마지막 전달페이지가 담당함. 하지만 사용자의 URL은 변화 없음
//include : 요청을 전달하는 건 같음, 단 최종 출력 결과는 include 하는 페이지의 버퍼에 인클루드된
//페이지의 결과가 합해져서 출력된다.
//ex> a.jsp 가 include b.jsp 를 하는 경우, b.jsp 의 결과는 a.jsp 버퍼에 담겨져서 a.jsp의 
//결과와 같이 출력된다.

//pageContext 의 include() 를 이용해서 사용자의 세션 정보를 include 해서 출력함.




%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>멤버 페이지</title>
</head>
<body>
	<h2>Welcome <%=session.getAttribute("id") %>님.</h2>
	<button onclick="location.href = 'logout.jsp'">로그아웃</button><br>
	
	
<% 
//위 메세지 하위에는 사용자의 세션 정보를 담고 있는 memberMainSub.jsp 를 include 해서
//사용자 정보를 출력시키도록 합니다.
pageContext.include("memberMainSub.jsp", true);
%>
</body>
</html>
















