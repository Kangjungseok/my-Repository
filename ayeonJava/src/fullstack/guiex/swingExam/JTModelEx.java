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
import javax.swing.table.DefaultTableModel;

/*
 * JTableModel : JTable에서 데이터와 연산처리를 중계하는 역할의 객체
 * MVC(Model View Controller) 패턴의 Model 역할을 담당합니다.
 * Model이라는 개념은 나중에 JSP, Servlet, SpringBoot 시간에 자세히 배울겁니다.
 * 단, Model은 뭔가 비즈니스 로직을 담당하는 논리적인 개념의 단위(객체)로 생각하세요.
 * 
*/
public class JTModelEx extends JFrame{

	JRootPane jrp;
	Container con;
	
	
	//DefaultTableModel dtm = new DefaultTableModel(3, 4);//3행 4열 Model 생성
	
	//데이터 생성..다중배열로, 데이터를 생성할게요.
	String[] str[] = {
			{"1_1","1_2","1_3","1_4",},	
			{"2_1","2_2","2_3","2_4",},	
			{"3_1","3_2","3_3","3_4",}	
	};
	//아래 배열은 각 쿨롱의 HEADER 정보를 배열로 선언합니다.
	String header[] = {"1번컬럼","2번컬럼","3번컬럼","4번컬럼"};
	
	DefaultTableModel dtm = new DefaultTableModel(str, header);
	
	
	JTable jt = new JTable(dtm);
	
	//위처럼 뭔가 컴포넌트의 내용이 프레임보다 많아질 때, 스크롤을 적용해주는
	//객체를 이용해서, 위 테이블을 붙입니다.
	JScrollPane jsp = new JScrollPane(jt);
	
	public JTModelEx() {
		this.init();
		this.start();
		this.setSize(500, 500);
		this.setLocation(450, 450);
		this.setVisible(true);
		
		System.out.println("1.컬럼의 클래스 이름 : " + dtm.getColumnClass(0)); 
		System.out.println("컬럼의 갯수 : " + dtm.getColumnCount()); 
		System.out.println("2.컬럼의 이름 보기 : " + dtm.getColumnName(2)); 
		System.out.println("컬럼의 값 세팅하기 setter 호출함.");
		dtm.setValueAt("강정석", 2, 2);
		System.out.println("셀 수정 가능여부 : " + dtm.isCellEditable(2, 2));
		System.out.println("2번 컬럼의 포지션 : " + dtm.findColumn("2번컬럼"));
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String[] s = {"1","2","3","4","5"};
		//모델에 컬럼 동작 추가함.
		dtm.addColumn("5번",s);
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String a[] = {"true","true","true","true","true",};
		dtm.addRow(a);
		
		String b[] = {"false","false","false","false","false"};
		dtm.insertRow(2,b);
		
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
		new JTModelEx();
	}

}
