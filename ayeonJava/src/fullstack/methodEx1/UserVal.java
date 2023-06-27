package fullstack.methodEx1;

import java.util.Scanner;

public class UserVal {

	
	static Scanner sc =new Scanner(System.in);
	
	private String user;
	private int usernum;
	
	
	int userval() {
		user = sc.next();
		
		switch (user) {
		case "가위":
			usernum = 1;
			break;
		case "바위":
			usernum = 2;
			break;
		default :
			usernum = 3;
			break;
			
		}
		return usernum;
	}
}
