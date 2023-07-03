package fullstack.netex.chat2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;





public class TcpMultiChatServer {

	HashMap clients; 
	
	public TcpMultiChatServer() {
		clients = new HashMap<>();
		Collections.synchronizedMap(clients);
	}
	
	public void start() {
		ServerSocket serverSocket = null;
		Socket socket = null;
		
		try {
			serverSocket = new ServerSocket(9788);
			System.out.println("서버가 시작됨");
			
			while(true) {
				socket = serverSocket.accept();
				
				System.out.println(socket.getInetAddress() +" : " + " 에서 접속함");
				
				//요청된 클라이언트 소켓을 쓰레드로 실행
				ServerReciever thread = new ServerReciever(socket);
				thread.start();
			}
		} catch (Exception e) {
			System.out.println("서버 start() 예외.." + e.getMessage());
		}
		
	}
	
	//서버에서 클라이언트 모두에게 보내는 메서드 정의
	void sendToAll(String msg) {
		Iterator it = clients.keySet().iterator();
		
		while(it.hasNext()) {
			try {
				DataOutputStream dos = 
						(DataOutputStream)clients.get(it.next());
				dos.writeUTF(msg);
			} catch (Exception e) {
				System.out.println("sendToAll() 예외 발생.." + e.getMessage());
			}
		}
		
	}//End of sendToAll
	
	public static void main(String[] args) {
		new TcpMultiChatServer().start();
		
		
	}

	//사용자의 msg를 입력 받는 inner 쓰레드 클래스..
	class ServerReciever extends Thread{
		Socket socket;
		DataInputStream dis;
		DataOutputStream dos;
		
		public ServerReciever(Socket socket) {
			this.socket = socket;
			
			try {
				//스트림 얻기
				dis = new DataInputStream(socket.getInputStream());
				dos = new DataOutputStream(socket.getOutputStream());
			} catch (Exception e) {
				System.out.println("서버 리시버 생성자 예외.. "+e.getMessage());
			}
			
			
		
			
		}
		
		@Override
		public void run() {
			String name = "";
			try {
				name = dis.readUTF();
				sendToAll("# " + name + " 님 입장함");
				
				clients.put(name, dos);
				System.out.println("현재 서버 접속자 수 : " + clients.size());
				
				while(dis != null) {
					sendToAll(dis.readUTF());
				}
				
			} catch (Exception e) {
				System.out.println("서버리시버 클래스 run() 예외 " + e.getMessage());
			}finally {
				sendToAll("@.." + name + "님이 나갔음");
				//나간 사람의 socket 제거
				clients.remove(name);
				System.out.println(socket.getInetAddress() + " 이 접속 종료함");
				System.out.println("현재 접속자 수 : " + clients.size());
			}
			
			
		}
		
	}

	
	
}
