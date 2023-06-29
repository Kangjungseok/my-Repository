package fullstack2.langex;

class VeryBusyThread extends Thread{
	
	//얘가 현재 업무를 하고 있는 중인지의 여부를 갖는 flag 필드 선언할게요
	public boolean isWorking = true;//이 쓰래드가 업무 중이라면 true, 쉬는 중이라면 false
	
	public VeryBusyThread(String name) {
		setName(name);
	}
	
	@Override
	public void run() {
		while(true) {
			if(isWorking) {
				try {
					Thread.sleep(300);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(getName() + "이 열심히 작업중임///");
			}else {
				//작업중이 아니니깐, 다른 쓰래드에게 CPU 점유를 양보하고 자신은
				//실행대기 영역으로 전이함.
				Thread.yield();
				
			}
		}
	}
	
	
	
}
public class ThreadEx5 {

	public static void main(String[] args) {
		
		VeryBusyThread json = new VeryBusyThread("JSON");
		VeryBusyThread son = new VeryBusyThread("MR.Son");
		
		json.start();
		son.start();
		
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		json.isWorking = false;
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		json.isWorking = true;
		
		
		
	}

}
