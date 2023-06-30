package fullstack.netex;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.json.JSONException;
import org.json.JSONObject;

public class ChatServer {

	// 필드 선언합니다.

	ServerSocket serverSocket;
	static ExecutorService threadPool = Executors.newFixedThreadPool(100);
	// 아래 필드가 중요합니다.
	// 각각의 접속자는 모두 쓰레드로 생성되고, 모든 메세지는 아래 선언될 필드에(Map)에
	// 저장되어야 합니다. 따라서 반드시 동기화가 되어야 하는데, java에서는
	// 이런 동기화가 필요한 Collection 을 자동으로 생성해주니 사용만 하세요.
	Map<String, SocketClient> chatroom = Collections.synchronizedMap(new HashMap<String, SocketClient>());

	private static ChatServer instance = new ChatServer();

	private static ChatServer getInstance() {
		return instance;
	}
	// 서버 시작 메서드 정의합니다.
	// 여기서는 쓰레드 풀을 이용해서 클라이언트 요청이 오면 쓰레드로 생성 SocketClient객체로
	// 클라이언트와 1 : 1 매핑을 합니다.

	public void start() throws Exception {
		serverSocket = new ServerSocket(9999);
		System.out.println("[서버 Started.........]");

		// 익명 객체로 Runnable 객체 구현합니다.
		// 람다식 익명객체 예시...
		/*
		 * Thread thread = new Thread( () -> { SocketClient sc = new
		 * SocketClient(this,socket); });
		 */

		Thread thread2 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					while (true) {
						// 클라이언트 요청 시 Socket 생성 후 SocketClient에게 보냄
						Socket socket = serverSocket.accept();
						SocketClient sc = new SocketClient(ChatServer.getInstance(), socket);
					}
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}

			}
		});
		//thread2.setDaemon(true);
		thread2.start();
	}// end of start();

	// 접속된 모든 크라이언트 소켓 정보를 add 시키는 메서드 정의합니다.
	public void addSocketClient(SocketClient socketClient) {
		String key = socketClient.chatName + "@" + socketClient.clientIp;

		// 여기서부터가 중요함..
		// 사용자의 모든 메세지는 map 저장되어야 하고 (동기화되서), 저장된 데이터는
		// 순회되면서 출력되어야 합니다.
		chatroom.put(key, socketClient);
		System.out.println("입장 : " + key);
		// map의 size가 전체 사용자 수임
		System.out.println("현재 채팅 사용자 수 : " + chatroom.size());
	}

	// 사용자가 채팅을 빠져나가면, 연결된 소켓도 공유 객체에서 (map)에서 삭제 해야 함
	public void removeSocketClient(SocketClient socketClient) {
		String key = socketClient.chatName + "@" + socketClient.clientIp;
		chatroom.remove(key);

		System.out.println("나감 : " + key);
		System.out.println("현재 채팅 사용자 수 : " + chatroom.size() + "\n");
	}

	// 아래 메서드는 참가자 전원에게 메세지를 보내는 메서드입니다.
	// 보내지는 메세지는 JSON 형태이고, 참가자 전원은 map에 SocketClient로 저장되어있습니다.
	// 해서 SocketClient 내부에는 send() 가 존재하고, 이 메서드를
	// chatRoom(Map)에서 순회하면서 호출합니다.

	public void sendToAll(SocketClient sender, String message) throws JSONException {
		JSONObject root = new JSONObject();
		root.put("clientIp", sender.clientIp);
		root.put("chatName", sender.chatName);
		root.put("message", message);

		Collection<SocketClient> socketClients = chatroom.values();

		for (SocketClient sc : socketClients) {
			if (sc == sender)
				continue;
			sc.send(json);
		}
	}
	
	
	public static void main(String[] args ) throws Exception {
		ChatServer chatServer = new ChatServer();
		chatServer.start();
		
		
		
	}
	
	
	
	

}
