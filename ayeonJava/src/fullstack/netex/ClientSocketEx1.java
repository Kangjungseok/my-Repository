package fullstack.netex;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

/*
 * 서버로 접속을 수행하는 클라이언트 소켓 정의합니다.
 * 제일 중요한 건, Socket 객체 생성 시에 서버의 ip, port 정보를 알아야 합니다.
*/
public class ClientSocketEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Socket socket = null;
		try {
			socket = new Socket("14.42.124.125", 9450);
			
			System.out.println("클라이언트 서버와 연결 성공함");
			
			//서버가 클라이언트에게 메세지 보내기. OutputStream을 얻어내서 보냅니다.
			DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
			dos.writeUTF("안녕하세요~~~~정석입니다~~~~~");
			dos.flush();
			
			
			
			DataInputStream dis = new DataInputStream(socket.getInputStream());
			String fromServerMsg = dis.readUTF();
			
			
			System.out.println("서버로부터 받은 메세지 : " + fromServerMsg);
			

			socket.close();
			System.out.println("클라이언트 종료함");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
