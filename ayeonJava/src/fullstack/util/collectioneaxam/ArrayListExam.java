package fullstack.util.collectioneaxam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class ArrayListExam {

	public static void main(String[] args) {
		ArrayList<FSStudent> function = new ArrayList();//빈 List 생성함
		//조장객체를 생성해서 Ele로 넣어볼게요.
		FSStudent hank = new FSStudent("김한규", 100, 100, 100);
		FSStudent kause = new FSStudent("강정석", 10, 10, 10);
		FSStudent jungw = new FSStudent("김정우", 95, 95, 95);
		FSStudent eunj = new FSStudent("황은지", 90, 90, 90);

		function.add(hank);
		function.add(kause);
		function.add(jungw);
		function.add(eunj);
		
		
		//기존 function조를 다른 조와 병합을 해볼게요.
		ArrayList<FSStudent> fullgae = new ArrayList<>(function);
		FSStudent ahyun = new FSStudent("아현", 89, 89, 89);
		fullgae.add(ahyun);
		
		//function조가 fullgae 내부에 포함되었는지 확인..
		if(fullgae.containsAll(function)) {
			System.out.println("function 조는 fullgae에 포함되어 있습니다.");
		}
		
		//function 조만 남기고 모두 삭제하기.
		fullgae.retainAll(function);
		System.out.println(fullgae.size()); 
		
		
		
		Iterator<FSStudent> it = fullgae.iterator();
		while(it.hasNext()) {
			System.out.println(it.next().getName());
		}
		
	
		
		
		Collections.sort(fullgae);
		
		for(FSStudent stu : fullgae) {
			System.out.println(stu.getName()+stu.getTotal());
		}
		
		
		

		
		
	}

}
