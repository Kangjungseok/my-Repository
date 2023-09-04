package firstweb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HeaderSetTest
 */
@WebServlet("/HeaderSetTest")
public class HeaderSetTest extends HttpServlet {
	private static final long serialVersionUID = 1L;


	
	private int counter = 0;//카운터 필드 선언함.
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Internal Server Error");
		response.setContentType("text/html;charset=euc-kr");
		//3초마다 페이지를 리로드(refresh) 하도록 헤더를 설정해서 respond 한다.
		response.setHeader("refresh", "3");
		PrintWriter pw = response.getWriter();
		
		pw.append("<html><head></head><body>");
		pw.append("카운터 = " + counter++);
		pw.append("</body></html>");
		
		
	}

}
