package fullstack.methodEx1;

import java.util.Arrays;
import java.util.Scanner;

public class MethodEx3 {

	// MethodEx3를 생성하고 아래처럼 구현해보세요
	/*
	 * main()에서 여러분의 이름과 출력할 count(정수)를 입력받아 카운트만큼 이름을 출력하도록 메서드를 정의하세요. 잘 봐야할 부분은 이
	 * 메서드는 주어진 숫자만큼 이름을 출력하는게 주 기능입니다.
	 */

	static Scanner sc = new Scanner(System.in);

	/*
	 * static void namecount(String name, int count) {
	 * 
	 * for (int i = 0; i < count; i++) { System.out.println(name); } }
	 */
	
	
	static int[] makeIntArr(int length) {
		
		int[] arr = new int[length];
		for(int i=0; i<length; i++) {
			arr[i] = (int)((Math.random()*30)+1);
		}		
		return arr;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {

		/*
		 * String name = ""; int count;
		 * 
		 * System.out.println("이름을 입력하세요."); name = sc.next();
		 * 
		 * System.out.println("몇 번 출력할까요?"); count = sc.nextInt();
		 * 
		 * namecount(name, count);
		 */
		
		//생성될 배열의 길이를 int로 받아서 해당 길이만큼의
		//배열을 생성 후 Math.random() 을 이용해서 1~30 사이의 정수를 
		//랜덤하게 각 index에 담은 후 결과 배열을 리턴하는 메서드를 정의 및 호출
		//결과까지 확인하세요.
		
		//(int)((Math.random()*30)+1);
		
		
		int length;
		System.out.println("배열의 element수 입력 :");
		length = sc.nextInt();		
		Arrays.toString(makeIntArr(length));
		

	}

}