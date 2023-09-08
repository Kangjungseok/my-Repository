package fullstack_referenceEx;

import java.util.Arrays;
import java.util.Iterator;

public class MultiArrEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 다중 배열 중 이차원 배열
		/*
		 * 배열 내부에 다시 배열을 생성하는 형태로 갯수는 제한 없이 맘대로 생성가능하다.
		 * 일반적으로 2~3차원 배열을 주로사용한다.
		 * 생성식은 이전처럼 3개의 형태를 갖는다.
		 * 
		 * 1. int[] multi1[] = new int[2][3] -> multi1 이라는 APT에 2개 동을 생성하고
		 * 각 동에는 3가구를 생성한다는 의미..따라서 총 가구수는 6개의 가구수이다.
		 * 위 코드는 기본 배열(앞으로 객체에서 기본 객체 또는 기본 배열 등이 나오면 무조건
		 * 특정 값으로 줘서 그 값으로 초기화 되지 않은, 즉 default value로 값 또는 필드의
		 * 값이 초기화 되어 생성된 객체를 통칭합니다. 꼭 기억하세요!!!)
		 * 을 생성한 코드이기에 2*3의 격자형(Grid) 형태의 배열이 생성되고, 실제 데이터는
		 * inner 배열의 각 index에 저장됩니다.
		 * 
		 * 2. int[][] multi2 = {{1,2,3},{,4,5,6}}; //특정 값으로 초기화한 배열 생성
		 * 위 코드에서 {}는 Outer 배열 즉 아파트의 한 동을 나타내며, 그 값의 수만큼
		 * 가구수가 생성되어 값으로 초기화 됩니다.
		 * 
		 * 3. int multi3 = new int[][]{{1,2},{3,4}}
		 * 위 코드는 Outer 배열은 2개, inner 배열도 2개인 2*2의 배열이 생성되어
		 * 1,2,3,4 라는 값으로 초기화 한 생성식입니다.
		 * 
		 * 꼭 기억할 것 하나 더 ...다중배열은 배열 내부에 배열이 존재하는 것이므로
		 * 두 배열 모두 length라는 속성을 갖습니다. 따라서 이 length를
		 * 잘 이용하는게 핵심입니다.
		 * 	
		*/
		
		
		
		int[] multi1[] = new int[2][3];
		//배열의 값을 문자열로 보고 싶을 때 이 API를 이용하면 쉽게 볼 수 있어요.
		
		//System.out.println(Arrays.toString(multi1));
		
		for(int i = 0 ; i<multi1.length; i++ ) {
			// 이 영역은 아파트의 동으로 진입했습니다.
			for(int j=0; j < multi1[i].length; j++) {
				System.out.println(multi1[i][j]);
			}
		}
		
		
		
		String myApt[][] = {{"한울","아현"},{"지호","기열"},{"서영","수정"}};
		
		for(int i = 0; i<myApt.length;i++) {
			for(int j=0; j<myApt[i].length; j++) {
				System.out.println(myApt[i][j]);
			}
		}
		
		
		//동적가변배열 이라고 있습니다. 잘 안 쓰이지만, 싸비스 차원으로다가..
		//머리에 그리세요..뭐가 나올지..
		
		char[] stars[] = new char[10][];
		for(int i = 0; i<stars.length; i++) {
			//가구를 만들게요..
			stars[i] = new char [i+1];
			for(int j =0; j<stars[i].length; j++) {
				stars[i][j] = '*';
				
				System.out.print(stars[i][j]);
			}
			System.out.println();
			
		}
		

	}

}
