package fullstack.util.collectioneaxam;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class MapExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * Map Interface : Map은 Collection의 직접적인 하위 타입은 아니지만,
		 * 내부에 여러 메서드를 통해 필요 시 key, value, key AND value 전체를
		 * Collection 타입으로 리턴하도록 정의하고 있습니다.(호환성)
		 * 
		 * Map의 대표적 클래스로는 HashMap이 있고, 초기부터 사용하던 HashTable은
		 * HashMap으로 대체되었다고 보면 됩니다.
		 * 
		 * Map은 데이터(객체)를 key로 관리하고, key는 중복 불가입니다.(덮어씀)
		 * 이러한 이유로 Map은 순차적(index 등을 통한)인 Element 접근은 불가능하고
		 * 오직 key로만 Value를 얻어낼 수 있습니다.
		 * 
		 *  만약 타입 변환이 필요하다면, 메서드를 통해 Collection 타입의 요소로 변환 가능합니다.
		 * 
		 * 
		 * 
		 * 
		 * 
		*/
		
		Map<Integer, String> map1 = new HashMap<>();
		map1.put(1, "일");
		map1.put(2, "이");
		map1.put(3, "삼");
		map1.put(4, "사");
		map1.put(5, "일");
		
		System.out.println(map1.size());
		System.out.println(map1);
		
		Map<Integer, Person> students = new HashMap<>();
		
		Person json = new Person("노재현", 31, 100);
		students.put(json.number, json);
		Person p1 = new Person("한울", 31, 200);
		students.put(p1.number, p1);
		Person p2 = new Person("아현", 31, 300);
		students.put(p2.number, p2);
		Person p3 = new Person("아연", 31, 400);
		students.put(p3.number, p3);
		Person p4 = new Person("대성", 31, 500);
		students.put(p4.number, p4);
		Person p5 = new Person("민건", 31, 600);
		students.put(p5.number, p5);
		
		//위 students 에 각 객체의 넘버값을 key로 해서 put 시켜보세요.
		
		System.out.println(students);
		
		System.out.println(students.containsKey(1));
		System.out.println(students.get(1).name);
		
		Iterator it = students.keySet().iterator();
		ArrayList<Person> values = new ArrayList<>(students.values()); 
		
		
		while(it.hasNext()) {
			for(Person p : values) {
				System.out.println(it.next() + " : " + p.name + "\n");
			}
			
		}
		
		
		
		
		
		
		
		/*
		Set set =  students.entrySet();
		Iterator it = set.iterator();
		
		while(it.hasNext()) {
			Map.Entry e = (Map.Entry)it.next();
			
			System.out.println(e.getKey());
			System.out.println(e.getValue());		
			
			
			
		
			
			Set subSet = ((HashMap)e.getValue()).entrySet();
			
			Iterator innerIt = subSet.iterator();
			
			System.out.println("-- "+e.getKey() +" {" +subSet.size() + "}");
			
			
		}
		*/
		
		
		
		
	}

}
