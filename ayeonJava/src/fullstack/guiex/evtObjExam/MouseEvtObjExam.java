package fullstack.guiex.evtObjExam;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MouseEvtObjExam extends Frame implements MouseListener {

	
	private Button bt = new Button("Catch Me If U Can");
	
	public MouseEvtObjExam() {
		super("마우스 리스너");
		
		//여기선 레이아웃 매니저를 아예 없애버립니다.
		this.setLayout(null);
		bt.setBounds(new Rectangle(50, 50, 80, 30));
		this.add(bt);
		this.setLocation(400, 300);
		this.setVisible(true);
		
		bt.addMouseListener(this);
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
				
			}
		});
	}
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		System.out.println("마우스를 누른 상태군요");

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("마우스포인터가 버튼영역에 왔네요..");
		bt.setLocation((int)(Math.random()*400 -10), (int)(Math.random()*300 -10));
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MouseEvtObjExam();
	}

}
