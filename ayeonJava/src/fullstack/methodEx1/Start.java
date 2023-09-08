package fullstack.methodEx1;

import java.util.Scanner;

public class Start {

	static Scanner sc = new Scanner(System.in);
	
	
	
	void hello() {
		System.out.println("가위바위보 게임을 시작합니다!! \n입력 메뉴 : 가위, 바위, 보 \n엔터를 치면 시작합니다!");
		sc.nextLine();  // 엔터
		System.out.println("값을 입력하세요 : ");
		
	}
}
