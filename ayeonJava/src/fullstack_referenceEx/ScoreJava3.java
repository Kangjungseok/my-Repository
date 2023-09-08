package fullstack_referenceEx;

import java.util.Scanner;

public class ScoreJava3 {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// ScoreJava2와 같은 내용과 결과가 나오도록 정의하는데
		// 아래의 코드를 완성하세요.
		
		String subject[] = {"국어","영어","수학"};
		int[] scores = new int[subject.length + 1];

		
		//scores 배열도 이전과 같음
		//평균, 학점 변수도 같음
	
		
		for(int i=0; i<subject.length; i++) {
			//여기에 dowhile 한 번만 넣으면 이 for 구문 내에서 
			//평균을 제외한 과목별 점수, 총점이 모두 구해져야 합니다.
			//또한 점수가 올바르지 않을 경우엔 절대 다음과목의 
			//점수로 입력되어선 안 됩니다.
			
			
			do {
				System.out.println(subject[i] + "점수 입력");
				scores[i] = sc.nextInt();
			} while(scores[i] < 0 || scores[i] > 100);
			//과목점수가 올바름...
			//총점영역을 채워줍니다.
			scores[subject.length] += scores[i];
		}// End of for
		
		//여기로 온다는 말은 모든 점수가 다 입력 되었다는 뜻..
		//평균과 학점은 알아서 잘..

}
}