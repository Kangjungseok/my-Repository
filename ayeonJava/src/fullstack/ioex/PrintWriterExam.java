package fullstack.ioex;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class PrintWriterExam {

	public static void main(String[] args) {
		
		PrintWriter pw = null;
		File file = null;
		
		//문자를 byte로 쪼개서 파일에 byte로 써볼게요.
		//쓰는 방법은 간단합니다. 생성자에서 OutputStream을 파라미터로 받는
		//애를 사용하면 됩니다.
		
		
		
		try {
			file = new File("writer로 출력한 파일.txt");
			pw = new PrintWriter(file);
			
			//문자 하나만 쓸게요.
			pw.write('가');
			//char 배열을 쓸게요.
			pw.write("나다".toCharArray());
			//문자열을 쓸게요
			pw.write("마바사아");;
			
			
			
			pw.flush();//호출해서 혹시 스트림 내에 있는 안 쓰여진 데이터를 배출합니다.
			pw.close();
			
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());			
		}

	}

}
