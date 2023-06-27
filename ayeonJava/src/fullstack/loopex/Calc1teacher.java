package fullstack.loopex;

import java.util.Scanner;

import javax.accessibility.AccessibleValue;

public class Calc1teacher {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		/*
		 * 계산기를 정의합니다. 사용자로부터 2개의 수와 연산자를 받아서 계산 후 결과를 출력하는데, 출력문 이후엔 계속 계산할 지를 물어본 후 y
		 * or Y 가 입력되면 첨으로 다시 시작되어 수를 입력 받고 연산자 입력 받는 로직이 수행됩니다.
		 * 
		 * 만약 N or n가 입력되면 "좋은 하루되세요!" 라고 출력 후 종료 시킵니다.
		 * 
		 * 참고로 switch 구문을 이용할 분은 연산자 비교를 문자열로 해봐도 좋습니다.
		 */

		int first, sec, total;
		double dvTotal;
		String op = ""; // 문자열의 기본값 선언은 좌측처럼 하는게 일반적입니다.

		System.out.println("계산기를 시작합니다.");

		// 여기서부터 필요에 따라 반복되는 로직이니, while로 묶습니다.
		while (true) {

			System.out.println("첫 수 입력 : ");
			first = sc.nextInt();
			System.out.println("두 번쨰 수 입력 : ");
			sec = sc.nextInt();
			System.out.println("연산자 입력 : ");
			op = sc.next();

			// 게산합니다.
			switch (op) {
			case "+":
				total = first + sec;
				break;
			case "-":
				total = first - sec;
				break;
			case "*":
				total = first * sec;
				break;
			case "/":
				dvTotal = (double) first / sec;
				break;
			default: // 올바르지 않은 연산자가 입력시 프로그램을 아예 종료합니다.
				System.out.println("올바르지 않은 연산자입니다.");
				for (int i = 5; i > 0; i--) {
					try {
						Thread.sleep(1000);
						System.out.println("프로그램 종료" + i + "초전....");
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.exit(0);// 실행중인 자바 프로그램을 완전히 종료하는 코드
			}// End of switch
			
			
			
			
	//	System.out.println("결과는" + total);
			
			
			
			
			
			

			// 위 계산이 끝났으니, 다시 할 건지 물어봄..
			System.out.println("계속 할래요? Y or N");
			// 문자열의 값이 같은지 비교하는 메서드 하나 알아두세요.
			if (sc.next().equalsIgnoreCase("n")) {// 대소문자 구분 없이 같은 y인지 확인하는 메서드
				System.out.println("좋은 하루되세요.");
				break;

			}

		} // End of while..

	}

}
