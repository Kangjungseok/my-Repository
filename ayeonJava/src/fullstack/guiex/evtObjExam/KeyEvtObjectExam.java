package fullstack.guiex.evtObjExam;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import fullstack.methodEx1.Start;

import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class KeyEvtObjectExam extends JFrame implements KeyListener{

	private JPanel contentPane;
	private JPasswordField pass1;
	private JPasswordField pass2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KeyEvtObjectExam frame = new KeyEvtObjectExam();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public KeyEvtObjectExam() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		pass1 = new JPasswordField();
		pass1.setEchoChar('*');
		pass1.setBounds(30, 122, 129, 21);
		pass1.setColumns(6);
		contentPane.add(pass1);
		
		pass2 = new JPasswordField();
		pass2.setEchoChar('*');
		pass2.setBounds(232, 122, 129, 21);
		pass2.setColumns(6);
		contentPane.add(pass2);
		
		start();
	}
	private void start() {
		pass1.addKeyListener(this);
	}
	
	@Override
	public void paint(Graphics g) {
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		String str = new String(pass1.getPassword());
		//6글 번째 암호까지 누르고 난 후에 다음 암호 필드로 포커스 이동시켜보세요.
		
		if(str.length() == 6) {
			pass2.requestFocus();
		}
		
		System.out.println(e.getKeyChar());
		System.out.println(e.getModifiersEx() == InputEvent.ALT_DOWN_MASK);
		
		
	}
	
	
	
}
