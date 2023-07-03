package fullstack.methodEx1;

public class ComVal {

	int comnum=0;
	String com="" ;
	
	
	int createCom() {
		comnum = (int) (Math.random() * 3 + 1);
		return comnum;
	}


	
	switch (comnum) {
	case 1:
		com = "가위";
		break;
	case 2:
		com = "바위";
		break;
	case 3:
		com = "보";
		break;
	}
	
	
	
	
	
	
	 
}
