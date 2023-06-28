package kang;

import java.io.File;

import javax.imageio.spi.RegisterableService;
import javax.security.auth.login.LoginContext;

public class Test {

	public static void main(String[] args) {
		// 가위바위보 V3 main을 간단히 구현해보자.
		
		
		//회원가입 파트 ... 같은 이메일 있는지 검증,  회원가입 시 폴더와 파일 생성 , 암호화
		
		//1.회원가입하기 2.로그인하기 3.현재랭킹 순위보기(승률별) 4.게임 제일 많이 한 랭킹보기 5.끝내기
		
		
		
		while(userChoice == "첫 번째 팝업창") {
			
			입력 창 팝 
			userChoice = sc.next();
			userChoice.converter(userChoice);
			
			switch (userChoice) {
			case "회원가입":
				register();
				break;
			case "로그인":
				login();
					 // 로그인 성공 시 userChoice = "두 번째 팝업창" 으로
				break;
			case "승률랭킹":
				winRRanking;
				break;
			case "게임수랭킹":
				playRanking;
				break;
			case "끝":
				System.out.println("굿바이");
				return; //return 주의
			default:
				break;
			}
			
			
		}
		
		
		
		//로그인 성공이 되었다면...
		//메뉴 띄우기 1. 게임하기 2. 승률별 랭킹보기 3. 게임 수 랭킹보기 4. 끝내기 5. 회원 탈퇴
		

		while(userChoice == "두 번째 팝업창") {
			
			입력 창2 팝 
			userChoice = sc.next();
			userChoice.converter(userChoice);
			
			switch (userChoice) {
			case "게임하기":
				playRSP();
				
				userChoice = sc.next();
				
				break;
			case "승률랭킹":
				winRRanking();
				break;
			case "게임수랭킹":
				playRanking();
				break;
			case "회원 탈퇴":
				delete();
				break;
			case "끝":
				System.out.println("굿바이");
				return; //return 주의
			default:
				break;
			}

		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		//로그인 파트 ... 로그인 시 가장 최근 접속 기록 출력
		System.out.println("아이디를 입력하세요");
		inputId = sc.next();
		checkId();
		System.out.println("비밀번호를 입력하세요");
		inputPw = sc.next();
		checkPw();
		
		
		System.out.println("로그인 성공");
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
