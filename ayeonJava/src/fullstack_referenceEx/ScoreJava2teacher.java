package fullstack_referenceEx;

import java.util.Scanner;

public class ScoreJava2teacher {

	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//ScoreJava2 클래스를 정의하는데, 로직은 아래처럼 하세요
		/*
		 * 모든 과목의 점수를 배열로 담으세요.
		 * 각 과목은 동일하게 올바른 점수가 아닌 경우엔 다음 과목 점수를 입력받게 할 수 없습니다.
		 * 연산은 최대한 배열의 length를 이용하도록 정의하시고,
		 * 결과는 이전과 같이 총점, 평균, 학점(A,B,F)등이 나오도록 하세요.	
		*/
		//국영수 과목명 배열 생성합니다. 과목명이니깐 String
		String[] subject = {"국어","영어","수학"};
		//입력 점수를 담을 배열 및 총점도 정수이니깐 4개 생성합니다.
		int[] scores = new int[subject.length + 1];
		
		double avg = 0;
		char grade = 'F'; //기본값 F로 줍니다. 이렇게 하면 switch case에서
		//default 사용 안 해도 됩니다. 초기화하지 않은 상태에서 default 정의하지 않고
		//출력하면 grade가 초기화되지 않았다고 컴파일 에러뜹니다.(꼭 확인하세요)
		
		//점수 입력 메세지 출력 및 점수를 순차적으로 배열에 담습니다.
		
		do {
			System.out.println(subject[0] + "점수 입력 : ");
			scores[0] = sc.nextInt();
		}while(scores[0] < 0 || scores[0] > 100);//해당 과목이 정상 범위인지 검증합니다.
		//여기에 총점을 구하는 로직을 넣어도 OK입니다.
		//즉 이 구간으로 온다는 의미는 국어점수가 올바르다는 이유입니다.
		//일단 여기에 과목별로 누적해서 총점을 구하도록 합니다.
		//배열은 생성후 바로 모든 값이 기본값으로 초기화 되기에, 현재 총점 영역인
		//scores[3]은 0입니다. 따라서 누적대입해도 전혀 문제 안 됩니다.
		scores[scores.length] += scores[0]; //국어점수 누적
		do {
			System.out.println(subject[1] + "점수 입력 : ");
			scores[1] = sc.nextInt();
		}while(scores[1] < 0 || scores[1] > 100);
		scores[scores.length] += scores[1]; // 영어점수 누적
		do {
			System.out.println(subject[2] + "점수 입력 : ");
			scores[2] = sc.nextInt();
		}while(scores[2] < 0 || scores[2] > 100);
		scores[scores.length] += scores[2]; // 수학점수 누적
		
		
		//scores의 총점은 여기서 한 번에 해도 됩니다. 아래처럼...
		for(int i=0; i<subject.length; i++) {
			
		}
		
		
		
		
		
		
		//평균 구합니다.
		avg = scores[subject.length] / (float)subject.length;
		
		//학점 구합니다.
		switch((int)(avg/10)) {
		case 10 :
		case 9 :
			grade = 'A';
			break;
		case 8 :
			grade = 'B';
			break;
			//위에서 grade를 F로 초기화 했기에 나머지 평점은 모두 F임..		
		}
		
		System.out.println("너의 총점 : " + scores[subject.length]);
		System.out.println("너의 평균 :" + avg);
		System.out.println("네 학점 : " + grade);
		
		
		

		
	}

}
