package fullstack2.lombokex;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;


@Data  //필드의 get/setter 자동생성
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor

public class Person {
	
	
	
	private String id;
	@NonNull private String name;
	private String password;
	private int age;
	
	
	
	
	
}
