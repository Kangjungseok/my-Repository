package kang;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Codeprogrammers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int answer = 0;
		int[] numlist = {12, 4, 15, 1, 14};
		int temp =0 ;
		
		
			for(int num : numlist) {
				temp = num;
				
				while(temp != 1) {
				
				if(temp % 2 ==0) {
					temp = temp /2 ;
					answer++;
				}else {
					temp = (temp-1) /2;
					answer++;
				}
				}
			}
		
		
		
		
		System.out.println(answer);
	
		
	}

}
