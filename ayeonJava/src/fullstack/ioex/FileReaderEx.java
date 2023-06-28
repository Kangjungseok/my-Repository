package fullstack.ioex;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class FileReaderEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file = null;
		FileReader fr = null;
		
		try {
			file = new File("자바3차 과제.txt");
			fr = new FileReader(file);
			
			int data;
			System.out.print("파일의 인코딩 " + fr.getEncoding());
			while((data =fr.read()) != -1) {
				System.out.print((char)data);
			}
			fr.close();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
	}

}
