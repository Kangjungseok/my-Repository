package fullstack.methodEx1;

import java.util.Scanner;

/*
 * 가위바위보 게임을 만듭니다.
 * 조건은 아래와 같습니다.
 * 
 * 게임 시작하면 "가위바위보 게임을 시작합니다." 라고 메세지 출력하세요.
 * 다음으론 입력 메뉴 : 가위(1 or 가위), 바위(2 or 바위), 보(3 or 보)
 * 사용자가 엔터를 치면 값을 입력하세요 : 라고 출력
 * 입력하면, 컴퓨터에서 랜덤한 값 1 ~ 3을 생성해서 비교를 합니다.
 * 이때 컴퓨터의 값은 createCom()로 정의해서 생성된 값을 되돌려줍니다.
 * 메인에서는 이 값을 받아서 사용자의 값과, 컴 값을 모두 compare()라는 메서드로 전달합니다.
 * compare 메서드는 이 두 값을 받아서 비교하고, 누가 이겼는지의 여부를 문자열로 되돌려 줍니다.
 * ex> user 승일 경우 user or com
 * 리턴 받은 결과를 가지고 사용자에게 아래처럼 출력하도록 메서드를 호출합니다. (printResult)
 * printResult() 메서드는 파라미터로 온 값 3개 (사용자값, 컴값, 결과값)을 받아서
 * 축 유저 승 : 컴 가위, 유저 바위
 * 처럼 출력시키고 종료합니다. 
 * 
 * 중요..모든 문자열 값이 같은지를 비교할 때는 
 * 문자열.equalIsIgnoreCase("비교문자열")
 * 대소문자 구분 없이 값만 비교하며, 같으면 true 리턴, 아님 false 리턴합니다.
 * 
 * 
 * 
*/

public class RockPaperScissors {

	static Scanner sc = new Scanner(System.in);

	static int createCom() {
		int com = (int) (Math.random() * 3 + 1);
		return com;
	}

	static String compare(int user, int com) {

		String winner = "";

		// (user-com) 의 case는 -2,-1,0,1,2 ....5개의 케이스가 3가지 경우의 수로 나뉜다. 
		// -부호는 컴퓨터의 값이 오른쪽에 있음을 의미한다, +부호는 왼쪽에 있음을 의미한다.
		// 수의 크기는 거리이다.
		// 이기는 경우 : 컴퓨터의 값이 1.자신보다 한 칸 왼쪽(3n-1), 2. 자신보다 두 칸 오른쪽 있을 떄(3n+2)
		// 지는 경우 : 컴퓨터의 값이 1. 자신보다 한 칸 오른쪽(3n-2), 2. 자신보다 두 칸 왼쪽 있을 떄(3n+1)
		// 비기는 경우 : 같은 값 or +-3n
		switch (user - com) {
		case 0:
			winner = "비김 ! ";
			break;
		case 1:
		case -2:
			winner = "유저 승 ! ";
			break;
		case 2:
		case -1:
			winner = "컴퓨터 승 ! ";
			break;
		}// end of switch

		return winner;
	}

	static void printResult(String user, String com, String winner) {
		System.out.println(winner + "유저 : " + user + ", 컴퓨터 : " + com);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String user, com = ""; // 가위바위보 입력 받음. 문자로
		int usernum = 0;
		int comnum = 0; // 가위바위보 데이터를 연산을 위해 숫자로 바꿔줌

		System.out.println("가위바위보 게임을 시작합니다!! \n입력 메뉴 : 가위, 바위, 보 \n엔터를 치면 시작합니다!");
		sc.nextLine();  // 엔터
		System.out.println("값을 입력하세요 : ");
		user = sc.next();
		
		//유저 가위바위보 문자화..출력을 위해서
		switch (user) {
		case "가위":
			usernum = 1;
			break;
		case "바위":
			usernum = 2;
			break;
		case "보":
			usernum = 3;
			break;
		}

		comnum = createCom();//컴퓨터 숫자 뽑기

		//컴퓨터 가위바위보 문자화..출력을 위해서
		switch (comnum) {
		case 1:
			com = "가위";
			break;
		case 2:
			com = "바위";
			break;
		case 3:
			com = "보";
			break;
		}

		compare(usernum, comnum);

		printResult(user, com, compare(usernum, comnum));

	}

}
