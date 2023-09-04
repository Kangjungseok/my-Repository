<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.Context"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.sql.*" %>

<!--
이 페이지가 하는 역할은 넘어오는 ID, PW 가 DB 상에 존재하는 회원인지를 판단합니다.
만약 요청된 정보가 모두 맞다면, 회원들만 볼 수 있는 loginSuccess(memberMain.jsp) 페이지로 forward 시킵니다.

해서 만약 맞다면, session 영역에 필요한 정보를 넣어두고, 정보가 틀리거나, 회원이 아닌 경우엔
회원가입폼(register.jsp)로 redirect 시킵니다.
-->



<%
//요청 파라미터를 get 합니다.
String id = request.getParameter("id");
String pw = request.getParameter("pw");

//전번과, 이름도 DB 상에서 가져올 때 담을 변수 선언.
String name = "", tel = "";

String sql = "SELECT * FROM user_tb WHERE id = ? and pw = ?"; //PreparedStatement 객체 사용 예정임.

Connection conn = null;
PreparedStatement pstmt = null;
ResultSet rs = null;

try{
	Context context = new InitialContext();
	DataSource source = (DataSource)context.lookup("java:comp/env/jdbc/mariaconn");
	conn = source.getConnection();
	
	pstmt = conn.prepareStatement(sql);
	pstmt.setString(1, id);
	pstmt.setString(2, pw);
	
	rs = pstmt.executeQuery();
	
	//사용자 정보가 존재한다면, 즉 인증이 완료되었다면...
	if(rs.next()){
		name = rs.getString("name");
		tel = rs.getString("tel");
	}else{
		//일부러 예외를 발생시켜서 사용자 요청을 회원가입폼으로 재전송합니다.
		throw new Exception();
	}
	
	rs.close();
	pstmt.close();
	
}catch(Exception e){
	response.sendRedirect("register.jsp");
	//response.sendError(500, "회원처리 Process 페이지 예외발생");
	return;
}finally{
	if(conn != null){
		conn.close();
		conn=null;
	}
}

//위에서 예외가 발생되지 않았을 시에는 하위 코드가 실해됨... 따라서 여기서는 
//session 영역에 사용자 정보를 setting 함.
session.setAttribute("name", name);
session.setAttribute("id", id);
session.setAttribute("pw", pw);
session.setAttribute("tel", tel);


//memberMain 페이지로 forward 시킵니다.
//request.getServletContext().getRequestDispatcher("path").forward(request,response);
pageContext.forward("memberMain.jsp");

%>
