package firstweb.objscope;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Scope2
 */
@WebServlet("/Scope4")
public class Scope4 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 요청 파라미터의 값을 얻어냅니다.
		

		String data1 = (String)request.getAttribute("data1");
		ArrayList<String> data2 = (ArrayList<String>)request.getAttribute("data2");
		
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().append("<html><head></head><body>");

		response.getWriter().append("Scope3 에서 읽은 request 영역의 값1 " + data1 +"<br>");
		response.getWriter().append("Scope3 에서 읽은 request 영역의 값2 " + data2.get(0) +"<br>");
		response.getWriter().append("Scope3 에서 읽은 request 영역의 값2 " + data2.get(1) +"<br>");
	}

}
