package fullstack.guiex.graphicExam;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class PaintDoHyung extends Frame{

	public PaintDoHyung() {
		super("그래픽으로 뭔가를 그려보기");
		this.setSize(700, 700);
		this.setVisible(true);
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	
	@Override
	public void paint(Graphics g) {
		for(int i = 0 ; i<1000 ; i++) {
			//랜덤한 컬러 객체를 생성해볼게요
			int r = (int)(Math.random() * 256);
			int gr = (int)(Math.random() * 256);
			int b = (int)(Math.random() * 256);
			
			Color color = new Color(r, gr, b);
			
			//자바에서 뭔가를 그리는(Paint) 기능에 도구(붓) 역할을 하는
			//Graphics 객체에 물감(Color) 색을 입힙니다.
			g.setColor(color);
			g.drawString("Hello World", 50, 50);
			
			Dimension di = this.getSize();
			
			int x = (int)(Math.random() * di.getWidth());
			int y = (int)(Math.random() * di.getHeight());
			int w = (int)(Math.random() * 50) + 50;
			int h = (int)(Math.random() * 50) + 50;
			
			
			/*
			//어떤 도형을 그릴지를 결정하는 랜덤 정수...
			int dist = (int)(Math.random() * 4);
			
			if(dist == 0)	g.drawRect(x, y, w, h);
			else if (dist == 1) g.fillRect(x, y, w, h);
			else if (dist == 2) g.drawOval(x, y, w, h);
			else if (dist == 3) g.fillOval(x, y, w, h);
			*/
			
			
			
			
			
			try {
				Thread.sleep(100);
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			
		}
	}
	
	@Override
	public void update(Graphics g) {
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new PaintDoHyung();
	}

}
