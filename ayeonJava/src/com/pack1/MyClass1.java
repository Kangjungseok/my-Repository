package com.pack1; // 패키지 선언문 .. 반드시 파일 첫머리에 선언되어야 합니다.
/*
 * Java Package : Package는 자바에서 Resource를 관리하는 단위입니다.
 * 서로 연관성이 있는 Resource(소스, 클래스) 등을 같은 패키지에 두고 생성하며
 * 다른 기능이 있는 패키지에서 필요시에 import 구문을 통해 가져와 사용하는 용도입니다.
 * 
 *  기본적으로 패키지 선언은 반드시 파일 첫머리에 나와야합니다.
 *  패키지명은 기본적으로 도메인명(ex>com.naver.shoppingmall....)을 거꾸로 사용하며,
 *  만약 도메인 명을 사용치 않을 때는 프로젝트명을 기준으로 패키지명을 생성합니다.
 *  
 *  반드시 소문자로 시작을 하도록 하는게 좋고, 각 패키지의 연관성에 따라서 "." 을 이용해서
 *  sub 패키지를 구성할 수 있습니다.
 *  
 *  윈도우 등에서는 패키지는 폴더처럼 보이지만 폴더와는 다른 개념이니 헷갈리지 마세요.
 *  그리고 com.pack1.pack2 처럼 pack1의 서브인 pack2를 선언해도, 위 두 패키지는
 *  다른 패키지로 인식이 되기 때문에, 소속된 API를 가져다 쓸 때는 반드시 import를 해야합니다.
 *  
 *  만약 패키지명을 주지않게 되면(안 좋은 형태), 패키지 명이 없는 default 패키지로 간주되어집니다.
 *  
 *  이 경우에 다른 패키지에서 기본패키지의 API를 가져다 사용할 수 없습니다.
 *  
 *  때문에 클래스를 정의할 때는 패키지를 반드시 선언하는게 좋습니다.
 *  
 *  다른 패키지의 API를 가져다 쓸 때는 아래처럼 구문을 선언해야 합니다.
 *  
 *  import 선언은 반드시 패키지 선언 다음에 나와야 합니다.
 *  
 *  import com.naver.shoppingmall.* --> shoppingmall 패키지의 모든 API를 import 함
 *  import com.naver.shoppingmall.Frame --> 해당 패키지의 Frame 클래스만 import 함
 *  
 *  위 두 선언문의 차이는 1번은 패키지내의 모든 API를 사용할 수 있고, 
 *  2번은 Frame만 사용가능합니다. 다른 API를 가져다 쓸 때는 다시 import를 해야 합니다.
 *  
 *  "*" --> 표시는 모든 API를 뜻합니다.
*/

/*
 * 접근제어자(Access Modifiers) : 접근제어자는 자바의 Resource(클래스, 인터페이스, 
 * 클래스와 인터페이스 내의 필드, 메서드, 생성자 등) 모든 부분에 선언되어질 수 있습니다.
 * 
 * 이 중 클래스에는 public or default (중첩 클래스는 조금 다름..나중에 배움)가
 * 올 수 있고, 인터페이스 또한 같습니다.
 * 
 * 나머지 필드, 생성자, 메서드에는 모든 접근제어자가 선언될 수 있습니다.
 * 
 * 다음은 접근 제어자 종류 및 의미입니다.
 * 
 * public > protected > default > private : 순서대로 범위가 가장 큰게 public입니다.
 * 
 * public : 다른 패키지에서도 접근 가능한 제어자.(당연히 같은 패키지는 가능함)
 * protected : 다른 패키지에서 접근 가능하지만, 반드시 상속받은 하위 클래스만 가능함
 * default : 오직 같은 패키지에서만 접근 가능함.
 * private : 오직 자신의 클래스에서만 접근 가능함.
 * 
*/


public class MyClass1 {

	public String name;
	protected String addr;
	int age;
	private char gender;
	
	
	
	private static MyClass1 mycls = new MyClass1('m');//내 주석 : class가 로드될 때 인스턴스를 생성함, static은 클래스가 로드 될 때 한 번만 호출됨.
	//자바의 싱글톤 : 인스턴스를 생성할 수 있는 생성자를 private으로 막아버리고
	//자사의 인스턴스를 자신만이 생성(딱 하나만)후 인스턴스를 외부에 메서드 등으로 전달하는 개념
	
	
	/*
	 * public MyClass1() {
	 * 
	 * }
	 */
	
	MyClass1(String name){
		this.name = name;
	}
	protected MyClass1(String addr,char gender) {
		this.addr = addr;
		this.gender = gender;
	}

	private MyClass1(char gender) {
		
	}
	
	public static MyClass1 getMycls() {
		return mycls;
	}
	
	
	
	//같은, 다른 패키지의 모든 곳에서 접근 가능함
	public void a() {
		
	}
	//다른 패키지의 상속받은 하위 클래스가 부모의 기능을 이용하고자 호출시에만 활용하도록 함.
	//물론 같은 패키지 내에선 접근 가능함
	protected void b() {
		
	}
	//같은 패키지의 모든 API들이 사용가능함
	void c() {
		
	}
	
	
	
	
	
}
