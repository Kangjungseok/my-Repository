package firstweb.lambda;

/*
 * 자바 람다 interface : 먼저 람다 함수라는 개념부터 알아볼게요.
 * 람다함수는 말 그대로 함수(function) 입니다.
 * 메서드는 아니란 뜻..
 * 
 * 이 함수는 자바스크립트에서 파생되었고, 요즘은 거의 모든 언어에서 사용합니다.
 * 
 * 이게 뭐하는 애냐면, 쉽게 말할게요... 그냥 익명 객체를 구현하는 형태라고 생각하면 편합니다.
 * 
 * 익명객체가 이름이 없는 객체를 뜻하듯이, 함수명이 없이 선언된 함수를 특정 데이터영역을 이 함수를
 * 통해서 구현하게끔 하는 형채입니다.
 * 
 * 자바에서도 람다를 지원하는데, 규칙이 매우 엄격합니다.
 * 
 * 1. 모든 람다 함수는 인터페이스만 가능합니다.
 * 2. 람다 함수가 되는 함수를 가진 인터페이스는 무조건 람다 함수 하나만 보유해야 합니다(반드시)
 * 3. 람다 함수는 인터페이스에서 선언되었기 때문에, 당연히 body가 없겠죠??.. 구현 시에 body를 추가합니다.
 * 4. FuctionInterface 라는 어노테이션을 인터페이스 선언문 전에 선언해서 람다 인터페이스임을 선언해야 합니다.
 * 만약 안하면, 컴파일 시 위 조건을 컴파일러가 검색해서 문제 없으면 자동으로 넣어줌.
 * 5. 이전에 강의했듯이, JDK 1.8 부터는 인터페이스에서 static 메서드를 이용해서 메서드 body를 가질 수 있고,
 * default 키워드를 통해서 기본 메서드 또한 가질 수 있습니다.
 * 즉 위 예를 종합하면, 람다 인터페이스는 총 3종류의 메서드를 보유할 수 있는데, 위 두개와 하나의 람다함수입니다.
 * 더 이상 보유하게 되면 에러입니다.
 * 
 * 
 * 문법 : (파라미터1,2,,,,,,n) -> {파라미터 처리식}
 * 위 문법에서 파라미터가 하나도 없을 경우엔 () 처리합니다. 그리고, 로직이 있는 경우엔 -> 를 통해 
 * {구현 로직} 을 정의한다라고 선언하는 방식입니다.
 * 
 * 여기서 ->는 반드시 넣어야하며, 저는 -> 를 메서드 명이라고 생각하니깐 쉽게 이해됨.
 * 
 * a + b 결과값을 받아서 다음 로직에서 처리를 해야 한다면???
 * 
 * int sum(int a, int b) {
 * 	return a+b;
 * }
 * 
 * (a,b) ->{a + b}
 * 
 * 
 * 만약 파라미터가 하나인 경우엔 괄호를 생략해도 됨.
 * 만약 구현부가 하나의 수행문인 경우엔 {}도 생략가능함.
 * a -> return a == 0?a:1
 * 
 * 만약 파라미터가 없을 경우엔?? () -> {} 처럼 빈 괄호를 이용해야 합니다.
 * 즉 파라미터 위치값은 반드시 존재해야 한다는 것입니다.
 * 
 * 
 */

class MyRun implements Runnable{
	@Override
	public void run() {
		System.out.println("러너블 쓰레드 시작함");
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("러너블 쓰레드 끝");
	}
}
public class LamEx1 {

	public static void main(String[] args) {
		Thread t = new Thread();// run() 없으니깐 아무 것도 안 함.
		
		//Runnable 객체를 파람으로 받는 쓰레드 객체를 생성할게요.
		Thread runnableT = new Thread(new MyRun());
		runnableT.start();
		
		Thread annonyT = new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("익명2 쓰레드 시작함");
				
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("익명2 쓰레드 끝");
			}
		});
		annonyT.start();
		
		
		
		//람다로 정의해볼게요.
		Thread lam = new Thread( () -> {
			System.out.println("람다러너블 쓰레드 시작함");
			
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("람다러너블 쓰레드 끝");
		}); 
	
	
		
		
		
		
		
		
		
		
	
	}

}



























