package fullstack.ifex;

import java.util.Scanner;

import javax.swing.SpinnerNumberModel;

public class FindGreaterNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
		
		/*
			FindGreaterNumber 라는 클래스를 생성하세요.
			세 개의 수를 입력받아서, 큰 수부터 나열되도록 조건을 정의하세요.
			팁을 드리자면, 임시적으로 사용될 변수가 꼭 필요합니다.
			즉, 입력된 수를 담는 변수 외에 임시 변수가 더 필요하다는 의미입니다.
		*/
		
		
		
		Scanner sc = new Scanner(System.in);
		
		
		
		
		System.out.println("첫 수 입력 : "); 
		int first = sc.nextInt();
		int lowernum =first; //임시변수 설정
		 
		System.out.println("두 번쨰 수 입력 : ");
		int sec = sc.nextInt();
		if(sec >= first) { // 첫 번째와 두 번째 비교
			
			first = sec; //첫 번째와 두 번째 값 변경
			sec = lowernum; //첫 번째와 두 번째 값 변경
		} else  lowernum = sec; // 값 변경 없이 임시변수에 작은 값은 담았음
		
		System.out.println("세 번쨰 수 입력 : ");
		int third = sc.nextInt(); 
		if (third >= sec) { //세 번째와 두번째 배교
			sec = third; // 세 번쨰와 두번쨰 값 변경
			third = lowernum; // 세 번쨰와 두번쨰 값 변경
			
			if(sec >= first) { // 두 번쨰와 첫 번째 비교...세 번째로 입력된 값이 가장 큰 값일 수도 있기 떄문에
				int midnum = first;
				first = sec;
				sec = midnum;
			}
			
		}
		
		
	
		System.out.println(first +">="+ sec +">="+ third);
		
		
		
		
		
		
		
	}

}
