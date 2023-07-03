package fullstack.nestedex;
/*
 * local class : 말 그대로 지역(local)에서 정의하는 클래스를 말합니다.
 * 클래스에는 지역({})을 가질 수 있는 코드는 생성자와 메서드 밖에 없습니다.
 * 당연히 클래스는 가능하고요...(이 안에 정의한 inner는 멤버라고 하죠??)
 * 
 * 이렇듯 생성자나 메서드 내부에 정의된 클래스를 로컬인너클래스라고 합니다.
 * 
 * 이 클래스는 지역 내에 정의되기 때문에 인스턴스를 실행할 수 있는 방법은
 * 해당 생성자 또는 메서드를 호출할 때 외에는 없습니다.
 * 
 * 문법도 중요하지만 꼭 하나 기억해야 할 건, 지역 클래스가 존재하는 메서드 내에서 선언된
 * 지역변수는 묵시적으로 final로 선언되어지고, 컴파일되어집니다.
 * 
 * 따라서 값을 읽을 순 있지만, 쓰지는 못합니다.
*/
public class LocalInnerEx {
	
	public LocalInnerEx() {
		class LocalInner1{
			int a = 1;
			
			void doSome() {
				System.out.println("생성자 지역 클래스 "+ this.a);				
			}
		}
		
		new LocalInner1().doSome();
	}
	
	void outterMethod(int a) {
		int k  = 10;
		class LocalInner1{
			int b =1 ;
			
			void doSome2() {
				System.out.println("메서드 지역 클래스 : " + this.b);
				//System.out.println(++a);//지역변수는 로컬inner 에서는 final이다.
			}
		}
		new LocalInner1().doSome2();
	}
	
}
