package fullstack.nestedex;

import javax.swing.ButtonModel;

/*
 * 자바 중첩클래스(인터페이스)
 * 
 * 자바에서는 클래스 내부에 클래스 or Interface를 중첩(nested) 정의할 수 있습니다.
 * 이러한 형태를 중첩클래스라고 합니다.
 * 
 * 이렇게 정의하는 이유는 클래스의 속성의 값중 일반적인 값으로는 처리하기 어려운 경우
 * 내부적으로 중첩클래스를 정의해서 사용하거나, 아니면 특정 클래스에만 종속되어지게 하는 경우
 * 중첩 클래스를 정의해서 사용합니다.
 * 
 * 이렇게 하면 코드의 복잡성을 내부에 구현하고, 외부에서는 쉽게 사용할 수 있는 장점이 생깁니다.
 * 
 * 또한 중첩클래스는 외부 클래스의 멤버 등을 쉽게 사용(접근) 할 수 있는 장점 또한 갖게됩니다.
 * 
 * 쉽게 개념을 갖게 하기 위해서 외부클래스는 Outer class, 내부를 Inner class(중첩된 클래스)로
 * 통칭할게요.
 * 
 * 아래는 중첩 클래스의 종류입니다.
 * 
 * 멤버클래스 : <-- 얘는 다시 일반 인스턴스 클래스와 정적(static)으로 구분되어집니다.
 * 
 * 멤버클래스는 형태가 클래스의 멤버의 자리에 정의되어지기 때문에 멤버라고 합니다.
 * 이 멤버 클래스는 외부 클래스 밖(즉, 다른 클래스에서) 중첩 클래스를 필요에 따라서 인스턴스화 
 * 할 수 있습니다.
 * 
 * 이 중 인스턴스 중첩 클래스는 객체를 생성하기 위해서는 반드시 외부객체를 생성 후 Inner 객체를 생성해야 하고,
 * 정적Inner는 이와는 반대로 외부 객체 없이 외부클래스 명으로 인스턴스 생성 가능합니다. 
 * 
 * 다른 하나는 local 클래스로 구분되어집니다.
 * Local 클래스는 말 그대로 지역(생성자나 메서드 내부)에서 정의되어지는 클래스를 말합니다.
 * 
 * 이 클래스는 외부에서 인스턴스를 생성 못 하고, 해당 클래스가 정의된 메서드나 생성자가 수행되어야만 
 * 인스턴스가 생성되고, 메서드가 끝나면 인스턴스 역시 사라지는 특징을 갖습니다.
 * 
*/
public class NestedClassEx1 {

	public static void main(String[] args) {
		// 멤버 Inner 클래스의 인스턴스를 외부에서 생성해보기
		A outer = new A();

		// A의 Inner인 B 인스턴스 생성해보기
		A.B inner = outer.new B();

		// AA의 static inner 클래스의 instance 생성하기.
		// static이라는 특성 때문에, Outer 인스턴스는 필요없다.
		AA.BB bb = new AA.BB();

		// 중첩 interface를 이용하는 예제입니다.
		Button sayHello = new Button();

		class SayMsg implements Button.MyClickListner {

			@Override
			public void onclick() {
				System.out.println("안녕하십니까. 조금만 기다리시면 점심시간입니다.");
			}

		}// end of 구현객체 클래스

		
		// 버튼에 이벤트를 등록합니다.
		sayHello.setMyClickListener(new SayMsg());
		// 버튼을 클릭해볼게요.
		sayHello.click();

		/*
		 * 익명중첩 클래스 : 말 그대로 이름이 없는 중첩 클래스입니다. 얘는 정말 많이 사용되는 형식으로 꼭 기억하세요. 지금까지는 class
		 * className 이라는 형식으로 중첩해서 필요시 instance를 생성하여 사용했는데, 이 익명 클래스는 이름이 없는 아이이기 때문에
		 * 객체를 ref 할 수가 없습니다. 따라서 한 번만 사용하고 버리는 형태입니다. (즉,필요시에 해당 타입의 인스턴스를 생성(익명구현객체) 후
		 * 한 번만 사용 후 버리는 형태입니다.)
		 * 
		 * 이 익명 객체는 클래스, 인터페이스 등을 가리지 않고 만들어낼 수 있습니다.
		 * 
		 */

		Button sayHello2 = new Button();
		// 버튼에 이벤트를 등록합니다.
		sayHello.setMyClickListener(new Button.MyClickListner() {
			
			@Override
			public void onclick() {
				// TODO Auto-generated method stub
				System.out.println("이건 익명객체가 오버라이드 한 내용입니다.");
			}
		});
		// 버튼을 클릭해볼게요.
		sayHello.click();

		
		
		MyAbstract my = new MyAbstract() {
			@Override
			public void abstractMethod() {
				System.out.println(a);
			}
		};
		my.abstractMethod();
		

		
		//로컬클래스 테스트
		LocalInnerEx lo  = new LocalInnerEx();
		
		lo.outterMethod(10);
		

		
		
	}

}
