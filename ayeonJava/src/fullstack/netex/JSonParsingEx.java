package fullstack.netex;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JSonParsingEx {

	public static void main(String[] args) throws IOException, JSONException {
		// 저장된 파일 읽어서 String으로 저장함
		BufferedReader br = new BufferedReader(new FileReader("D:\\test.json", Charset.forName("UTF-8")));
		
		String json = br.readLine();
		br.close();
		
		//파싱시작
		JSONObject root = new JSONObject(json);
		
		System.out.println("id : " + root.getString("id"));
		System.out.println("pass : " + root.getInt("pass"));
		System.out.println("학생여부 : " + root.getBoolean("student"));
		
		//객체 내의 객체 얻어내기
		JSONObject telObj = root.getJSONObject("tel");
		System.out.println("HP : " + telObj.getString("mobile"));
		
		//배열 속성 얻어내기
		JSONArray arr = root.getJSONArray("skills");
		for(int i = 0 ; i<arr.length(); i++) {
			System.out.println(arr.get(i));
		}
		
		
	}

}
