package fullstack.netex;

import java.net.Inet4Address;
import java.net.InetAddress;

public class InetAddrEx1 {

	public static void main(String[] args) {
		
		//net 패키지의 대부분의 API는 checked 예외로 throws 되어 있으므로
		//try 절로 핸들링합니다.
		
		try {
			
			//내 로컬 주소 알아보기
			InetAddress localHost = InetAddress.getLocalHost();
			System.out.println("내 컴 IP : " + localHost.getLocalHost());
			
			//URL로 특정 서버의 도메인에 할당된 IP 정보 얻어내기
			//도메인(domain)이란, 하나 이상의 서버로 분할된 서버명입니다.
			//네이버를 기준으로 보면 네이버 메인, 파파고, 번역, 사전 등...
			//서비스를 하는 서버에 따라서 도메인 명을 다르게 하겠죠.
			//이런 경우에 root 도메인에 할당된 모든 IP 정보를 얻을 수 있는데
			//만약 존재한다면 배열로 리턴해 줍니다. InetAddress[]
			//메서드로는 static InetAddress[] getAllByName(String host)
			//을 사용합니다.
			
			String domainName = "www.naver.com";
			
			InetAddress[] naverDomains = InetAddress.getAllByName(domainName);
			
			for(InetAddress domain : naverDomains) {
				System.out.println("네이버 도메인 주소 : " + domain.getHostAddress());
			}
			
			
		} catch (Exception e) {
			
		}
		
		
	}

}
