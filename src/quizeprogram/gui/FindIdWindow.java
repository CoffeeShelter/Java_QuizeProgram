package quizeprogram.gui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import quizeprogram.db.User;
import quizeprogram.db.UserDAO;

public class FindIdWindow extends JFrame {
	private JTextField nickName_Field;
	private JTextField question_Field;
	
	public FindIdWindow() {
		setTitle("아이디/비밀번호 찾기");
		setSize(355,  240);
		getContentPane().setLayout(new BorderLayout(0, 0));
		setLocationRelativeTo(null);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setBackground(SystemColor.inactiveCaption);
		getContentPane().add(mainPanel);
		mainPanel.setLayout(null);
		
		JLabel idLabel = new JLabel("닉네임");
		idLabel.setHorizontalAlignment(SwingConstants.LEFT);
		idLabel.setFont(new Font("굴림", Font.BOLD, 15));
		idLabel.setBounds(14, 12, 62, 18);
		mainPanel.add(idLabel);
		
		nickName_Field = new JTextField();
		nickName_Field.setBounds(14, 32, 305, 35);
		mainPanel.add(nickName_Field);
		nickName_Field.setColumns(10);
		
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
	
		ActionListener buttonListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserDAO userDAO = new UserDAO();
				User user = userDAO.getUser(nickName_Field.getText(), question_Field.getText());
				
				if(user != null) {
					JOptionPane.showMessageDialog(null, "아이디 : " + user.getId());
					dispose();
				}else {
					JOptionPane.showMessageDialog(null, "잘못된 입력 입니다.");
					nickName_Field.setText("");
					question_Field.setText("");
				}
			}
		};
		
		findButton.addActionListener(buttonListener);
		
		setVisible(true);
		
	}
}
