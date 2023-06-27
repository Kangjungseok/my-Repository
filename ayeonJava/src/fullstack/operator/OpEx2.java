package fullstack.operator;

public class OpEx2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
			자바의 논리 연산자의 특징(&&, &, ||, |)의 차이점 확인하기.
			위 논리연산자 모두 사용가능합니다.
			&&, & 는 크게 차이점이 없으나, ||, |에서 미세한 차이점이 있습니다.
			
			|| => 검색한 첫 조건이 true면 다음 것 실행 안 함
			| => 검색한 첫 조건이 true여도 뒤엣것 실행함
			
			이 말은 만약 로직상에서 두 조건을 모두 검색해야 한다면, | 를 사용하라는 의미입니다.
		*/
		
		boolean result = aaa() | bbb();
		System.out.println(result);

	}
	
	static boolean aaa() {
		System.out.println("AAA 메서드의 내용");
		return true;
	}
	static boolean bbb() {
		System.out.println("BBB 메서드의 내용");
		return false;
	}
	

}
