package fullstack.objex;

//Animal의 하위 type으로 Dog 클래스를 정의합니다.
//클래스에 final이 선언되면, 상속금지입니다.

/*class SubDog extends Dog{
	
}*/
public final class Dog extends Animal implements Eatable,Moveable{
	
	String name ;
	String breed ; 
	String gender;
	
	private int energy;
	private static final int FEEL_HUNGRY = 30;
	

	public Dog(String name, String breed, String gender) {
		super("개");
		this.name = name;
		this.breed = breed;
		this.gender = gender;
		this.energy = 50; //중간정도로 값을 설정합니다.
	}

	/*
	 * 메서드 오버라이드(Override) : 상속받은 부모의 메서드를 자식의 입장에서 내용부
	 * 즉 메서드 바디를 재정의 하는걸 말합니다. 이렇게 하는 이유는 기능적인 면으로 봤을 때
	 * 상속받은 부모의 메서드와 같지만, 내용이 자식입장에서 재정의될 필요성이 있을 경우를
	 * 처리하기 위해서 입니다.
	 * 단, 주의해야 할 것은 반드시 부모의 리턴타입, 메서드명과, 파라미터까지 모두 같아야 하며,
	 * 접근제어자(public > protected > default > private)는 부모와 같거나 
	 * 부모보다 커야합니다.  
	*/
	public String toString() {
		return super.toString() + " 이름은 " + name + " 품종은 " + breed + " 성별은 " + gender;
	}

	@Override
	public void sound() {
		// TODO Auto-generated method stub
		System.out.println("멍멍하고 소리냅니다.");
		
	}

	@Override
	public void eat() {
		if(this.energy <= Dog.FEEL_HUNGRY) {
			System.out.println(this.type + "가 먹이를 먹습니다");
			this.energy += 10;
			if(this.energy == Eatable.MAX_ENERGY) {
				System.out.println(this.type + "가 배가 불러서 그만 먹습니다.");
			}
		}else {
			System.out.println(type + "가 배가 안 고파 먹지 않습니다.");
		}
		
	}

	@Override
	public void moveNorm(int x, int y) {
		// TODO Auto-generated method stub
		System.out.println(this.type + "가 "+x+y+"로 "+ Moveable.DOG_NORM_SPEED+ " 속도로 이동합니다.");
	}

	@Override
	public void moveFast(int x, int y) {
		// TODO Auto-generated method stub
		System.out.println(this.type + "가 "+x+y+"로 "+ Moveable.DOG_SUPER_SPEED+ " 속도로 이동합니다.");
		
	}
	
	/* Animal의 final 메서드를 오버라이드 한 예..컴파일에러이다.
	@Override
	public void finalAnimalMethod() {
		// TODO Auto-generated method stub
		super.finalAnimalMethod();
	}
	*/
	
	//final이 메서드 파라미터에 사용되는 경우의 예
	//해당 변수는 지역에서 상수로 지정됩니다.
	
	/*
	public void dietDog(final String food, final int[] arr) {
		//food의 종류가 반드시 vegetable인 경우만 먹을 수 있도록 지정할게요
		String cowMeat = "소고기";
		//food = cowMeat;
		System.out.println("다이어트중인 멍멍이가 " + food + " 를 먹고있습니다.");
		
		arr = new int[] {1,2,3}; //객체 고정을 목적으로 final 선언되었기에 컴파일 에러
	}
	*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
