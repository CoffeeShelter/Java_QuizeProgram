package quizeprogram.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class SigninWindow extends JFrame {
	private JTextField idField;
	private JPasswordField pwField;
	private JTextField rePwField;
	private JTextField findPwField;
	private JTextField nickNameField;
	
	public SigninWindow() {
		setTitle("회원가입");
		getContentPane().setLayout(new BorderLayout(0, 0));

		JPanel mainPanel = new JPanel();
		mainPanel.setBackground(SystemColor.inactiveCaption);
		getContentPane().add(mainPanel);
		mainPanel.setLayout(null);

		JLabel mainLabel = new JLabel("회원가입");
		mainLabel.setFont(new Font("굴림", Font.BOLD, 40));
		mainLabel.setForeground(new Color(0, 0, 128));
		mainLabel.setHorizontalAlignment(SwingConstants.CENTER);
		mainLabel.setBounds(14, 12, 305, 53);
		mainPanel.add(mainLabel);

		idField = new JTextField();
		idField.setBounds(24, 92, 295, 39);
		mainPanel.add(idField);
		idField.setColumns(10);

		pwField = new JPasswordField();
		pwField.setBounds(24, 160, 295, 39);
		mainPanel.add(pwField);
		pwField.setColumns(10);

		JLabel idLabel = new JLabel("아이디");
		idLabel.setFont(new Font("굴림", Font.BOLD, 15));
		idLabel.setHorizontalAlignment(SwingConstants.LEFT);
		idLabel.setBounds(24, 65, 62, 33);
		mainPanel.add(idLabel);

		JLabel pwLabel = new JLabel("비밀번호");
		pwLabel.setHorizontalAlignment(SwingConstants.LEFT);
		pwLabel.setFont(new Font("굴림", Font.BOLD, 15));
		pwLabel.setBounds(24, 131, 62, 33);
		mainPanel.add(pwLabel);

		JLabel signinLabel = new JLabel("");
		signinLabel.setHorizontalAlignment(SwingConstants.CENTER);
		signinLabel.setForeground(Color.RED);
		signinLabel.setFont(new Font("굴림", Font.BOLD, 15));
		signinLabel.setBounds(14, 262, 305, 18);
		mainPanel.add(signinLabel);

		JLabel findLabel = new JLabel("나의 학번은?");
		findLabel.setHorizontalAlignment(SwingConstants.LEFT);
		findLabel.setFont(new Font("굴림", Font.BOLD, 15));
		findLabel.setForeground(new Color(0, 0, 128));
		findLabel.setBounds(24, 304, 150, 18);
		mainPanel.add(findLabel);

		JLabel findIdPwLabel = new JLabel("비밀번호 찾기 질문");
		findIdPwLabel.setFont(new Font("굴림", Font.BOLD, 15));
		findIdPwLabel.setForeground(new Color(0, 0, 0));
		findIdPwLabel.setHorizontalAlignment(SwingConstants.LEFT);
		findIdPwLabel.setBounds(24, 282, 295, 18);
		mainPanel.add(findIdPwLabel);
		
		JLabel lblNewLabel = new JLabel("비밀번호 재입력");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setBounds(24, 198, 140, 33);
		mainPanel.add(lblNewLabel);
		
		rePwField = new JTextField();
		rePwField.setBounds(24, 222, 295, 39);
		mainPanel.add(rePwField);
		rePwField.setColumns(10);
		
		findPwField = new JTextField();
		findPwField.setBounds(24, 324, 295, 37);
		mainPanel.add(findPwField);
		findPwField.setColumns(10);
		
		JButton finishButton = new JButton("완료");
		finishButton.setBackground(Color.BLUE);
		finishButton.setFont(new Font("굴림", Font.BOLD, 15));
		finishButton.setBounds(107, 448, 105, 27);
		mainPanel.add(finishButton);
		
		JLabel nickNameLabel = new JLabel("닉네임");
		nickNameLabel.setHorizontalAlignment(SwingConstants.LEFT);
		nickNameLabel.setFont(new Font("굴림", Font.BOLD, 15));
		nickNameLabel.setBounds(24, 373, 87, 18);
		mainPanel.add(nickNameLabel);
		
		nickNameField = new JTextField();
		nickNameField.setBounds(24, 397, 295, 39);
		mainPanel.add(nickNameField);
		nickNameField.setColumns(10);
	}
}
