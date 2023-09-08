package fullstack.guiex.layoutEx;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Frame2Ex extends JFrame {

	private JPanel contentPane;

	//컴포넌트 선언할게요.
	private JLabel lb1 = new JLabel("Label1");
	private JLabel lb2 = new JLabel("Label2");
	private JLabel lb3 = new JLabel("Label3");
	private JLabel lb4 = new JLabel("Label4");
	private JLabel lb5 = new JLabel("Label5");
	private JLabel lb6 = new JLabel("Label6");
	

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame2Ex frame = new Frame2Ex();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	//보통 GUI를 생성 시엔, 순서가 있습니다.
	//이 순서는 메서드로 분리해서 호출하는 방식을 취해요.
	/*
	 * 1. 컴포넌트 생성 및 배치 초기화하기
	 * 2. 컴포넌트에 이벤트 지정하기
	 * 3. 컨테이너에 컴포넌트(컨테이너) 부착(add) 하기
	 * 4. 컨테이너 보여주기
	*/
	//초기화 메서드 정의
	private void init() {
		//컨테이너에 적용할 레이아웃 객체 생성..기본은 Flow임.
		//FlowLayout flow = new FlowLayout(FlowLayout.TRAILING);
		//GridLayout grid = new GridLayout(2, 3, 10, 30);
		Border
		
		//컨테이너 역할을 할 JPanel 생성
		contentPane = new JPanel();
		//JPanel에 flow 배치 지정
		contentPane.setLayout(grid);
		
		//각 컴포넌트에 컬러 속성 지정함.
		lb1.setBackground(Color.PINK);
		lb2.setBackground(Color.cyan);
		lb3.setBackground(Color.magenta);
		
		contentPane.add(lb1);
		contentPane.add(lb2);
		contentPane.add(lb3);
		contentPane.add(lb4);
		contentPane.add(lb5);
		contentPane.add(lb6);
		
		
		
		
	}
	/**
	 * Create the frame.
	 */
	public Frame2Ex() {
		//초기화 메서드 호출
		init();
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 300);
		Dimension dimen = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension dimen1 = this.getSize();
		int xPos = (int)(dimen.getWidth()/2 - dimen1.getWidth()/2);
		int yPos = (int)(dimen.getHeight()/2 - dimen1.getHeight()/2);
		//setBounds(xPos, yPos, 450, 300);
		/*
		 * contentPane = new JPanel(); contentPane.setBorder(new EmptyBorder(5, 5, 5,
		 * 5));
		 */

		setContentPane(contentPane);
	}

}
