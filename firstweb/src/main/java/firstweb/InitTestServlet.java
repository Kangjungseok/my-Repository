package firstweb;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InitTestServlet
 */

public class InitTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//멤버필드 선언. 
	private int hap = 0;
	
	
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 초기화 정보를 간직하는 객체 ServletConfig 객체.. 이 객체는 WAS 시작 시 WAS 가 생성해서
		// 객체화 합니다.
		/*
		 * Enumeration<String> initNames = getInitParameterNames();
		 * while(initNames.hasMoreElements()) {
		 * System.out.println(initNames.nextElement()); }
		 */
		
		//init-param 으로 정의한 초기화 정보를 간직하는 객체인 ServletConfig 얻어내기 
		ServletConfig config = getServletConfig();
		
		int start = Integer.parseInt(config.getInitParameter("start")); 
		int end = Integer.parseInt(config.getInitParameter("end")) ;
		
		
		int hap = 0; //지역변수 선언합니다.
		
		for(int i = start; i<=end;i++ ) {
			hap += i;
		}
		
		System.out.println(start + " ~ " + end + " 누적합 : " + hap); //hap의 결과는? 멤버필드 hap이 나올까요 지역변수 hap이 나올까요?
		System.out.println(start + " ~ " + end + " 멤버필드 hap : " + this.hap); //hap의 결과는? 멤버필드 hap이 나올까요 지역변수 hap이 나올까요?
		
		
	}

}







