package fullstack.operator;

public class memo {

	public static void main(String[] args) {

		int n = 41;
		int m = 78;
		String eq = "!";
		String ineq = ">";
		int answer = 0;
        
		
		System.out.println(eq);
		System.out.println(ineq);
		System.out.println(answer);
		
		System.out.println(eq == "=");
		System.out.println(ineq == ">");
		System.out.println(n>m);
		
        if(eq == "=" ) {
        	
        	if(ineq == ">") {
        		if(n>=m) {
        			answer = 1;
        		}else {
        			answer = 0;
        		}
        	}else {
        		if(n<=m) {
        			answer =1;
        		}else {
        			answer =0;
        		}
        	}
        	
        	
        }else {
        	if(ineq == ">") {
        		if(n>m) {
        			answer = 1;
        		}else {
        			answer = 0;
        		}
        	}else {
        		if(n<m) {
        			answer =1;
        		}else {
        			answer =0;
        		}
        	}
        	
        }
		
		
		
        System.out.println("answer는 :"+answer);
		
		

	}

}
