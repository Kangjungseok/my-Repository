package firstweb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CyanServlet
 */
@WebServlet("/CyanServlet")
public class CyanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		//전달된 요청 객체를 이용해서 사용자의 정보를 얻어낸다.
		//이 요청객체가 계속 참조 가능한 이유는 forward(), include() 시
		//요청객체와, 응답객체를 같이 주기 때문이다.
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String bgColor = request.getParameter("fcolor");
		
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.append("<html><head></head><body bgcolor='"+bgColor+"'>");
		out.append(name + "님 당신이 좋아하는 컬러는 " + bgColor + "군요");
		out.append("id: "+ id + " pw : " + pw);
		out.append("</body></html>");
		
		
		
		
		
		
		
		
		
		
		
	}

}
