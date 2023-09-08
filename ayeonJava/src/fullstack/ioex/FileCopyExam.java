package fullstack.ioex;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * 파일을 읽어들인 후에 카피본을 생성해서 저장할 예정입니다.
 * 일단, 한글 깨지는 것 감안하세요.
 * 두 번째, 읽었으면, 카피하려면 새로 쓴다라는 의미입니다.
 * 이 말은 파일을 읽어들인 데이터는 프로그램내부로 input 되어질 거구요
 * 읽혀진 data는 파일에 output 되어질 겁니다.
 * 
 * 참고로 InputStream 클래스와 OutputStream 클래스는 똑같은 구조로 상속 처리되어있습니다.
 * 즉, 클래스 이름이 in --> out 으로 바뀔뿐이에요.
 * 
*/

public class FileCopyExam {

	public static void main(String[] args) {

		File file = new File("D:\\full_stack_2nd_mg\\ayeonJava\\src\\fullstack\\ioex\\InputStreamEx2.java");
		/*
		 * 위 파일을 그대로 읽어서 FileName.java_backup 이라는 파일에
		 * 그대로 write 합니다. 현재는 백업 파일이 없기 때문에 FileOutputStream을
		 * 이용하면 새롭게 만들어집니다.(즉 Output 스트림의 대상이 파일이면,
		 * 새롭게 만들거나, 기존에 존재하면 내용만 다시 씁니다. 기억하세요.)
		 * 
		*/
		
		FileInputStream fis = null;
		FileOutputStream fos = null;
		
		try {
			fis = new FileInputStream(file);
			fos = new FileOutputStream(file.getName()+"_back");
			
			int data;
			while((data = fis.read()) != -1) {
				fos.write(data);
			}
			
			fis.close();
			fos.close();
			System.out.println("파일복사 끝.");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
		
		

	}
}