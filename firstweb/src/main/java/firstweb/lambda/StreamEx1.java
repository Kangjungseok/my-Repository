package firstweb.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * Stream 객체 : 이 객체는 1.8? 이후에 제공된 객체로, 한 마디로 표현하자면
 * 컬렉션 등의 내부에 있는 요소(element)를 처리하는 방식을 주입해서 그 결과를 빠르게
 * 그리고 쉽게 도출하여 원하는 다음 요소로 변경해서, 최종적으로 결과값을 원하는 연산로직에
 * 쉽게 도출하도록 만드는 요소입니다. 매우 다양한 형태가 존재하며, 모두 외울 필요는 없습니다.
 * 또한 이 데이터를 도출할 때는 내부적으로 콜백 형태의 함수인터페이스를 받도록 파라미터가 정의되었기
 * 떄문에 반드시 람다를 이용해야만 사용 가능합니다.
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
class FullStScore{
	//우리반 학생 점수를 관리하는 클래스
	private String name;
	private int score;
	
}

public class StreamEx1 {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		
		list.add("가");
		list.add("나");
		list.add("다");
		list.add("라");
		list.add("마");
		list.add("바");

		
		Stream<String> pStream = list.parallelStream();
		pStream.forEach(t -> System.out.println(t));
		
		//스트림을 통해 전달될 데이터를 원하는 타입으로 변경 가능하도록 만들 수 있습니다.
		//대부분 메서드를 통해 변경을 하는데, 하나 주의해야 할 것은 변경이 되면, 변경된
		//타입의 데이터는 또다른 스트림을 통해 전달된다는 것입니다. 꼭 기억하세요.
		//이렇게 변환되어 전달된 최종 스트림의 데이터는 메서드를 통해서 여러가지 기능의
		//산술, 정렬 등의 메서드를 통해 결과를 도출할 수 있습니다.
		//이 때 꼭 주의해야 할 점은, 집계 요소 메서드를 호출하지 않으면, 중간에 변환된 
		//스트림이 제 기능을 못하게 된다는 점입니다.
		//이 스트림변환은 일반적으로 메서드체인 방식으로 구현합니다.
		
		FullStScore a = new FullStScore("아현", 100);
		FullStScore b = new FullStScore("재현", 30);
		FullStScore c = new FullStScore("한울", 99);
		
		
		ArrayList<FullStScore> students = new ArrayList<>();
		students.add(a);
		students.add(b);
		students.add(c);
		
		Stream<FullStScore> studentStr = students.stream();
		//요소의 특정
		IntStream ist = studentStr.mapToInt(st -> st.getScore());
		
		double avg = ist.average().getAsDouble();
		
		System.out.println("avg :" + avg);
		
		double avg1 = students
				.stream().mapToInt(v -> v.getScore())
				.asDoubleStream()
				.average()
				.getAsDouble();
		
		System.out.println(avg1);
		
	}

}
