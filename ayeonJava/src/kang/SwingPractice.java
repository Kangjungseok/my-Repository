package kang;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultButtonModel;
import javax.swing.JButton;
import javax.swing.JFrame;

public class SwingPractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		JFrame frame = new JFrame("제이프레임");
		frame.setSize(500, 500);
		// frame.setLayout(null);
		frame.setVisible(true);

		JButton jButton = new JButton("버튼이당");
		jButton.setBounds(250, 250, 100, 100);
		;
		jButton.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						System.out.println("버튼을 클릭했당");
					}
				}
		);

		frame.add(jButton);

	}

}
