package fullstack.nestedex;

import java.awt.Button;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrameEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Frame frame = new Frame();
		
		frame.setTitle("이건 java AWT 프레임");
		frame.setSize(300,300);
		frame.setLocation(300, 300);
		Button btn = new Button("클릭하세요");
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		frame.add(btn);
		frame.setVisible(true);
	}

}
