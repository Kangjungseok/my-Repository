package firstweb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookieServ
 */
@WebServlet("/CookieServ")
public class CookieServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		/*
		 * rememberMe.html 에서 요청이 왔을 때, 쿠키 정보를 출력하는 코드를 작성하세요
		 * request 객체에서 Cookie 배열을 얻어서, 쿠키 이름에 해당하는 값을 decoding해서 콘솔에 출력하세요.
		 * java.net.URLDecoder.decode(id, "utf-8") 이용하세요.
		 */
		Cookie[] cookies = request.getCookies();
		if(cookies != null) {
			String c_id = "";
			for(Cookie cookie : cookies) {
				String key = cookie.getName();
				if(key.equals("id")) {
					c_id = java.net.URLDecoder.decode(cookie.getValue(), "utf-8");
					System.out.println("쿠키 값 : " + c_id);
				}
			}		
		}
		
		
		
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String id_rem = request.getParameter("id_rem");
		
		response.setContentType("text/html;charset=euc-kr");
		
		PrintWriter out = response.getWriter();
		
		out.println("<html><head></head><body>");
		out.println("<center><h2>");
		out.println(id+" ::: "+ pw + " ::: 로그인 성공!!" );
		out.println("</h2>");
		out.println("</body></html>");
		
		//쿠키 생성 및 전송하기.
		//쿠키 객체의 메서드 사용법 정도는 눈에 익히세요.
		
		if(id_rem != null && id_rem.equals("chk")) {
			//쿠키객체 생성
			//key : id value : 인코딩된 id 값
			Cookie id_Cookie = new Cookie("id", java.net.URLEncoder.encode(id, "utf-8"));
			
			id_Cookie.setComment("테스트용 쿠키..이건 저장된 ID 정보");
			id_Cookie.setPath("/");//root context 권한 설정
			id_Cookie.setMaxAge(60*60*24*365);//1년 MaxAge 설정
			
			//쿠키 보내기.
			response.addCookie(id_Cookie);
			
		}
		
		
		
	}

}
