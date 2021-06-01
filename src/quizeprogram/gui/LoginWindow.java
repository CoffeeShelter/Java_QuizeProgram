package quizeprogram.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class LoginWindow extends JFrame{
	private JTextField idField;
	private JPasswordField pwField;
	public LoginWindow() {
		setTitle("로그인");
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel mainPanel = new JPanel();
		mainPanel.setBackground(SystemColor.inactiveCaption);
		getContentPane().add(mainPanel);
		mainPanel.setLayout(null);
		
		JLabel mainLabel = new JLabel("QUIZE");
		mainLabel.setFont(new Font("궁서체", Font.BOLD, 40));
		mainLabel.setForeground(new Color(255, 215, 0));
		mainLabel.setHorizontalAlignment(SwingConstants.CENTER);
		mainLabel.setBounds(14, 12, 305, 114);
		mainPanel.add(mainLabel);
		
		idField = new JTextField();
		idField.setBounds(100, 127, 209, 39);
		mainPanel.add(idField);
		idField.setColumns(10);
		
		pwField = new JPasswordField();
		pwField.setBounds(100, 178, 209, 39);
		mainPanel.add(pwField);
		pwField.setColumns(10);
		
		JLabel idLabel = new JLabel("아이디");
		idLabel.setFont(new Font("굴림", Font.BOLD, 15));
		idLabel.setHorizontalAlignment(SwingConstants.CENTER);
		idLabel.setBounds(24, 127, 62, 39);
		mainPanel.add(idLabel);
		
		JLabel pwLabel = new JLabel("비밀번호");
		pwLabel.setFont(new Font("굴림", Font.BOLD, 15));
		pwLabel.setBounds(24, 178, 62, 39);
		mainPanel.add(pwLabel);
		
		JLabel signinLabel = new JLabel("아직 회원이 아니신가요?");
		signinLabel.setHorizontalAlignment(SwingConstants.CENTER);
		signinLabel.setForeground(new Color(0, 0, 0));
		signinLabel.setFont(new Font("굴림", Font.BOLD, 15));
		signinLabel.setBounds(14, 234, 305, 18);
		mainPanel.add(signinLabel);
		
		JLabel signButtonLabel = new JLabel("회원가입");
		signButtonLabel.setHorizontalAlignment(SwingConstants.CENTER);
		signButtonLabel.setFont(new Font("굴림", Font.BOLD, 15));
		signButtonLabel.setForeground(new Color(0, 0, 128));
		signButtonLabel.setBounds(121, 253, 89, 18);
		mainPanel.add(signButtonLabel);
		
		JLabel findIdPwLabel = new JLabel("아이디가 기억이 안나시나요?");
		findIdPwLabel.setFont(new Font("굴림", Font.BOLD, 15));
		findIdPwLabel.setForeground(new Color(0, 0, 0));
		findIdPwLabel.setHorizontalAlignment(SwingConstants.CENTER);
		findIdPwLabel.setBounds(14, 283, 305, 18);
		mainPanel.add(findIdPwLabel);
		
		JLabel findIdPwButtonLabel = new JLabel("아이디/비밀번호 찾기");
		findIdPwButtonLabel.setFont(new Font("굴림", Font.BOLD, 15));
		findIdPwButtonLabel.setForeground(new Color(0, 0, 128));
		findIdPwButtonLabel.setHorizontalAlignment(SwingConstants.CENTER);
		findIdPwButtonLabel.setBounds(78, 302, 170, 18);
		mainPanel.add(findIdPwButtonLabel);
	}
}
