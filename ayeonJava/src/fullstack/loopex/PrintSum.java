package fullstack.loopex;

import java.util.Scanner;

public class PrintSum {

	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		int small, big, box;
		int total = 0;
		
		System.out.println("첫 수 입력 : "); 
		small = sc.nextInt();
		System.out.println("두 번쨰 수 입력 : "); 
		big = sc.nextInt();

		
		if(small > big) {
			box = small;
			small = big;
			big = box;
		}
		
		box = small;
		
		
		for(int i=small ;i<=big; i++) {
			
			total += i;
			
		}
		
		System.out.println(total);
		
		

		
		
	}

}
