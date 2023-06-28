package kang_RSPv3;

import java.util.Scanner;

public class Main {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		while(true) { 
			System.out.println("웰컴 자바 게임 1.회원가입하기 2.로그인하기 3.현재랭킹 순위보기(승률별) "
					+ "4.게임 제일 많이 한 랭킹보기 5.끝내기");
			
			userChoice = sc.nextInt();
			
			switch (userChoice) {
			case 1: //회원가입
				회원가입 진행
				break;
			case 2: //로그인
				로그인 진행
				
				if() {// 로그인이 되었다면, 게임 진행
					while (userChoice ==5 ) {//회원가입 탈퇴 누르면 탈출. 웰컴자바게임으로 돌아감
						System.out.println("1.게임하기 2.승률별 랭킹보기(10위까지), 3. 게임 수 랭킹보기(10위까지) 4.끝내기 5.회원가입 탈퇴");
						userChoice = sc.nextInt();
						
						
						switch (userChoice) {
						case 1: //게임하기
							playRSP();
							break;
						case 2: //승률랭킹 보기
							승률랭킹보기;
							break;
						case 3: //게임 수 랭킹 보기
							게임수랭킹보기;
							break;
						case 4: //끝내기
							System.out.println("GG");;
							return;
						case 5: //회원가입 탈퇴
							회원가입 탈퇴;
							break;
						default:
							break;
						}
					}//end of 로그인 안에 있는 while 
				}//end of if...

				break;
			case 3: //승률 랭킹
				승률 랭킹 보기
				break;
			case 4: //게임 수 랭킹
				게임 수 랭킹 보기
				break;
			case 5: //끝내기
				System.out.println("GG");
				return;
			default://12345 외에 다른 거 누르면 웰컴 자바 게임으로 돌아가기
				break;
			}
			
		}//end of while
		
		
		
		
	}

}
