package firstweb.objscope;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import firstweb.dtos.*;

/**
 * Servlet implementation class SessionServlet
 */
@WebServlet("/SessionServlet")
public class SessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * session 영역 객체 : 세션이 invalid 되기 전까지 WAS에 정보가 유지되는 scope
		 * 기본적으로 웹서버와 브라우저 간에는 세션 정보를 이용해서 인증유무를 유지합니다.
		 * 따라서 세션이 한 번 설정되어 무효화 되기 전까지는, 이 정보를 이용해서 세션을 계속 유지할 수 있습니다.
		 */
		
		FirstDTO me = new FirstDTO("aaa", "강정석", "test@test.com", "1234");
		
		//세션영역에 me 객체를 setting 합니다.
		HttpSession session = request.getSession();
		System.out.println("WAS 가 생성한 고유의 세션 ID : " + session.getId());
		
		
		session.setAttribute("member", me);
		
		response.getWriter().append("로그인되었습니다");
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
