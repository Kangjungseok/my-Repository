package kang;

import java.util.Scanner;

public class GababoMain {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Name_verification nv = new Name_verification();
		Comparison compare = new Comparison();
		String inputEmail;
		String inputPw;
		String userInput;
		String user;// 유저 가위바위보
		String com;// 컴 가위바위보
		String userChoice;

		// 회원가입 영역
		do {
			System.out.println("이메일을 등록해주세요.");
			inputEmail = sc.next();
		} while (!nv.checkEmail(inputEmail));

		nv.setRegisterdId(inputEmail); // 이메일 등록

		System.out.println("비밀번호를 설정해주세요.");
		inputPw = sc.next();
		nv.setRegisterdPw(inputPw); // 비밀번호 설정

		// 로그인 영역
		do {
			System.out.println("이메일을 입력해주세요.");
			inputEmail = sc.next();
		} while (!nv.name_verification(inputEmail));

		do {
			System.out.println("비밀번호를 입력해주세요.");
			inputPw = sc.next();
		} while (!nv.pw_verification(inputPw));

		System.out.println("로그인 되었습니다.");

		// 게임 영역

		System.out.println("가위바위보 게임을 시작합니다!");

		do {
			System.out.println("가위(or1), 바위(or2), 보(or3) 중 하나를 입력하세요!");
			userInput = sc.next();
			String user_filter_value = new String_filter(userInput).filter();
			String computer_input = Integer.toString(new Computer_select().comnum());
			String comp_filter_value = new String_filter(computer_input).filter();
			System.out.println(compare.message(user_filter_value, comp_filter_value));

			System.out.println("1. 계속하기 2. 그만두기 3. 전적보기");

			userChoice = sc.next();

			if (UserChoiceFilter.filter(userChoice).equals("3")) {
				compare.myScore();
				System.out.println("1. 다시 게임하기 2. 게임 나가기");
				userChoice = sc.next();
			}

		} while (UserChoiceFilter.filter(userChoice).equals("1"));

		if (UserChoiceFilter.filter(userChoice).equals("2")) {
			System.out.println("즐거운 게임이었습니다!");
			return;
		}

	}

}
