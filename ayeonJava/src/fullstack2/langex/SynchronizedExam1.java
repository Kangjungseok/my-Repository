package fullstack2.langex;
/*
 * 이 클래스에서는 하나 이상의 쓰래드에서 공유하는 공유 객체의 필드값이
 * 경쟁하는 쓰래드에 의해 변경되면서 발생되는 문제점을 확인하는 클래스입낟.
 * 여기서 이해를 해야 하는 부분은
 * 1. 공유객체의 개념
 * 2. 공유객체가 공유하는 것 : Only Member field만 가능함
 * 3. 하나의 객체를 하나 이상의 쓰래드에게 공유 시키는 방법
 * 
 * 이 세가지를 먼저 이해해야 합니다. 
*/

//여기엔 공유 목적의 클래스를 정의할게요.

class Calculator1 {

	// 공유 목적의 필드 선언.
	private int sharedField;

	/*
	 * synchronized 키워드. 메서드 리턴문 앞에 붙이면, 해당 메서드는 먼저 점유한 쓰레드가 run()을 완전히 종료할 때까지 객체에
	 * 락을 걸어버립니다. 이렇게 되면 경쟁 쓰레드는 이 메서드를 접근 못하게 되는데, 이 메서드에 필드가 들어 있는 경우가 일반적이기
	 * 때문에(필드를 공유하기 때문에), 필드에 접근을 못 하는 것과 같게 됩니다.
	 * 
	 * 이렇게 락을 걸어서 자기 할 일을 다한 쓰레드는 대기중인 쓰레드에게 나 일 끝났어라고 알려주도록 하는 메서드가 notify(),
	 * notifyAll()입니다.
	 * 
	 * 이렇게 알려주고 일이 다 끝난 쓰레드는 wait() 호출하게 되면, CPU는 더 이상 해당 쓰레드를 CPU에 처리 대상으로 인식하지 않기
	 * 때문에, 재작업을 하지 않습니다.
	 * 
	 * 이렇게 전이된 쓰레드는 terminated 되어집니다.
	 * 
	 * 주의!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! 위 notify, notifyAll,
	 * wait은 반드시 동기화 메서드 또는 동기화 블락 내에서 호출해야 합니다. 반.드.시
	 * 
	 * 동기화 블락은 좀 있다가 설명할게요.
	 * 
	 * 동기화 블락 : 동기화 메서드와 비슷하지만, 객체 전체를 대상으로 하는데에 문법적인 차이점이 있습니다.
	 * 
	 * 동기화 블락은 synchronized(공유객체명){ 동기화 할 코드 구현 } 으로 정의하고, 이렇게 되면 위의 동기화 메서드와 같은 일이
	 * 벌어집니다.
	 * 
	 * 여기서 주의해야 할 것은, 위 동기화 메서드는 메서드 전체를 동기화 하기 때문에 경쟁쓰레드는 점유한 쓰레드가 run()을 완료할 때까지
	 * 메서드 전체를 접근 못 하지만 동기화 블락은 메서드는 접근 및 동기화 블락을 제외한 나머지 실행 영역은 수행한다는 것입니다.
	 * 
	 * 
	 */

	/*
	 * public synchronized void setField1(int value) { this.sharedField = value;
	 * 
	 * try { Thread.sleep(2000); } catch (Exception e) { e.printStackTrace(); }
	 * System.out.println(Thread.currentThread().getName() + " : " +
	 * this.sharedField); }
	 */
	public void setField1(int value) {

		// 동기화 블락 적용함.
		synchronized (this) {
			this.sharedField = value;

			try {
				Thread.sleep(2000);
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + " : " + this.sharedField);
		}

		System.out.println(Thread.currentThread().getName() + " 여긴 동기화블락이 아닌 메서드 영역입니다.");
	}

}

//위 객체를 공유하도록 하는 쓰래드 정의합니다.
class UserThread1 extends Thread {

	// 접근하려는 필드 선언
	private Calculator1 c;

	public UserThread1(Calculator1 c) {
		// 쓰래드 이름 설정
		this.c = c;
		this.setName("UserThread1 입니다");

	}

	@Override
	public void run() {
		this.c.setField1(100);
	}

}

class UserThread2 extends Thread {

	// 접근하려는 필드 선언
	private Calculator1 c;

	public UserThread2(Calculator1 c) {
		// 쓰래드 이름 설정
		this.c = c;
		this.setName("UserThread2 입니다");

	}

	@Override
	public void run() {
		this.c.setField1(50);
	}

}

public class SynchronizedExam1 {

	public static void main(String[] args) {
		Calculator1 cal1 = new Calculator1();

		UserThread1 t1 = new UserThread1(cal1);
		t1.start();
		UserThread2 t2 = new UserThread2(cal1);
		t2.start();
	}

}
