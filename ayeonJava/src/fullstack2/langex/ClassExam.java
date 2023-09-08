package fullstack2.langex;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.Map;
import java.util.Properties;

/*
 * Class class : 클래스의 메타정보(Meta : 전반적인 정보를 뜻합니다.)를 얻어낼 때
 * 사용되는 클래스입니다. 대표적인 메서드로는 forName(String className)이 있고
 * 정상적인 패키지명과 이름이라면 해당 클래스의 객체를 생성해서 내부에 어떤 내용이 정의 되었는지
 * 알 수 있습니다. 참고로 로직을 안다는 말이 아니라, 메서드 이름, 필드 이름, 갯수 등의
 * 클래스의 메타정보를 알 수 있다는 말입니다.
 * 
 * 또한 우리가 외부라이브러리를 가져와서 사용할 때, 해당 lib 내의 특정 클래스 정보를 얻어내서
 * 클래스 로더나, 아니면 다른 API 정보를 넘겨야 할 때가 있는데, 이 때도 유용하게 사용됩니다.
 * 
 *  위 설명처럼 특정 클래스의 정보를 얻어내는 행위를 자바에서는 Reflection 이라고 합니다.
 *  
 *  즉, 특정 클래스를 거울에 비추는 것처럼 클래스의 모든 정보를 거울에 반영시킨다라고 보면 됩니다.
 *  
 *  아래는 코드에 따라서 class 정보를 얻어내는 문법입니다.(알아두면 좋아요)
 *  
 *  1.Class Somecls = ClassName.class
 *  
 *  2.Class Somecls2 = Class.forName("패키지명 포함 클래스명");
 *  
 *  3.Class Somecls3 = Ref 변수.getClass(); // Object 클래스로부터 상속 받은 메서드 활용
*/
public class ClassExam {

	public static void main(String[] args) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		// ScannerExam 클래스의 정보를 얻어내는 코드입니다.
		// 먼저 해당 클래스의 Class 객체를 얻어냅니다.

		Class scExam = ScannerExam.class;
		System.out.println(scExam);

		Class scExam2 = Class.forName("fullstack2.lombokex.Person"); // 반드시 패키지명까지 다 주세요!!!
		System.out.println(scExam2);

		Class scExam3 = new ClassExam().getClass();
		System.out.println(scExam3);

		System.out.println("생성자 정보 얻어낼게요.");

		Constructor[] constructors = scExam2.getDeclaredConstructors();
		for (Constructor con : constructors) {
			System.out.println(con.getName());
			Class[] params = con.getParameterTypes();
			for (Class cls : params) {
				System.out.println(cls.getName());
			}
		}

		Method[] methods = scExam2.getDeclaredMethods();
		for (Method method : methods) {
			System.out.println(method.getName());
			Class[] params = method.getParameterTypes();
			for (Class cls : params) {
				System.out.println(cls.getName());
			}
		}
		
		
		//Class class의 getResource()를 통해서
		//설정 정보 파일을 얻어내볼게요.
		
		Class ce = ClassExam.class;
		
		String location = ce.getResource("sleep/test.properties").getPath();
		System.out.println(location);

		
		//Properties 객체를 통해서 설정 정보를 얻어내볼게요.
		//Properties 기본 객체를 먼저 생성합니다. 순서1
		Properties prop = new Properties();
		
		//load() 를 이용해서 파일이 있는 경로에 입력객체를 이용, 연결해 볼게요.
		try {//실행시 예외가 발생할 수 있는 코드는 묶어서 예외 handling 을 할게요
			//만약 예외가 발생되지 않으면 이 코드가 정상적으로 실행되고,
			//그렇지 않다면, 예외가 발생되는 코드라인, 지금은 92line(prop.load()지점)입니다.
			//에서 코드실행이 멈춰지고, 아래 catch 절 이동합니다.
			//두 개의 catch가 있는데, 이중 발생된 예외의 타입에 따라서
			//그 타입의 객체로 catch 한 절로 넘어갑니다.
			//현재는 파일을 못 찾는 예외이기에, 100% FileNotFoundException
			//예외절로 넘어갑니다...참고로 IOException은 99%이상 발생하지 않습니다.
			prop.load(new FileInputStream(new File(location)));
			
		
			Enumeration en = prop.propertyNames();
			
			
			
			String keyName = "";
			while(en.hasMoreElements()) {
				keyName = (String)en.nextElement();
				System.out.println(keyName + " = " + prop.getProperty(keyName)); 
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
		
	}

}
