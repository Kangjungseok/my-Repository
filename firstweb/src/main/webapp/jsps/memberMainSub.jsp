<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" 
rel="stylesheet" 
integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" 
crossorigin="anonymous">
</head>
<body>
<%
//이 페이지는 memberMain 에서 include 로 호출한 페이지라서, 요청이 그대로 유지됩니다.
//해서 파라미터정보도 얻어낼 수 있고, 세션에 관련된 정보도 얻어내서 출력내용을 구성할 수도 있습니다.
//출력내용은 모두 include 한 페이지에 편입되어지고, 결과는 하나로 합쳐져서 출력되어집니다.
String name = (String)session.getAttribute("name");
String id = (String)session.getAttribute("id");
String pw = (String)session.getAttribute("pw");
String tel = (String)session.getAttribute("tel");
%>
<hr>
<p>
	당신의 로그인 정보 <br>
	
	이름 : <%=name %><br>
	ID : <%=id %><br>
	PW : <%=pw%><br>
	전화번호 : <%=tel %><br>
	
	이 내용은 모두 include 된 페이지의 내용입니다.
</p>


<div class="container bg-warning shadow mx-auto mt-5 p-5 w-75">
	<h2>Test</h2>
	<hr>
	<div class="input-group">
		<input id="item" class="form-control" type="text" placeholder="할 일을 넣으세요">
		<button type="button" class="btn btn-primary" onclick="addItem();">할 일 추가</button>
	</div>
	<hr>
	<ul id="todolist" class="list-group"></ul>
</div>

<script type="text/javascript">
function addItem(){
	let todo = document.getElementById('item');
	let list = document.getElementById('todolist');
	let listItem = document.createElement("li");//DOM을 이용해서 list 항복 객체 생성 및 바인딩
	
	//생성된 리스트항목에 부트스트랩 CSS 적용하기
	listItem.className = "d-flex list-group-item list-group-item-action list-group-item-warning";
	
	//항목에 삭제 버튼을 추가할게요.
	let xbtn = document.createElement("button");
	//css class는 위에서 선언한 부트스트랩 CDN 때문에 인터넷으로 동적으로 사용가능하게 됩니다.
	xbtn.className = "btn-close ms-auto";
	
	//xbtn에 이벤트 추가합니다.
	//발생된 대상의 부모 Node 를 찾아서 자식 노드를 삭제하도록 구현합니다.
	xbtn.onclick = function(e){
		let pnode = e.target.parentNode;
		list.removeChild(pnode);
	}
	
	//listItem 에 TextNode 추가
	listItem.innerText = todo.value;
	
	//항목에 버튼을 추가합니다.
	listItem.appendChild(xbtn);	
	//list(ul)에 child 추가하기..
	list.appendChild(listItem);
	
	todo.value = "";
	todo.focus();
}
</script>







</body>
</html>