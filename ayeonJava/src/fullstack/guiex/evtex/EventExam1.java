package fullstack.guiex.evtex;
/*
 * 자바 GUI 이벤트 처리 방법
 * 
 * 1. 컴포넌트에 적용 가능한 이벤트를 addxxxListener() 로 찾는다...없다면 그 이벤트는
 * 해당 컴포넌트에 적용 불가능한 이벤트란 의미입니다.
 * 
 * 2. 적용하고자 하는 이벤트 종류를 addxxxLister()로 등록한다.
 * 
 * 3. 이벤트가 발생하면 등록된 리스너가 이벤트의 후속 처리를 할 이벤트 구현 객체를 자동으로
 * 호출하기 때문에, 리스너 등록 시에 이벤트 구현객체를 파라미터로 넣어준다.
 * 
 * 4. 이벤트 구현 객체는 반드시 addxListener(구현객체 타입) 파람타입과 같아야 하기 때문에
 * 구현객체(클래스)는 반드시 파라미터 타입의 하위 타입이어야 한다.
 * 
 * 5. 구현객체는 이벤트가 실행된 후 상태에 따라 자동으로 호출(Invoked)되는 메서드를 목적에 맞게 
 * 적절히 오버라이딩 한다.
 * 
 * 6. 모든 xxxListener 들은 Interface 이기에 필요치 않은 메서드도 가져야 하는데, 이를 좀 더
 * 편하게 하기 위해 특정 리스너(자주 사용되는...) 하위엔 Adapter 클래스가 있다.
 * 이 클래스를 상속받아서 필요한 부분만 오버라이드 해도 된다.
 * 
 * 7. 모든 이벤트 발생 시 자동으로 Invoked 되는 메서드에는 이벤트에 대한 상세 내용을 가진
 * 객체인 xxxEvent 객체가 자동으로 시스템에서 생성하여 해당 메서드 파람으로 넣어주기 때문에
 * 이벤트를 핸들링 시 적절하게 해당 이벤트 객체의 속성, 메서드를 이용하여 로직을 작성한다.
 * 
 * 8. 아래는 리스너에 따른 Adapter 클래스 종류...
 * 
 * windowListener --> windowAdapter
 * MouseListener --> MouseAdapter
 * KeyListener --> KeyAdapter
 * FocusListener --> FocusAdapter
 * MouseMotionListener --> MouseAdapter 
 *  
*/

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Button;

//1번 방법 : Listener 를 구현하거나 Adapter를 상속 받은 임의의 클래스를
//구현객체로 적용하는 방법

//윈도우리스너를 상속받은 윈도우 아답터를 상속해서 윈도우 이벤트 구현객체로 정의합니다. 
class WindowDefine extends WindowAdapter{
	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}
}
class ActionDefine implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		//특정 컴포넌트에 액션 이벤트가 발생하면 Invoked 되는 메서드입니다.
		System.exit(0);
	}
}
//위 이벤트 구현 객체를 적용할 GUI 클래스 정의할게요.
class EvtEx1 extends Frame{
	
	private Dimension dim,dim1;
	private int x,y;
	private Button bt = new Button("CLOSE");
	
	public EvtEx1() {
		super("이벤트구현객체 적용1");
		
		this.init();
		this.start();
		
		this.setSize(400,400);
		
		dim= Toolkit.getDefaultToolkit().getScreenSize();
		dim1 = this.getSize();
		
		x = (int)(dim.getWidth() /2 - dim1.getWidth()/2);
		y= (int)(dim.getHeight()/2 - dim1.getHeight()/2);
		
		this.setLocation(x, y);
		//컨테이너 보여주기 메서드
		this.setVisible(true);
	}
	
	private void start() {
		//여기엔 이벤트나 쓰레드를 적용할 때 사용되는 메서드 영역입니다.
		this.addWindowListener(new WindowDefine());
		ActionDefine handler = new ActionDefine();
		bt.addActionListener(handler);;
	}
	
	private void init() {
		//화면 구성 적용 메서드.
		this.setLayout(new FlowLayout());
		//버튼을 프레임에 붙이기
		this.add(bt);
	}
	
}



public class EventExam1 {

	public static void main(String[] args) {
		new EvtEx1();
		
	}

}
