package fullstack.methodEx1;

import java.util.Scanner;

public class Calc {

	/*
	 * 계산기를 정의합니다. Scanner 객체는 static 필드로 선언 및 초기화 하세요 더하기,빼기,곱하기,나누기 메서드를 만들고
	 * main에서 두 수와 연산자를 입력 받아서 연산자를 확인 후 해당 메서드를 통해서 연산 결과를 출력하도록 할게요. 즉 모든 메서드는 연산
	 * 후 결과를 출력해야 하며, int 타입의 파라미터 2개를 받도록 정의합니다.
	 */

	static void plus(int fir, int sec) {
		System.out.println(fir + sec);
	}

	static void minus(int fir, int sec) {
		System.out.println(fir - sec);
	}

	static void multi(int fir, int sec) {
		System.out.println(fir * sec);
	}

	static void divide(int fir, int sec) {
		System.out.println((double) (fir / sec));
	}

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int first, sec;
		String operator;
		boolean notop = false;

		System.out.println("첫번째 수 입력 : ");
		first = sc.nextInt();

		System.out.println("두번째 수 입력 : ");
		sec = sc.nextInt();

		do {
			System.out.println("연산자 입력 : ");
			operator = sc.next();

			switch (operator) {
			case "+":
				plus(first, sec);
				break;
			case "-":
				minus(first, sec);
				break;
			case "*":
				multi(first, sec);
				break;
			case "/":
				divide(first, sec);
				break;
			default:
				System.out.println("올바른 연산자가 아닙니다!");
				notop = true;
			}
		} while (notop);

	}

}
