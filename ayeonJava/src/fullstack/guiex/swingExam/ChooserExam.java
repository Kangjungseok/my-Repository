package fullstack.guiex.swingExam;

import java.awt.Color;
import java.io.File;

import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class ChooserExam extends JFrame{
	
	JColorChooser jcc = new JColorChooser(Color.orange);
	JFileChooser jfc = new JFileChooser("D:\\");
	
	public ChooserExam() {
		this.setSize(300, 400);
		this.setLocation(300, 300);
		
		Color myColor = JColorChooser.showDialog(this, "내 색상 선택하기", Color.blue);
		System.out.println("선택된 색상 : " + myColor);
		
		jcc.setColor(myColor);
		
		jfc.showDialog(this, "파일선택하기");
		//다중파일선택 가능 메서드 사용하기
		jfc.setMultiSelectionEnabled(true);
		jfc.showDialog(this, "GGGG");
		File[] files = jfc.getSelectedFiles();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ChooserExam();
	}

}
