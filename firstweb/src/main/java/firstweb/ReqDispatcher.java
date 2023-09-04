package firstweb;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ReqDispatcher
 */
@WebServlet("/ReqDispatcher")
public class ReqDispatcher extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String fcolor = request.getParameter("fcolor");
		
		//ServletContext 를 이용해서 RequestDispatcher 객체 생성함
		ServletContext ctx = getServletContext();
		
		
		RequestDispatcher rd = null;
		if(fcolor.equalsIgnoreCase("cyan")) {
			//선택한 컬러에 따라서 요청을 전달하고 응답한 서블릿을 동적 결정한다.
			rd = ctx.getRequestDispatcher("/"+fcolor+"Servlet");
		}else if(fcolor.equalsIgnoreCase("yellow")) {
			rd= ctx.getRequestDispatcher("/"+fcolor+"Servlet");
		}
		
		//사용자의 요청정보와, 응답정보를 담당하는 객체를 반드시 메서드로 보내야한다.
		rd.forward(request, response);
		
		
		
		
		
		
		
		
		
	}

}
