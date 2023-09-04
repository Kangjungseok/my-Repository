package firstweb;

import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ReqServlet
 */
@WebServlet("/ReqServlet")
public class ReqServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	
	
	
	private static String getClientIP(HttpServletRequest request) {
		String ip = request.getHeader("X-Forwarded-For");
		System.out.println(ip);
		return null;
	}
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doAnything(request, response);
	}

	@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			doAnything(req, resp);
		}
	
	protected void doAnything(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 만약 get 방식으로 요청이 오면 sendRedirect 를 이용해서 error.jsp 로 재전송 할게요.
		
		if(request.getMethod().equalsIgnoreCase("get")) {
			System.out.println("이건 get 방식으로 요청될 시 콘솔 내용.");
			response.sendRedirect("error.jsp");
		}
		
		
		
		// getParameter 를 이용하지 않고 모든 파라미터 정보를 얻어냅니다.
		// 사용될 메서드는 getParameterNames() 입니다.

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		// 아래의 코드를 완성해서, 모든 파라미터 이름을 System.out.println() 으로 출력시키세요.
		Enumeration<String> en = request.getParameterNames();

		while (en.hasMoreElements()) {
			// String param = en.nextElement();
			// System.out.println( param + " : " +
			// Arrays.toString(request.getParameterValues(param)));
			// System.out.println("파라미터 이름 : " + en.nextElement());
			String key = en.nextElement();
			System.out.println("파라미터 이름 : " + key);

			String[] values = request.getParameterValues(key);
			if (values != null) {
				for (String val : values) {
					System.out.println(key + " : " + val);
				}
			}
		}
		// client 의 접속 정보 알아보기
		System.out.println("접속 IP : " + getClientIP(request));
		System.out.println("접속 HOST Name : " + request.getRemoteHost());
		System.out.println("접속 port : " + request.getRemotePort());

		// 현재 요청의 헤더의 키 알아보기
		en = request.getHeaderNames();
		while (en.hasMoreElements()) {
			System.out.println("헤더 이름 : " + en.nextElement());
		}

		// 사용자가 요청한 요청 URI 정보 얻기
		System.out.println(request.getRequestURI());

		// 사용자의 세션정보가 기본 쿠기값에서 생성되었는 지의 여부 확인
		boolean isSessionIdFromCookie = request.isRequestedSessionIdFromCookie();
		System.out.println("사용자의 세션은 쿠키에서 생성됨 : " + isSessionIdFromCookie);

	}

}
