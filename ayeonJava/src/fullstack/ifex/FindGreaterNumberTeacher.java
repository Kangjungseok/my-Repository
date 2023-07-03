package fullstack.ifex;

import java.util.Scanner;

import javax.swing.SpinnerNumberModel;

public class FindGreaterNumberTeacher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
		
		/*
			FindGreaterNumber 라는 클래스를 생성하세요.
			세 개의 수를 입력받아서, 큰 수부터 나열되도록 조건을 정의하세요.
			팁을 드리자면, 임시적으로 사용될 변수가 꼭 필요합니다.
			즉, 입력된 수를 담는 변수 외에 임시 변수가 더 필요하다는 의미입니다.
		*/
		
		
		
		Scanner sc = new Scanner(System.in);
		
		
		int fir, sec, third, imsi =fir ;
		
		System.out.println("첫 수 입력 : "); 
		int fir = sc.nextInt();
		System.out.println("두 번쨰 수 입력 : ");
		int sec = sc.nextInt();
		System.out.println("세 번쨰 수 입력 : ");
		int third = sc.nextInt(); 
		
		//어떻게 값을 입력했던간에 fir에 큰 수를 대입하자.
		//첫 입력값이 젤 큰 경우는 조건에서 제외하고, 중간수와 마지막 수중 뭐가 젤 큰지
		//조건으로 검색하자.
		//중간수가 젤 큰지 검색
		if(sec >= fir && sec >= third) {
			//여기가 실행된다는 의미는 무조건 sec 값이 젤 크다는 의미입니다.
			//fir 값을 imsi 변수에 대입합니다.
			imsi = fir;
			fir = sec;//fir 값이 사라져요..
			sec =imsi;//sec 값에 fir 값을 대입해서 값을 치환합니다.
		}else if(third >= fir && third >= sec) {
			//여기가 실행된다는 말은 third 수가 젤 큰 수임.
			//따라서 third 값을 first에게 first 값을 third에게 치환함
			imsi = fir;
			fir = third;
			third = fir;
		}
		//위 if else if 에서 큰 수 값은 정렬되었음.
		if(third >= sec) {
			imsi = sec;
			sec = third;
			third = imsi;
		}
		
	
		System.out.println(fir +">="+ sec +">="+ third);
		
		
		
		
		
		
		
	}

}
