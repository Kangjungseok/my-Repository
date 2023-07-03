/*
	여기서 배울 내용은 Data type 부터 배웁니다.
	
	자바는 데이터 타입이 엄격히 구분되어집니다.
	
	즉 어떤 값이 존재하려면 메모리가 필요하고 그 메모리에 값이 들어갈 때
	값의 타입에 따라서 분류를 하게됩니다. 이를 데이터 타입이라고 합니다.
	
	타입은 크게 2종으로 구분되는데, 반드시 기억하세요!!! 반.드.시
	
	1.Primitive Type(P type) : 이 타입은 객체를 제외한 모든 타입을 말합니다.
	종류로는 수치형, 문자형(문자열 아님), 불린형으로 구분되어지고
	수치형은 다시 정수형, 실수형으로 구분되어집니다.
	수치형은 다시 음수와 양수를 갖도록 되어지기에, 이 모두를 기억하세요.
	데이터타입은 여러분이 코드내에서 어떤 값을 대입 또는 초기화 시킬 때 그 타입이 맞는 변수에 
	넣어야 한다는 말입니다. 이 말은 곧 변수가 처음 선언될 때는 반드시 타입이 먼저 선언되어야 
	한다는 말입니다. 꼭 기억하세요. 
	만약 타입이 틀리면 바로 에러입니다.
	
	
	2.Reference Type(R type) : P type 을 제외한 모든 타입은 참조형 즉 객체 타입을 말합니다.
	대표적으로는 문자열값을 담는 String 객체가 있고, 여러분이 이 객체에 대해서 공부할 예정입니다.
	
	
	int x; //declare
	
	x = 10; //assine
	
	
	
	
	
	
*/
public class DataTypeEx {
	
	public static void main(String[] args) {
		//정수형 타입(byte(1byte or 8bit), short, int(default type), long
		
		/*
		 *	byte 타입 (-128~127) 범위의 정수를 담는 타입.
		 *	수치 연산할 때는 안 씁니다. 나중에 stream 이라는 거 할 때 사용될 예정입니다.
		 *	하나만 말하자면, 여러분이 채팅할 때 모든 문자열은 byte로 변경되어서 나갑니다.		
		 */
		
		
		
		byte b; //byte type 변수 b 선언함
		b = -128;
		
		//자바의 변수 선언 및 대입, 초기화하는 예제.
		//또 하나는 지역 내에서(클래스, 메서드 모두) 재선언시 에러 발생 예제도 포함.
		
		// b =20; //컴파일 에러.. 같은 지역에선 재선언 불가합니다.
		
		//b = 1 //빠져서 에러..무조건 구문의 끝에는 ; 넣어야 합니다. (루프(do while 제외),
														//if 제외
		//같은 타입의 변수 한 번에 선언하기.
		byte c,d,e,f; // 좌 변수는 모두 byte 타입임.
		c=d=e=f=0; //모두 0으로 대입하기
		
		//콘솔에 출력하기 System.out.println(내용) --> 출력 후 라인변경
		//System.out.print(내용) --> 출력 후 커서 위치 출력결과 바로 옆
		
		System.out.print(c);
		/* println 의 ln 은 next line의 약자 */
		System.out.println(c + ":" + d);
		
		//문자열과 + 다른 타입이 만나면 결과는 모두 문자열임(String...JS와 같음)
		String cc = "1" + 1;
		
		
		//gg, oo, jj 라는 변수를 모두 byte로 선언 후 다음과 같이 하세요
		//gg는 선언 후 10을 대입, oo는 gg의 값을 대입
		//jj -100으로 초기화 후 모두 출력하세요.
		
		byte gg;
		gg = 10;
		byte oo = gg;
		byte jj = 100;
		
		System.out.println(gg);
		System.out.println(oo);
		System.out.println(jj);
		
		
		
		//short 데이터 타입(2byte 정수형 타입)
		//대략 -25,000 ~ +25,000 까지의 범위를 갖습니다.
		//이 short는 자바에서는 사용되지 않는 타입이니 크기와 개념만 알고 가세요.
		
		System.out.println(Short.MAX_VALUE);
		System.out.println(Short.MIN_VALUE);
		
		
		short s = c; //바이트 값을 short에 대입 --타입 프로모션
		
		s = 30000;
		
		
		
		d = (byte)s;//캐스팅 연산수행.. 단 결과는 상위 8비트는 모두 삭제 되어지고 나머지 8비트의 값만 대입됩니다.
						
		
		System.out.println(d);
		
		//정수의 기본타입인 int에 대해서 알아봅니다.
		//4byte의 크기를 갖고 범위는 찍어보세요
		
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);
		
		
		s = 0; //short 타입
		d = 0; //byte 타입
		
