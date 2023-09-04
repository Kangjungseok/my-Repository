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
@WebServlet("/CalResult")
public class CalcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	public void doAnything(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		
		int first = Integer.parseInt( request.getParameter("firstN"));
		int second = Integer.parseInt(request.getParameter("secondN"));
		String operator = request.getParameter("operator");
		
		
		double result = 0;
		
		switch (operator) {
		case "+":
			result = first + second;
			break;
		case "-":
			result = first - second;
			break;
		case "*":
			result = first * second;
			break;
		case "/":
			if(second != 0) {
				result = (double)first / second;				
			}
			break;
		default:
			break;
		}
		
		
		
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		out.append("<html><head><title>내가 만든 계산기 서블릿</title></head><body>");

		out.append(first + operator + second + " 연산결과는 "+ result + "입니다.</body></html>");
		
		
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAnything(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAnything(request, response);
	}

}
