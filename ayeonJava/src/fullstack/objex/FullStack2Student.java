package fullstack.objex;
/*
 * 하나의 자바 파일 내에는 하나 이상의 클래스를 정의할 수 있습니다.
 * 이 때 파일명과 같은 이름을 가진 클래스가 대표 클래스가 되고, public이란 키워드는 
 * 반드시 대표 클래스만 선언할 수 있습니다.
 * 또한 이 대표 클래스에만 main()을 가질 수 있습니다. 꼭 기억하세요. 
*/
class A {
	
}
class B {
	
}
//이 클래스는 우리반 학생들을 정의한 클래스입니다.
public class FullStack2Student {

	//이 영역(클래스 영역 내부)에 선언된 변수는 field라고 합니다.
	//field도 2가지로 구분되어질 수 있는데, static 붙은 경우엔 static 필드
	//그렇지 않은 경우엔 member field로 구분합니다. 꼭 기억하세요.
	//member 필드는 이 클래스를 바탕으로 생성되어지는 instance가 생성되는 시점에
	//모두 복사되어서 해당 인스턴스의 속성으로 표현되어집니다.
	//이 때 특정값으로 이 필드를 초기화 하지 않을 시엔, 모두 해당 타입의 기본값으로
	//초기화 되어집니다. 이렇게 생성된 instance 즉 객체를 기본객체라고 합니다.(꼭 기억)
	
	//멤버필드 정의해 봅니다. 필드는 이 클래스의 객체가 가져야 할 공통 기본 속성을 정의하는데서 시작합니다.
	
	String name;//학생의 이름을 나타낼 필드 선언
	char gender;//성별
	String phoneNum;//
	int age;
	
	void speakName() {
		System.out.println("내 이름은 : " + name);
	}
	

	
	
	public static void main(String[] args) {
		//인스턴스를 생성시엔 new 라는 키워드와 함께 생성될 인스턴스의 className+() 를
		//코드로 정의하면 VM이 프로그램 실행 시에(매우 중요) heap 영역에 생성해주게 됩니다.
		//이렇게 생성된 인스턴스는 위에서 정의한 멤버필드를 모두 복사해 가지고 가게되며
		//기본적 값으로 세팅하게 됩니다.
		//또한 이렇게 생성된 인스턴스는 꼬리표로 항상 내가 어떤 타입의 인스턴스인지를
		//나타내기 위해 인스턴스의 원형 클래스 타입을 항상 가지고 다닙니다. (꼭 꼭 꼭 기억)
		//즉 이 말은 모든 인스턴스는 자신을 생성한 바탕이 되는 classType을 매우 중요하게
		//생각한다는 말입니다. (반드시 * 1000000000 기억하세요)
		
		//제일 먼저 나를 표현하는 instance를 생성하고 그 hashcode 값을 확인합니다.
		FullStack2Student kause = new FullStack2Student();//instance화, instantiating 이라고 합니다.
		System.out.println(kause);
		kause.name = "강정석";//속성에 값 대임합.
		kause.age = 27;
		kause.speakName();
		//System.out.println(kause.name);//속성호출함.
		System.out.println(kause.age);//나이속성호출함
		
		FullStack2Student hank = new FullStack2Student();
		//짝 객체를 생성해서 속성값을 대입해봅니다.
		hank.name = "김한규";
		hank.age = 30;
		hank.speakName();
		//System.out.println(hank.name);//속성호출함.
		System.out.println(hank.age);

		
		
		
		
		
		
		
	}

}
