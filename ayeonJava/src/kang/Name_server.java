package kang;

public class Name_server {
	String email,id,server;
	

	//name 서버 앞의 아이디 부분 메서드입니다.
	static public String  name(String email) {
		String id = email.substring(0,email.indexOf("@"));
		return id;
	}
	
	
	public String server(String email) {
		server = email.substring((email.indexOf("@")+1),email.length());
		return  server;
	}
	
	
}