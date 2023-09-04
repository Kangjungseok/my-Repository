package firstweb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import firstweb.dtos.FirstDTO;

/*
 * Hello Servlet : 처음 만드는 서버에서 수행되는 Java Server API 프로그래밍
 * 이 서블릿은 Java SE API가 아니라 확장 API 입니다.
 * 즉 Java Se 를 기반으로 이 위에 웹was 에서 수행될 수 있는 기능을 가진 api 들의 확장 집합이란
 * 뜻입니다.
 * 
 * 때문에 이 api 가 어떤 의미인지, 어떻게 사용하는지를 알아야 jsp 가 이해가 됩니다.
 * 이 서블릿 lib 는 오라클에서 제공하지 않고, WAS 에서 제공을 합니다.  
 */
public class HelloServlet1 extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		//로그인한 사용자 정보를 출력해봅니다.
		
		FirstDTO member = (FirstDTO)request.getSession().getAttribute("member");
		String id,pass,email,name ;
		id=pass=email=name="";
		if(member != null) {
			id = member.getId();
			pass = member.getPassword();
			email = member.getEmail();
			name = member.getName();
		}
		
		PrintWriter out = response.getWriter();
		
		out.println("<h2>Hello Servlet</h2>");
		out.println("안녕하세요 "+ id + " 님! 암호는 " +pass+ " 이메일 : " +email + "이군요<br>");		
		out.println("<h2>현재 시간은 : " + java.time.LocalDateTime.now() + " 입니다.</h2>");
		
		
	}
	
}
