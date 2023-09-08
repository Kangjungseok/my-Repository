import java.io.IOException;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class DateInputExam {

	public static void main(String[] args) throws IOException {
		/*
			콘솔로부터 키보드 데이터를 입력 받는 몇가지 방법
			
			1. System.in.read(); --> 이걸 이용하면 콘솔로부터 입력된 첫 번째
			문자 하나만 정수형으로 리턴합니다.
			
			2. Scanner 객체를 이용하는 방법..import java.util.Scanner 확인할 것
			Scanner sc = new Scanner(System.in);
			sc.nextInt() or next() 메서드를 이용해서 값을 얻어냅니다.
			
			3. JoptionPane 객체를 이용한 UI로 값 입력 받기
			사용법은 아래코드로 설명합니다. 단, 반드시 import 확인하세요.
			
		*/
		
		
		
		String value = 
		JOptionPane.showInputDialog("첫 수 입력하세요"); //입력된 값을 문자열로 리턴합니다.
		
		System.out.println(Integer.parseInt(value) + 1);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//2번 방법 사용 예
		/*
		 * Scanner sc = new Scanner(System.in);
		 * 
		 * System.out.println("첫 수 입력하세요 : "); int first = sc.nextInt(); //입력된 키 값이
		 * 정수(int 범위내)인 경우 //그 값을 그대로 리턴합니다. System.out.println("이름을 입력하세요.. : ");
		 * String name = sc.next();//엔터 전까지의 모든 값을 문자열로 리턴합니다.
		 * 
		 * System.out.println("두 번째 수 입력하세요 : "); int sec =sc.nextInt();
		 * 
		 * //이름과 첫 수 + 두 번재 수 합산 결과 출력하세요 System.out.println(name + (first+sec));
		 */
		
		
		
		
		
	

		/*
		 * System.out.println("첫 번째 수 입력 : "); int input = System.in.read();
		 * 
		 * //엔터처리합니다. //키보드의 입력값중 1byte 만을 읽어서 int로 리턴하는 API입니다.
		 * 
		 * System.in.read(); System.in.read();
		 * 
		 * System.out.println("두 번째 수 입력 : "); int input2 = System.in.read();
		 * 
		 * System.out.println("첫 번째 값 :" + input); System.out.println("두 번째 값 :" +
		 * input2);
		 */

		
		/*
		 * System.out.println((char)49); 
		 * System.out.println((char)13);
		 */
	 
	}

}
