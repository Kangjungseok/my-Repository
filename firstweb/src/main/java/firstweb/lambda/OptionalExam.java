package firstweb.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

public class OptionalExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Optional 클래스 : 스트림종류의 하나로써, 특정 타입의 스트림요소의 결과를 받아서
		 * 집계, 요소 존재여부, 요소가 없을 시의 처리여부 등을 consumer(람다) 를 통해
		 * 정의할 수 있는 클래스입니다.
		 * 재밌는 것은, 만약 컬렉션의 요소가 동적으로 추가되거나 삭제될 때, 추가 시에는 상관 없지만
		 * 삭제되어 아무 것도 존재하지 않는 상태에서 요소를 get하게되면 예외가 발생할 수 있는데,
		 * 이 때를 대비해 메서드를 제공해서 예외를 발생하지 않으면서도 다음 처리 작업을 할 수 있도록
		 * 정의되어 있습니다.
		 * 
		 * 대표적인 메서드로는 아래와 같음.
		 * isPresent() : 요소가 존재하는지의 여부를 리턴함
		 * orElse() : 요소가 없는 경우, 즉 집계할 수 없는 경우를 대비, default 값을 정의할 수 있음
		 * ifPresent() : 요소가 존재하는 경우에만 동작하는 람다를 제공하는 메서드입니다.
		 */
		
		List<Integer> list = new ArrayList<>();//빈 요소의 컬렉션 생성
		//하위 코드는 일부러 없는 요소를 집계하여서 예외를 발생시킵니다.
		/*
		double avg = list.stream()
					 .mapToInt(Integer :: intValue)//value -> Integer.intValue(value)
					 .average()
					 .getAsDouble();
		
		System.out.println(avg);
		*/
		
		OptionalDouble optional = list.stream()
								  .mapToInt(Integer :: intValue)
								  .average();
		
		if(optional.isPresent()) {//요소가 존재하면 true 리턴함.
			System.out.println("평균 : " + optional.getAsDouble());
		}else {
			System.out.println("요소에 값이 없음..." + 0.0);
		}
		
		
		
		
		double avg = list.stream()
				 .mapToInt(Integer :: intValue)//value -> Integer.intValue(value)
				 .average()
				 .orElse(0.0);
				 
	
		System.out.println("orElse() 를 이용한 집계 처리 " + avg);
		
		list.stream()
		.mapToInt(Integer :: intValue)
		.average()
		.ifPresent(v -> System.out.println("평균 : " + v));
		
		
		
		
	}

}
