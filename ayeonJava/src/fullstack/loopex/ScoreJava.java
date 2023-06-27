package fullstack.loopex;

import java.util.Scanner;

public class ScoreJava {

	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//ScoreJava 클래스를 정의합니다.
		/*
			프로그램이 시작하면 "국영수 점수를 입력하세요"라고 메세지를 띄우고
			
			처음엔 국어 점수를 입력 받도록 하세요.
			다음엔 수학, 영어입니다.
			
			각 점수의 영역은 반드시 0 ~ 100 이어야 하고, 만약 이를 어긴 점수면
			다음 과목 점수 입력으로 넘어가지 않아야 합니다.
			
			모든 점수를 입력 받으면, 총점과 평균 그리고 학점을 구하는데,
			학점은 (100 ~ 90) A, (89.999 ~ 80) B, 나머진 F로 
			하고 평균은 소숫점 세자리에서 반올림 합니다.
		*/
		
		int kor, math, eng, total;
		double avg;
		char grade ;
		
		
		
		
		do {
			System.out.println("국어 점수를 입력하세요");
			kor = sc.nextInt();
		} while (kor<0 || kor>100); //0 ~ 100 사이 점수가 아니면 계속 입력 받습니다.
		
		do {
			System.out.println("수학 점수를 입력하세요");
			math = sc.nextInt();
		} while (math<0 || math>100);
		
		do {
			System.out.println("영어 점수를 입력하세요");
			eng = sc.nextInt();
		} while (eng<0 || eng>100);
		
		//코드가 여기로 온다는 말은 각 과목의 점수가 모두 OK 라는 말...따라서 평균 구함
		
		
		
		
		total = kor + math + eng;
		avg = total/3.0; // int와 int 의 연산값은 int! 실수를 만들기 위해 3.0으로
		
		//switch 구문을 이용해서 학점을 구할건데,
		//평균을 10으로 나누면 100 -->
		
		
		//학점
		/*
		 * if(avg>=90 && avg<100) { credit = "A"; }else if(avg>=80 && avg<90) { credit =
		 * "B"; }else credit = "F";
		 */
		
		switch((int)(avg/10)) {
		
		case 10 :
		case 9 :
			grade = 'A';
			break;
		case 8 : 
			grade = 'B';
			break;
		default : 
			grade = 'F';
		
		
		}
		
		
		
		//평균은 아래처럼 출력시키세요
		System.out.println("총점은" + total);
		System.out.println("학점은" + grade );
		System.out.printf("평균 = %.2f", avg);
		
		
		
		
		

	}

}
