package quizeprogram.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import quizeprogram.db.User;
import quizeprogram.db.UserDAO;

public class FindPwWindow extends JFrame{
	private JTextField id_Field;
	private JTextField question_Field;
	
	public FindPwWindow() {
		setTitle("아이디/비밀번호 찾기");
		setSize(355,  240);
		getContentPane().setLayout(new BorderLayout(0, 0));
		setLocationRelativeTo(null);
		
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
		
		JLabel findIdLabel = new JLabel("아이디 찾기");
		findIdLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		findIdLabel.setFont(new Font("굴림", Font.BOLD, 15));
		findIdLabel.setForeground(Color.BLUE);
		findIdLabel.setBounds(145, 149, 174, 18);
		mainPanel.add(findIdLabel);
	
		ActionListener buttonListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserDAO userDAO = new UserDAO();
				User user = userDAO.getUserforPw(id_Field.getText(), question_Field.getText());
				
				if(user != null) {
					JOptionPane.showMessageDialog(null, "암호 : " + user.getPw());
					dispose();
				}else {
					JOptionPane.showMessageDialog(null, "잘못된 입력 입니다.");
					id_Field.setText("");
					question_Field.setText("");
				}
			}
		};
		
		MouseAdapter findIdListener = new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				new FindIdWindow();
			}
		};
		
		findIdLabel.addMouseListener(findIdListener);
		findButton.addActionListener(buttonListener);
		
		setVisible(true);
		
	}	
	
}
