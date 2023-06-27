package fullstack.loopex;

import java.util.Scanner;

public class DoWhile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		  do{실행구문}while(조건식); //반드시 ; 있어야 합니다!!!!!!!!
		  while(false)를 주면 while 구문은 시작도 안하지만 
		  do while 구문은 일단 한 번은 무조건 실행 후 조건의 결과에 따라서
		  재실행 또는 break를 하게 되는 차이점이 있습니다.
		*/
		
		/*
		 * int i=0; do { System.out.println("do의 실행문"); i += 2 ; }while(i<10);
		 * 
		 */
		
		Scanner sc = new Scanner(System.in);
		int subject = 0 ;
		
		do {
			System.out.println("국어 점수를 입력하세요");
			subject = sc.nextInt();
		}while(subject < 0 || subject > 100);
		

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
