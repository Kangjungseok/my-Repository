package fullstack.objex;

public class RobertDubal extends DonColeone{

	//fields 오버라이드?
	String name = "RobertDubal";
	
	@Override
	public String familyBusiness() {
		// TODO Auto-generated method stub
		return name+ "은 "+ super.familyBusiness()+"의 아들";
	}
}
