<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
//post 방식이라 문자셋 깨짐 설정
request.setCharacterEncoding("utf-8");

//파라미터 받습니다. 이름은 값이 하나지만, 과목과 점수는 다중으로 올 수 있으니 배열로 받습니다.
String name = request.getParameter("name");
String[] subjects = request.getParameterValues("subject");
String[] scores = request.getParameterValues("jumsu");

double total = 0;
double avg = 0;

%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h3><%=name %>님!! 점수 결과입니다.</h3>

<% 

	try{
		for(int i = 0 ; i<subjects.length; i++){
			out.println(subjects[i]);
			if(i != subjects.length-1){
				out.println(", ");
				
				//total 과 평균의 값 누적함..
				total += Double.parseDouble(scores[i]);
			}else{
				total += Double.parseDouble(scores[i]);
			}
			avg = total / subjects.length;
		}
	}catch(Exception e){
		response.sendError(512,"연산시 오류가 발생했네요.");
		return;
	}
	
%><br/>

<h1>총점 : <%=total %> 평균 : <%=avg %></h1>

</body>
</html>