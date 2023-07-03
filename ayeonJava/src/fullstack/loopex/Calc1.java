package fullstack.loopex;

import java.util.Scanner;

import javax.accessibility.AccessibleValue;

public class Calc1 {
	
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		/*
			계산기를 정의합니다.
			사용자로부터 2개의 수와 연산자를 받아서 계산 후 결과를
			출력하는데, 출력문 이후엔 계속 계산할 지를 물어본 후
			y or Y 가 입력되면 첨으로 다시 시작되어 수를 입력 받고
			연산자 입력 받는 로직이 수행됩니다.
			
			만약 N or n가 입력되면 "좋은 하루되세요!" 라고 출력 후 종료 시킵니다.
			
			참고로 switch 구문을 이용할 분은 연산자 비교를 문자열로 해봐도 좋습니다.
		*/
		
		
		
		
		
		
		
		
		
		char choice;
		int fir=0 ;
		int sec=0 ;
		int sum=0 ;
		
		String operator="";
		

		
		
		
		do {
			
			System.out.println("첫 번째 수를 입력하세요");
			fir = sc.nextInt();
			
			System.out.println("연산자를 입력하세요");
			operator = sc.next();
			
			System.out.println("두 번째 수를 입력하세요");
			sec = sc.nextInt();
			
			switch(operator) {
			case "+" : 
				sum = fir + sec;
				break;
			case "-" : 
				sum = fir - sec;
				break;
			case "*" : 
				sum = fir * sec;
				break;
			case "/" : 
				sum = fir / sec;
				break;
			}
			
			System.out.println("결과값은" + sum);

			
			System.out.println("계속 계산하시겠습니까? y / n");
			choice = sc.next().charAt(0);

			if(choice == 'N' || choice == 'n')
				System.out.println("좋은 하루되세요!");
				break;
			
		} while (choice == 'Y' ||  choice == 'y');
		
		
		

	}

}
