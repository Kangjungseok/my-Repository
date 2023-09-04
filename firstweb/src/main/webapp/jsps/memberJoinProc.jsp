<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.Context"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 
사용자의 회원가입 정보는 이전 페이지에서 스크립트로 모두 검증했기 때문에, 단 ID or email 등의 중복 검사는
나중에 해볼게요.

요청된 정보는 모두 DB에 Insert 되어야 합니다.

Insert 된 후에는 id 정보를 session 에 담아서 login.jsp 로 보내게 됩니다.
이러면, login.jsp 에서는 세션 내에 ID 값이 있는지를 판단 후 있다면, 그 값을 ID 필드에 출력시키도록 정의했죠??
 -->
<%
request.setCharacterEncoding("utf-8");
String name = request.getParameter("name");
String id = request.getParameter("id");
String pw = request.getParameter("pw");
String tel = request.getParameter("tel");

String sql = "INSERT INTO user_tb  VALUES (null,?, ?, ?, ?)"; // 사용자 정보를 insert 하는 쿼리 생성하세요.
Connection conn = null;
PreparedStatement pstmt = null;

try{
	Context context = new InitialContext();
	DataSource source = (DataSource)context.lookup("java:comp/env/jdbc/mariaconn");
	conn = source.getConnection();
	
	pstmt = conn.prepareStatement(sql);
	pstmt.setString(1, name);
	pstmt.setString(2, id);
	pstmt.setString(3, pw);
	pstmt.setString(4, tel);
	
	pstmt.executeUpdate();
	
	pstmt.close();
	
}catch(Exception e){
	response.sendRedirect("register.jsp");
	return;
}finally{
	if(conn != null){
		conn.close();
		conn=null;
	}
}


session.setAttribute("id", id);
response.sendRedirect("login.jsp");










%>