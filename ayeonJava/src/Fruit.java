		/*
			Fruit라는 클래스를 만들어서 아래의 로직을 main()에 정의하고
			결과를 출력하세요.
			
			여러분이 과수원을 경영하고 있습니다.
			과일로는 사과, 배, 오렌지가 있고,
			각각 하루에 총 생산량은 7, 5, 5개 입니다.
			위 생산량을 기준으로 하루에 시간당 평균 몇 개의 과일이 생산되어지는에 대한
			평균을 내어 다음처럼 출력하세요.
			
			평균값은 반드시 float으로 나와야 합니다.
			
			3과일의 하루 24시간 기준 시간당 평균 생산량 : 3.145....
			
			조건 1. 반드시 한 번의 리터럴 데이터를 이용하세요.
			2. 반드시 한 번의 캐스팅 연산자를 이용하세요(우선순위 꼭 확인하세요)
			3. 모든 데이터는 반드시 변수에 담아서 활용하세요(리터럴 제외)
		
		*/
		
public class Fruit {
	
	public static void main(String[] args) {
		
		int PRAPPLE = 7;
		int PRPEAR = 5;
		int PRORANGE = 5;
		
		float total = (float)((PRAPPLE+PRPEAR+PRORANGE)/24.0) ;
		
		System.out.println(total);
			
		
		/*
			문자데이터 char(2byte - 음수가 없는 양의 수인 정수타입입니다.)에 대해서 알아봅니다.
			
			자바에서는 문자(문자 하나)를 취급하기에 char type을 사용하고
			내부적으로는 정수로 처리합니다. 이유는 JS 때에 강의 했듯이,
			유니코드를 기본 문자셋으로 자바에서 사용하기에, 해당 문자셋을 적용하는 정수를 사용합니다.
			
			정수이긴 하지만 음수가 없는 형태이기에 정수 타입의 데이터들과는 호환성에
			주의를 해야 합니다. 아래는 그 예입니다.
			
		*/
		
		char ch = 'A'; //문자를 표현하기 위한 표식으로 ''를 사용합니다.
		char ch2 = 'B';
		
		int so = ch;
		
		System.out.println((char)++so);
		
		char fName = '강';
		System.out.println(Integer.toHexString(fName));
		
		char fName2 = '\uac15'; //unicode 값의 문자값 대입..
		System.out.println(fName2);
		
		
		
	}

}
