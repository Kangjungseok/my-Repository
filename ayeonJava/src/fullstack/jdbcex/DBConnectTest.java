package fullstack.jdbcex;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import fullstack.jdbcex.dtos.GameMemberDTO;

public class DBConnectTest {

	public static void main(String[] args) throws Exception {
		GameDAO dao = GameDAO.getInstance();

		/*
		 * 신규회원 Insert 하기 GameMemberDTO dto = new GameMemberDTO();
		 * dto.setEmail("Tttt2@ttt.com"); dto.setName("디티오2입니다");
		 * dto.setPassword("1234"); System.out.println(dao.insertMember(dto));
		 */

		// 1234
		/*
		 * GameMemberDTO udto = new GameMemberDTO(); udto.setNum(3);
		 * udto.setPassword("5678"); System.out.println(dao.updatePass(udto));
		 */


		//회원삭제
		GameMemberDTO deldto = new GameMemberDTO();
		deldto.setNum(3);
		dao.deleteMember(deldto);
		
		

		// 회원의 모든 정보 보기.
		ArrayList<GameMemberDTO> members = dao.getAllMember();

		for (GameMemberDTO dto : members) {
			System.out.println(dto.getNum() + dto.getName() + dto.getEmail() + dto.getPassword() + dto.getReg_date());
		}

	}

}
