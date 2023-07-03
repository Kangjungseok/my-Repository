package fullstack2.langex;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ExceptionExam {

	// 계산기의 결과를 담는 변수 하나 선언할게요.
	static double result;

	static boolean devide(int a, int b) {
		// 두 수를 입력받아서 / 하는 메서드 정의합니다.
		/*
		 * 예외를 핸들링하는 방법입니다.
		 * 
		 * 1. throws를 선언해서 예외를 전가하는 방법입니다. throws 키워드는 두 가지의 의미를 가지고 있는데, 하나는 내 코드(메서드
		 * or 생성자)의 로직에는 예외가 발생할 수 있어 라고 선언하는 동시에, 만약 그럼에도 불구하고 너가 나를 호출해서 사용하다가 예외가
		 * 발생하면 난 예외 객체를 생성해서 네게 전가(전달) 할 거야 라는 의미가 있습니다.
		 * 
		 * 2. try~catch : 이 의미는 예외가 발생할 코드를 try{}로 감싸고, 만약 예외가 발생하면 해당 예외객체를 받아서(catch)
		 * 해서 올바르게 다음 로직으로 흐름을 이어가게 하는 방법입니다.
		 * 
		 */
		try {// 예외가 발생할 수 있는 코드를 이 블럭 내에 위치합니다.
			result = a / b;
			return true;
		} catch (ArithmeticException aeArithmeticException) {
			result = 0;
			return false;
		}

	}

	// properties 파일에 접근하도록 하는 메서드를 정의할게요.
	static void getProp(String fName) throws Exception{
		Class ce = ClassExam.class;
		String location = ce.getResource("sleep/" + fName).getPath();
		Properties prop = new Properties();

		prop.load(new FileInputStream(new File(location)));
	}

	public static void main(String[] args){

		/*
		 * Exception : 프로그램이 실행중에 발생하는 모든 에러 상황을 예외라고 합니다. 이렇게 예외가 발생하면 프로그램은 즉시 실행을 멈추고
		 * 예외의 내용을 담은 예외객체(Exception 타입의 객체)를 던지게(throw) 되어있습니다. 그래서 자바에서는 예외는 던져진다라고
		 * 표현을 합니다.
		 * 
		 * 실행중에 발생하는 에러 사항이기에 컴파일러는 관여를 못합니다.(순서 때문에...) 단, 알려진 예외 (Known Exception :
		 * RuntimeException 하위 타입이 아닌 애들) 인 경우엔 컴피일 시 컴파일러가 예외를 핸들링 했는지를 검사하게 됩니다.
		 */
		int a = 10, b = 0;

		/*
		while(true) {
			System.out.println("값 두개와 연산자 입력해..");
			
			if(!devide(a, b)) {
				System.out.println("0으로 나눌 수 없음..");
				break;
			}
			
			System.out.println("결과는 어쩌구..");
			System.out.println("계속 할래??");
			break;
		}
		*/
		
		//System.out.println("AAA");

		//찾으려는 파일명 넣어주세요..라고 띄웁니다.
		String fName = "test5.properties";
		try {
			getProp(fName);
			
		} catch (Exception e) {
			System.out.println("예외발생");
			System.out.println("예외 내용 : " + e.getMessage());
			e.printStackTrace();
		} finally {
			//이 블락은 예외 여부와 상관없이 무조건 실행되는 블락입니다.
			//보통 여기에는 파일을 접근했을 때 파일의 접근을 해제하거나,
			//DB 등에 연결했을 때 DB 연결 해제하는 등의 자원에 대한
			//맨 마지막 처리를 할 때 사용되는 블락입니다.
			try {
				
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		
		
		
		
		
		

	}

}
