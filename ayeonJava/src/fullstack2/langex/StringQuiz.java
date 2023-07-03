package fullstack2.langex;

import java.util.Scanner;

import fullstack.ifex.IfExam;

/*
 * StringQuiz 클래스를 생성해서 다음처럼 작성하세요.
 * 
 * 프로그램 시작하면, 이메일 입력하라고 띄우고, 값 받으세요.
 * @ 없으면, 없다고 메세지 후 종료
 * 있다면, id와 서버 분리하세요.
 * id 검증하세요. 8~12 사이여야하고, 반드시 첫자는 대문자여야하고,
 * 값중에 하나는 반드시 숫자가 포함되어 있어야 합니다.
 * 
 * 위 검증로직을 완성 후, 모두 올바르면 마지막으로 입력된 서버값을
 * .을 기준(ex : no777@abc.com or .net 입력시..)으로 
 * 메일서버명을 fullstack.com으로 모두 변경해서
 * 변경된 이메일 값을 축 회원 가입 aabc@fullstack.com 님으로 출력시키세요.
 * 만약 위 조건중 하나라도 어긋나면 뭐가 문제인지 출력시키세요.
 * 
*/
public class StringQuiz {


	
	
	static Boolean isthereAt(String email){
		if(email.indexOf("@") == -1) {//indexof 에서 없으면 -1 리턴
			return true;
		}else return false;
	}
	
	static String splitId(String email){
		email= email.substring(0, email.indexOf("@"));
		return email;
	}
	
	static Boolean checklength(String email){//false 라면 안된다는 메세지 출력문 필요
		if(email.length()>= 8 && email.length()<=12) {
			return true;
		}else return false;
	}
	
	static Boolean isfirstCap(String id){
		if(id.charAt(0) >='A' && id.charAt(0) <='Z') {
			return true;			
		}else return false;
	}
	
	static Boolean isthereNum(String id){
		int digit = 0;
		char[] idToChar = id.toCharArray();
		for (int i =0; i<id.length();i++) {
			  if(Character.isDigit(idToChar[i])) {
				  digit++;
			  }
		}
		return digit>=1;
	}
	
	
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		
		/*
		System.out.println("이메일을 입력하세요 : ");
		String email = sc.next();
		if(email.indexOf("@") == -1) {
			System.out.println("@ 없음");
			return;
		}
		
		char[] id = email.substring(0,email.indexOf("@")).toCharArray();
		int dCount = 0;
		int uCount = 0;
		for(char value : id) {
			if(dCount >= 1 && uCount >= 1) {
				break;
			}
			if(Character.isDigit(value)) {
				dCount++;
			}else if(Character.isUpperCase(value)) {
				uCount++;
			}
		}
		*/
		
		
		System.out.println("이메일을 입력하세요 : ");
		String email = sc.next();
		
		if(isthereAt(email)) {
			String id = splitId(email);
			if(checklength(id)) {
				
				if(isfirstCap(id)){
					
					if(isthereNum(id)) {
						System.out.println("축! 회원가입 성공!");
					}else {
						System.out.println("숫자가 포함되어야 합니다.");
					}
					
				}else {
					System.out.println("첫 문자는 대문자여야 합니다.");
				}
				

			}else {
				System.out.println("8~12의 길이로 입력해주세요.");
			}
			
		}else {
			System.out.println("@을 넣어주세요!");
		}
		
		

	}

}
