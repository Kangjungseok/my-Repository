package fullstack.objex;

public class Doojoon extends DonColeone{

	
	//fields 오버라이드?
	String name = "Doojoon";
	
	@Override
	public String familyBusiness() {
		// TODO Auto-generated method stub
		return  name+"은 "+ super.familyBusiness()+"의 아들";
	}
}
