<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%--
jsp 에서 제공하는 기본객체 : 서블릿에서 봤던 객체를 jsp 에서는 아래의 객체명으로 제공함.
따라서 해당 객체를 획득할 때는 객체명만 사용하면 됨.
단!!!!!!! 반드시 주의해야 할 것은 이 객체는 오직 지역변수로만 사용해야 함. 전역으로 선언하면 에러임.

request, response, pageContext(몰라도 됨), out, page(몰라도 됨)

session, ServletContext = application, ServletConfig = config,

Throwable exception : 예외 객체...jsp 에서 예외 핸들링 시 사용함.
 --%>
<%
//Scriptlet
//config.getServletContext();
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	let cnt = 1;

	//테이블에 동적으로 과목과 점수 항목 추가 삼수 정의
	function addRow() {
		let area = document.getElementById('area');
		let insert = area.insertRow(cnt + 1);
		let subject = "<input type = 'text' name='subject' size='8'/>";
		insert.insertCell().innerHTML = subject;

		let jumsu = "<input type = 'text' name='jumsu' size='8'/>";
		insert.insertCell().innerHTML = jumsu;

		cnt++;
	}

	//테이블에 동적으로 과목과 점수 항목 추가 삼수 정의
	function delRow() {
		if (cnt == 1) {
			alert('더이상 삭제 불가함');
			return;
		}

		let area = document.getElementById('area');
		area.deleteRow(1);
		cnt--;

	}

	//form 데이터 검증 함수 정의
	function check_form() {
		let name = myform.name.value;
		if (name == '') {
			alert("이름 넣어..");
			myform.name.focus();
			return false;
		}
		if (cnt == 1) {
			let subject = myform.subject.value;
			let jumsu = myform.jumsu.value;

			if (subject == '' || jumsu == '' || isNaN(jumsu)) {
				alert('과목명이 비었거나, 점수가 숫자 아님');
				return false;
			}

		} else {
			for (let i = 0; i < cnt; i++) {
				let subject = myform.subject[i].value;
				let jumsu = myform.jumsu[i].value;
				if (subject == '' || jumsu == '' || isNan(jumsu)) {
					alert('과목명이 비었거나, 점수가 숫자 아님');
					return false;
				}
			}
		}
		return true;
	}
</script>
</head>
<body>

	<h2>성적 계산</h2>
	<form action="calScore.jsp" method="post"
		onsubmit="return check_form()" name="myform">
		이름 : <input type="text" name="name"><br />
		<h3>과목과 점수입력</h3>

		<input type="button" value="추가" onclick="addRow();"> <input
			type="button" value="삭제" onclick="delRow();"> <input
			type="submit" value="계산"><br /> <br />

		<table id="area" width="300" border="1">
			<tr>
				<th width="100">과목</th>
				<th width="200">점수</th>
			</tr>

			<tr>
				<td><input type="text" name="subject" size="8"></td>
				<td><input type="text" name="jumsu" size="15"></td>
			</tr>

		</table>
	</form>

</body>
</html>