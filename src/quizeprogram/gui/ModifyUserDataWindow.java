package quizeprogram.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import quizeprogram.db.User;
import quizeprogram.db.UserDAO;

public class ModifyUserDataWindow extends JFrame {
	private JTextField nickNameField;
	private JPasswordField passField;
	private JPasswordField rePassField;
	
	private boolean checking = false;
	private String changeName;

	public ModifyUserDataWindow(User user) {
		setTitle("마이 페이지");
		setSize(500, 300);
		getContentPane().setLayout(new BorderLayout(0, 0));
		setLocationRelativeTo(null);

		JPanel mainPanel = new JPanel();
		getContentPane().add(mainPanel);
		mainPanel.setLayout(null);

		JLabel idLabel = new JLabel("아이디 : " + user.getId());
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

		passField = new JPasswordField("");
		passField.setBounds(201, 88, 242, 28);
		mainPanel.add(passField);
		passField.setColumns(10);

		rePassField = new JPasswordField("");
		rePassField.setBounds(200, 126, 243, 28);
		mainPanel.add(rePassField);
		rePassField.setColumns(10);

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

		JButton cancelButton = new JButton("취소");
		cancelButton.setFont(new Font("굴림", Font.BOLD, 15));
		cancelButton.setBounds(99, 185, 105, 37);
		mainPanel.add(cancelButton);

		setVisible(true);

		ModifyUserDataWindow modWindow = this;
		ActionListener cancel = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modWindow.dispose();
			}
		};
		cancelButton.addActionListener(cancel);
		
		ActionListener mod = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(checking) {
					if(changeName.equals(nickNameField.getText())){
						if(passField.getText().equals("") || rePassField.getText().equals("")) {
							JOptionPane.showMessageDialog(null, "비밀번호를 입력 해주세요");
						}else {
							if(passField.getText().equals(rePassField.getText())) {
								user.setName(nickNameField.getText());
								user.setPw(passField.getText());
								JOptionPane.showMessageDialog(null, "변경 완료");
								UserDAO userDAO = new UserDAO();
								userDAO.update(user.getId(), user);
								modWindow.dispose();
							}else {
								failrePwLabel.setText("비밀번호가 다릅니다.");
								passField.setText("");
								rePassField.setText("");
							}
						}
					}else {
						checking = false;
						changeName = "";
						JOptionPane.showMessageDialog(null, "변경된 닉네임 중복 확인 해주세요");
					}
				}else {
					JOptionPane.showMessageDialog(null, "닉네임 중복 확인 해주세요");
				}
			}
		};
		modifyButton.addActionListener(mod);
		
		ActionListener checkName = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserDAO userDAO = new UserDAO();
				if(userDAO.checkName(nickNameField.getText())) {
					JOptionPane.showMessageDialog(null, "이미 존재하는 닉네임 입니다.");
				}else {
					JOptionPane.showMessageDialog(null, "사용 할 수 있는 닉네임 입니다.");
					changeName = nickNameField.getText();
					checking = true;
				}
			}
		};
		nickNameButton.addActionListener(checkName);
	}

	

}
