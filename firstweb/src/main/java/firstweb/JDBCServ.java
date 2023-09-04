package firstweb;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class JDBCServ
 */
@WebServlet("/JDBCServ")
public class JDBCServ extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = null;
		
		try {
			/*
			  Class.forName("org.mariadb.jdbc.Driver"); conn =
			  DriverManager.getConnection("jdbc:mariadb://localhost:3306/gamedb",
			  "jskang2", "1234");
			 */
			//JNDI (Java Naming Datasource Interface) 를 이용한 Connection 얻어내기 테스트
			//설정만 제대로 되면 아래의 코드는 변경없이 사용하니, 외우거나 할 필요는 없음
			
			Context context = new InitialContext();
			DataSource source = (DataSource)context.lookup("java:comp/env/jdbc/mariaconn");
			conn = source.getConnection();
			/*
			ResultSet rs = null;
			Statement stmt = null;
			
			String sql = "Select * from test";
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				response.getWriter().append(rs.getString("content"));
			}
			*/
			response.getWriter().append(conn.toString());
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
