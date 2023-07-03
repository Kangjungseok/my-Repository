package fullstack2.langex;

/*
 * java.lang 패키지는 자주 쓰이는 API 패키지입니다.
 * 따라서 해당 패키지는 따로 import 하지 않아도 자동으로
 * import java.lang.* 이 컴파일 시에 들어갑니다.
 * 나머지 패키지는 반드시 import해야 합니다. 
*/




class Hanul {
	int juminNum;
	
	public Hanul(int juminNum) {
		this.juminNum = juminNum;
	}
	
	//부오의 equals를 오버라이드 해서 주민번호가 같은지를 비교해볼게요.
	//이렇게하면 이 객체의 equals를 호출 시 Hanul 객체타입의 주민번호를 비교
	//같은지 여부를 리턴하게 됩니다.
	@Override
	public boolean equals(Object obj) {
		//NULL Pointer(Reference) Exception 주의
		
		//null 인지 여부와, Hanul 타입의 객체인지를 검사한 후
		if(obj != null && obj instanceof Hanul) {
			return this.juminNum == ((Hanul)obj).juminNum;
		}else {
			return false;
		}
	}
	
}
public class ObjectEx {
	/*
	 * Object 클래스 : 모든 Java 클래스의 최고 계층의 클래스 우리가 작성한 클래스에서 extends Object를 따로 하지 않더라도
	 * 컴파일 시에 자동으로 들어갑니다.
	 * 
	 * 따라서 배열을 포함한 모든 클래스 타입의 객체는 Object 타입으로 캐스팅 가능합니다. 대표적인 메서드로는 toString(),
	 * equals() 정도가 있습니다.
	 */

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString() + " + 오버라이드 한 내용입니다.";
	}

	public static void main(String[] args) {

		//Hanul 객체 2개를 같은 주민번호로 생성해봅니다.
		Hanul han1 = new Hanul(900101);
		Hanul han2 = new Hanul(900101);
		
		if(han1.equals(han2)) {
			System.out.println("다른 객체이지만 주민번호는 같습니다.");
		}else {
			System.out.println("다른 객체입니다.");
		}
		


		// 기본생성자를 이용한 Object 객체 생성..
		Object obj = new Object();
		// 아래 코드는 toString()을 묵시적으로 호출함
		System.out.println(obj);

		/*
		 * toString()은 Object에서 정의한 클래스입니다. 기본 기능은 객체의 해쉬코드값과, 객체의 패키지명을 포함한 클래스 타입을
		 * 
		 * @이란 코드와 함께 조합해서 String으로 return 시키도록 되어 있습니다. 이 toString()은 거의 모든 클래스가 오버라이드
		 * 했기 때문에, 자바 SE 내의 각 클래스들을 객체화 후 출력하면 오버라이드한 내용이 출력될겁니다.
		 */
		System.out.println(obj.getClass().getName());
		System.out.println(Integer.toHexString(obj.hashCode()));

		String name = "노재현";
		System.out.println(name.toString());

		ObjectEx oex = new ObjectEx();
		ObjectEx oex2 = oex;// 위와 같은 객체임

		System.out.println(oex);
		System.out.println(oex2);

		// 같은 객체인지를 Object의 equals를 이용해서 알아봅니다.
		// Object의 equals는 hash가 같은지를 비교합니다.
		// 즉 ref가 같은지를 비교한다는 의미
		if (oex.equals(oex2)) {
			System.out.println("같은 객체입니다.");
		} else {
			System.out.println("다른 객체입니다.");
		}

		// == --> 연산자는 P type과 사용하면 값이 같은지를 비교하고
		// R 타입에 사용하면 같은 객체인지(즉, Ref 같은지)를 비교합니다.

		if (oex == oex2) {
			System.out.println("같은 객체입니다.");
		} else {
			System.out.println("다른 객체입니다.");
		}


		
		
	}
}
