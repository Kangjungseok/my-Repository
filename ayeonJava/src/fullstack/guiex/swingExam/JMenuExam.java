package fullstack.guiex.swingExam;

import java.awt.Color;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;

public class JMenuExam extends JFrame{

	JMenuBar jmb = new JMenuBar();
	JMenu file = new JMenu("File");
	JMenuItem fnew = new JMenuItem("New File");
	JMenuItem fopen = new JMenuItem("Open File");
	JMenuItem fexit = new JMenuItem("Exit");
	
	JMenu edit = new JMenu("Edit");
	JMenu esize = new JMenu("Size");
	
	//여기에 HTML에서 radio input type 과 같은 RadioButtonItem 을 이용해서
	//메뉴의 Item으로 구성해볼게요.
	JRadioButtonMenuItem es10 = new JRadioButtonMenuItem("10");
	JRadioButtonMenuItem es20 = new JRadioButtonMenuItem("20");
	JRadioButtonMenuItem es30 = new JRadioButtonMenuItem("30");
	
	//아래는 Toggle처럼 다중의 버튼들이 나열되었을 때, 하나가 선택되면
	//나머지는 비활성화 되는 형태로 보여지는 ButtonGroup을 이용해볼게요.
	//위와 같은 효과를 주는 것을 Toggle 버튼이라고 합니다.
	
	ButtonGroup bg = new ButtonGroup();
	
	JMenu ecolor = new JMenu("Color");
	
	//아래는 MenuItem 중에서 Checkbox 형태로 보여지는 Component
	JCheckBoxMenuItem ecred = new JCheckBoxMenuItem("RED");
	JCheckBoxMenuItem ecgreen = new JCheckBoxMenuItem("GREEN");
	JCheckBoxMenuItem ecblue = new JCheckBoxMenuItem("BLUE");
	
	JMenu help = new JMenu("HELP");
	
	private void init() {
		
		//메뉴는 Frame에 붙여지는 형태이기 때문에 ContentPain 즉 Container에 
		//붙여지는게 아닙니다. 그냥 프레임이 add만 시킵니다.
		this.setJMenuBar(jmb);
		fexit.setArmed(true);
		file.add(fnew);
		file.addSeparator();
		file.add(fopen);
		file.addSeparator();
		file.add(fexit);
		jmb.add(file);
		
		//여러분들 GUI 플러그인에 보면 나오는 Bebel style을 지정해볼게요
		//Bebel은 컴포넌트에 외곽라인을 말하며, 이 스타일은 상수로 지정되어 있어서
		//적용하면 조금씩 다른 스타일이 보여질겁니다. 자세한건 GUI툴을 확인해보세요.
		
		edit.setBorder(new LineBorder(Color.red));
		esize.setBorder(new BevelBorder(BevelBorder.RAISED));
		ecolor.setBorder(new BevelBorder(BevelBorder.RAISED));
		
		//위 컬러 선택을 토글로 묶습니다.
		bg.add(es10);
		bg.add(es20);
		bg.add(es30);
		
		//메뉴에 아이템 add
		esize.add(es10);
		esize.add(es20);
		esize.add(es30);
		
		//edit에 esize add...(메뉴에 메뉴 add)
		edit.add(esize);
		edit.addSeparator();
		
		ecolor.add(ecred);
		ecolor.add(ecgreen);
		ecolor.add(ecblue);
		
		edit.add(ecolor);
		
		//메뉴바에 메뉴 add
		jmb.add(edit);
		jmb.add(help);
		
	}
	private void start() {
		
	}
	
	public JMenuExam() {
		this.init();
		this.start();
		this.setSize(500, 600);
		this.setLocation(300, 300);
		this.setVisible(true);
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new JMenuExam();
	}

}
