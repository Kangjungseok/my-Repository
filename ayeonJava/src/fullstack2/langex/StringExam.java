package fullstack2.langex;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.StringTokenizer;

import javax.swing.plaf.basic.BasicProgressBarUI;

import fullstack.ifex.IfExam;

public class StringExam {

	public static void main(String[] args) throws UnsupportedEncodingException {
		String sayHello = "안녕 아현";
		String sayHello2 = "안녕 아현";
		String sayHello3 = new String("안녕 아현");

		if (sayHello.equals(sayHello3)) {
			System.out.println("값 같음");
		} else {
			System.out.println("값 다름");
		}

		String a = "A";
		String b = "a";

		System.out.println(a.equals(b));

		String emptyStr = new String(" ");
		System.out.println(emptyStr.length());
		if (emptyStr.isBlank()) {
			System.out.println("공백문자열임");
		} else {
			System.out.println("값 있음");
		}
		
		
		byte[] bArr = {48,49,50,51,-10};
		
		//byte[] 파라미터로 받아 그 값을 문자열로 생성하는 생성자 호출함
		String bString = new String(bArr);
		System.out.println(bString);
		
		//여러분의 이름을 java에 기본 세팅된 문자셋(character set)으로
		//encoding 후 바이트배열로 리턴하는 메서드를 이용해볼게요.
		bArr = "강정석".getBytes();
		
		System.out.println(Arrays.toString(bArr));
		System.out.println(new String(bArr,0,3));
		
		
		int unicode = "강정석".codePointAt(0);
		System.out.println(unicode);
		
		
		String msg = "Hello World";
		
		if(msg.contains("Hello")) {
			System.out.println("포함됨");
		}
		
		
		
		char[] name = {'강','정','석'};
		String copyVal = String.copyValueOf(name);
		System.out.println(copyVal);
		
		
		
		String value = String.join(":", "a","b","c","d");
		System.out.println(value);
		
		
		
		//Charset 클래스를 이용해서 자바에서 이용 가능한 문자셋(character set)
		//정보를 얻어볼게요.
		//나중에 배우는 Map 타입으로 리턴되는 available...()을 이용합니다.
		
		SortedMap charsets = Charset.availableCharsets();
		System.out.println("지원되는 문자set 수 : " + charsets.size());
		
		Set key = charsets.keySet();
		for(Object obj : key) {
			System.out.println(obj);
		}
		
		
		byte eucKR[] = "강정석".getBytes("EUC-KR");
		byte utf8[] = "강정석".getBytes("UTF-8");
		
		System.out.println(Arrays.toString(eucKR));
		System.out.println(Arrays.toString(utf8));
		
		String newName = new String(eucKR, "UTF-8");
		System.out.println(newName);
		
		
		
		
		
		
		String msg2 = "오늘은 수요일입니다.";
		
		StringBuilder sb = new StringBuilder(msg2);
		
		//delete를 이용해서 수요일을 삭제해보세요.
		
		sb= sb.delete(msg2.indexOf("수"), msg2.indexOf("일")+1);
		
		System.out.println(sb.insert(sb.lastIndexOf("입"), "힘든 요일"));
		
		System.out.println(sb);
		
		//sb의 값을 가진 문자열 객체로 리턴하도록 해보세요.
		//ew> String theDay = ??;
		
		String theDay =  sb.toString();
		
		
		StringTokenizer st = new StringTokenizer("월/화/수/목","/");
		System.out.println(st.countTokens());
		
		while(st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}
		
		
		System.err.println("Hello");
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}
}