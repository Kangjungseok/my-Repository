package fullstack.guiex.evtObjExam;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Label;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class ActionEventEx extends Frame implements ActionListener{

	private Dimension dim,dim1;
	private int x,y;
	
	private Label lb = new Label("Result : No Button Clicked", Label.CENTER);
	
	private Button bt = new Button("Button 1");
	private Button bt1 = new Button("Button 2");
	
	public ActionEventEx() {
		super("Action 이벤트 객체 알아보기");
		
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
	private void init() {
		//프레임에 보더레이아웃을 적용합니다.
		this.setLayout(new BorderLayout());
		
		//프레임 내에 부착될 컨테이너 생성(Panel)
		Panel p  = new Panel();
		//판넬에 다시 레이아웃 적용함..Gridbaglayout은 그냥 알고만 있으세요.
		GridBagLayout gb = new GridBagLayout();
		//gb 레이아웃에 실제 요소를 배치하는 객체인 constraints 객체 생성
		GridBagConstraints gc = new GridBagConstraints();
		//판넬에 gb 레이아웃 적용
		p.setLayout(gb);
		
		gc.insets = new Insets(0, 0, 0, 10);
		gb.setConstraints(bt, gc);
		p.add(bt);
		
		gc.insets = new Insets(0, 10, 0, 10);
		gb.setConstraints(bt1, gc);
		p.add(bt1);
		
		//프레임의 북쪽으로 라벨 부착
		this.add("North", lb);
		//프레임의 Center에 판넬 부착...이러면 북쪽을 제외한 모든 영역을 p가 다 사용함
		//어제는 Border 레이아웃의 상수를 이용해서 방위를 지정했지만
		//아래처럼 방위를 문자열로 줘도 됨..단 첫자만 대문자여야 함..
		this.add("Center",p);
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
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//액션이 발생될 때마다 액션의 모든 정보를 담은 ActionEvent 객체를 시스템의 파람으로 준다
		if(e.getSource() == bt) {
			lb.setForeground(Color.red);
			lb.setText("Button1 Clicked");
		}else if (e.getSource()==bt1) {
			lb.setForeground(Color.BLUE);
			lb.setText("Button2 Clicked");
		}
		
	}
	public static void main(String[] args) {
		new ActionEventEx();

	}
}
