package fullstack.guiex.swingExam;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;

/*
 * JDialog : 일종의 팝업입니다.
 * 얘는 JFrame의 하위 타입처럼 인식하면 됩니다. 내부적으로 구성될 컴포넌트가 있다면
 * JFrame처럼 반드시 컨테이너를 획득한 뒤에 그 컨테이너에 컴포넌트를 구성해야 합니다.
 * 이 점만 잘 기억하세요
*/
public class JDialogExam extends JFrame implements ActionListener{

	//필드 선언부터 할게요.
	
	Container con;
	FlowLayout f1 = new FlowLayout();
	JLabel lb = new JLabel("ID : ",JLabel.RIGHT);//문자열 우측 정렬
	JTextField tf = new JTextField(10);//10자 길이의 TF 생성
	//모달 상태로 다이럴로그를 생성함..팝업을 닫지 않으면 부모창 선택 불가함.
	JDialog dialog = new JDialog(this, "ID 체커", true);
	
	Container dialogCon; //Dialog에서 컴포넌트 구성할 컨테이너
	JLabel dialogLb = new JLabel("사용가능한 ID임", JLabel.CENTER);
	BorderLayout dialoLayout = new BorderLayout();
	
	
	public JDialogExam() {
		this.init();
		this.start();
		
		this.setSize(400,450);
		this.setLocation(300, 300);
		this.setVisible(true);
		
	}
	
	
	private void start() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tf.addActionListener(this);
		dialog.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
	}
	
	private void init() {
		//컴포넌트를 구성하고 부착하는 작업수행합니다.
		//1.JFrame의 Container get
		con = this.getContentPane();
		con.setLayout(f1);
		con.add(lb);
		con.add(tf);
		
		//Dialog 컨테이너 get
		dialogCon = dialog.getContentPane();
		dialogCon.setLayout(dialoLayout);
		dialogLb.setBorder(new BevelBorder(BevelBorder.RAISED));
		dialogCon.add("Center", dialogLb);
		dialog.setSize(250, 200);
		
		dialog.setLocation(300, 300);
		
		
		
	}
	
	
	public static void main(String[] args) {
		new JDialogExam();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == tf) {
			//tf에 이벤트 발생 시 , 다이얼로그 보여줌.
			dialog.setVisible(true);
		}
	}

}
