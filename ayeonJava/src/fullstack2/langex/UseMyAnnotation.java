package fullstack2.langex;


public class UseMyAnnotation {

	@MyAnnotation2
	public void doSome() {
		System.out.println("doSome1 실행문");
	}
	@MyAnnotation2(value = "&&&&&&&")
	public void doSome2() {
		System.out.println("doSome2 실행문");
	}
	@MyAnnotation2(value = "$$$$$$", number = 30)
	public void doSome3() {
		System.out.println("doSome3 실행문");
	}
	
	
}
