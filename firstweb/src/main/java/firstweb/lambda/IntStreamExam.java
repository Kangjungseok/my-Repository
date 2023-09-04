package firstweb.lambda;

import java.util.stream.IntStream;

public class IntStreamExam {

	static int sum = 0;
	public static void main(String[] args) {
		/*
		 * IntStram int 타입의 요소를 스트림을 통해 전달하는 스트림입니다.
		 * 어제 봤듯이 mapToInt() 등의 스트림 변환 메서드를 통해 다른 요소의 값을
		 * int로 변환해서 전달하기도 하고, 다른 메서드를 통해 특정 범위의 int 값을
		 * 스트림을 통해 전달할 수도 있습니다.
		 */

		//final int sum = 0;
		//위 지역 변수 sum이 스트림내부에서 람다의 변수로 사용되면, 지역익명객체의 target 변수가 됩니다.
		//자바에서는 4개의 중첩이 존재하는데, 이 중 지역중첩은 지역(메서드)내의 변수를 중첩 클래스에서
		//사용할 시엔 반드시 final로 선언이 되어야 합니다. 때문에 지역 sum의 final로 선언하면
		//사용은 가능하나 reassign(재대입 or 값변화)이 안 되기 때문에
		//static member로 선언해서 사용합니다.
		
		
		// 1~100 사이의 int 값 생성 후 스트림을 통해 전달받기
		IntStream.range(1,100).forEach(i -> sum += i);
		System.out.println(sum);
		sum = 0 ;
		IntStream.rangeClosed(1, 100).forEach(j -> sum += j);
		System.out.println(sum);
		
		
	}

}
