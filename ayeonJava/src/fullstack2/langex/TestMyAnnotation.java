package fullstack2.langex;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestMyAnnotation {

	public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		//annotation이 적용된 클래스를 객체로 만들어, 어떻게 적용되는지 알아봅니다.
		Method[] methods = UseMyAnnotation.class.getDeclaredMethods();
		
		for(Method me : methods) {
			MyAnnotation2 myAnnotation2 = me.getAnnotation(MyAnnotation2.class);
			printLine(myAnnotation2);
			
			me.invoke(new UseMyAnnotation());
			
			printLine(myAnnotation2);
			
		}
	}

	//출력문을 메서드로 정의해서 이용할 수 있도록 할게요.
	private static void printLine(MyAnnotation2 myAnnotation2) {
		int num = myAnnotation2.number();
		for(int i =0 ; i<num; i++) {
			String val = myAnnotation2.value();
			System.out.print(val);
		}
		System.out.println();
	}
}
