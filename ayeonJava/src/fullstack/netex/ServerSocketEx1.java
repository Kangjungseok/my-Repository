package fullstack.netex;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
 * 서버소켓 : 클라이언트의 요청을 처리하는 역할의 서버소켓
 * accept()는 내부 쓰레드로 서버소켓을 생성한 후 accept()를 호출하면
 * 클라이언트의 요청이 오는 순간 서로 간의 통신을 위한 Socket 객체를 리턴해줍니다.
 * 이 시점부터 C/S 간의 통신이 Socket을 통해 이뤄집니다.
 * Client는 서버로 데이터를 전송 시엔 OutputStream이, 반대인 경우엔, InputStream 이 필요한데
 * 이 스트림은 각 소켓객체의 getxxxxx()를 통해 얻어냅니다.
 * 이렇게 얻어낸 스트림을 통해 서로 통신이 가능하세 되는 것입니다.
*/
public class ServerSocketEx1 {

	private static ServerSocket serverSocket = null;

	// Java API의 Thread Pooling 이용해서 클라이언트에 사용될 쓰레드를 먼저 생성합니다.
	private static ExecutorService executorService = Executors.newFixedThreadPool(100);

	public static void main(String[] args) {

		System.out.println("서버를 종료 시엔 q or Q를 입력해......");
		// 서버소켓을 시작하는 메서드 호출.
		startServer();

		Scanner sc = new Scanner(System.in);

		while (true) {
			String input = sc.nextLine();
			if (input.equalsIgnoreCase("q")) {
				break;
			}
		} // end of while

		sc.close();

		stop();

	}

	private static void startServer() {
		// 서버로 오는 요청을 각각의 쓰레드로 처리할게요.
		// 외부에서 생성을 해도 되지만 지금은 지역 익명클래스로 정의합니다.
		Thread theSocket = new Thread() {
			@Override
			public void run() {
				try {
					serverSocket = new ServerSocket(9450);
					System.out.println("서버 시작됨");

					// 무한루프를 이용해서 클라이언트의 요청을 계속 대기합니다.
					while (true) {
						System.out.println("서버가 클라이언트의 요청을 대기함");
						// 요청이 오면 Socket 객체 리턴함
						Socket socket = serverSocket.accept();

						executorService.execute(() -> {
							try {
								// 소켓이 연결되면 서로 통신이 가능함..
								// 일단은 클라이언트의 정보만 얻어서 출력함.

								InetAddress client = socket.getInetAddress();
								System.out.println("C/S의 연결이 완료됨");

								System.out.println("요청된 Client의 기본 정보 : " + Arrays.toString(client.getAddress()));

								// 데이터 받고 보내는 작업을 처리할게요.
								// 우리가 배웠던 Stream을 이용해서 처리합니다.
								// 클라이언트로부터 오는 데이터(Output)을 input으로
								// 받아냅니다. socket.getInputStream()을 이용하면
								// 그대로 받아집니다.
								DataInputStream dis = new DataInputStream(socket.getInputStream());
								String clientMsg = dis.readUTF();
								System.out.println("클라이언트의 메세지 : " + clientMsg);

								// 서버가 클라이언트에게 메세지 보내기. OutputStream을 얻어내서 보냅니다.
								DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
								dos.writeUTF("너가 내게 보낸 메세지 : " + "[" + clientMsg + "]");
								dos.flush();

								// 아래 socket을 close()하면 위에 연결된 모든 스트림도 자동 close() 됨
								// 모든 리소스는 사용된 후엔 반드시 닫아야 함...
								socket.close();
								System.out.println("서버와의 연결 해제함");

							} catch (Exception e) {
								System.out.println(e.getMessage());
							}
						});

					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		};
		theSocket.setDaemon(true);
		theSocket.start();// 서버쓰레드 start...

	}// End of startServer();

	public static void stop() {
		try {
			serverSocket.close();
			System.out.println("서버 종료됨");
			//생성된 쓰레드풀을 삭제함...
			executorService.shutdown();
			System.exit(0);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}// End of Class
