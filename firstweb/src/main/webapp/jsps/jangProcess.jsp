<%@page import="firstweb.dtos.JangBaguni"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
ArrayList<JangBaguni> baguni = null;
Object obj = session.getAttribute("jang");

if(obj == null){
	baguni = new ArrayList<JangBaguni>();
}else{
	baguni = (ArrayList)obj;
}

request.setCharacterEncoding("utf-8");

String name = request.getParameter("name");
String price = request.getParameter("price");

int pos = -1;

for(int i = 0 ; i<baguni.size(); i++){
	JangBaguni item = baguni.get(i);
	
	if(item.getName().equals(name)){
		pos = 1;
		//이미 존재하기 때문에 갯수만 추가
		item.setCnt(item.getCnt() + 1);
		break;
	}
}

if(pos == -1){//처음 담기는 아이템이라면..
	 JangBaguni jang = new JangBaguni();
	 jang.setName(name);
	 jang.setPrice(Integer.parseInt(price.replaceAll(",","")));// 가격에 ,를 삭제함
	 jang.setCnt(1);
	 baguni.add(jang);
}

//세션에 담는다.
session.setAttribute("jang", baguni);


out.println("<script>alert('카트에 담았습니다.'); history.go(-1);</script>");









%>