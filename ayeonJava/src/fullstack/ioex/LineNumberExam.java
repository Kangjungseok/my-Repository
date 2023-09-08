package fullstack.ioex;

import java.io.File;
import java.io.FileReader;
import java.io.LineNumberReader;

public class LineNumberExam {

	public static void main(String[] args) {
		String logFile = "chatting.log";
		
		try {
			LineNumberReader line = 
					new LineNumberReader(new FileReader(new File(logFile)));
			
			String data = null;
			
			while((data = line.readLine()) != null ) {
				System.out.println(line.getLineNumber() + ". "+ data);
			}
			line.close();			
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		

	}

}
