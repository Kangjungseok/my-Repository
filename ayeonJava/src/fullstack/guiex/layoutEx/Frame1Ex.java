package fullstack.guiex.layoutEx;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

import fullstack.methodEx1.Start;

//java에서 window 역할을 하는 Frame을 상속받을게요.
//상속받지 않아도 Frame을 생성할 수 있습니다. 즉
//모든 보여지는 창(window)는 무조건 Frame 타입이면 됩니다.

class MyFrame extends Frame{
	private Label lb1 = new Label("Label1");
	private Label lb2 = new Label("Label2");
	private Label lb3 = new Label("Label3");
	private Label lb4 = new Label("Label4");
	private Label lb5 = new Label("Label5");
	private Label lb6 = new Label("Label6");
	
	private void init() {
		//컨테이너에 적용할 레이아웃 객체 생성..기본은 Flow임.
		//FlowLayout flow = new FlowLayout(FlowLayout.TRAILING);
		//GridLayout grid = new GridLayout(2, 3, 10, 30);
		BorderLayout border = new BorderLayout(20, 20);
		

		this.setLayout(border);
		
		//각 컴포넌트에 컬러 속성 지정함.
		lb1.setBackground(Color.PINK);
		lb2.setBackground(Color.cyan);
		lb3.setBackground(Color.magenta);
		lb4.setBackground(Color.yellow);
		lb5.setBackground(Color.green);
		
		
		this.add(lb1, BorderLayout.CENTER);
		this.add(lb2, BorderLayout.EAST);
		this.add(lb3, BorderLayout.WEST);
		this.add(lb4, BorderLayout.NORTH);
		this.add(lb5, BorderLayout.SOUTH);
		//this.add(lb6);
		
		
		
		
	}
	
	
	//영역을 관리하는 객체입니다. 프레임이 화면에서 어디에 위치하는지 등의 정보와
	//화면의 해상도 등을 관리하는 객체.
	private Dimension  dimen, dimen1;
	private int xPos, yPos;
	
	//부모의 기본생성자를 통해서 기본 설정(프레임 크기, 위치 등)을 합니다.
	public MyFrame() {
		init();
		start();
		
		

		
		//뭔가를 초기화 할 때 사용되는 초기화 메서드
		this.setSize(500, 300);
		
		//Toolkit 이라는 클래스가 있는데, 이 클래스는 시스템에서
		//UI 정보(화면 해상도, 사운드 설정, 이미지 설정 등...시스템에서 필요한
		//리소스를 관리하는 객체입니다. 이 놈을 이용해서 영역 객체를 리턴받을게요(다 이럼)
		dimen = Toolkit.getDefaultToolkit().getScreenSize();
		dimen1 = this.getSize();
		
		//창의 left의  x,y 좌표값을 스크린의 센터를 기준으로 사등분하여 위치시킵니다.
		//즉 창이 화면의 가운데에 위치한다는 말입니다.
		xPos = (int)(dimen.getWidth()/2 - dimen1.getWidth()/2);
		yPos = (int)(dimen.getHeight()/2 - dimen1.getHeight()/2);
		
		//창의 위치값 설정 메서드 호출
		this.setLocation(xPos, yPos);
		//창을 화면에 보이게하는 메서드 호출
		this.setVisible(true);
		
		
		
	}

	private void start() {
		this.addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
			
			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
				
			}
			
			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}
}

public class Frame1Ex {

	public static void main(String[] args) {

		new MyFrame(); 

	}

}
