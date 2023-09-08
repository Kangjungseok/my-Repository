package fullstack.methodEx1;

import java.lang.reflect.Array;
import java.util.Arrays;

import javax.print.attribute.standard.PrinterStateReason;

/*
 * 자바메서드(method) : 자바를 포함한 모든 객체지향 or 기반 언어들은 모두 method라는 
 * 개념을 가지고 있습니다. 단적으로 말하자면 프로그램이 어떤 일을 수행할 때 또는 여러분이
 * 수행하라는 명령어를 구현할 때 실제 그 업무를 담당하는 애가 메서드입니다.
 * 따라서 메서드에 대한 개념을 잘 알고, 업무(앞으로 Business Logic 이라고 합니다.)를
 * 코드를 구현하는 대부분의 대상이 이 메서드입니다.
 * 
 * 객체지향에서는 이 메서드를 객체가 어떤 행위(action)를 할 때 그 수단이 메서드라고도 하는데
 * 이 말은 잘 이해가 안 될테니, 제가 위에 정의한대로 이해하시면 됩니다.
 * 
 * 메서드 문법 : 앞으로 코드에서 문법에 []가 나오면 optional 이라는 의미입니다.
 * 즉 있어도 그만 없어도 그만..로직에 따라 틀려진다는 의미 입니다.
 * 
 * [public,protected,default,private] [static,abstract] void or return type ==>
 * (좌측에 선언된 걸 리턴타입이라고 합니다 void는 리턴이 없다는 의미, p or r type 모두 리턴 가능)
 *  methodName(parameter1, 2, ...){//메서드 바디 open
 * 		//메서드가 해야할 일 정의
 *		//만약 리턴 
 * }//메서드 바디 close
 * 
 * LIFO(Last In First Out) : 데이터의 적재 및 추출되는 형태를 나타내는 자료구조의 한 모델로,
 * 대표적인 형태가 자바에서 메서드가 수행될 때 사용되는 stack 메모리 구조이다.
 * 이 말은 메서드가 다른 메서드를 호출할 때, 호출된 메서드는 stack 호출한 메서드보다 
 * 위에 존재하기 때문에, 호출된 메서드가 모든 작업을 끝낼 때까지는 호출한 메서드는
 * 다른 작업을 못하는 상태로 유지된다.
 * 
 * 
*/
public class MethodEx1 {
	
	//*을 출력하도록 하는 메서드 정의(define)합니다.
	static void printStar(int count) {//지역변수
		/*
		 * try { Thread.sleep(1000 * 10); } catch (InterruptedException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 */
		for(int i=0; i<count; i++) {
			System.out.print("*");
		}
		System.out.println();				
	}
	
	//평균을 출력하도록 메서드를 정의합니다.
	static void printAvg(double[] avgArr) {
		
		avgArr[0] += 100;
		System.out.println(Arrays.toString(avgArr));
	
	}
	public static void main(String[] args) {
		
		int a = 10;
		printStar(a);//method called.
		System.out.println("당신의 점수는 : 100");
		printStar(a);//Call By Value. P타입을 param으로 넘기면, value를 복사해서 넘겨줌.
	
		double avg[] = {30, 40, 50};
		printAvg(avg);//Call By Ref. 객체를 param으로 넘기면, 전달시 Ref가 복사되어 넘어감.
		System.out.println(Arrays.toString(avg));
		
		//r타입 객체가 생성되면, heap 메모리에 instance가 생성됨.
		
		
		
		
		int[] aa = {1,2,3};
		int[] bb = {1,2,3};
		
		//두 객체 aa와 bb는 서로 같은 객체일까?
		
		if(aa == bb) {
			System.out.println("같은 객체입니다.");
			
		}else {
			System.out.println("틀린 객체입니다.");
		}
		
		
		
		bb = aa;
		//그렇다면 지금 aa와 bb는 같은 객체일까?
		//답은 같은 객체. bb가 본래 참조하고 있던 {1,2,3}은 몹쓸 인스턴스가 되었다.
		
		
		
	}
}

























