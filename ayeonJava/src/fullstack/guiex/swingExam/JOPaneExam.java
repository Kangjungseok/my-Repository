package fullstack.guiex.swingExam;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.print.attribute.standard.JobPriority;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

//JOptionPane의 다양한 사용법에 대해서 알아볼게요.
//JOptionPane은 간단한 팝업, 알럿, 입력창 기능을 모두 수행하는데,
//각 형태로 변경하는 방법은 내부에 선언된 상수를 이용하는 것입니다. 매우 쉬움...
//단계적으로 하나씩 볼게요
public class JOPaneExam extends JFrame{

	private Container con;
	private JOptionPane jop = new JOptionPane();
	
	public JOPaneExam() {
		this.init();
		this.setSize(300, 300);
		this.setVisible(true);
		
		//JOptionPane.showConfirmDialog(this, "저장할래요??","저장",JOptionPane.OK_CANCEL_OPTION, 
		//		JOptionPane.QUESTION_MESSAGE,new ImageIcon("imgs/pikachu.png"));
		
		//String[] str = {"노재현","이한울","송아현"};
		//JOptionPane.showInputDialog(this, "이름?", "이름", JOptionPane.INFORMATION_MESSAGE, null, str, "이한울");
		
		JOptionPane.showMessageDialog(this, "오류가 발생했네요", "오류창", JOptionPane.ERROR_MESSAGE);
		
	}
	void init() {
		con = this.getContentPane();
		con.setLayout(new BorderLayout());
	}
	public static void main(String[] args) {
		new JOPaneExam();

	}

}
