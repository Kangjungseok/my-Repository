package fullstack.jdbcex.dtos;

import java.sql.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GameMemberDTO {
	
	private int num; //회원넘버
	private String name;
	private String email;
	private String password;
	private Date reg_date;
	
	
	
}
