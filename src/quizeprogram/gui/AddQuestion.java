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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import quizeprogram.db.Quiz;
import quizeprogram.db.QuizDAO;

public class AddQuestion extends JFrame {
	private JTextField answerField;
	private JTextField groupField;
	private JTextArea questionField;

	public AddQuestion() {
		setTitle("퀴즈 추가");
		setSize(600, 400);
		getContentPane().setLayout(new BorderLayout(0, 0));
		setLocationRelativeTo(null);

		JPanel mainPanel = new JPanel();
		mainPanel.setBackground(Color.DARK_GRAY);
		getContentPane().add(mainPanel);
		mainPanel.setLayout(null);

		JLabel lblNewLabel = new JLabel("문제");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 20));
		lblNewLabel.setBounds(14, 61, 111, 39);
		mainPanel.add(lblNewLabel);

		questionField = new JTextArea();
		questionField.setBounds(14, 112, 559, 157);
		mainPanel.add(questionField);

		JButton button = new JButton("추가");
		button.setFont(new Font("굴림", Font.BOLD, 20));
		button.setBounds(415, 281, 158, 48);
		mainPanel.add(button);

		JLabel lblNewLabel_1 = new JLabel("정답");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 20));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(14, 281, 72, 48);
		mainPanel.add(lblNewLabel_1);

		answerField = new JTextField();
		answerField.setBounds(100, 281, 293, 48);
		mainPanel.add(answerField);
		answerField.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("그룹 명");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_5.setFont(new Font("굴림", Font.BOLD, 20));
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setBounds(14, 12, 111, 37);
		mainPanel.add(lblNewLabel_5);

		groupField = new JTextField();
		groupField.setBounds(139, 12, 434, 37);
		mainPanel.add(groupField);
		groupField.setColumns(10);

		ActionListener addQuestionListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String quest = String.format("<html><p style=\"text-align: center;\">%s</p></html>",
						questionField.getText().replaceAll("\n", "<br>"));
				Quiz quiz = new Quiz();
				quiz.setQuestion(quest);
				quiz.setAnswer(answerField.getText());
				quiz.setQuizGroup(groupField.getText());
				
				QuizDAO quizDAO = new QuizDAO();
				quizDAO.addQuiz(quiz);
				
				JOptionPane.showMessageDialog(null, "추가 완료");
				
				questionField.setText("");
				answerField.setText("");
				groupField.setText("");
			}
		};
		button.addActionListener(addQuestionListener);

		setVisible(true);
	}
}
