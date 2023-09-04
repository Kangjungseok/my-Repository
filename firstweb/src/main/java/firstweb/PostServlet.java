package firstweb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PostServlet
 * 
 * 
 * 계산기 서블릿을 구현하세요.
 * calc.html에는 수 2개와, 연산자를 받는 폼을 구현하세요. 메서드는 get으로 하세요.
 * CalcServlet 은 위 입력 데이터를 모두 받아서 출력하도록 하세요.
 * ex> 3 + 2 = 5 입니다 처럼.
 * 연산자 예외는 처리하지 말고, 4칙 연산만 할 수 있도록 하고, servlet 이름은 자유롭게,
 * 요청 패턴은 CalResult 로 되도록 하세요.
 * 
 */
@WebServlet("/PostServ")
public class PostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/*
	 * 웹의 C/S 구조는 반드시 아래의 구조로 이뤄집니다..꼭 기억하세요.
	 * 
	 * 1.request 시 http 프로토콜은 2개의 구조로 이뤄집니다.
	 * 	a.요청헤더(Request header) : 프로토콜 버전, 타입, 요청 URL, 요청방식(method), cache, cookie 
	 * 	  등의 요청 정보 등을 담고 있는 헤더정보
	 * 	b.전송되어질 데이터(input tag 등에 쓰여진 사용의 값 등...)
	 * 
	 * 2.웹 서버는 요청에 대한 accept 후 헤더를 먼저 분석해서 위 내용을 모두 메모리에 담아놓습니다.
	 * 	이후 요청이 html 이라면, html 문서를 다운로드 해주고, 그 외의 확장자를 요청하면, 무조건 was 로 요청을 위임합니다.
	 * 
	 * 3.was는 위임 받은 요청을 해석해서 서블릿, jsp 등을 실행하고(jsp 는 내부적으로 servlet 으로 컴파일 됨)
	 * 	그 실행결과를 Response 하게 됩니다.
	 * 
	 * 4.응답 역시 아래의 구조로 이뤄집니다.
	 * 	a.응답헤더(Response header)를 먼저 보내는데, 이 내부에는 응답결과에 해당하는 스테이터스코드(SC Code), 쿠키정보 등...을
	 * 	  담은 헤더를 먼저 보냅니다.
	 * 	b.헤더정보를 받은 브라우저는 헤더 정보를 먼저 분석해서 쿠키는 브라우저 내부에 저장하고, 스테이터스 코드값을 분석해서
	 * 	  200번(OK) SC 코드인 경우만 서버에서 보내주는 웹문서를 랜더링하기 시작합니다.
	 * 
	 * 나머지 코드는 모두 에러와 관련된 내용이기 때문에, 코드에 따른 결과를 브라우저 내부의 메세지로 매핑을 해서
	 * 페이지에 띄워서 사용자에게 보여지게 됩니다.
	 * 
	 * 이 중 500번대 코드는 서버의 오류코드 종류로, 대부분 요청은 문제없지만, 서버쪽에서 문제가 발생되어질 때 보내집니다. 
	 */

	//post, get 모두를 처리하는 메서드를 정의함.
	public void doAnything(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// post 방식으로 보내지는 한글 데이터가 깨짐을 방지하는 첫 번째 방법
		// 모든 요청의 문자셋을 utf-8 타입으로 변경한다.
		// 이 메서드는 request 객체에 있음.
		// 반드시 메서드 첫머리에서 해주는게 좋음.
		// 이게 안 되면 다음 방법을 찾아야 함.
		
		if (request.getMethod().equalsIgnoreCase("post")) {
			request.setCharacterEncoding("utf-8");			
		}
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		
		out.append("<html><head><title>내가 만든 서블릿</title></head><body>");
		String id = request.getParameter("id");
		String message = id+"님 환영합니다.";
		out.append(message + "</body></html>");
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doAnything(request, response);
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doAnything(request, response);		
	}

}
