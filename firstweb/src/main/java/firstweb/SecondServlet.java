package firstweb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SecondServlet
 */
@WebServlet(description = "두번째서블릿", urlPatterns = { "/Second","/third" })
public class SecondServlet extends HttpServlet {

	//private static final long serialVersionUID = 1L;  //지워도 된다고 하심

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	/*
	 * HttpServletReques interface : 클라이언트의 모든 요청 정보를 담고 있는 interface
	 * 서블릿을 상속을 받고, doSomething() 을 오버라이드 하면, 요청 메서드에 담겨 있는 정보 등을 
	 * 활용할 수 있도록 자동으로 해당 객체를 WAS 에서 생성해서 doSomething() 에 파라미터 객체로 넘겨줍니다.
	 * 
	 * 
	 * response(응답객체) : 서블릿에 정의된 결과 값을 보내주는 객체, 이 또한 was 에서 자동으로 생성해서
	 * 객체로 파라미터의 값으로 넘겨줍니다. 따라서 이 객체를 이용, 응답 시 필요한 작업을 메서드 등을 이용해서
	 * 작업을 합니다.
	 * 
	 * 먼저 알아둬야 할 것!!!
	 * 
	 * 1. 응답 전에 반드시 contentType 설정할 것
	 * 2. 응답은 내부적으로 stream 을 통해서 클라이언트로 전송되어지기 때문에 전송하려면 반드시 OutputStream 타입 객체 or
	 * 	Writer 객체를 response 객체로부터 얻어내서 전송해야 함. 
	 * 
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		//출력 객체를 얻어냈으니 문자열로 html 문서를 정의해서 스트림을 통해 output 시킵니다.
		//서블릿 3.0 이전에는 반드시 println() 등을 이용해야 했지만, 이후부터는 append() 를 이용해서
		//전송한 컨텐츠만 정의하면 자동으로 flush 되어집니다.
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		out.append("<html><head><title>내가 만든 서블릿</title></head><body>");
		
		String message = "서블릿의 내용입니다.";
		out.append(message + "</body></html>");
		
		//스트림은 닫지 않아도 됩니다.
		
		
		
		
		
		
		
		
		
	}

}
