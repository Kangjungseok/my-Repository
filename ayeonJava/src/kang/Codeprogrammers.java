package kang;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Codeprogrammers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int a = 5;
		int b = 3;
		int c = 3;
		int answer = 0;
		
		HashSet<Integer> set = new HashSet<>();
		
		set.add(a);
		set.add(b);
		set.add(c);
		System.out.println(set.size());
		
		switch (set.size()) {
		case 3:
			answer = a+b+c;
			break;

		case 2:
			answer =((int)(Math.pow(a, 2) + Math.pow(b, 2) + Math.pow(c, 2))*(a+ b+ c));
			
		default:
			answer = (int)(3*Math.pow(a, 3) * 3*Math.pow(a, 2) * 3*Math.pow(a, 1));
			break;
		}
		
	
		System.out.println((Math.pow(a, 2) + Math.pow(b, 2) + Math.pow(c, 2)));
		System.out.println((a+ b+ c));
		System.out.println((int)(Math.pow(a, 2) + Math.pow(b, 2) + Math.pow(c, 2))*(a+ b+ c));
		System.out.println(answer =((int)(Math.pow(a, 2) + Math.pow(b, 2) + Math.pow(c, 2))*(a+ b+ c)));
		
	}

}
