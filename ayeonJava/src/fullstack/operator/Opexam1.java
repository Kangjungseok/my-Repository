package fullstack.operator;

public class Opexam1 {

	public static void main(String[] args) {
		// 아래의 연산식의 결과값과 타입을 계산해보세요.
		// 4+5 > 2 -1 * 7 && (12 & 3 * 2) > 7 || -2 != 2;
		//  산  관  산  산   논리    비트  산   관   논     관
		boolean sum = 4+5 > 2 -1 * 7 && (12 & 3 * 2) > 7 || -2 != 2;
		System.out.println(sum);
		
		// 최 : ., [], () 1순위
		// 단 : !, ~(비트반전), +/-(음양표기), ++/--(선행 증감), (casting)
		// 산술 : 4칙 연산 + %
		// 쉬프트 : 비트이동 <<(left shift 연산자. 부호비트 안 건드림), >>(right shift), >>>(하나만 존재)
		// 관계 : <, >, <=, >=, ==, !=
		// 논리 : &, |, &&, ||
		// 삼항 : 조건식 ? true 리턴 값 : false 리턴값
		// 배정대입 : =, +=, ........
		// 후행증감 : ++/--
		
		System.out.println(Integer.toBinaryString(Integer.MAX_VALUE));
		
		System.out.println("1111111111111111111111111111111".length());
		
		int a = 1 ;
		System.out.println(Integer.toBinaryString(a << 2)); //4
		
		//4인 100 비트를 우측으로 3bit 이동했기에 기존 1이 자리한 비트는 비트 범위 밖이라 삭제됨
		System.out.println(Integer.toBinaryString(a >> 3)); //0
		
		// <<< 3개짜리 left shift(부호비트를 통째로 다 이동시키라는 의미입니다)
		int b = -1;
		System.out.println(Integer.toBinaryString(b));
		// >>>3 하면 부호비트부터 이동이 시작됩니다.
		//이동되는 비트의 자리는 모두 0으로 채워집니다.
		//따라서 아래의 결과는 음수 -1이 양수 큰 값으로 변경됩니다.
		
		System.out.println(Integer.toBinaryString(b >>> 3));
		System.out.println(b>>>3);
		
		//비트 반전 연산자 ~ = > 모든 비트를 다 반전시킵니다.
		System.out.println(~-1);
		
		//비트 AND OR 연산자
		//AND(&) => 두 비트를 비교해서 둘다 1인 경우만 1로 리턴
		//OR(|) => 두 비트를 비교, 둘 다 0인 경우만 0 리턴, 나머진 모두 1리턴
		
		int c = 10, d = 14;
		System.out.println(c & d); 
		System.out.println(c | d); 

	}

}
