package firstweb.objscope;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Scope2
 */
@WebServlet("/Scope2")
public class Scope2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 요청 파라미터의 값을 얻어냅니다.
		
		String param1 = request.getParameter("data3");
		String param2 = request.getParameter("data4");
		

		response.setContentType("text/html;charset=utf-8");
		response.getWriter().append("<html><head></head><body>");
		response.getWriter().append("파라미터 값1 " + param1 +"<br>");
		response.getWriter().append("파라미터 값2 " + param2 +"<br>");
		
		//요청을 Scope3 에게 다시 보내고, 일부 내용은 클라이언트에게 출력합니다.
		//요청 파라미터는 없이 보냅니다.
		request.getRequestDispatcher("/Scope3").forward(request, response);
		
	}

}
