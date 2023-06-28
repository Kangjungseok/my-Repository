package fullstack.ioex;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.SequenceInputStream;
import java.util.Vector;

/*
 * SequenceInputStream : 하나 이상의 inputstream을 하나로 처리해주는 스트림입니다.
*/
public class SequenceInputExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileInputStream fis1 = null;
		FileInputStream fis2 = null;
		
		try {
			fis1 = new FileInputStream("aUser.dat");
			fis2 = new FileInputStream("bUser.dat");
		
			
			//위 두 개의 스트림을 하나로 연결할게요.
			SequenceInputStream sis = new SequenceInputStream(fis1, fis2);
			
			int data;
			
			while ( (data = sis.read())!= -1 ) {
				System.out.print((char)data);
			}
			
			sis.close();
			
			//하나 이상의 파일을 배열로 땡겨볼까요?
			//File 클래스는 시스템의 모든 파일에 대한 정보 및 기능을 
			//가지고 있는 클래스입니다.
			//얘는 Input/Output 기능은 없고, 오로지 파일에 대한 관리 기능만 있어요.
			
			//가져올 파일을 담고 있는 폴더명(path)를 이용해서 File 객체를 생성해볼게요.
			//무지 쉬움.
			File rootFolder = new File("D:\\players");
			System.out.println(rootFolder.isDirectory());
			System.out.println(rootFolder.listFiles().length);
			
			File[] files = rootFolder.listFiles();
			/*
			 * 위 파일을 모두 FileInputStream에 담은 후
			 * Vector에 넣을 예정입니다.
			*/
			
			Vector<FileInputStream> v = new Vector<>();
			for(File f :files) {
				v.add(new FileInputStream(f));
			}
			System.out.println(v.size());
			
			SequenceInputStream sst = new SequenceInputStream(v.elements());
			
			
			while( (data = sst.read()) != -1 ) {
				System.out.print((char)data);
			}
			
			
			
			
			
			
			
			
			
			
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
