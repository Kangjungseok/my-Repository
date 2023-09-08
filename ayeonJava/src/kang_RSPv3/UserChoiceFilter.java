package kang_RSPv3;

public class UserChoiceFilter {

	static String filter(String userChoice) {
		if(userChoice.equals("1") || userChoice.equals("2") || userChoice.equals("3")) {
			return userChoice;
		}else {
			System.out.println("123을 입력해라 멍청아!");
			return "1"; // 다른 값을 입력했을 경우 일갈 후 게임 속행
		}
		
	}
}
