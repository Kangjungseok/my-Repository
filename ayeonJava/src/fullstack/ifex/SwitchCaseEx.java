package fullstack.ifex;

import java.util.Scanner;

public class SwitchCaseEx {

	public static void main(String[] args) {
		/*
			switch(조건){case break; case break; default}
			
			로직에서 if를 이용한 조건검색이 많아지면 수행 속도가 떨어집니다.
			이때 switch 구문을 이용하면 수행 속도는 월등히 좋아집니다.
			단 편한거 쓰세요.
			
			자바스크립트에서 배운 것과 모두 같지만 단, 하나의 중요한 차이점이 있습니다.
			switch(value) <-- value의 값은 반드시 int 이하만 가능하다는 것입니다.
			즉 정수타입만 비교 가능하며, 반드시 int 하위 타입이여야 합니다.
			때문에 대부분이 int로 비교합니다. 참고로 char 또한 int와 호환되는걸 기억하세요.			
		*/
		
		
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("주민번호 7번째 자리 입력해 : ");
		int year = sc.nextInt();
		String gender = "";
		
		//switch 구문으로 태어난 해 검증해보기
		//결과를 당신은 ?년대에 태어난 여성 or 남성 이군요
		//로 출력되도록 로직을 추가하세요.
		switch(year) {
		
		case 9 : 
		case 0 :
			gender = (year % 2 ==0) ? "여성" : "남성" ;
			year = 1800;
			break;
		case 1 :
		case 2 :
			gender = (year % 2 ==0) ? "여성" : "남성" ;
			year = 1900;
			break;
		case 3 :
		case 4 :
			gender = (year % 2 ==0) ? "여성" : "남성" ;
			year = 2000;
			break;

		default :
			System.out.println("잘못입력했군요");
		}
		

		
		
		System.out.println("당신은" +year+ "대에 태어난" +gender+ "이군요");
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
