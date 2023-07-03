package fullstack.util.collectioneaxam.genericex;
/*
 * Generic : 어떤 타입이 결정되지 않은 필드나 메서드에 타입을 지정 또는 파라미터로
 * 선언해서, 실제 사용 시엔 구체적인 타입으로 대체하는 자바의 기능
*/

import javax.security.auth.login.LoginContext;

class OwnClass {
	//내가 정의한 클래스
	//속성, 메서드
	
	public void login() {
		System.out.println("로그인을 처리하는 메서드입니다.");
	}
	
}

class SomeClass<T>{
	public T login;
}

public class GenericEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SomeClass<String> scl = new SomeClass();
		
		scl.login = "로그인했습니다.";
		
		System.out.println(scl.login);
		
		SomeClass<OwnClass> somecls = new SomeClass();
		somecls.login = new OwnClass();
		somecls.login.login();
		
		
	}

}
