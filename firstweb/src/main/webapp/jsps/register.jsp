<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 디자인 등은 CSS or BootStrap 에서 template 가져다 활용하세요. -->
<!-- 이 페이지는 회원가입 폼입니다. 
	회원 가입요청 시 입력폼에 관련된 내용을 script로 검증 후, 모두 올바르다면
	memberJoinProc.jsp(프로세스 페이지)로 post 요청을 보냅니다. 
-->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 폼 페이지</title>
<script type="text/javascript">
function isNull2(obj){//입력폼의 null 여부 검증 함수
	const data = obj.value;
	if(data == ''){
		alert(obj.name + " 필드는 공백 안 됨");
		obj.focus();
		return true;
	}
	return false;
}
// 각 폼의 공백여부를 확인해서, 공백이 하나라도 존재하면 회원가입 안 되게 클라이언트단에서 처리하는 함수
function check_form(){
	if(isNull2(reg_form.name)) return false;
	if(isNull2(reg_form.id)) return false;
	if(isNull2(reg_form.pw)) return false;
	if(isNull2(reg_form.tel)) return false;
	return true;	
}
</script>
</head>
<body>
	<h2>회원가입 페이지</h2>
	<!-- form 태그 내에 onsubmit 이벤트를 적용 시 반드시 return 을 함께 줘야 함
		함수의 결과가 false일 시 submit 안 되고, 반대는 됨...꼭 기억하세요.
	 -->
		<form action="memberJoinProc.jsp" 
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