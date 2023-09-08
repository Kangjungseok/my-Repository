package fullstack.ioex;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/*
 * Filter In/Out Stream : 기존 스트림에 특정 기능을 추가한 메서드를 보유한
 * 기능 클래스입니다. 대부분이 IO 할 때 이 필터클래스를 이용해서 효율성을 높이거나
 * 객체를 통째로 쓰거나, 자바 Data를 쓰거나 읽거나 하는 기능을 구현합니다.
 * 
 * 대표적인 Filter 로는 BufferedIn/OutputStream 이 있고, 모든 스트림은
 * 1:1로 in/out이 구성되어 있습니다.
 * 
 * 
*/
public class FilterStreamEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		
		try {
			fis = new FileInputStream("first.dat");
			//스트림원형을 버퍼에 꼽습니다.
			bis = new BufferedInputStream(fis);
			
			/*
			BufferedInputStream bs = 
					new BufferedInputStream(new FileInputStream(new File("test.dat")));
			bs.close();
			*/
			
			
			int data;
			while((data = bis.read()) != -1 ) {
				System.out.println((char)data);
			}
			//위 두개 이상이 연결된 경우엔 반드시 마지막 스트림을 닫아야 하거나
			//모두 순차적으로 닫아야 합니다.
			//일반적으로는 마지막 스트림을 close() 하게 되면 내부에서
			//super.close()를 호출해서 순차적으로 모두 닫게됩니다.
			bis.close();//버퍼스트림만 close() 하면 됩니다.
			
			
			//버퍼를 이용해서 파일에 데이터를 쓰는 로직
			FileOutputStream fos = new FileOutputStream("123.dat");
			//버퍼의 크기를 5byte 로 정의합니다.
			//이렇게 될 경우 5byte가 채워지면 버퍼의 내용을 파일에 쓰게 됩니다.
			
			BufferedOutputStream bos = new BufferedOutputStream(fos,5);
			for(int i = '1' ; i<='9'; i++) {
				bos.write(i);
			}
			//bos.flush();
			bos.close();
			System.out.println("파일에 다 씀");
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage()); 
		}
		
	}

}
