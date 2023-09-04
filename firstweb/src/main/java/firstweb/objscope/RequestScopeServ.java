package firstweb.objscope;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RequestScopeServ
 */
@WebServlet("/reqscope")
public class RequestScopeServ extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request scope 영역의 데이터를 setting 하고 getting 하는 예제.
		//request scope 영역은 요청이 전달되는 한 지속됩니다. 즉 response 하는 시점까지 존재한다라고
		//생각하세요.
		String data1 = new String("Servlet");
		ArrayList<String> data2 = new ArrayList<>();
		
		data2.add("JSP");
		data2.add("SpringBoot");
		data2.add("BootStrap");
		
		//request 영역가지 데이터 설정하기
		request.setAttribute("data1", data1);
		request.setAttribute("data2", data2);
		
		
		request.getRequestDispatcher("/Scope2?data3="+URLEncoder.encode("기운내세요")  +"&data4=fighting").forward(request, response);
		
		
		
		
		
		
	}

}
