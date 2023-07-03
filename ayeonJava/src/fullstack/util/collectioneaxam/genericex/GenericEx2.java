package fullstack.util.collectioneaxam.genericex;
/*
 * 클래스나 인터페이스를 정의 시에 타입을 파라미터로 지정할 수 있습니다.
 * 이 타입은 목적에 따라서 하나 또는 하나 이상이 되어질 수 있어요.
 * 이 때도 제네릭 코드를 선언해서 타입을 명기할 수 있습니다.
 * 이 때 쓰이는 키워드는 어떤 문자(영문자)가 와도 상관은 없지만,
 * 내부에서는 이 키워드가 타입을 매칭하는 객체로 사용되는 연관성이 있는
 * 키워드를 사용하는 것이 좋겠네요. 대문자를 사용하세요.
 *
*/

class GiftBox<K,B>{
	
	private K kind; 
	private B brand;
	
	public K getKind() {
		return kind;
	}
	public B getBrand() {
		return brand;
	}
	public void setKind(K kind) {
		this.kind = kind;
	}
	
	public void setBrand(B brand) {
		this.brand = brand;
	}
}

class SBuck{
	public String toString() {
		return "난 스타벅스입니다.";
	}
}
class MacBook{
	public String toString() {
		return "난 맥북입니다.";
	}
}





public class GenericEx2 {

	public static void main(String[] args) {
		
		GiftBox<String,SBuck> fGift = new GiftBox();
		fGift.setBrand(new SBuck());
		fGift.setKind("머그잔셋트");
		
		SBuck first = fGift.getBrand();
		System.out.println(fGift.getKind());
		
		GiftBox<Integer,MacBook> sec = new GiftBox();
		MacBook theGift = sec.getBrand();
		sec.setBrand(new MacBook());
		sec.setKind(2);
		System.out.println(sec.getKind());
		
		
	}

}
