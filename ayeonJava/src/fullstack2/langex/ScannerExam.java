package fullstack2.langex;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ScannerExam {

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("수 입력");
		try {
			Scanner sc = new Scanner(new File("data1.txt"));
			int sum = 0;
			int cnt = 0;
			while(sc.hasNextInt()) {
				sum += sc.nextInt();
				cnt++;
			}
			
			System.out.println("파일의 총합 : " + sum);
			System.out.println("int의 카운트 수 : " + cnt);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("파일명 제대로 입력헤!!!!!");
		}
		
	}

}