		int s2 = s + d;
		
		int st = s + 0;
		
		
		//long 형 : 8byte의 정수타입이며, 정수의 무한대영역의 값을 담습니다.
		//long 형은 값 대입시 끝에 대문자 L을 넣어서 표시해 주면 좋습니다.
		
		
		long lo = 10L;
		
		long res = 10 + lo;
		
		
		//이번에 실수형타입을 봅니다.
		//float(4byte), double(8byte default type)
		
		System.out.println(Float.MAX_VALUE);
		
		float fl = 3.14F; //리터럴(..내가 직접 대입한 값?) //float은 값 끝에 f or F를 넣어서 표기해준다.
		
		lo = (long)fl; //캐스팅을 통한 대입 OK.. BUT 소숫점 이하는 절삭된 정수부만 넘어감
		System.out.println(lo);
		
		double ff = 1 + 3.14;
		
		// (int 20억 + int 21억 > Integer.MAX_VALUE) {long res= } .... 값이 굉장히 크다고 느껴질 때는 long이나 double을 써라
		
		

		
		
		
		/*
			수치형 타입의 연산시 발생되는 연산 수행 단계에 대해 설명합니다.
			
			자바에서는 정수의 기본 타입은 int입니다. 기본 타입이라고 하는 말은
			코드에서 100, 300, 25000 즉 int 범위를 넘지 않는 리터럴을 사용하면
			VM에서는 기본형인 int 메모리(32bit, 4byte)를 만들어서 값을 대입시킵니다.
			그렇기 때문에 기본형이라고 하고, 이는 다시 연산자를 만났을 때도 아래처럼 적용됩니다.
			
			기본형 이하의 타입끼리 연산시엔 두 피연산자(변수)의 타입을 기본형(int)로 변경 후 
			연산을 하게됩니다. 이 말은 byte + short의 연산이 될 때 두 타입을 먼저
			int와 int로 변경 후 int로 리턴한다는 뜻입니다.
			
			만약 int보다 큰 타입과의 연산시엔 더 큰 타입으로 먼저 변경 후 연산, 결과를 리턴합니다.
			당연히 두 개의 피연산자중 큰 타입으로 변경되어 리턴되어집니다. //
			
			아래의 내용은 반드시 기억하세요.
			
			데이터타입 프로모션 : 작은 타입의 변수의 값을 큰 타입에 대입하면, 그 값의 타입은 
			자동으로 큰 타입으로 변경되어집니다. 따라서 대입을 할 때도 이 개념을 생각해서 
			타입 결정을 해야합니다.
			
			데이터타입 캐스팅(Casting) : 큰 타입의 데이터(변수)를 작은 타입에 대입할 때
			기본적으로는 컴파일 에러입니다(type mismatch). 하지만 때에 따라선 그렇게 해야 하는데,
			이 때 사용되는 대표적 연산자인 casting 연산자 (type)을 사용해서
			타입을 작게 변형해야 합니다.
			
			이 연산자는 우선순위가 2번 째로 높고, 우측항 하나만 영향을 미치게 됩니다.
			
			이 주석내용들은 반드시 머리에 숙지해야 합니다. 반.드.시
			
		*/
		
		
		
		
		
		
		//boolean 형 : true or false만 갖는 타입.
		//JS와는 다르게 정수 0/1을 값으로 못 갖습니다. only true or false만 받아요
		
		boolean uFun = true;
		
		if(uFun) {
			System.out.println("다행입니다. 앞으로도 화이팅!!");
		}else {
			System.out.println("어려운걸 말해주세요. 도와드릴게요ㅠㅠ");
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
