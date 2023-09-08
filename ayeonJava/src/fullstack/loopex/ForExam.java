package fullstack.loopex;

import java.util.Scanner;

public class ForExam {

	public static void main(String[] args) {
		/*
		  자바의 루프문 : JS와 마찬가지로 for, for in, while, do~while 모두 사용합니다.
		  이중 대표적인 구문은 for이고 필요에 따라서 중첩 및 내부에 조건을 넣는 경우가 많습니다.
		*/
		
		for(int i =0; i<10; i++) {
			//루프변수 i는 반드시 정수 타입이어야 합니다. 위에서의 i 변수는 
			//for 구문에서 처음 나왔기 때문에 for 구문이 끝나면 사라집니다.
		//	System.out.println(i);
		}
		
		//출력할 단을 입력 받아서 for를 이용해 결과 출력해보세요.
		//ex> 3 입력되면 3*1=3 ~ 3*9=27 이렇게
		
		Scanner sc = new Scanner(System.in);
		
		/*
		 * System.out.println("원하는 단 입력 : "); 
		 * int dan = sc.nextInt();
		 * 
		 * 
		 * for (int i = 1 ; i<10 ; i++) { 
		 * System.out.println(dan + " * " + i + " = " + * (dan * i)); }
		 */
		//이번엔 루프 변수를 위에서 선언 후 루프에 사용, 이후의 값이 변화되는 형태를 봅니다.
		
		int i = 20;
		for(i=10; i>0; i--) {
			//위 i의 초기값 20이 for에서 10으로 변경됩니다.
			//이후 1이 될 때까지 감소하면서 루프를 돌릴게요
		//	System.out.println(i);
		}
		
		//여기서 i의 값을 출력하면 0입니다.
		//이처럼 코드 위에서 선언된 변수를 루프에서도 사용할 수 있습니다.
	//	System.out.println("i-->" + i);
		
		
		//이번엔 하나 이상의 루프변수를 이용해 봅니다.
		for(int j = 0, k=10; j<10; j++, k--) {
			//위에서는 j와 k의 루프변수를 사용합니다.
			//하나 이상을 사용시엔 ,를 기준으로 선언 및 증감하시면 됩니다.
			//조건식은 하나 이상 쓰지는 않습니다.
			
		//	System.out.println(j + " : " + k);
		}
		
		//이번엔, 좀 더 특별하게 만들어봅니다.
		//문자 char는 내부적으로 정수타입인거 알고있듯이, 이게 연산자를
		//만나면 int로 변환되어지는 원리를 이용한 루프입니다.
		
		for(char ch='A' ; ch<='Z'; ch++) {
			//System.out.print(ch);
		}
	//	System.out.println();
		//위 결과와 똑같이 나오도록 아래 내용을 정의하세요.
		for(int ii=65; ii<=90; ii++) {
			//출력결과는 A~Z까지 나옵니다.
		//	System.out.print((char)ii);
		}
		
		
		//구구단 출력 기억하세요>
		//아래는 A~Z까지를 A~Z 수만큼 출력해볼게요.
		for(char a ='A'; a<='Z'; a++) {
			//구구단의 단 범위로 생각하면 되겠네요.
			for(char b ='A';b<='Z'; b++) {
				//System.out.print(b);
			}//a가 A인 경우의 A~Z 출력완료됨 .. A=>B
			//공백라인 추가함 
		//	System.out.println();
		}
		
		
		
		for(char a ='A'; a<='Z'; a++) {
			//구구단의 단 범위로 생각하면 되겠네요.
			for(char b = a ;b<='Z'-(a-65); b++) {
				//System.out.print(b);
			}//a가 A인 경우의 A~Z 출력완료됨 .. A=>B
			//공백라인 추가함 
			//System.out.println();
		}
		
		
		
		// 구구단 루프 만드세요.
		// 짝수단만 출력 시키도록 하세요...continue 사용하세요.
		
		
		
		
		// Label loop 구문을 볼게요.
		// Label loop란 루프에 label(이름)을 지정해서
		// 제어시에 이름을 호출하면 해당 루프가 제어되는 원리입니다.
		// 이름 선언 방법은 name : for 구문식입니다.
		Outer: for(int iii=1; iii<10 ; iii++) {
			if(iii % 2 == 0)
				continue;//이 하위의 로직 개무시..그러면서 Outer 조건으로 다시 감.
			
			Inner: for(int jjj=1; jjj<10; jjj++) {
				//결과가 홀수인 애만 출력하세요..break 사용하세요.
				if((iii*jjj) % 2 == 0) 
					//continue Outer; 홀수단의 *1만 찍힘    
					//break Outer;  3*1만 찍힘
				
				System.out.println(iii +" * "+ jjj+ " = " + (iii*jjj));
			}
			//각 단의 결과 다음에 공백라인 추가
			System.out.println();
		}
		
		
		
		/*
		  PrintSum이라는 클래스를 생성 후 아래의 조건대로 나오도록 정의하세요.
		  
		  먼저, 결과값은 두 개의 수를 입력 받은 후 해당 범위의 모든 수를 누적해서
		  누적합을 출력하는데, 문제는 두 수의 범위가 반드시 오름차순이어야 한다는 겁니다.
		  
		  즉 1, 10을 이력하면 1~10까지의 누적합 55,
		  반대로 10, 1을 입력해도 1~10까지의 누적합이 나오도록 하라는 말입니다.
		*/
		
		
		

		
		
		
		
	}

}
