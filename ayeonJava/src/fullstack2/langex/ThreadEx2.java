package fullstack2.langex;
/*
 * 쓰레드를 만드는 방법 2가지
 * 
 * 1. Thread 클래스를 직접 상속 받아서 run() 오버라이드 및 start() 호출
 * 
 * 2. Runnable interface를 상속 받은 클래스가 run() 오버라이드 후
 * Thread 클래스의 생성자로 들어가서 수행되는 방법
 * 
 * 
*/
class ThreadEx2_1 extends Thread{//쓰레드의 자식 타입이 되어 run() override
	
	@Override
	public void run() {
		for(int i = 0 ; i<=5; i++) {
			//이 클래스가 Thread 자식타입이라 상속 받은 메서드중 현재
			//CPU가 실행중인 Thread의 이름을 리턴받는 getName() 호출하여 
			//쓰레드 이름을 출력합니다.
			System.out.println(getName());
		}
	}
}

//Runnable을 상속 받아 run() 오버라이드
class ThreadEx2_2 implements Runnable{
	@Override
	public void run() {
		for(int i = 0 ; i<=5; i++) {
			//쓰레드의 직접 자식이 아니라서 static 메서드 중 
			//현재 running 중인 쓰레드 객체를 리턴받는 메서드 호출하여
			//이름을 출력합니다.
			Thread runningThread = Thread.currentThread();
			System.out.println(runningThread.getName());
			
			//아래는 한 방 코드 
			//System.out.println(Thread.currentThread().getName());
		}
		
	}
}

public class ThreadEx2 {

	public static void main(String[] args) {
		
		
		System.out.println("메인 쓰레드의 이름 : " + Thread.currentThread().getName());
		
		//Thread 객체 생성 1번
		ThreadEx2_1 thread1 = new ThreadEx2_1();  
		thread1.start();//쓰레드의 상태를 뉴로 설정했으니
		//VM에게 Runnable 상태로
		//보내달라고 요청하는 메서드 start() --> 프로그래머가 이것만 호출하면 됨
		
		//Thread 객체 생성 2번
		//Runnable 을 상속한 객체를 쓰레드 객체에 탑재하는 방법
		Thread thread2 = new Thread(new ThreadEx2_2());
		thread2.start();
		
		
		

	}

}
