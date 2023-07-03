package fullstack.ifex;

import java.util.Scanner;

public class IfExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		if 조건문 : if (조건식 or 논리결과값) {
			위 조건식의 결과가 true시에 수행될 구문 정의
			if 내부에는 로직에 따라 다시 if가 올 수 있고
			계속 중첩 되어질 수 있습니다.
			if가 없는 else는 절대 존재할 수 없고, else 절에 조건식이 들어올 수 없음.
			하나의 조건을 연속으로 검증할 때는 else if(조건식){
				조건식의 결과가 true시 수행구문 정의
			} 를 계속 나열할 수 있고, 역시 else if 내부에도 if가 들어올 수 있습니다.
			이처럼, if else if, else if, else 를 나열 시엔, 어느 한 조건이 만족되면
			나머지는 모두 skip 하게됩니다.
		}
	*/
		
		
		
		Scanner sc = new Scanner(System.in);
		
		
		  System.out.println("첫 수 입력 : "); int first = sc.nextInt();
		 
		  System.out.println("두 번쨰 수 입력 : "); int sec = sc.nextInt();
		  
		 /* 
		 * if(first >= sec) { System.out.println(first + " >= " + sec); }else {
		 * System.out.println(sec + ">= " + first); }
		 * }
		 */
	

	
	/*
		모든 프로그램에서의 조건은 {}이 없을 경우엔 무조건 조건의 아래식만 
		if의 실행문으로 간주합니다.
		따라서 아래의 구문중 두 번째 출력문은 if 구문의 실행문이 아닌
		main()의 실행문이 됩니다...꼭 기억하세요.
	*/
	
		//else를 정의하지 않는 방법
	if(first >= sec) {
		System.out.println(first + ">=" + sec);
		return; // 명시적으로 void 타입의 메서드를 여기서 종료하라는 의미가 됨.
	}
	System.out.println(sec + ">=" + first); // main()실행문이 됨
	
	
	

	
	
	
	
	
	
	}
	
}
