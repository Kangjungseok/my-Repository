package fullstack.objex;

import java.util.Iterator;

import fullstack.ifex.IfExam;

public class Zoo {

	public static void main(String[] args) {
		
		
		
		//내가 쓴 주석 : DDC 인스턴스 안에 Animal, Moveable, Eatable, Flyable이 다 있기 때문에
		//DDC를 참조하는 객체들은 A,M,E,F 로 다 형변환이 가능하다.
		Animal a = new SuperDDC("DDC");
		
		//Flyable f = a; // 이건 안 됨. a 명세서는 여전히 Animal이라서.
		
		Flyable f2 =(Flyable)a; // 이건 됨. a가 가리키는 실제 인스턴스는 DDC고 DDC 안에 Flyable이 있기 떄문에
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		// 현실적으론 말도 안 되지만 Animal 인스턴스를 생성해 볼게요.
		//Animal animal = new Animal();//기본생성자를 호출해서 잘 생성됨.
		
		
		
		Dog dog = new Dog("콩이", "믹스견", "암컷");//기본생성자 호출되어서 잘 생성됨.
	//	System.out.println(dog);
	//	dog.sound();
		
		Cat cat = new Cat("냐옹이", "포켓몬", "수컷");
	//	System.out.println(cat);
	//	cat.sound();
		
		Duck duck = new Duck("도널드덕", "디즈니", "수컷");
	//	System.out.println(duck);
	//	duck.sound();
		
		SuperDDC superDDC = new SuperDDC("DDC");
		
		//인스턴스는 한 번 생성되면 메모리에서 사라지기 전까지 그 타입은 절대 불변입니다.
		//객체 변수 or dog2 객체 or dog2 ref 변수
		
		Animal dog2 = new Dog("두아2", "토이푸들2", "Female2");
	//	System.out.println(dog2);
		
		
		
		
		/*
		Animal animal1 = dog;
		Animal animal2 = cat;
		Animal animal3 = duck;
		*/
		
		//Animal 클래스 타입의 객체를 담는 배열 선언합니다.
		Animal[] animals = {dog, cat, duck,superDDC}; 
		//Dog dg = (Dog)animals[0];
		
		/*
		for(int i=0; i<animals.length;i++) {
			
			Animal theAnimal = 
					animals[(int)(Math.random() * animals.length)];
			System.out.println(theAnimal);
			theAnimal.sound();
			
			//instanceof 연산자 : 주어지는 객체가 주어진 클래스의 인스턴스인지를
			//물어보는 연산자입니다. VM이 동적으로 판별 후 맞으면 true, 아니면 false 리턴.
			
			if(theAnimal instanceof Duck) {
				((Duck)theAnimal).layEggs();				
			}
			
			//모든 동물에게 eat()을 호출해보세요.
			//타입 캐스팅을 통해서 eat() 을 호출해야 합니다.
			
			Eatable eatable = (Eatable)theAnimal;		
			eatable.eat();
			
			Moveable moveable = (Moveable)theAnimal;
			moveable.moveFast(10, 20);
			moveable.moveNorm(-20, -30);
		}
		*/
		
		
		/*
		 * 먹을 수 있는(eatable) 동물들 그룹으로 배열을 생성해서
		 * 모든 동물의 객체를 값으로 채우세요.. 당연히 4종류겠네요.
		 * 모두 채워진 배열을 loop하면서 eat()을 호출하는데,
		 * 이중 날 수 있는 기능을 가진 객체는 날도록(fly()) 호출하세요.
		 */
		
		
		//Animal 클래스 타입의 객체를 담는 배열선언합니다.
		Animal[] animals2 = {dog, cat, duck};
		Eatable[] theAnimals = 
			{(Eatable)animals2[0],
				(Eatable)animals2[1],
					(Eatable)animals2[2],
						new SuperDDC("Super DDC")}; 
				
		for(Eatable animal : theAnimals) {
			animal.eat();
			if(animal instanceof Flyable) {
				((Flyable)animal).fly();
			}
		}
		
		
		/* 내가 한 코드
		Eatable[] eatable = {dog, cat, duck, superDDC};
		
		for(int i=0; i<eatable.length; i++) {
			eatable[i].eat();
			if(eatable[i] instanceof SuperDDC) {
				((Flyable)eatable[i]).fly();
			}	
		}
		*/ 
		
		
		
		
		
		
		
		
		
		
		/*
		 * 다형성 : 객체지향언어에서는 다형성이란 개념이 있습니다.
		 * 이 의미는 쉽게 표현하자면, 하나의 인스턴스가 상속관계에 있는 클래스를 바탕으로 
		 * 생성되었다면, 해당 인스턴스를 Ref 하는 클래스타입이 다양하게 변경되어질 수 있다는 말입니다.
		 * 즉 자식 인스턴스를 발생했을경우에, 그 Ref 타입은, 자식 그리고 부모 모두 되어질 수 있다는 말입니다.
		 * 
		 * 이렇게 하는 이유는 오버라이드를 한 메서드를 타입 구분 없이 동일하게 호출하된
		 * 구현되는 내용은 오버라이드 한 내용이 나오도록 함입니다.
		*/
		
		
		
		/*
		int a=10;
		double[] b = {a, 5, 20};
		
		a = b[0]; //대입이 안 됨. b[0]는 double타입이 되었기 때문
		*/
		
		

	}

}
