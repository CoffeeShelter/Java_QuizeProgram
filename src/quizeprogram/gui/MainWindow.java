package quizeprogram.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import quizeprogram.db.User;

public class MainWindow extends JFrame {
	private MainWindow thisWindow = this;

	public MainWindow(User user) {
		setTitle("퀴즈 프로그램");
		setSize(1280, 780);
		setResizable(false);
		setLocationRelativeTo(null);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout(0, 0));

		if (new ImageIcon(MainWindow.class.getResource("balloon.png")).getImage() == null) {
			System.out.print("널포잍ㄴ트");
		}

		ImagePanel mainPanel = new ImagePanel(new ImageIcon(MainWindow.class.getResource("background.png")).getImage());
		getContentPane().add(mainPanel);
		mainPanel.setLayout(null);

		ImagePanel balloonPanel = new ImagePanel(new ImageIcon(MainWindow.class.getResource("balloon.png")).getImage());
		balloonPanel.setSize(586, 436);
		balloonPanel.setBounds(getSize().width / 2 - balloonPanel.getSize().width / 2, 190, 586, 436);
		mainPanel.add(balloonPanel);
		balloonPanel.setLayout(null);

		JPanel welcomeTextPanel = new JPanel();
		welcomeTextPanel.setBackground(new Color(0, 0, 0, 0));
		welcomeTextPanel.setBounds(61, 52, 457, 214);
		balloonPanel.add(welcomeTextPanel);
		welcomeTextPanel.setLayout(new BorderLayout(0, 0));

		JLabel welcomeLabel = new JLabel(
				"<html><p style=\"text-align : center;\">퀴즈 프로그램에 <br>접속하신 것을 환영합니다.<br> 아래 퀴즈 시작을 눌러<br>지금 바로 퀴즈를 풀어보세요!</p></html>");
		welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		welcomeLabel.setFont(new Font("굴림", Font.BOLD, 30));
		welcomeTextPanel.add(welcomeLabel);

		JPanel titlePanel = new JPanel();
		titlePanel.setBackground(new Color(0, 0, 0, 0));
		titlePanel.setBounds(347, 31, 586, 151);
		mainPanel.add(titlePanel);
		titlePanel.setLayout(new BorderLayout(0, 0));

		JLabel titleLabel = new JLabel("QUIZ");
		titleLabel.setFont(new Font("궁서", Font.ITALIC, 99));
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setForeground(new Color(255, 204, 51));
		titlePanel.add(titleLabel);

		ImagePanel buttonPanel = new ImagePanel(new ImageIcon(MainWindow.class.getResource("button.png")).getImage());
		buttonPanel.setBounds(436, 636, 440, 81);
		mainPanel.add(buttonPanel);
		buttonPanel.setLayout(null);

		JLabel buttonLabel = new JLabel("시작");
		buttonLabel.setFont(new Font("휴먼모음T", Font.BOLD, 20));
		buttonLabel.setHorizontalAlignment(SwingConstants.CENTER);
		buttonLabel.setBounds(34, 22, 374, 36);
		buttonPanel.add(buttonLabel);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu userMenu = new JMenu("회원 정보");
		menuBar.add(userMenu);

		if (user.getAuth() == 1) {
			JMenuItem userListMenu = new JMenuItem("유저 리스트");
			userMenu.add(userListMenu);
			userListMenu.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new ViewUserList();
				}
			});
		}

		JMenuItem userInfoMenu = new JMenuItem("정보 확인");
		userMenu.add(userInfoMenu);
		userInfoMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new UserRecord(user);
			}
		});

		JMenuItem modMenu = new JMenuItem("정보 수정");
		userMenu.add(modMenu);
		modMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ModifyUserDataWindow(user);
			}
		});

		JMenuItem logout = new JMenuItem("로그아웃");
		userMenu.add(logout);
		logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				thisWindow.dispose();
				new LoginWindow();
			}
		});

		if (user.getAuth() == 1) {
			JMenu quizMenu = new JMenu("퀴즈 관리");
			menuBar.add(quizMenu);

			JMenuItem addQuizMenu = new JMenuItem("퀴즈 추가");
			quizMenu.add(addQuizMenu);
			addQuizMenu.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new AddQuestion();
				}
			});
		}

		buttonLabel.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
				new SelectQuiz(user);
			}

			public void mousePressed(MouseEvent e) {
			}

			public void mouseReleased(MouseEvent e) {
			}

			public void mouseEntered(MouseEvent e) {
			}

			public void mouseExited(MouseEvent e) {
			}
		});

		setVisible(true);
	}
}
