package fullstack_referenceEx;

import java.util.Scanner;

public class MultiScores {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * MultiScores 클래스를 생성하고 다음과 같은 로직을 완성하세요.
		 * 
		 * 5명의 국영수 점수를 관리하는 프로그램입니다. 다섯명 모두의 국영수 점수를 입력 받고, 각 점수 범위는 0 ~ 100 사이여야 합니다.
		 * 
		 * 
		 * 모든 점수를 입력 받은 후에 출력 결과는 다음과 같아야 합니다.
		 * 
		 * 1. 아이언맨 총점 : ?, 평균 ?, grade ? 2. 슈퍼맨 상동 3. 배트맨 상동 4. 곰돌이 푸 상동 5. 짱구 상동
		 * 
		 * 조건 1. 점수, 이름, 과목명, 평균, 학점 모두 배열로 사용하세요. 조건 2. 이중 위 학생과 관련된 점수는 반드시 2중 배열로
		 * 처리하세요. 5 * x의 다중배열을 생성해서 이 배열의 값으로 점수를 관리하세요. 조건 3. 출력시 이름은 출력문에서 동적으로 이름을
		 * 저장한 배열에서 추출해 출력하세요. 조건 4. 마지막 루프와 조건을 사용하는 예제이니 반드시 이해하고 본인이 최대한 작성하세요. 조건 5.
		 * 모든 로직에는 주석을 달도록 하세요. 기간 지금부터 내일 2교시 전까지 완성하세요. 그 전에 끝나면 더 좋고 모든 과제는 제출하시고,
		 * 구글링하시면 바로 알 수 있으니 알아서 하시길 바랍니다.
		 */

		String[] subject = new String[] { "국어", "수학", "영어" }; // 과목 이름을 담은 배열 생성. 입력할 때 과목의 이름을 알려주기 위함.
		String[] heroes = { "아이언맨", "슈퍼맨", "배트맨", "곰돌이 푸", "짱구" };// 캐릭터의 이름을 배열로 담았다.
		int[][] scores = new int[heroes.length][subject.length + 1];// 국어 수학 영어 총점
																	// 국어 수학 영어 총점 ....

		int[] total = new int[heroes.length];
		double[] avg = new double[heroes.length];// 캐릭터 수만큼, 평균은 double 타입으로 받겠다.
		char[] grade = new char[heroes.length];

		// scores[i][subject.length]은 'i'번째 캐릭터의 총점,

		// 점수를 입력받자!
		for (int i = 0; i < heroes.length; i++) {
			for (int j = 0; j < subject.length; j++) {
				while (true) {
					System.out.println(heroes[i] + "의" + subject[j] + "값을 입력하세요!");
					scores[i][j] = sc.nextInt();
					if (scores[i][j] >= 0 && scores[i][j] <= 100) // 46,47 line 올바른 값을 담는다.
						break;
				}
				// 여기까지, 행은 '히어로수', 열은 '과목수' 까지 국수영 값을 담았다.
				scores[i][subject.length] += scores[i][j]; // 과목 총점을 구했다. 자바에서 배열값이 0으로 초기화되기 때문에 바로 중첩 가능
			} // end of for "j"

			total[i] = scores[i][subject.length]; // total이라는 싱글배열에 담았다. 이유는 서로 다른 타입과의 연산을 위해. 총점 구함.
			avg[i] = total[i] / 3.0; // 3.0으로 double화 . 평균 배열 구함

			switch ((int) (avg[i] / 10)) {
			case 10:
			case 9:
				grade[i] = 'A';
				break;
			case 8:
				grade[i] = 'B';
				break;
			default:
				grade[i] = 'F'; // 과목수에 따라 일일이 'F'로 초기화 할 수 없어서 default를 줬다
			}// end of switch . 학점 배열 구함

		} // end of for "i"

		
		
		//출력
		for (int i = 0; i < heroes.length; i++) {
			System.out.println(heroes[i] + " 총점 : " + total[i] + ", 평균 : " + avg[i] + ", grade : " + grade[i]);
		}

	}

}
