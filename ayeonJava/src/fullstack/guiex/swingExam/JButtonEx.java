package fullstack.guiex.swingExam;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
/*
 * 이 클래스에서는 Swing 컴포넌트에서 제공하는 이벤트 등에 대해서 보여주도록 할게요
 * 버튼 내의 글자 위치, 강제로 클릭시키는 기능, 특수키와 같이 사용되는 단축키 기능 등을 적용하는 예입니다.
*/
public class JButtonEx extends JFrame implements MouseListener{

	private Container con;
	
	//레이아웃 생성
	private FlowLayout f1 = new FlowLayout();
	private JButton jb = new JButton("String Value");
	private ImageIcon im = new ImageIcon("imgs/pikachu.png");
	
	private JButton jb1 = new JButton(im);
	private JButton jb2 = new JButton("String & Icon", im);
	
	private ImageIcon im1 = new ImageIcon("imgs/grassPoke.png");
	private ImageIcon im2 = new ImageIcon("imgs/pikachu2.png");
	
	
	
	public JButtonEx() {
		this.init();
		this.start();
		
		
		
		this.setSize(400, 450);
		this.setLocation(300, 300);
		this.setVisible(true);
	}
	
	
	private void start() {
		// JFrame은 close 이벤트를 상속 받지 않아도 기본 메서드로 창을 닫도록 정의됨
		//아래 코드를 사용하면 언제든 닫힘.
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jb.addMouseListener(this);
	}


	private void init() {
		// JFrame에 컴포넌트를 구성할 다중 Panel 중,contentPane을 얻어낼게요
		con = this.getContentPane();
		
		//con에 f1 레이아웃을 지정해보세요.
		con.setLayout(f1);
		
		//jb 버튼을 disable 시킴.
		jb.setEnabled(true);
		con.add(jb);
		//단축키를 지정하는 메서드입니다. 기본적으로 alt + 파라미터 키값으로 설정됩니다.
		jb1.setMnemonic('a');//alt+a 단축키 설정함
		con.add(jb1);
		
		jb2.setMnemonic('z');
		//아래 메서드는 마우스로 버튼을 눌렀을 때 이미지를 변화시키는 메서드입니다.
		jb2.setPressedIcon(im1);
		//아래 메서드는 마우스 오버 시 변경될 이미지 메서드입니다.
		jb2.setRolloverIcon(im2);
		
		con.add(jb2);
		
		
	}


	public static void main(String[] args) {
		new JButtonEx();

	}


	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == jb) {
			System.out.println("클릭됨");
			//강제로 클릭을 지속시키는 메서드 호출해서 5초동안 클릭하도록 합니다.
			jb.doClick(5000);
		}
	}


	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
