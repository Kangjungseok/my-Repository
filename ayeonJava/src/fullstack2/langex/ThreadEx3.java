package fullstack2.langex;

import javax.swing.JOptionPane;

/*
 * 이 클래스에 직렬로 수행되는 작업과 병렬로 수행되는 작업의 차이점을 알아보고
 * 병렬로 처리(즉, 다중 쓰레드로 처리 시) 발생되는 문제점도 알아봅니다.
*/



class ThreadEx3_1 extends Thread {

	public void run() {
		for (int i = 0; i <= 10; i++) {
			try {
				Thread.sleep(500);

				System.out.println(getName() + "쓰레드 run 값 :" + i);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}

class ThreadEx3_2 implements Runnable {
	
	@Override
	public void run() {
		for(int i = 0 ; i<1000 ; i++) {
			System.out.print("-");
			for(int j=0; j<100000; j++);			
		}
	}
}
class ThreadEx3_3 implements Runnable {
	
	@Override
	public void run() {
		for(int i = 0 ; i<1000 ; i++) {
			System.out.print("|");
			for(int j=0; j<100000; j++);			
		}
	}
}
public class ThreadEx3 {

	public static void main(String[] args) {

		/*
		ThreadEx3_1 thread = new ThreadEx3_1();
		// 쓰레드에 이름을 부여합니다.
		// 얘는 반드시 start() 전에 부여되어야 합니다.
		thread.setName("Ahyun");
		thread.start();

		String input = JOptionPane.showInputDialog("아무 값이나 입력");
		System.out.println("입력된 값은 : " + input);
		*/
		
		System.out.println("main의 우선순위 : " +  Thread.currentThread().getPriority());
		
		
		Thread t1 = new Thread(new ThreadEx3_2());
		Thread t2 = new Thread(new ThreadEx3_3());
		
		t1.setPriority(Thread.MIN_PRIORITY);
		t2.setPriority(Thread.MAX_PRIORITY);
		
		
		t1.start();
		t2.start();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
