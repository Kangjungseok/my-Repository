package firstweb.board.dtos;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BoardDTO {

	private int num;
	private String writer;
	private String subject;
	private String content;
	private String passwd;
	private Timestamp reg_date;
	private int readcount;
	private int ref;
	private int re_step;
	private int re_level;
	private String ip;
	
	
	
}
