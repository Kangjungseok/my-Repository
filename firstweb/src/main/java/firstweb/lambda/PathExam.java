package firstweb.lambda;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathExam {

	public static void main(String[] args) throws IOException, URISyntaxException {
		/*
		 * 이번 예제는 stream의 또다른 형식인 Path를 이용한 파일에 접근
		 * 파일의 내용을 행(Row) 단위로 요소를 읽어들여서 stream을 통해 가공하는 
		 * 코드예제입니다.
		 * 
		 *  주의깊게 보시면 정말 편하게 되어 있고, 하나 주의할 점은 이런 기능을 제공하는
		 *  IO API는 nio 라는 sub domain package에 할당되어 있으니 참고하세요.
		 */
		
		
			Path path = Paths.get(PathExam.class.getResource("data.txt").toURI());
			
			Files.lines(path, Charset.defaultCharset())
			.forEach(line -> System.out.println(line));
			
			//파일스트림은 반드시 close() 해야 합니다... 지금은 그냥 테스트용...
		
		
	}

}





















