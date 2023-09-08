package fullstack2.langex;


class CalThread extends Thread{
	private int total;
	
	public int getTotal() {
		return total;
	}
	
	@Override
	public void run() {
		for(int i = 1; i<=100; i++) {
			total+=i;
		}
		System.out.println(this.getName() + "쓰레드 종료됨");
	}
	
	
}










public class ThreadEx4 {

	public static void main(String[] args) {

		System.out.println("메인쓰레드 시작함");
		//위 CalThread 를 생성해서 연산작업 수행토록 함
		CalThread thread = new CalThread();
		thread.start();
		
		try {
			thread.join();//이 메서드를 호출한 쓰레드에게 main은
			//CPU 점유를 양보하고 일시정지 영역으로 전이합니다.
			//VM은 위 쓰레드가 run()을 모두 완료하면 자동으로
			//아래의 예외를 발생시켜서 main을 깨우고, main은
			//나머지 작업을 수행합니다.
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println("1~100까지의 누적합 : " + thread.getTotal());
		System.out.println("메인 쓰래드 종료됨");
		

	}

}
