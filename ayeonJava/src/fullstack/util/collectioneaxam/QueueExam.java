package fullstack.util.collectioneaxam;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class QueueExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Queue 자료구조 : Stack(LIFO)와는 반대로 FIFO 구조로 자료를 관리하는 형태
		 * 대표적인 메서드로는 offer(E), pop() 등이 있고, 나머지는 코드를 통해 확인해볼게요
		 * 
		*/
		
		Queue<String> q = new LinkedList<>();
		
		/*
		q.add("1");
		q.add("2");
		q.add("3");
		*/
		System.out.println(q);
		
		/*
		 * offer() : Queue 자료구조에서 HEAD(출구) 쪽으로 데이터를 자동 저장시킵니다.
		*/
		
		q.offer("6");
		q.offer("5");
		q.offer("4");
		
		System.out.println(q);
		/*
		while(!q.isEmpty()) {
			//poll() : Queue의 구조에서 출구 맨 앞에 있는 Element를 리턴하면서 삭제합니다.
			//peek() : 위와 같은나 삭제는 않고 리턴만 시킵니다.
			System.out.println(q.poll());
			//System.out.println(q.peek());
		}
		*/
		Stack<String> stack = new Stack<>();
		
		stack.push("5");
		stack.push("4");
		stack.push("3");
		stack.push("2");
		stack.push("1");
		
		while(!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
		
		
		//스택구조의 활용 예 : 연산식 검사, 괄호 검사, 이클립스에서의 undo/redo 수행
		//웹 브라우저의 back / forward 기능수행 등을 구현할 때 이 구조를 사용함
		
		//Queue : 채팅, 이클립스의 경우 최근 사용 문서의 리스트 등에서 볼 수 있음.
		
		
		
		
		
		
	}

}
