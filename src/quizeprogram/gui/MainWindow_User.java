package quizeprogram.gui;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JList;

public class MainWindow_User extends JFrame{
	
	private int score = 0;
	
	public MainWindow_User() {
		getContentPane().setBackground(SystemColor.activeCaption);
		setTitle("퀴즈 프로그램");
		setSize(1600,900); // 16 : 9 화면 비율
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel mainPanel = new JPanel();
		getContentPane().add(mainPanel, BorderLayout.CENTER);
		mainPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel infoPanel = new JPanel();
		infoPanel.setBackground(SystemColor.activeCaption);
		mainPanel.add(infoPanel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("나의 점수");
		lblNewLabel.setForeground(new Color(0, 0, 128));
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 90));
		infoPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel(Integer.toString(score));
		lblNewLabel_1.setForeground(new Color(240, 230, 140));
		lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 90));
		infoPanel.add(lblNewLabel_1);
		
		JPanel selectPaenl = new JPanel();
		selectPaenl.setBackground(SystemColor.activeCaption);
		mainPanel.add(selectPaenl, BorderLayout.WEST);
		selectPaenl.setLayout(new BorderLayout(0, 0));
		
		JList list = new JList();
		selectPaenl.add(list);
		
		JLabel GroupLabel = new JLabel("그룹 선택");
		GroupLabel.setFont(new Font("굴림", Font.BOLD, 15));
		selectPaenl.add(GroupLabel, BorderLayout.NORTH);
		
		JPanel quizePanel = new JPanel();
		quizePanel.setBackground(SystemColor.activeCaption);
		mainPanel.add(quizePanel, BorderLayout.CENTER);
		quizePanel.setLayout(new BorderLayout(0, 0));
		
		JList list_1 = new JList();
		quizePanel.add(list_1);
	}
	
}
