package kang_RSPv3;

import java.util.Scanner;

public class PlayRSPv2 {

	static Scanner sc = new Scanner(System.in);

	public static void playRSPv2() {
		// TODO Auto-generated method stub

		Comparison compare = new Comparison();
		String inputEmail;
		String inputPw;
		String userInput;
		String user;// 유저 가위바위보
		String com;// 컴 가위바위보
		String userChoice;

		// 게임 영역

		System.out.println("가위바위보 게임을 시작합니다!");

		do {
			System.out.println("가위(or1), 바위(or2), 보(or3) 중 하나를 입력하세요!");
			userInput = sc.next();
			String user_filter_value = new String_filter(userInput).filter();
			String computer_input = Integer.toString(new Computer_select().comnum());
			String comp_filter_value = new String_filter(computer_input).filter();
			System.out.println(compare.message(user_filter_value, comp_filter_value));

			System.out.println("1. 계속하기 2. 그만두기");

			userChoice = sc.next();

		} while (UserChoiceFilter.filter(userChoice).equals("1"));

		if (UserChoiceFilter.filter(userChoice).equals("2")) {
			System.out.println("즐거운 게임이었습니다!");
			return;
		}

		
		
	}

}
