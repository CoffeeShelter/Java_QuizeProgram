package quizeprogram.gui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import quizeprogram.db.QuizDAO;
import quizeprogram.db.User;

public class SelectQuiz extends JFrame {
	private SelectQuiz selectQuiz = this;

	private JComboBox comboBox;
	
	private String[] quizList;
	private QuizDAO quizDAO = new QuizDAO();

	public SelectQuiz(User user) {
		quizList = quizDAO.getQuizGroup();
		
		setTitle("퀴즈 선택");
		setSize(450, 170);
		setResizable(false);
		setLocationRelativeTo(null);
		
		getContentPane().setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		getContentPane().add(panel);
		panel.setLayout(null);

		JLabel label = new JLabel("퀴즈 선택 :");
		label.setFont(new Font("굴림", Font.BOLD, 15));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(26, 29, 95, 33);
		panel.add(label);

		this.comboBox = new JComboBox(quizList);
		comboBox.setBounds(141, 33, 237, 29);
		panel.add(comboBox);

		JButton startButton = new JButton("시작");
		startButton.setFont(new Font("굴림", Font.BOLD, 15));
		startButton.setBounds(273, 74, 105, 27);
		panel.add(startButton);
		
		startButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String quizGroup = (String) comboBox.getSelectedItem();
				new QuizWindow(quizGroup, user);
				selectQuiz.dispose();
			}
		});
		
		setVisible(true);
	}
}
