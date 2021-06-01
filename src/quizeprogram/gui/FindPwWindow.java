package quizeprogram.gui;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.SystemColor;

public class FindPwWindow extends JFrame{
	private JTextField id_Field;
	private JTextField question_Field;
	public FindPwWindow() {
		setTitle("아이디/비밀번호 찾기");
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel mainPanel = new JPanel();
		mainPanel.setBackground(SystemColor.inactiveCaption);
		getContentPane().add(mainPanel);
		mainPanel.setLayout(null);
		
		JLabel idLabel = new JLabel("아이디");
		idLabel.setHorizontalAlignment(SwingConstants.LEFT);
		idLabel.setFont(new Font("굴림", Font.BOLD, 15));
		idLabel.setBounds(14, 12, 62, 18);
		mainPanel.add(idLabel);
		
		id_Field = new JTextField();
		id_Field.setBounds(14, 32, 305, 35);
		mainPanel.add(id_Field);
		id_Field.setColumns(10);
		
		JLabel questionLabel = new JLabel("나의 학번은?");
		questionLabel.setFont(new Font("굴림", Font.BOLD, 15));
		questionLabel.setBounds(14, 76, 159, 18);
		mainPanel.add(questionLabel);
		
		question_Field = new JTextField();
		question_Field.setBounds(14, 99, 305, 35);
		mainPanel.add(question_Field);
		question_Field.setColumns(10);
		
		JButton findButton = new JButton("찾기");
		findButton.setFont(new Font("굴림", Font.BOLD, 15));
		findButton.setBounds(14, 145, 105, 27);
		mainPanel.add(findButton);
	
	
	
	}
}
