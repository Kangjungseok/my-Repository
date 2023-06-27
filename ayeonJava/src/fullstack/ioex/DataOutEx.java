package fullstack.ioex;

import java.io.BufferedOutputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class DataOutEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		FileOutputStream fos = null;
		DataOutputStream dos = null;
		BufferedOutputStream bos = null;
		
		int readInt;
		int result=0;		
		
		
		try {
			fos = new FileOutputStream("dataOut.dat", false);
			bos = new BufferedOutputStream(fos);
			dos = new DataOutputStream(bos);
			
			int a = 10;
			
			dos.writeInt(a);
			dos.writeInt(a);
			dos.writeInt(a);
			dos.close();
			
			System.out.println("파일출력 끝");
			
			//DataInput은 반드시 쓴 순서 그대로 읽어야 합니다.
			//위 순서대로 read(), readInt(), readUTF()로 호출해야 합니다.
			//이 객체는 파일의 끝일 때 EOF(End of File) Exception 을 던지기 때문에
			//catch절에서 적절히 핸들링해서 파일의 끝을 처리합니다.
			
			DataInputStream dis = 
					new DataInputStream(new FileInputStream("dataOut.dat"));
			
			while(true) {
				readInt = dis.readInt();
				System.out.println("읽은 Data " + readInt);
				System.out.println();
				result += readInt;
						
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			//System.out.println(e.getMessage());
			//e.printStackTrace();
			System.out.println("총합 : " + result);
		}
		
		

	}

}
