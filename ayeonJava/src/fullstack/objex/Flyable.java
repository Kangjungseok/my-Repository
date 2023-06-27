package fullstack.objex;

public interface Flyable extends Eatable, Moveable {

	//default 메서드와 private 메서드, 그리고 static private method 에 대한 설명
	/*
	 * jdk 1.8 이전까지는 모든 인터페이스에는 선언할 수 있는 코드가 딱 두 개만 가능했습니다.
	 * 이미 배웠던, 추상 메서드와 상수가 그것이죠.
	 * 
	 * 하지만 1.8 이후 부터는 목적에 따라서 메서드를 완전히 구현할 수도 있도록 변경되었습니다.
	 * 
	 * 하지만 대부분에서는 이전의 방식을 많이 사용합니다.
	 * 
	 * 이중 default 메서드만 살펴보도록 할 예정입니다. 다른 메서드는 모르셔도 문제없음.
	*/
	default int defMethod(int x, int y) {
		//특정 기능을 구현해서 상속되어지는 클래스나 인터페이스가 이 기능을 사용 또는
		//오버라이드 하도록 하는 목적입니다.
		//만약 오버라이드 하는 클래스는 반드시 public으로 선언하고 default는 삭제해야 합니다.
		
		return x + y;
	}
	
	
	void fly();//날 수 있는 기능 추가함.
}
