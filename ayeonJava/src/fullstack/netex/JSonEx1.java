package fullstack.netex;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JSonEx1 {

	public static void main(String[] args) throws JSONException, IOException {
		/*
		 * JSON : JavaScript Object Notation의 약자
		 * RESTfull 서비스(웹페이지 없이 데이터만 주고 받는 웹서비스를 일컫는 말)를 구현하는데
		 * 가장 많이 쓰이는 데이터 교환 타입입니다.
		 * 처음엔 자바스크립트에서만 사용하려고 했는데, 워낙 가볍고, 관리하기 편해서
		 * 지금은 모든 언어에서 다 사용하는 가장 Hot한 애입니다.
		 * 
		 *  형식이 매우매우 간단합니다.
		 *  자바의 Map을 생각하시면 돼요. key : value  key : value 이런 식입니다.
		 *  
		 *  
		 *  JSON은 위 FullName에서 보듯이 Object입니다.
		 *  때문에 기본적으로 객체 취급을 합니다.
		 *  
		 *  표현 가능 범위는 자바에서 배운 모든 것들을 다 데이터화 할 수 있습니다
		 *  아래는 문법.
		 *  
		 *  {//정의 시작
		 *  여기에 key : value, key : value,
		 *  필요 시 객체도 정의 가능합니다.
		 *  객체는 {객체 정의} 형식으로 정의합니다.
		 *  배열도 가능합니다 당연히 표식자는 [] 입니다.
		 *  
		 *  꼭 기억할 부분!!!!
		 *  
		 *  key(속성명은 반드시 ""로 감싸야 합니다)
		 *  각 속성의 값 이후에는 ","를 꼭 넣어줘야 key 구분이 됩니다.
		 *  속성값으로는 "String", number, true/false 
		 *  위에서 설명한 객체, 배열 등이 모두 가능합니다.
		 *  }//정의 끝
		*/
		
		/*
		{//JSON 객체 시작
			//hobby, name, id, pass, tel, skill
			"id" : "json",
			"name" : "강정석",
			"pass" : 1234,
			"student" : false,
			"tel" : { "moblie" : "010-1234-567", "home" : "031-345-3456"},
			"skills" : ["Java","Oracle","Spring Boot","React"]
		}
		*/
		
		
		//JSON.jar를 이용해서 JSON 객체를 생성해 볼게요.
		//모든 객체는 JSONObject라는 객체로 생성합니다.
		JSONObject root = new JSONObject();
		root.put("id", "JSON");
		root.put("name", "노재현");
		root.put("pass", 12345);
		root.put("student", "true");

		//이번엔 root 내의 속성으로 또 다른 JSON 객체를 넣도록 합니다.
		//따라서 다시 JSON 객체를 생성해서 put 합니다.
		JSONObject tel = new JSONObject();
		tel.put("mobile", "010-5686-5107");
		tel.put("home", "031-555-5555");
		root.put("tel",tel);
		
		//보유 스킬은 배열 JSONArray로 생성해서 다시 넣습니다.
		JSONArray skills = new JSONArray();
		skills.put("Java");
		skills.put("Servlet/Jsp");
		skills.put("SpringBoot");
		skills.put("React");
		
		root.put("skills", skills);
		
		//생성된 JSON, String으로 얻기 ... toString()이면 가능함
		String json = root.toString();
		
		System.out.println(json);
		
		FileWriter fw = new FileWriter("D:\\test.json", Charset.forName("UTF-8"));
		
		fw.write(json);
		fw.flush();
		fw.close();
		
		System.out.println("JSON 파일 잘 만들어짐");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
