package fullstack.util.collectioneaxam.genericex;

import java.util.ArrayList;
import java.util.HashMap;

class Animal<P>{
	
}
class Dog extends Animal{
	
}
class Cat extends Animal{
	
}

class CatWoman extends Cat{
	
}

class TheZoo<P>{
	
	
}


public class GenericMethodEx {

	/*
	 * 메서드에 제네릭 타입 T를 파라미터에 걸고, 리턴메서드는 특정 타입만 지정되도록 해볼게요.
	 * 이렇게 되면 메서드 전체가(파라미터, 리턴 타입) 제네릭이 걸리는 형태가 됩니다.
	 * 이 중 메서드 리턴은 제한타입(즉, 특정 타입만 허용되도록) 걸어볼게요.
	*/
	
	/*
	static void doSome(Animal <? extends Animal> z) {
		System.out.println(z);
	}
	*/
	
	
	
	
	private static <T extends Number> boolean compare(T t1, T t2) {
		System.out.println("t1 타입 정보 : " + t1.getClass().getSimpleName());
		System.out.println("t2 타입 정보 : " + t2.getClass().getSimpleName());
		
		int i = t1.intValue();
		int i2 = t2.intValue();
		return(i == i2);
	
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(compare(10, 10)); 
		
		
		HashMap<Integer, String> map = new HashMap<>();
		ArrayList al = new ArrayList(map.values());
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
