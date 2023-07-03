package fullstack.objex;

public class Duck extends Animal implements Eatable,Moveable {

	String name ;
	String breed ;
	String gender;
	
	public Duck(String name, String breed, String gender) {
		super("오리");
		this.name = name;
		this.breed = breed;
		this.gender = gender;
	}

	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return  super.toString() + " 이름은 " + name + " 품종은 " + breed + " 성별은 " + gender;
	}
	
	@Override
	public void sound() {
		System.out.println("꽥꽥하고 소리냅니다");
		
	}
	
	
	//알을 낳는 기능을 추가합니다. 이 기능은 부모에는 없고, 다른 클래스(cat, dog) 과는
	//다른 기능이기에 상속도 불가능합니다. 따라서 부모가 메서드를 보유하면 안 됩니다.
	public void layEggs() {
		System.out.println("오리 알 낳다.");
	}
	
	
	
	@Override
	public void eat() {
		System.out.println(this.type + "가 먹이를 먹습니다");
		
	}
	
	
	@Override
	public void moveNorm(int x, int y) {
		// TODO Auto-generated method stub
		System.out.println(this.type + "가 "+x+y+"로 "+ Moveable.DUCK_NORM_SPEED+ " 속도로 이동합니다.");
		
	}

	@Override
	public void moveFast(int x, int y) {
		// TODO Auto-generated method stub
		System.out.println(this.type + "가 "+x+y+"로 "+ Moveable.DUCK_SUPER_SPEED+ " 속도로 이동합니다.");
		
	}
	
	
	
	
	
	
	
	
	
}
