package fullstack.methodEx1;
/*
 * 파라미터를 하나 이상 받는 메서드의 활용법과,
 * 리턴문이 있는 메서드의 활용법을 알아봅니다.
*/

import java.util.Scanner;

public class MethodEx2 {

	static Scanner sc = new Scanner(System.in);
	//클래스 영역에 클래스내에 정의된 static 메서드가 참조할 수 있는
	//static 필드를 선언합니다.
	static String yon = null;

	
	// 입력된 연산자가 오칙 연산자 중 하나인지를 판별하는 메서드 정의합니다.
	static boolean isOperator() {
		
		//switch를 이용해서 연산자 검증후 결과 리턴합니다.
		switch(yon) {
		case "+":
		case "-":
		case "*":
		case "/":
		case "%":
			return true;
		}
		return false;
	}
	
	
	
	public static void main(String[] args) {
		
		System.out.println("계산할 연산자 입력하세요 : ");
		yon = sc.next();
		//연산자 올바른지 판별하는 메서드 호출합니다.
		//boolean isOp = isOperator();
		//System.out.println(isOp);
		
		
		if(isOperator()) {
			System.out.println("두 수의 결과는 10입니다.");
		}else {
			System.out.println("연산자가 틀립니다.");
		}
		
		//두 개의 수를 전달받아서 + 결과값을 리턴하는 메서드 호출해봅니다.
		int first = 10;
		int sec = 20;
		
		System.out.println(first + "+" + sec + "=" + sum(first,sec));
		
	}
	
	
	// 두 개의 수를 파람으로 빋이서 + 한 결과를 되돌리는 메서드 정의합니다.
	static int sum(int a, int b) {
		return a+b;
	}
	

	
	
	

}
