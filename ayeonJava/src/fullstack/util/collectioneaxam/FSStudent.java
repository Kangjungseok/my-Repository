package fullstack.util.collectioneaxam;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * 이 클래스는 여러분 한 사람의 정보를 관리하려고 만드는 클래스입니다.
 * 따라서 관리하조가 하는 속성을 필드로 선언하고, getter, setter를
 * 만들어서 활용할 겁니다.
 * 
 * 이러한 기능을 하는 객체를 java에서는 DTO라고 말합니다.ㅏ
 * Data Transfer Object. 즉 Data를 필요로 하는 코드에서는
 * 이런 DTO를 생성해서 get, set 을 한다는 의미입니다.
*/


@NoArgsConstructor
@Data
public class FSStudent implements Comparable<FSStudent>{

	
	
	
	
	
	
	public FSStudent(String name, int kor, int eng, int math) {
		super();
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		total = kor + eng + math;
	}





	private String name;

	private int kor ;
	private int eng;
	private int math;
	private int total;
	

	
	
	
	
	@Override
	public int compareTo(FSStudent o) {
		
		return this.total - o.total;
	}
	
	
	
	
	
	
	
	
	
}
