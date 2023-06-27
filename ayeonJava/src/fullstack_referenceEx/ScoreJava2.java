package fullstack_referenceEx;

import java.util.Scanner;

public class ScoreJava2 {

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
		

		
		 /* int total, kor, math, eng; double avg; char grade;
		  
		  
		  
		  while(true) { System.out.println("국어 점수 입력 : "); kor = sc.nextInt();
		  if(kor>=0 && kor<=100) break; } while(true) {
		  System.out.println("수학 점수 입력 : "); math = sc.nextInt(); if(math>=0 &&
		  math<=100) break; } while(true) { System.out.println("영어 점수 입력 : "); eng =
		  sc.nextInt(); if(eng>=0 && eng<=100) break; }
		  
		  total = kor + math + eng; // 이걸 배열을 이용해서 연산? arr[] 모든
		  
		  
		  avg = total/3.0;
		  
		  
		  
		  switch((int)(avg/10)) {
		  
		  case 10: case 9: grade = 'A'; break; case 8: grade='B'; break; default :
		  grade = 'F'; }
		  

		  int arr[] = {kor, math, eng, total};
		  
		 
		  for(int i=0; i<arr.length;i++) { System.out.println(arr[i]); }
		  
		  
		  System.out.println("평균은" + avg); System.out.println("학점은" + grade);
		  
		 */
		
		
		int nos= 5; // number of subject
		double avg;
		char grade;
		
		int[] arr = new int[nos+1]; //nos + total
		
		for(int i=0; i<arr.length-1;i++) {
			while(true) {
				System.out.println((i+1)+"번째 점수 대입");
				arr[i] = sc.nextInt();
				if(arr[i]>=0 && arr[i]<=100)
					break;
			}
			arr[arr.length-1] += arr[i];			
		}//end of for
	
		avg = arr[arr.length-1] / (double)nos;
		
		switch ((int)(avg/10)) {
		case 10: 
		case 9:
			grade='A';
			break;
		case 8:
			grade='B';
			break;
		default:
			grade='F';			
		}

		System.out.println("총점은" + arr[arr.length-1]);
		System.out.printf("평균은 %.2f\n" , avg);
		System.out.println("학점" + grade);
		
	
		
		
	}

}
