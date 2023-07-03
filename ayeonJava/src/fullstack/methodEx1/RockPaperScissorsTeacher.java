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

public class RockPaperScissorsTeacher {

	static Scanner sc = new Scanner(System.in);

	private static void printStartMsg() {
		System.out.println("---가위 바위 보 게임을 시작합니다. ---");
	}
	private static void showMenual(int kind) {
		switch(kind) {
		case 0 : //기본 게임 메뉴얼 보여주기
			System.out.println("입력 예 : 1 or 가위, 2 or 바위, 3 or 보 중 하나 입력하세요.");
			break;
			
		default : 
			break;
		}
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		/*
		 * 게임 시작하면 가위바위보 게임을 시작합니다. 라고 메세지 출력하세요
		*/
		printStartMsg();
		
		/*
		다음으론 입력 메뉴 :
		가위(1 or 가위), 바위(2 or 바위), 보(3 or 보)
		사용자가 엔터를 치면 값을 입력하세요 : 라고 출력
		*/
		
		showMenual(0);
		System.out.print("입력 해주세요 : ");
		
		/* 
		 * 입력하면, 컴퓨터에서 랜덤한 값 1 ~ 3을 생성해서 비교를 합니다. 
		 * 이때 컴퓨터의 값은 createCom()로 정의해서 생성된 값을 되돌려줍니다.
		 */
		String user = sc.next();
		//위에서 user의 값 입력 받았으니 컴퓨터 값 생성 후 리턴 받도록 메서드 호출합니다.
		int comValue = createCom();
		
		
		String userValue = null;
		//사용자의 값을 분석해서 1은 가위로, 2는 바위로, 3은 보로 면환할게요.
		if(!(user.equals("가위") || 
		   user.equals("바위") || 
		   user.equals("보"))) {
			//무조건 숫자를 입력했다는 말임.
			switch(user) {
			case "1": 
				//가위
				userValue = "가위";
				break;
			case "2": 
				//가위
				userValue = "바위";
				break;
			default : 
				//보
				userValue = "보";
				break;
			}
		}else {
			//무조건 문자열 값으로 가위 바위 보가 들어왔으니, 이걸 userValue에 대입해서
			//결과 검증에 사용하도록 합니다.
			userValue = user ;
		}
		
		//여기에는 이미 컴값은 int로, 사용자값은 문자열인 가,바,보 중 하나로 설정완료됨
		System.out.println("com : " + comValue + " user : " + userValue);
		
		
		System.out.println(compare(comValue, userValue));
		
		 
	}
	//랜덤한 컴값을 생성하는 메서드 정의해서 1~3 범위의 값을 리턴토록 정의합니다.
	private static int createCom() {
		return (int)((Math.random() * 3) + 1);
	}

	
	//이제 컴과 사용자의 값을 비교해서 결과 메세지를 리턴하도록 하는 정의합니다. 
	private static String compare(int comValue, String userValue) {
		String result = null;
		String convertCom = "";
		switch(comValue) {
		case 1:
			convertCom = "가위";
			break;
		case 2:
			convertCom = "바위";
			break;
		default:
			convertCom = "보";
			break;
		}
		
		if(convertCom.equalsIgnoreCase(userValue)) {
			result = "컴 : " + convertCom + " 너님 : " + userValue + "결과 : 무승부" ;
		}else if(convertCom.equals("가위") && userValue.equals("바위")) {
			result = "컴 : " + convertCom + " 너님 : " + userValue + " 결과 : 너님 승";
		}
		
		return result;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
