package fullstack.netex;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import org.json.JSONException;
import org.json.JSONObject;

/*
 * 채팅 클라이언트 클래스
 * 
 * 챗서버로 연결 요청을 보내고, 연결 후에는 id(대화명)을 보냅니다.
 * 이후 메세지를 주고 받기 때문에, 주고 받을 때 쓰레드를 이용해서 처리합니다. 
 * 
*/


public class ChatClient {

	//필드 선언
	Socket socket;
	DataInputStream dis;
	DataOutputStream dos;
	String chatName;
	
	
	//서버의 연결 요청 메서드 정의
	public void connect() {
		try {
			socket = new Socket("14.42.124.125", 9999);
			//스트림 얻어냅니다.
			dis = new DataInputStream(socket.getInputStream());
			dos = new DataOutputStream(socket.getOutputStream());
			System.out.println("[클라이언트] 서버에 연결됨...");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//서버로부터 오는 메세지를 받는 메서드 정의
	public void receive() {
		Thread thread = new Thread(() ->{
			try {
				//무한루프를 돌면서 서버에서 오는 JSON을 받아서 콘솔에 출력합니다.
				
				while(true) {
					String json = dis.readUTF();
					JSONObject root = new JSONObject(json);
					String clientIp = root.getString("clientIp");
					String chatName = root.getString("chatName");
					String message = root.getString("message");
					
					System.out.println("<"+chatName+"@"+clientIp+">"+message);
				}
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
				System.out.println("클라이언트 연결 끊어짐");
				System.exit(0);
			}
			
		});
	}
	
	//클라이언트가 입력한 내용을 서버로 전송하는 send() 정의
	public void send(String json) {
		try {
			dos.writeUTF(json);
			dos.flush();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	//클라이언트가 채팅 종료 시 소켓 해제 메서드 정의
	public void unConnect() {
		if(socket != null) {
			try {
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	
	public static void main(String[] args) {
		ChatClient chatClient = new ChatClient();
		chatClient.connect();
		
		//클라이언트 키보드 입력 read
		Scanner sc = new Scanner(System.in);
		System.out.println("대화명 입력 : ");
		chatClient.chatName = sc.nextLine();
		
		//대화명을 제일 먼저 서버로 json 형태로 보냅니다.
		try {
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("command", "incoming");
			jsonObject.put("data", chatClient.chatName);
			String json = jsonObject.toString();
			chatClient.send(json);
			
			//서버로부터 데이터 받기
			chatClient.receive();
			System.out.println("----------------------------------------------");
			System.out.println("메세지 입력하고 Enter");
			System.out.println("채팅 종료 시 q or Q 입력..");
			System.out.println("----------------------------------------------");
			
			while(true) {
				String message = sc.nextLine();
				if(message.equalsIgnoreCase("q")) {
					break;
				}else {
					jsonObject = new JSONObject();
					jsonObject.put("command", "message");
					jsonObject.put("data", message);
					json = jsonObject.toString();
					chatClient.send(json);
				}
			}
			
			sc.close();
			chatClient.unConnect();//채팅 종료..
			
		} catch (JSONException e) {
			System.out.println(e.getMessage());
			System.out.println("클라이언트 서버 연결 오류 발생함.");
		}
		
		
		
		
	}

}
