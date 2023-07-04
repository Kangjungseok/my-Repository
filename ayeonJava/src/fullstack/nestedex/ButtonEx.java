package fullstack.nestedex;
/*
 * 중첩 인터페이스 : 말 그대로 클래스 내부에 정의된 interface를 말합니다.
 * 자바에서는 주로, GUI에서 사용되는 이벤트를 처리하기 위해서 많이 사용하는데
 * 클래스 내부에 특정 기능을 수행하는 추상메서드를 가지고 있는 인터페이스를 정의해서
 * 해당 인터페이스를 외부에 노출하여, 이 인터페이스가 가지고 있는 추상메서드를 구현하는 객체
 * 즉 구현 객체를 정의하는데 사용합니다.
 * 
 * 이렇게 하는 이유는 예를 들어 버튼이라는 객체가 클릭이라는 이벤트가 발생할 때 
 * 이벤트 핸들링을 하는 요소를 다른데 두어도 되지만, 내부에 두고, 이벤트가 발생 시
 * 해당 인터페이스가 그 이벤트에 대응하는 메서드를 다른 클래스(즉 사용하는 클래스)에서
 * 즉시 구현객체를 구현하도록 하는데 있습니다.
 * 
 *  접근제어는 다른 것과 같이 public private default static 가능합니다.
*/
public class ButtonEx {
	
	//정적 멤버 interface 정의합니다.
	public static interface MyClickListner{
		//onclick()이라는 추상 메서드 선언합니다.
		void onclick();
	}
	
	private MyClickListner myClickListner;
	
	//특정 컴포넌트(GUI를 구성하는 모든 애들을 자바에서는 컴포넌트라고 합니다)
	//특정 컴포넌트에 리스너를 등록하게 하는 메서드를 두고, 해당 리스너객체는
	//위에서 정의한 clickListener 인터페이스 객체를 파라미터로 줍니다.
	public void setMyClickListener(MyClickListner myClickListner) {
		this.myClickListner = myClickListner;
	}
	
	public void click() {
		this.myClickListner.onclick();
	}
	
	
	
	
}
