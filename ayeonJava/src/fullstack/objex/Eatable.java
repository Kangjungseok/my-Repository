package fullstack.objex;
/*
 * interface : 자바에서 다중 상속을 목적으로 하는 개념
 * 클래스간의 상속은 단일 상속만 가능하기에, 다중 상속을 하는 경우엔, 위처럼 interface를
 * 이용해서 합니다.
 * 
 * 일단 이러한 목적 때문에, interface는 클래스와 다른 구조를 갖는데 아래와 같습니다.
 * 
 * 1.생성자를 가질 수 없습니다. 따라서 자신의 인스턴스를 생성 못 합니다.
 * 2.필드와 메서드를 가질 수 있는데, jdk 1.8 미만 버전에서는 모두 static과 abstract 이어야만 합니다.
 * 하지만 jdk 1.8 이상 부터는 다른 형태도 가질 수 있는데, 이는 나중에 다시 설명할게요
 * 일단 인터페이스의 필드는 모두 public  static final , 메서드는 public 추상이라고 생각하세요.
 * 3.인터페이스간의 상속은 다중으로 가능합니다.
 * 즉 interface A는 B,C,D,...,n개의 interface를 extends 키워드와 ","를 통해 상속 가능합니다.
 * 4.클래스는 인터페이스를 상속 할 때, implements 라는 키워드를 이용해서 하게됩니다.
 * 이 때, 하나 이상의 인터페이스를 상속 받을 수도 있는데 선언코드는 아래처럼 합니다.
 * ex> class A extends B implements A,B,C,D,...,n개의 interface..
 * 
 * 위에서 주의해야 할 것은 인터페이스는 생성자가 없기에 절대 자신의 인스턴스를 생성 못 합니다.
 * 하지만 상속을 했기에, 상속받은 하위 클래스의 Super Type으로는 항상 존재 가능한 것을 꼭 기억하세요.
 *  
 *  
 *  
 * 
*/
public interface Eatable {//인터페이스명은 일반적으로 형용사를 사용합니다. 꼭 그렇진 않지만..
	
	
	//필드를 선언합니다.. 여기 선언된 필드는 무조건 public static final입니다.
	int MAX_ENERGY = 100; //아래와 같음..
	public static final int MIN_ENERGY = 0;
	
	
	void eat();//컴파일 시에 컴파일러가 무조건 public abstract를 넣어줍니다. 
}
