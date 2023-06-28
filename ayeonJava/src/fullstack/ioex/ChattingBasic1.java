package fullstack.ioex;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.zip.DataFormatException;

public class ChattingBasic1 {

	// 여러분의 입력을 받은 Scanner 생성합니다.
	static Scanner sc = new Scanner(System.in);
	private static String msgFile = "chatting.log"; // 여러분이 채팅한 모든 내용을 저장할게요. 여기에
	private static Date date;
	private static String dFormate = "yy년MM월dd일 a HH:mm:ss 초 : ";
	
	//로그에 저장될 시간형식 지정 객체 초기화
	private static SimpleDateFormat sdf = new SimpleDateFormat(dFormate);
	
	public static void main(String[] args) {
		//로그파일에 기록하는 내용은 여기에 정의해드릴게요
		//어디에 정의하건 현재는 전혀 상관없음..단, 필드로 정의시엔 static만 넣어주세요
		
		 File file = null;
		 FileOutputStream fos = null;
		 PrintWriter writer = null;
		 
		 
		 
		 //사용자 키보드를 입력 받아서 버퍼에 담은 후 라인 단위로 읽을 수 있는 (readLine()) 을
		 //이용해서 사용자의 정보를 저장할게요.
		 BufferedReader br = 
				 new BufferedReader(
						 new InputStreamReader(System.in));
		 
		 
		 
		 
		 
		 
		 
		 
		 try {
			//로그 파일 생성해서 아래 while 절에서 입력된 여러분의 메세지를 기록하도록
			//각 객체를 생성하는데, 여기서 눈여겨 볼 부분은 문자열을 입력 받아서 최종적으로
			//쓰여지는 건 byte로 쓰도록 중간에 OutputStream 객체를 사용하는걸 잘 보세요.
			 
			 file = new File(msgFile);
			 fos = new FileOutputStream(file);
			 writer = new PrintWriter(fos);
			 
			 
			 System.out.println("채팅을 시작합니다.\n 입력할 내용을 넣으세요. 끝내려면 언제든 q 입력");
				while (true) {
					System.out.println("메세지 입력 : ");
					//String msg = sc.next();
					String msg = br.readLine();
					if(msg.equalsIgnoreCase("q")) {
						//채팅종료, 스트림 out.
						System.out.println("채팅을 종료합니다.");
						writer.flush();
						writer.close();				
						break;
					}
					//이 영역은 사용자 내용을 파일에 넣습니다.
					writer.println(sdf.format(new Date()) + " : " + msg);
				}
				System.out.println("프로그램 종료");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		

	}

}
