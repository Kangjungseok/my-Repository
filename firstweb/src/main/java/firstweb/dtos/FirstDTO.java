package firstweb.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//setter getter 생성자(Default만 보유한 애) --> 
//기본객체를 생성후에 데이터를 나중에 setter 를 이용해서 초기화해라 라는 의미의 객체
//이러한 객체를 POJO 객체라고 합니다.
//Plain Object Java Object 

@NoArgsConstructor
@AllArgsConstructor
@Data
public class FirstDTO {

	private String id;
	private String name;
	private String email;
	private String password;
}
