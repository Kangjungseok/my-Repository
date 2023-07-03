package fullstack.objex;

public class ALPacino extends DonColeone{

	
	//fields 오버라이드?
	String name = "ALPacino";
	
	String service = "군 복무중";

	@Override
	public String familyBusiness() {
		// TODO Auto-generated method stub
		return name+ "은 "+ super.familyBusiness()+"의 아들이자 " + service;
	}
	
	
	
}
