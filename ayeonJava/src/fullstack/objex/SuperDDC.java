package fullstack.objex;

//인터페이스는 자신의 인스턴스를 만들지 못하기에, 이를 구현한(implements) 한
//구현체를 통해 메서드의 기능을 수행합니다.
//따라서 인터페이스를 구현한(implements) 클래스를 무슨무슨 interface 를 구현한
//구현체라고 합니다.(책에서 이런 표현들이 많이 나와서 혹시 헤맬까봐 친절하게 설명중)
public class SuperDDC extends Animal implements Flyable {



	
	public SuperDDC(String type) {
		super("슈퍼동물");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void eat() {
		System.out.println(this.type + " 슈퍼 DDC가 밥을 먹다");
	}

	@Override
	public void moveNorm(int x, int y) {
		System.out.println("슈퍼 DDC가 " + x + y + " 좌표로 이동함");
	}

	@Override
	public void moveFast(int x, int y) {
		int distance = defMethod(x, y);
		System.out.println("슈퍼 DDC가 " + x + y + " 좌표로 " + Flyable.CAT_SUPER_SPEED + " 이동함");
	}

	@Override
	public void fly() {
		System.out.println("슈퍼 DDC가 하늘을 날다.");
	}

	@Override
	public void sound() {
		System.out.println("슈퍼 DDC가 DDC!!! 라고 울부짖습니다.");
	}

	@Override
	public int defMethod(int x, int y) {
		// TODO Auto-generated method stub
		return Flyable.super.defMethod(x, y);
	}
	
	
	
}
