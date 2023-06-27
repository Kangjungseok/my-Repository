package fullstack.objex;
/*
 * static : 정적이란 뜻으로 class(중첩만 가능함), field, method에 모두 사용가능합니다.
 * 이 중 클래스에는 중첩클래스(나중에 배움)에만 가능하단걸 꼭 기억하세요.
 * 
 * static의 main()이 호출되기 전에 VM이 먼저 호출하여 초기화 하는 키워드 입니다.
 * 이후 main()이 호출되고, 프로그램 시작 --> 인스턴스 생성 등의 과정을 거칩니다.
 * 
 * 때문에 static이 붙은 애들은 소유권을 클래스로 생각하시면 됩니다.
 * 즉 static은 인스턴스 생성 없이 사용 가능하다는 것으로 생각하면 됩니다.
 * 또한 위에서 처럼, 초기화 단계가 인스턴스와는 차이가 나기 때문에 호출이나, 접근하는데도
 * 주의를 해야합니다. 
 * static -> member 접근 불가능
 * member -> static 접근 가능. 이렇게 외우세요.
 * 
 * 
 * static 메서드를 정의하는 이유 : 
 * 기본적으로 인스턴스를 만들기 위해 클래스를 정의할 때,
 * 인스턴스 필드, 메서드는 필드의 값이 가공이 되어질 필요가 있을 때, 즉 인스턴스의 상태의 값이 
 * 변경이 필요할 때는 필드나, 메서드를 멤버로 설계합니다.
 * 
 * 하지만 static 메서드인 경우엔, 객체가 생성되지 않아도 클래스 명으로 접근 및 호출 가능한 
 * 특징 때문에 인스턴스의 필드의 값을 변경할 때는 사용되지 않고, 필드에 영향이 없는 경우
 * static으로 정의해서 사용하는게 일반적입니다.
 * 
 * 즉 정리를 하자면, static 필드는 공유의 목적으로, static 메서드는 멤버필드의 연산 등이 아닌
 * static 필드나 기타 다른 목적의 기능이 필요할 때 정의해 사용한다라고 기억하세요.
 * 
*/

public class StaticExam {

	
	static int a; // static field는 클래스거. 공유의 목적
	
	int b; //멤버필드로 b 선언함.
	
	
	
	//클래스가 로드된 후 호출되는 초기화 과정을 먼저 보여드릴게요
	/*
	 * static {// 이 블락은 인스턴스 블락입니다.. 그냥 그렇게 알고계세요. a++; }
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(StaticExam.a++);
		System.out.println(StaticExam.a++);
		
		StaticExam aa = new StaticExam();
		System.out.println(new StaticExam().b++);
		System.out.println(new StaticExam().b++);
	
		
		

	}

}
