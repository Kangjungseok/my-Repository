package fullstack.guiex.swingExam;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class JFrameEx1 extends JFrame {

	private Container con;
	private ImageIcon im,im1;
	private JButton j1 = new JButton("JButton");
	
	public JFrameEx1() {
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
		
	}


	private void init() {
		// JFrame에 컴포넌트를 구성할 다중 Panel 중,contentPane을 얻어낼게요
		con = this.getContentPane();
		
		im = new ImageIcon("imgs/pikachu.png");
		//프레임에 아이콘 설정하기
		this.setIconImage(im.getImage());
		im1 = new ImageIcon("imgs/pikachu2.png");
		
		//contentPane에 레이아웃 지정
		con.setLayout(new BorderLayout());
		con.add("North", j1);
		con.add("Center", new JButton("Hello", im1));
	}


	public static void main(String[] args) {
		new JFrameEx1();

	}

}
