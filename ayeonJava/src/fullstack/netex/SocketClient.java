package fullstack.netex;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Arrays;

import org.json.JSONException;
import org.json.JSONObject;

/*
 * 이 클래스는 서버에서 연결요청 온 클라이언트의 소켓을 처리하는 애입니다.
 * 여기에는 클라이언트의 모든 정보(메세지, IP, Stream 등...)를 처리하며
 * 공유 Map에 소켓에 대한 정보도 제공합니다.
*/
public class SocketClient {

	// 필드 선언
	ChatServer chatServer;
	Socket socket;
	DataInputStream dis;
	DataOutputStream dos;
	String clientIp;
	String chatName;

	// 생성자를 이용해서 서버에서 할당된 소켓을 초기화 합니다.
	public SocketClient(ChatServer chatServer ,Socket socket) {
		this.chatServer = chatServer;
		this.socket = socket;

		// 할당된 소켓으로부터 스트림 세팅
		try {
			this.dis = new DataInputStream(socket.getInputStream());
			this.dos = new DataOutputStream(socket.getOutputStream());

			InetAddress cAddr = socket.getInetAddress();
			this.clientIp = Arrays.toString(cAddr.getAddress());

			// 채팅에 참가한 사람은 id를 보내면서 메세지를 보낼 수도 아닐 수도 있습니다.
			// 안 보내더라도, 서버에 연결되면 일단 채팅에 참가했다라고 보기에,
			// 참가자의 메세지를 얻는 메서드를 호출합니다.
			receive();

		} catch (IOException e) {
			e.getMessage();

		}

	}

	// 위 생성자에서 초기화된 dis를 이용해서 사용자의 메세지를 가져옵니다.
	private void receive() {
		ChatServer.threadPool.execute(() -> {
			// 쓰레드를 이용해서 메세지를 처리할게요.

			try {
				while (true) {
					String receiveJson = dis.readUTF();
					JSONObject jsonObject = new JSONObject(receiveJson);
					String command = jsonObject.getString("command");

					switch (command) {
					case "incoming":
						this.chatName = jsonObject.getString("data");
						// 아래 메서드는 구현할 예정입니다.
						chatServer.sendToAll(this, command);
						chatServer.addSocketClient(this);
						break;

					case "message":
						String msg = jsonObject.getString("data");
						chatServer.sendToAll(this, command);
						break;
					}

				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
				try {
					chatServer.sendToAll(this,"채팅룸을 나갔습니다");
				} catch (JSONException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				// 소켓을 제거합니다.
				chatServer.removeSocketClient(this);
			}
		});
	}//end of recieve();
	
	//이 메서드는 챗서버에서 모두에게 메세지를 전송할 때 호출되는 메서드입니다.
	//모든 메세지는 json으로 주고 받을 예정이라서 C/S 모두 JSON 파싱을 합니다.
	public void send(String json) {
		try {
			dos.writeUTF(json);
			dos.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	//클라이언트가 채팅을 나가면 자원 해제
	public void close() {
		try {
			socket.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	
	
	

}
