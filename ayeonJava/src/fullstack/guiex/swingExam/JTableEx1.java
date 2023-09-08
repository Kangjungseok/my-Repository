package fullstack.guiex.swingExam;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;

/*
 * JTable : 많은 정보를 한 번에 보여줄 수 있는 기능의 Component
 * 기본 형태는 Grid처럼 되어있어서, 이름 또한 Table입니다.
 * 
 * 데이터는 각각의 Cell에 저장되어지고 있고, 필요에 따라서는 
 * JScrollPane(스크롤을 생성해주는 역할을 하는 객체)에 담아서 스크롤로 데이터를 계속 보여줄 수 있습니다.
 * 
 * 가장 기본적인 사용 형태는 데이터(셀 내부에 존재하는...)를 다중 배열로 표현해 내는 방법입니다.
 * 
*/
public class JTableEx1 extends JFrame{

	JRootPane jrp;
	Container con;
	
	//데이터 생성..다중배열로, 데이터를 생성할게요.
	String[] str[] = {
			{"1_1","1_2","1_3","1_4",},	
			{"2_1","2_2","2_3","2_4",},	
			{"3_1","3_2","3_3","3_4",}	
	};
	//아래 배열은 각 쿨롱의 HEADER 정보를 배열로 선언합니다.
	String header[] = {"1번컬럼","2번컬럼","3번컬럼","4번컬럼"};
	
	//JTable 생성자 호출
	//JTable jt = new JTable(3, 4);//3행 4열의 JTable 생성 생성자...
	JTable jt = new JTable(str, header);
	
	//위처럼 뭔가 컴포넌트의 내용이 프레임보다 많아질 때, 스크롤을 적용해주는
	//객체를 이용해서, 위 테이블을 붙입니다.
	JScrollPane jsp = new JScrollPane(jt);
	
	public JTableEx1() {
		this.init();
		this.start();
		this.setSize(500, 500);
		this.setLocation(450, 450);
		this.setVisible(true);
	}


	private void start() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

	private void init() {
		// TODO Auto-generated method stub
		jrp = this.getRootPane();//JFrame의 맨 하위층의 Panel 얻어내기
		con = jrp.getContentPane();
		con.setLayout(new BorderLayout(5, 5));
		con.add("North",new JLabel("JTable입니다..", JLabel.CENTER));
		
		JPanel jp = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		jp.add(new JButton("확인"));
		jp.add(new JButton("취소"));
		con.add("South" ,jp);
		con.add("Center" ,jsp);
	}









	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new JTableEx1();
	}

}
