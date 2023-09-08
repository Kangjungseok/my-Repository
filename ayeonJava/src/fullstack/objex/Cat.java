package fullstack.objex;

//Animal의 하위 type으로 Dog 클래스를 정의합니다.
public class Cat extends Animal implements Eatable,Moveable{
	
	String name ;
	String breed ; 
	String gender;
	
	
	public Cat(String name, String breed, String gender) {
		super("고양이");
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
		System.out.println("나는 냐옹이다옹.");
		
	}
	

	@Override
	public void eat() {
		System.out.println(this.type + "가 먹이를 먹습니다");
		
	}
	
	@Override
	public void moveNorm(int x, int y) {
		// TODO Auto-generated method stub
		System.out.println(this.type + "가 "+x+y+"로 "+ Moveable.CAT_NORM_SPEED+ " 속도로 이동합니다.");
		
	}

	@Override
	public void moveFast(int x, int y) {
		// TODO Auto-generated method stub
		System.out.println(this.type + "가 "+x+y+"로 "+ Moveable.CAT_SUPER_SPEED+ " 속도로 이동합니다.");
		
	}
	
}
