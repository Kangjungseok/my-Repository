package kang;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Codeprogrammers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] survey = {"AN", "CF", "MJ", "RT", "NA"};
		int[] choices = {5, 3, 2, 7, 5};
		int R=0;
		int T=0;
		
		int C=0;
		int F=0;
		
		int J=0;
		int M=0;
		
		int A=0;
		int N=0;
		
		String answer = "";
		
		for(int i = 0 ; i<survey.length;i++) {
			switch (survey[i].charAt(0)) {
			case 'R':
				 R = choices[i]-4;
				break;
			case 'T':
				R = choices[i]-4;
				break;
			case 'C':
				R = choices[i]-4;
				break;
			case 'F':
				R = choices[i]-4;
				break;
			case 'J':
				R = choices[i]-4;
				break;
			case 'M':
				R = choices[i]-4;
				break;
			case 'A':
				R = choices[i]-4;
				break;
			case 'N':
				R = choices[i]-4;
				break;
			default:
				break;
			}
		}
		
		if(R<T) {
			answer += "T";
		}else {
			answer += "R";
		}
		if(C<F) {
			answer += "F";
		}else {
			answer += "C";
		}
		if(J<M) {
			answer += "M";
		}else {
			answer += "J";
		}
		if(A<N) {
			answer += "N";
		}else {
			answer += "A";
		}
		
		System.out.println(answer);
		
		
	}

}
