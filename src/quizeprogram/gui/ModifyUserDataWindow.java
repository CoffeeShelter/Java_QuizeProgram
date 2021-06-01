package quizeprogram.gui;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Color;

public class ModifyUserDataWindow extends JFrame{
	private JTextField nickNameField;
	private JTextField textField;
	private JTextField textField_1;
	
	private String userID = "default@gmail.com";
	
	public ModifyUserDataWindow() {
		setTitle("마이 페이지");
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel mainPanel = new JPanel();
		getContentPane().add(mainPanel);
		mainPanel.setLayout(null);
		
		JLabel idLabel = new JLabel("아이디 : " + userID);
		idLabel.setFont(new Font("굴림", Font.BOLD, 20));
		idLabel.setBounds(14, 48, 447, 28);
		mainPanel.add(idLabel);
		
		JLabel nickNameLabel = new JLabel("닉네임");
		nickNameLabel.setFont(new Font("굴림", Font.BOLD, 20));
		nickNameLabel.setBounds(14, 12, 85, 28);
		mainPanel.add(nickNameLabel);
		
		nickNameField = new JTextField();
		nickNameField.setBounds(100, 12, 242, 28);
		mainPanel.add(nickNameField);
		nickNameField.setColumns(10);
		
		JButton nickNameButton = new JButton("중복 확인");
		nickNameButton.setFont(new Font("굴림", Font.BOLD, 15));
		nickNameButton.setBounds(356, 12, 105, 27);
		mainPanel.add(nickNameButton);
		
		JLabel pwLabel = new JLabel("비밀번호");
		pwLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		pwLabel.setFont(new Font("굴림", Font.BOLD, 20));
		pwLabel.setBounds(14, 88, 173, 28);
		mainPanel.add(pwLabel);
		
		JLabel rePwLabel = new JLabel("비밀번호 재입력");
		rePwLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		rePwLabel.setFont(new Font("굴림", Font.BOLD, 20));
		rePwLabel.setBounds(14, 122, 173, 28);
		mainPanel.add(rePwLabel);
		
		textField = new JTextField();
		textField.setBounds(201, 88, 242, 28);
		mainPanel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(200, 126, 243, 28);
		mainPanel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel failrePwLabel = new JLabel("");
		failrePwLabel.setForeground(Color.RED);
		failrePwLabel.setFont(new Font("굴림", Font.BOLD, 15));
		failrePwLabel.setHorizontalAlignment(SwingConstants.CENTER);
		failrePwLabel.setBounds(201, 155, 242, 18);
		mainPanel.add(failrePwLabel);
		
		JButton modifyButton = new JButton("수정");
		modifyButton.setFont(new Font("굴림", Font.BOLD, 15));
		modifyButton.setBounds(252, 185, 105, 37);
		mainPanel.add(modifyButton);
		
		JButton btnNewButton_1 = new JButton("취소");
		btnNewButton_1.setFont(new Font("굴림", Font.BOLD, 15));
		btnNewButton_1.setBounds(99, 185, 105, 37);
		mainPanel.add(btnNewButton_1);
	}

}
