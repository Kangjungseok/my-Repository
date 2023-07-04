package fullstack.guiex.evtObjExam;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import fullstack.methodEx1.Start;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

public class FocusEventObjExam extends JFrame implements FocusListener{

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FocusEventObjExam frame = new FocusEventObjExam();
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
	private void start() {
		//텍스트필드 2개에 focus리스너 등록하고 구현체도 나로 지정하세요.
		textField.addFocusListener(this);
		textField_1.addFocusListener(this);
	}
	public FocusEventObjExam() {
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(36, 28, 126, 40);
		contentPane.add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("PassWord");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setBounds(36, 123, 126, 40);
		contentPane.add(lblPassword);
		
		textField = new JTextField();
		textField.setToolTipText("\uC544\uC774\uB514\uB97C \uC785\uB825\uD558\uC138\uC694~~~");
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setBounds(144, 38, 206, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setToolTipText("\uD328\uC2A4\uC6CC\uB4DC\uB97C \uC785\uB825\uD558\uC138\uC694~~");
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setColumns(10);
		textField_1.setBounds(144, 133, 206, 21);
		contentPane.add(textField_1);
		
		JButton btnNewButton = new JButton("\uD655\uC778");
		btnNewButton.setBounds(144, 206, 97, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\uCDE8\uC18C");
		btnNewButton_1.setBounds(253, 206, 97, 23);
		contentPane.add(btnNewButton_1);
		
		start();
	}

	@Override
	public void focusGained(FocusEvent e) {
		System.out.println("DD");
		if(e.getSource() == textField_1) {
			int length = textField_1.getText().length();
			
			if(length == 0) {
				textField_1.setText("값이 없습니다");
				textField_1.requestFocus();
			}
		}else if(e.getSource() == textField) {
			int length = textField.getText().length();
			
			if(length == 0) {
				textField.requestFocus();
			}
		}
		
	}

	@Override
	public void focusLost(FocusEvent e) {
		if(e.getSource() == textField) {
			if(textField.getText().length() == 0) {
				textField.setForeground(new Color(123,222,0));
				textField.setText("ID는 공백이 될 수 없음");
			}
		}
		
	}
}
