package fullstack.jdbcex;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;

import fullstack.jdbcex.dtos.GameMemberDTO;

/*
 * DAO와 DTO
 * 
 * 자바에서는 DB에서의 데이터를 연동할 때 위의 개념을 일반적으로 사용합니다.
 * 이유는 로직분리(업무분리)입니다.
 * 
 * 즉, 한 클래스에서는 해당 클래스가 해야할 일만 집중해서 하자는 의미입니다.
 * 
 * 이렇게 클래스를 업무(Business)에 특화된 기능만을 정의해서 다른 업무를 정의한
 * 클래스가 필요할 경우엔 객체를 생성해서 가져다 쓰자는 개념입니다.
 * 
 * 이 개념의 기초가 DAO와 DTO입니다.
 * 
 * DAO(Data Access Object) : DB와 연결 및 쿼리를 주고 받는 업무에만 관점을 두는 클래스
 * 실제 가져온 데이터(ResultSet), 입력되어야 할 데이터(Insert, Update, Delete) 를 처리하는
 * 클래스는 DTO(Data Transfer Object)에 두고, 이 DTO를 이용한 DB 쿼리 작업만을
 * 메서드 등을 통해서 처리하도록 하는 객체입니다.
 * 
*/
public class GameDAO {
	
	//싱글톤으로 인스턴스 처리합니다.
	private static GameDAO instance = new GameDAO();
	
	private String url = "jdbc:mariadb://localhost:3306/gamedb";
	private String user = "jskang";
	private String pass = "rkdwjdtjr1";
	
	private ResultSet rs = null;
	
	
	private GameDAO() {
		// 외부에서 객체 생성 못 하게 기본 생성자 private 처리함
		
	}
	
	//외부에서 처리하고자 하는 DB 작업이 필요 시에 하나의 instance만 리턴하도록
	//static 메서드로 인스턴스 리턴시킴
	public static GameDAO getInstance() {
		return instance;
	}
	
	
	
	//DB에 연결할 때마다 conn을 리턴하는 메서드 정의합니다.
	private Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, pass);
		} catch (Exception e) {
			System.out.println(e.getMessage()); 
		}
		return conn;
	}
	
	//Connection close() 메서드 정의
	private void closeConnection(Connection conn) {
		if(conn != null)
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
	}
	
	//회원을 추가하는 메서드 정의할게요.
	public int insertMember(GameMemberDTO dto) throws Exception{
		int result = 0;
		
		Connection conn = getConnection();
		//PreparedStatement 객체를 사용할게요.
		String sql = "Insert into "
				+ "member Values ("
				+"(Select Max(a.num) + 1 from member a)"
				+",?,?,?,now())";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, dto.getName());
		pstmt.setString(2, dto.getEmail());
		pstmt.setString(3, dto.getPassword());
		
		result = pstmt.executeUpdate(); 
				
		pstmt.close();
		conn.close();


		return result;
		
		
	}
	
	
	//회원의 암호를 변경하는 메서드 정의
	public int updatePass(GameMemberDTO dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "Select password from member where num = ?";
		
		int result = 0 ; //변경 안 됐을 때의 값
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getNum());
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String oldPass = rs.getString("password");
				
				//갱신할 암호는 이전 암호와 비교해서 같다면 안됨.
				if(oldPass.equals(dto.getPassword())) {
					break;
				}else {
					//패스 다름...
					sql = "update member set password = ? where num = ?";
					pstmt = conn.prepareStatement(sql);
					
					//파라미터 세팅함..
					pstmt.setString(1, dto.getPassword());
					pstmt.setInt(2, dto.getNum());
					result = pstmt.executeUpdate();
				}
				
				
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return result;
	}
	
	
	//회원 삭제 메서드 정의...DTO에 회원의 num이 있다라고 가정합니다.
	public int deleteMember(GameMemberDTO dto) {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "Delete from member where num = ?";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getNum());
			
			result = pstmt.executeUpdate();	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	
	
	
	
	
	
	//회원정보 전체를 리턴하는 메서드 정의할게요.
	//이 메서드는 외부에서 필요한 정보를 리턴하는 기능이므로
	//모두 public으로 Open 해줘야 합니다.
	public ArrayList<GameMemberDTO> getAllMember() {
		//1.Connection부터 얻는다
		Connection conn = getConnection();
		String sql = "Select * from member";
		ResultSet rs = null;
		Statement stmt = null;
		GameMemberDTO dto =null;
		ArrayList<GameMemberDTO> members = new ArrayList<>(); 
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {//Row 커서 이동...즉, 한 Row는 하나의 DTO와 매칭됨
				
				dto = new GameMemberDTO();
				dto.setNum(rs.getInt("num")); 
				dto.setName(rs.getString("name")); 
				dto.setEmail(rs.getString("email")); 
				dto.setPassword(rs.getString("password"));
				dto.setReg_date(rs.getDate("reg_date"));
				
				members.add(dto);
				//모든 데이터를 DTO에 Setting
				

				
				/*
				 * System.out.println(num + " : " + name + " : "+ email + " : " + password +
				 * reg_date);
				 */
			}
			rs.close();
			stmt.close();
			closeConnection(conn);
			
			return members;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return (ArrayList)Collections.emptyList();
		}
	}
	
	
}
