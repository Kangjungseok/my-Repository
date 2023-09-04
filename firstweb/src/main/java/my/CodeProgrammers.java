package my;

import java.util.Arrays;
import java.util.Stack;

public class CodeProgrammers {

	public static void main(String[] args) {
		
		int n = 356;
		String x = ""+n;
		int answer = 0;
		
		for(char c  : x.toCharArray()) {
			answer += Integer.parseInt(String.valueOf(c));
		}
		System.out.println(answer);

	}
}
