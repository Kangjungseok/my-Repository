package fullstack.util.collectioneaxam;
//프로그래머가 정의한 클래스를 정렬을 통해 저장 또는 정렬을 시킬 때는
//반드시 comparable or comparator 중 하나를 구현해야 합니다.
//아래는 Person 클래스를 위 중 하나를 구현해서 정렬시킬 수 있도록 해봅니다.
public class Person implements Comparable<Person>{

	/*
	 * 비교할 특정 필드값을 오버라이드 하는데, 비교할 객체와 같으면 0,
	 * 적으면 음수, 크면 양수를 리턴하도록 정의합니다. 
	*/
	
	public String name;
	public int age;
	public int total;
	public static int number = 0;

	
	public Person(String name, int age, int total) {
		this.name=name;
		this.age = age;
		this.total=total;
		number++;
	}
	
	
	
	
	@Override
	public int compareTo(Person otherPerson) {
		//이 메서드를 호출하는 객체에 다른 Person 타입의 객체가 올 경우
		//age 값을 비교해서 위 로직대로 처리합니다.

		return this.age - otherPerson.age ;
	}

}
