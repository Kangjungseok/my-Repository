
package firstweb.board.daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import firstweb.board.dtos.BoardDTO;

/*
 * 게시판에 사용되는 DAO,
 * 설계 목적은, Connection, CRUD 를 모두 메서드로 정의합니다.
 */

public class BoardDAO {
	
	private static BoardDAO instance = new BoardDAO();
	
	private BoardDAO() {}
	
	
	public static BoardDAO getInstance() {
		return instance;
	}

	//Connection 리턴 메서드 정의
	
	private Connection getConnection() {
		Connection conn = null;
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/gamedb", "jskang2", "1234");
		}catch (Exception e) {
			System.out.println("Connection 생성 예외 발생 : " + e.getMessage());
		}
				
		return conn;
	}
	
	
	//list.jsp 에서 전체 글 수를 기준으로 paging 처리를 하기 때문에
	//전체 글 수를 리턴하는 쿼리 및 count 리턴 메서드 정의
	public int getArticleCount() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int cnt = 0 ; //리턴 카운트 변수		
		String sql = "SELECT count(*) FROM board";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				cnt = rs.getInt(1);
			}
			
		} catch (Exception e) {
			System.err.println("글갯수 리턴 메서드 예외!! : " + e.getMessage());
		}finally {
			if(rs != null) try {rs.close();} catch(Exception e) {}
			if(pstmt != null) try {pstmt.close();} catch(Exception e) {}
			if(conn != null) try {conn.close();} catch(Exception e) {}
		}
		return cnt;
	}
	
	
	public List<BoardDTO> getArticles(int start, int pageSize) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<BoardDTO> articleList = null; //글들이 담겨 있는 컬렉션
		
		String sql = "SELECT * FROM board order by ref DESC, re_step ASC LIMIT ?, ?";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start -1);
			pstmt.setInt(2, pageSize); //end 숫자가 아니라 pageSize 가 오지 않나?
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				articleList = new ArrayList<BoardDTO>();
				do {
					BoardDTO dto = new BoardDTO();
					dto.setNum(rs.getInt("num"));
					dto.setWriter(rs.getString("writer"));
					dto.setSubject(rs.getString("subject"));
					dto.setContent(rs.getString("content"));
					dto.setPasswd(rs.getString("passwd"));
					dto.setReg_date(rs.getTimestamp("reg_date"));
					dto.setReadcount(rs.getInt("readcount"));
					dto.setRe_step(rs.getInt("re_step"));
					dto.setRe_level(rs.getInt("re_level"));
					dto.setIp(rs.getString("ip"));
					
					articleList.add(dto);
				} while (rs.next());
			}
			
		} catch (Exception e) {
			System.err.println("글목록 리턴 메서드 예외!! : " + e.getMessage());
		}finally {
			if(rs != null) try {rs.close();} catch(Exception e) {}
			if(pstmt != null) try {pstmt.close();} catch(Exception e) {}
			if(conn != null) try {conn.close();} catch(Exception e) {}
		}
		
		if(articleList == null) {
			return Collections.EMPTY_LIST;
		}
		
		return articleList;
	}
	
	
	@SuppressWarnings("resource")
	public int insertArticle(BoardDTO article) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int x = 0 ;
		int number = 0; //테이블에 들어갈 글번호입니다.
		String sql = "";
		
		//댓글처리를 위한 컬럼값 세팅
		int num = article.getNum();
		int ref = article.getRef();
		int re_step = article.getRe_step();
		int re_level = article.getRe_level();
		
		try {
			conn = getConnection();
			//현재 저장된 게시글의 가장 큰 번호 get
			pstmt = conn.prepareStatement("SELECT max(num) FROM board");
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				number = rs.getInt(1) + 1;
			}else {
				//DB에 저장된게 없음, 첫 글임.
				number = 1;
			}
			
			//글번호(num) 값이 파라미터를 통해 DTO에 세팅되었는 지를 판단해서
			//있다면 댓글 데이터를 세팅하고, 없다면 기본 댓글 데이터 값으로 쿼리를 실행합니다
			
			if(num != 0) {//댓글임..
				sql = "UPDATE board SET re_step = re_step + 1 WHERE ref = ? AND re_step > ?";
				
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, ref);
				pstmt.setInt(2, re_step);
				pstmt.executeUpdate();
				re_step = re_step + 1;//0->1
				re_level = re_level + 1;//0->1
			}else {
				ref = number;//글 그룹값을 글번호로 세팅
				re_step = 0;//제목글은 0, 댓글들은 순차적으로 커짐.
				re_level = 0;//나중에 jsp 에서 보면 앎.
			}
			
			sql = "INSERT INTO board(writer,subject,content,passwd,reg_date,"
					+"ip, ref, re_step,re_level) "
					+"VALUES (?,?,?,?,?,"
					+ "?,?,?,?)";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, article.getWriter());
			pstmt.setString(2, article.getSubject());
			pstmt.setString(3, article.getContent());
			pstmt.setString(4, article.getPasswd());
			pstmt.setTimestamp(5, article.getReg_date());
			pstmt.setString(6, article.getIp());
			pstmt.setInt(7, ref);
			pstmt.setInt(8, re_step);
			pstmt.setInt(9, re_level);
			
			x = pstmt.executeUpdate();
			
		}catch(Exception e) {
			System.err.print("Insert 예외 발생함" + e.getMessage());
		}finally {
			if(rs != null) try {rs.close();} catch(Exception e) {}
			if(pstmt != null) try {pstmt.close();} catch(Exception e) {}
			if(conn != null) try {conn.close();} catch(Exception e) {}
		}
		
		return x;
	}
	
	//글 수정 시 해당 글번호의 ROW 리턴 메서드 정의
	public BoardDTO updateSel(int boardNum) {
		BoardDTO dto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("SELECT * FROM board WHERE num = ?");
			pstmt.setInt(1, boardNum);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dto = new BoardDTO();
				dto.setNum(rs.getInt("num"));//dto.setNum(boardNum);
				dto.setSubject(rs.getString("subject"));
				dto.setContent(rs.getString("content"));
			}
			
		} catch (Exception e) {
			System.err.println("업데이트데이터 select 시 예외!! : " + e.getMessage());
		}
		
		
		return dto;
	}
	
	
	//기존글 수정 메서드 정의
	//리턴은 -1 or 1을 리턴합니다.
	//1은 update 된 결과의 Row count, -1은 비번이 틀렸다는 의미
	public int updateArticle(BoardDTO dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		//비번 조회 쿼리
		String sql = "SELECT passwd FROM board WHERE num = ?";
		int result = -1; //jsp로 리턴되는 값 초기화..
		
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getNum());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				//비번 같은지 여부 조회
				if(dto.getPasswd().contentEquals(rs.getString("passwd"))) {
					//비번이 맞으니 제목과, 내용 수정 쿼리 재수행...
					sql = "UPDATE board SET subject = ?, content = ? WHERE num = ?";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, dto.getSubject());
					pstmt.setString(2, dto.getContent());
					pstmt.setInt(3, dto.getNum());
					
					result = pstmt.executeUpdate();
				}else {
					//비번이 틀리니 리턴 쳐주고 종료
					return result;
				}
			}
			
		} catch (Exception e) {
			System.err.print("게시글 수정 시 예외..." + e.getMessage());
		}
		
		
		
		return result;
		
	}
	
	public int deleteArticle(BoardDTO dto) {
		
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		//비번 조회 쿼리
		String sql = "SELECT passwd FROM board WHERE num = ?";
		int result = -1; //jsp로 리턴되는 값 초기화..
		
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getNum());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				//비번 같은지 여부 조회
				if(dto.getPasswd().contentEquals(rs.getString("passwd"))) {
					//비번이 맞으니 제목과, 내용 수정 쿼리 재수행...
					sql = "DELETE FROM board WHERE num = ?";
					pstmt = conn.prepareStatement(sql);
					pstmt.setInt(1, dto.getNum());
					
					result = pstmt.executeUpdate();
				}else {
					//비번이 틀리니 리턴 쳐주고 종료
					return result;
				}
			}
			
		} catch (Exception e) {
			System.err.print("게시글 삭제 시 예외..." + e.getMessage());
		}
		
		
		
		
		
		return result;
	}
	
}




























