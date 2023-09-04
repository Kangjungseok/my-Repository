<%@page import="firstweb.board.dtos.BoardDTO"%>
<%@page import="firstweb.board.daos.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<meta name="viewport" content="width=device-width,initial-scale=1.0"/>
<link rel="stylesheet" href="../css/style.css"/>
<script src="../js/jquery-1.11.0.min.js"></script>
<script src="delete.js"></script>

<% request.setCharacterEncoding("utf-8");%>

<%
 //수정할 글의 번호와 수정할 글이 위치한 페이지 번호를 얻어냄
int num = Integer.parseInt(request.getParameter("num"));
String pageNum = request.getParameter("pageNum");

//update 할 게시글을 num 을 기준으로 가져오는 dao 메서드를 호출해서
//하나의 DTO 로 받습니다.
//BoardDAO dao = BoardDAO.getInstance();
//BoardDTO dto = dao.updateSel(num);
//out.println(dto);
%>

<form method="post" action="deletePro.jsp">
	<div id="deleteForm">
	   <ul>
	      <li><p class="center">글삭제
	      <li><label for="passwd">비밀번호</label>
	          <input id="passwd" name="passwd" type="password" 
	              size="20" placeholder="6~16자 숫자/문자" maxlength="16">
	          <input type="hidden" id="num" name="num" value="<%=num%>">
	          <input type="hidden" id="pageNum" value="<%=pageNum%>" name="pageNum">
	      <li class="label2">
	          <input type="submit" value="삭제">
	          <button id="cancle" value="<%=pageNum%>">취소</button>
	   </ul>
	</div>
</form>