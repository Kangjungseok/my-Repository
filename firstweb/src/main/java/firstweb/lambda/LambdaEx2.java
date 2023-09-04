package firstweb.lambda;

import java.util.ArrayList;

//meme : @FunctionalInterface 어노테이션을 사용하면 구현부가 없는 추상메서드가 람다함수가 됨?
@FunctionalInterface
interface MyInter{
	default void sum1() {
		System.out.println("이건 jdk 1.8 부터 지원되는 인터페이스의 기본 메서드입니다.");
	}
	//얘는 static 메서드입니다. 이또한 1.8 부터 지원됨
	static int sum2() {
		return 100;
	}
	//이 놈은 람다 함수로 사용할 메서드입니다. 반드시 추상이어야 함
	public int sum3(int a, int b);
}


public class LambdaEx2 {

	public static void main(String[] args) {
		
		ArrayList<Integer> l1 = new ArrayList<>();
		l1.add(1);
		l1.add(2);
		l1.add(3);
		
		//1번 기존 방법
		for(int i = 0 ; i<l1.size(); i++) {
			System.out.println(l1.get(i));
		}
		
		//2번 방법
		for(Integer i : l1) {
			System.out.println(i);
		}
		
		//forEach를 이용한 람다 함수 적용방법
			
		//Stream 객체의 메서드를 이용한 형태입니다.
		//Stream 객체는 쉽게 표현하자면, 다중 쓰레드가 내부적으로 병렬로 CPU를 가동하도록
		//정의된 데이터 스트림입니다. IO 와는 완전 다른 개념입니다.
		l1.forEach(x -> System.out.println(x));
		l1.forEach(System.out::println);
		
		//FunctionInterface의 추상 메서드를 람다함수로 가져다 쓰기 
		//람다 함수는 특정 데이터가 있을 때 특정 기능의 함수를 그 때 그 떄 적용해서
		//결과를 도출하기 위한 목적입니다.
		
		MyInter function = (x, y) -> {return x + y;};
		System.out.println(function.sum3(10, 20));
		
		
	}

}
