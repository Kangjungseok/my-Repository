package fullstack_referenceEx;

import java.util.Iterator;

public class ArrayEx1 {

	public static void main(String[] args) {


		System.out.println(args[0]);
		System.out.println(args[1]);
		/*
			자바의 배열(Array) : 배열은 이미 여러분이 JS 시간에 충분히 보았을테니,
			자세한 설명은 제외하고, 핵심만 강의해 드릴게요.
			
			배열부터는 p타입이 아니 R타입으로 지정되어있습니다.
			즉 이 말은 배열을 생성 및 사용할 때는 배열 인스턴스를 생성 후
			Reference를 이용해서 속성과 메서드를 이용해야 한다는 뜻입니다.
			단, 자바에서는 배열 객체만 유일하게 속성 하나만 가지고 있습니다.
			길이를 나타내는 length 입니다.
			
			
			배열은 생성시에 반드시 어떤 값들이 배열의 요소로 지정되어질지를 선언해야 합니다.
			즉 int의 값을 관리할 예정이면 
		
		**	생성식 1 : int[] arr = new int[5];
			
			처럼 생성을 해야 합니다. 위 코드는 arr 배열 객체에 5개의 데이터를 관리하는
			방을 생성한다는 의미입니다. 방번호인 index는 당연히 0부터 시작하고
			마지막 방 index는 length - 1 입니다.
			
			위처럼 생성하게 되면 각 index에는 해당 타입의 default 값이 자동으로 할당되어
			초기화되는데, 정수는 0, 실수는 0.0, char = \u0000, 문자열은 null
			boolean은 false, 객체는 null입니다.
			
			
			
			배열은 생성시에 위처럼 기본값이 초기화 되어 대입되기에 반드시, 배열의 크기는 
			주고 생성해야 합니다. (나중에 값 초기화 안 됨)
			
			아래는 위와는 다르게, 값을 직접 주고 생성하는 구문입니다.
		**	생성식 2 : String[] sArr = {"A", "B", "C"} //ABC 문자열을 초기화 한 배열 생성
			
			아래는 위 두 개를 합친 생성식입니다.
		**	생성식 3 : int[] intArr = new int[]{1,2,3} // 1,2,3 으로 값 초기화 한 배열 생성함
			
			배열부터는 객체(R type)이기 때문에 아래의 내용은 반드시 기억하고 이해해야 합니다.
			
			모든 객체는 Reference를 이용해서 instance를 관리 및 사용하기 때문에
			항상 머릿속엔 위 Ref가 어떤 인스턴스를 가르키는지 이해해야 합니다..(되게 중요함)
	
		*/

		//아래는 몹쓸배열(즉 ref를 하지 않은 배열을 생성해서, 내용만 봅니다.)
		//int type의 배열 3개짜리 생성
		System.out.println(new int[3]);
		
		
		//3개짜리 int type 배열객체를 생성합니다.
		int[] iArr1 = new int[3];
		System.out.println(iArr1);
		System.out.println(iArr1.length);
		//배열의 값 출력
		System.out.println("" + iArr1[0] + iArr1[1] + iArr1[2]);
		
		//배열생성식 2. 값을 초기화 한 배열 생성.
		int arr2[] = {1,2,3};//length 3인 배열 생성함
		for(int i =0; i<arr2.length; i++) {
			System.out.println(arr2[i]);
		}
		String sArr[] = new String[3];
		System.out.println(sArr[0]);
		
		//3번째 생성식입니다.
		//위 두 개의 생성식을 합친 형태
		float f[] = new float[] {1.0f,2.0f,3.0f};
		//jdk1.5부터 지원된 향상된 for를 이용한 배열 및 컬렉션의 값을 출력해봅니다.
		//문법 for(값 대입 변수 타입 변수명 : 배열 or 컬렉션){
				//변수명엔 값이 들어가있음.
		//	}
		for (float ft : f) {
			System.out.println(ft);
		}
		
		
		//int 배열 5개짜리를 생성해서 myArr에 ref하세요.
		//각 인덱스에는 10,9,8,7,6 이 들어가게 하는데,
		//반드시 for 구문을 이용해서 하세요.
		
		
		int[] myArr = new int[5];
		
		for(int i = 0, j = 10 ; i<myArr.length ; i++,j--) {
			myArr[i] = j;
		}
		
		
		String subject[] = {"국어","영어","수학"};
		
		for(int i =0; i<subject.length; i++) {
			System.out.println(subject[i] + "점수를 입력하세요");
		}
		
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//위처럼 생성하면 hashcode 가 출력됩니다.
		//hashcode란 생성된 instance가 heap 메모리 영역의 어떤 메모리 주소값에 
		//생성되었는지를 16진수와 배열의 타입을 문자열로 만들어서 제공하는 값입니다. 기억하세요.
		
		
		
		
	}

}
