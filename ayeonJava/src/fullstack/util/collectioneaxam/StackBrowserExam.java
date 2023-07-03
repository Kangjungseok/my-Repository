package fullstack.util.collectioneaxam;

import java.io.IOException;
import java.util.Stack;

/*
 * 이 클래스는 브라우저의 back, forward의 기능을 stack 이용해서
 * 처리하는 예제입니다.
 * 
 * 각 기능은 메서드로 분리할 예정인데, 현재 어떤 사이트에 머물고 있는지는 문자열로
 * 출력하도록 할게요.
 * 
 * back, forward를 구현하기 위해서는 2개의 stack 구조가 필요합니다.
 * 
 * 나머지는 필요시 주석 넣을게요.
*/
public class StackBrowserExam {
	//static으로 Stack 2개 생성해보세요. (back, forward)
	private	static Stack<String> back = new Stack<>(); 
	private static Stack<String> forward = new Stack<>(); 
	static Runtime runtime = Runtime.getRuntime();

	//아래의 메서드는 현재 각 stack의 state를 문자열로 출력하도록 정의합니다.
	private static void printState() {
		System.out.println("back 내의 URL : " + back);
		System.out.println("forward 내의 URL : " + forward);
		//현재 사이트의 이름만 필요하기 때문에 remove 되면 안 됩니다. 해서 peek() 호출함
		System.out.println("현재 내가 머물고 있는 SITE : " + back.peek());
	}
	
	//웹브라우저의 Locator에 URL을 입력하는 기능의 메서드 정의합니다.
	private static void goSite(String url) throws IOException  {
		//url로 이동을 하기 때문에, back으로 되돌릴 시 에 필요한 URL 정보를 back에 저장함
		//당연히 Top에 저장해야 합니다.
		//runtime.exec("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe http://daum.net "+url);
		back.push(url);
		if(!forward.empty())
			forward.clear();
	}
	
	//브라우저의 forward 기능을 정의합니다.
	//이 기능은 이미 forward stack에 URL이 존재하는 경우에만 
	//브라우저에서 버튼이 활성화 되어있기 때문에, 따로 URL을 받지 않습니다.
	private static void goForward() {
		//forward에 값 존재 여부 확인 후 pop() 호출합니다.
		if(!forward.isEmpty()) {
			//forward 수행 시 이동. URL은 다시 back에 저장되어야 합니다.
			back.push(forward.pop());
		}
	}
	
	//이번엔 back 버튼 기능 메서드 정의
	//forward와 반대로 생각하시면 됩니다.
	private static void goBack() {
		if(!back.empty()) {
			forward.push(back.pop());
		}
	}
	
	
	public static void main(String[] args) {
		
		//RunTime 클래스를 이용해서 브라우저를 직접 실행 해볼게요.
		//"C:\Program Files\Google\Chrome\Application\chrome.exe"
		Runtime runtime = Runtime.getRuntime();
		
		try {
			goSite("1.다음");
			printState();
			goSite("2.네이버");
			printState();
			runtime.exec("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe http://naver.com");
			
			goBack();
			printState();
			goForward();
			printState();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	
		//printState();
		
		
		
		
	}

}
