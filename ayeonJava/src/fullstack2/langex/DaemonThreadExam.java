package fullstack2.langex;

class UserThread extends Thread {
	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("난 내 할 일을 할 뿐...");
		}
		
	}
}
public class DaemonThreadExam {

	public static void main(String[] args) {
		UserThread userT = new UserThread();
		userT.setDaemon(true);
		userT.start();
		
		for(int i = 0 ; i<5; i++) {
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("main()의 작업 " + i);
		}
		System.out.println("메인 쓰레드 종료함");

	}

}
