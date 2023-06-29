package fullstack2.langex;

public class ThreadEx1 {

	
	static void save() throws InterruptedException {
		Thread.sleep(1000*10);
		System.out.println("문서를 저장합니다.");
	}
	public static void main(String[] args) throws InterruptedException {
		
		for(int i = 0 ; i<=10;i++) {
			Thread.sleep(1000);//1초동안 멈추기
			
			if(i == 5) {
				//저장하기 메서드 호출
				save();
			}
			System.out.println("i 값" + i);
			
		}

	}

}
