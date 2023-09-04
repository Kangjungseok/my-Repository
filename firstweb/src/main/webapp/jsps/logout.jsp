<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//세션객체의 메서드를 이용한 로그아웃 처리.
session.invalidate();

response.sendRedirect("memberMain.jsp");
%>