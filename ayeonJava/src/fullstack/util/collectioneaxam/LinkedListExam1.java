package fullstack.util.collectioneaxam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListExam1 {

	public static void main(String[] args) {
		LinkedList<String> linkedList1 = new LinkedList<>();
		
		linkedList1.add("1");
		linkedList1.add("2");
		linkedList1.add("3");
		
		System.out.println(linkedList1);
		linkedList1.addFirst("4");
		System.out.println(linkedList1);
		
		Iterator<String> it= linkedList1.descendingIterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		linkedList1.offerFirst("5");
		System.out.println(linkedList1);
		
		ArrayList<String> arrList = new ArrayList<>(linkedList1);
		
		
		
		
	}

}
