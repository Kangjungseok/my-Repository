package fullstack.netex.chat2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class TcpMultiChatClient {

	// Sender 쓰레드 정의..
	// 생성된 서버와의 소켓을 기반으로 입력한 메세지를 서버에 전송하는 쓰레드입니다.
	// 메인에서 바로 호출하도록 static inner로 정의할게요.

	static class ClientSender extends Thread {
		Socket socket;
		DataOutputStream out;
		String name;
		
		public ClientSender(Socket socket, String id) {
			this.socket = socket;
			this.name = id;
			
			try {
				out = new DataOutputStream(socket.getOutputStream());
			} catch (Exception e) {
				System.out.println("서버와 소켓 생성 예외.." + e.getMessage());
			}
		}//end of 생성자
		
		@Override
		public void run() {
			Scanner sc = new Scanner(System.in);
			
			try {
				if(out != null) {
					out.writeUTF(name);
				}
				
				while(out != null) {
					out.writeUTF("[" + name + "]" + sc.nextLine());
				}
			} catch (Exception e) {
				System.out.println("클라이언트 sender() 예외..." + e.getMessage());
			}
		}//end of run..
	}//end of static Sender class

	//서버로부터 오는 메세지 받는 Recieve Thread 정의.
	static class ClientReciever extends Thread{
		Socket socket;
		DataInputStream in;
		
		public ClientReciever(Socket socket) {
			this.socket = socket;
			
			try {
				in = new DataInputStream(socket.getInputStream());
			} catch (Exception e) {
				System.out.println("클라이언트 sender 생성자 예외 " + e.getMessage());
			}
			
		}
		
		@Override
		public void run() {
			while(in != null) {
				try {
					System.out.println(in.readUTF());
				} catch (Exception e) {
					System.out.println("서버데이터 수신 예외.." + e.getMessage());
				}
			}
		}

	}//end of RecieverThread class
	
	
	
	public static void main(String[] args) {

		String id = "jason 쌤";

		try {
			String serverIp = "14.42.124.99";
			Socket socket = new Socket(serverIp, 9788);
			System.out.println("서버에 연결됨..");
			
			Thread sender = new Thread(new ClientSender(socket, id));
			Thread reciever = new Thread(new ClientReciever(socket));
			sender.start();
			reciever.start();
				
			
		} catch (Exception e) {
			System.out.println("챗클라이언트 메인 예외;;" + e.getMessage());
		}

	}

}
