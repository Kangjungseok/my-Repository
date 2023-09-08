package fullstack.guiex.graphicExam;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileInputStream;

import javax.swing.ImageIcon;

public class PaintImages extends Frame implements ActionListener {

	private Button bt = new Button("EnLarge");
	private Button bt1 = new Button("Shrink");

	private Image img = null;
	private int w = 200, h = 300;

	public PaintImages() {
		this.init();
		this.start();
		this.setSize(500, 650);
		this.setVisible(true);
	}

	private void start() {
		bt.addActionListener(this);
		bt1.addActionListener(this);
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

	}

	private void init() {
		// TODO Auto-generated method stub
		// 이미지객체는 기본적으로 Toolkit 객체의 메서드를 이용하면 쉽게 얻어낼 수 있습니다.
		//img = Toolkit.getDefaultToolkit().getImage("imgs/박효신.jpg");

		FileInputStream fis = null;
		try {

			fis = new FileInputStream("imgs/박효신.jpg");
			//System.out.println(Arrays.toString(fis.readAllBytes()));

			ImageIcon imageIcon = new ImageIcon(fis.readAllBytes());
			img = imageIcon.getImage();

			this.setLayout(new BorderLayout());
			// 버튼을 구성할 패널 생성
			Panel p = new Panel(new FlowLayout(FlowLayout.RIGHT));
			p.add(bt);
			p.add(bt1);
			this.add("North", p);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(img);
	}

	public static void main(String[] args) {
		new PaintImages();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == bt) {
			bt.setEnabled(false);
			bt1.setEnabled(true);
			bt1.requestFocus();
			w = h = 500;

			this.repaint();
		} else if (e.getSource() == bt1) {
			bt1.setEnabled(false);
			bt.setEnabled(true);
			bt.requestFocus();
			w = h = 200;

			// 여기서 중요한 개념..
			// 시스템에게 다시 그려달라고 요청할 경우엔 프로그래머는
			// repaint(); 메서드만 호출합니다.
			// 그럼 JVM은 이 요청을 받아서 내부적으로 update(); 를 자동으로 호출하고
			// update() 내부에서는 paint()를 자동으로 호출하게 되어지기에
			// 다시 그려지는 효과를 나타냅니다.
			// 실질적으로 update() 호출 시엔 우리 눈엔 보이지 않지만 이미 그려져 있는
			// 그래픽들을 모두 지우고 paint()를 재호출해서 다시 그려지는 형태입니다.
			this.repaint();
		}
	}

	// 처음 화면에 그려질 기본 이미지를 paint() 를 오버라이드해서 그립니다.
	@Override
	public void paint(Graphics g) {
		// 이미지를 그리는 도구를 g 객체를 통해 그려봅니다.
		g.drawImage(img, 50, 50, w, h, this);
	}

}
