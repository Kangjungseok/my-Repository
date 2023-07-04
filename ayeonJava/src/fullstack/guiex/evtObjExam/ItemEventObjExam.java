package fullstack.guiex.evtObjExam;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import fullstack.methodEx1.Start;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.List;

public class ItemEventObjExam extends JFrame implements ItemListener{

	private JPanel contentPane;
	
	private JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ItemEventObjExam frame = new ItemEventObjExam();
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
	public ItemEventObjExam() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		Vector<String> hobby = new Vector<>();
		hobby.add("낮잠");
		hobby.add("노래 듣기");
		hobby.add("만화 보기");
		hobby.add("게임 하기");
		hobby.add("산책 하기");
		
		comboBox = new JComboBox<>(hobby);
		comboBox.setOpaque(true);
		comboBox.setBackground(new Color(122,125,120));;
		comboBox.setBounds(195, 51, 137, 29);
		
		contentPane.add(comboBox);
		
		JLabel lblNewLabel = new JLabel("\uCDE8\uBBF8");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(56, 51, 76, 29);
		contentPane.add(lblNewLabel);
		
		List list = new List();
		list.add("안녕");
		list.add("hi");
		list.add("there");
		list.setBounds(195, 113, 137, 138);
		contentPane.add(list);
		
		start();
		
	}

	private void start() {
		comboBox.addItemListener(this);
	}
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		
		int state = e.getStateChange();
		//JOptionPane.showMessageDialog(this, "선택여부값 : " +state);
		
		if(state == ItemEvent.SELECTED) {
			JOptionPane.showMessageDialog(this, comboBox.getSelectedItem());
		}
		/*
		if(e.getSource() == comboBox) {
			String item = (String)e.getItem();
			int idx = comboBox.getSelectedIndex();
			JOptionPane.showMessageDialog(this, idx + "을 선택했군요");
		}
		*/
	}
}
