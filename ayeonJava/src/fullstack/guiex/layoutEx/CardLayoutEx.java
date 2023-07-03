package fullstack.guiex.layoutEx;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class CardLayoutEx extends Frame {

	// 중간 컨테이너 역할을 할 Panel 객체 생성...컨테이너이기 때문에
	// 각각에 레이아웃을 정의할 수 있습니다.
	private Panel p = new Panel();
	private Panel p1 = new Panel();
	private Panel p2 = new Panel();

	// 각 Panel에 적용할 cardLayout 생성...
	// 주의할 점은 카드레이아웃은 프레임에 적용되는게 아니라 이렇게 카드 한 장씩의 의미처럼
	// 구성될 Panel에 적용합니다.
	// 이 Panel을 Frame이 동적으로 add 시키는게 Point 에요
	CardLayout cardLayout = new CardLayout();

	private void init() {
		// Panel 전체에 색상 적용할게요.
		p.setBackground(Color.red);
		p1.setBackground(Color.green);
		p2.setBackground(Color.cyan);

		// 적용할 레이아웃 설정
		this.setLayout(cardLayout);

		// 프레임에 panel add 합니다.
		this.add("aaa", p);// add 메서드에 호출될 카드이름을 동적으로 부여합니다.
		// 위 코드는 p Panel 이름을 aaa로 지정한 코드임...나중에 이름으로 호출함
		this.add("bbb", p1);
		this.add("ccc", p2);
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

			}

			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub

			}
		});
	}

	public CardLayoutEx(String titleName) {// 프레임의 창 제목 파라미터 받음
		init();
		start();		
		this.setSize(500, 300);
		Dimension dimen = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension dimen1 = this.getSize();
		int xPos = (int) (dimen.getWidth() / 2 - dimen1.getWidth() / 2);
		int yPos = (int) (dimen.getHeight() / 2 - dimen1.getHeight() / 2);
		// 창의 위치값 설정 메서드 호출
		this.setLocation(xPos, yPos);
		// 창을 화면에 보이게하는 메서드 호출
		this.setVisible(true);
		
		//화면이 보여지면 5초 마다 카드이름을 호출해서 프레임의 컨텐츠를 변경합니다.
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//card 레이아웃의 show() 메서드를 이용해서 호출될 카드 이름을 호출합니다.
		cardLayout.show(this, "aaa");
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//card 레이아웃의 show() 메서드를 이용해서 호출될 카드 이름을 호출합니다.
		cardLayout.show(this, "bbb");
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//card 레이아웃의 show() 메서드를 이용해서 호출될 카드 이름을 호출합니다.
		cardLayout.show(this, "ccc");
		
		
	}

	public static void main(String[] args) {
		new CardLayoutEx("카드레이아웃");
	}

}
