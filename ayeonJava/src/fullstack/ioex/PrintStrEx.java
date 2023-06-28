package fullstack.ioex;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

public class PrintStrEx {

	public static void main(String[] args) throws FileNotFoundException {
		
		PrintStream ps = new PrintStream(new File("ahyun.data"));
		ps.println("Hello 아현");
		ps.println(ps);
		ps.close();
		
	}

}
