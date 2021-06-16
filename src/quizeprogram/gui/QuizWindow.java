package quizeprogram.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import quizeprogram.db.Quiz;
import quizeprogram.db.QuizDAO;
import quizeprogram.db.User;

public class QuizWindow extends JFrame {
	private QuizWindow thisWindow = this;
	
	private String name;
	private String title;
	private String question;
	private String answer;
	private JTextField answerField;

	private String quizGroup = null;
	private Vector<Quiz> quizVector = new Vector<>();
	private Quiz currentQuiz;
	private QuizDAO quizDAO = new QuizDAO();

	private int page = 0;
	private int correctCount = 0;

	private boolean showAnswer = false;
	JLabel answerLabel;

	public QuizWindow(String quizGroup, User user) {
		this.quizGroup = quizGroup;
		quizVector = quizDAO.getQuiz(quizGroup);
		currentQuiz = quizVector.get(page);

		setTitle(quizGroup);
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 128, 0));
		getContentPane().add(panel);
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(14, 52, 704, 121);
		panel.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));

		JLabel questionLabel = new JLabel(quizVector.get(page).getQuestion());
		questionLabel.setBackground(Color.WHITE);
		questionLabel.setFont(new Font("굴림", Font.BOLD, 20));
		questionLabel.setHorizontalAlignment(SwingConstants.CENTER);

		JScrollPane scrollPane = new JScrollPane(questionLabel);
		panel_1.add(scrollPane);

		JLabel lblNewLabel = new JLabel("정답 :");
		lblNewLabel.setForeground(new Color(124, 252, 0));
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(14, 186, 97, 55);
		panel.add(lblNewLabel);

		this.answerField = new JTextField();
		answerField.setBounds(138, 185, 403, 56);
		panel.add(answerField);
		answerField.setColumns(10);

		JButton button = new JButton("다음");
		button.setFont(new Font("굴림", Font.BOLD, 20));
		button.setBounds(564, 185, 154, 56);
		panel.add(button);

		JLabel lblNewLabel_1 = new JLabel("문제");
		lblNewLabel_1.setForeground(new Color(0, 255, 0));
		lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 20));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(306, 12, 97, 28);
		panel.add(lblNewLabel_1);

		this.answerLabel = new JLabel("");
		answerLabel.setForeground(new Color(255, 0, 0));
		answerLabel.setFont(new Font("굴림", Font.BOLD, 30));
		answerLabel.setHorizontalAlignment(SwingConstants.LEFT);
		answerLabel.setBounds(137, 188, 244, 53);
		answerLabel.setVisible(false);
		panel.add(answerLabel);

		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (showAnswer == false) {
					if (answerField.getText().equals(currentQuiz.getAnswer())) {
						correctCount++;
					}
					showAnswer = true;

					if(currentQuiz.getAnswer().length() > 5) {
						answerLabel.setFont(new Font("굴림", Font.BOLD, 20));
					}else {
						answerLabel.setFont(new Font("굴림", Font.BOLD, 30));
					}
					answerLabel.setText(currentQuiz.getAnswer());
					
				} else {
					++page;
					if(quizVector.size() <= page) {
						new QuizResult(quizGroup, quizVector.size(), correctCount, user);
						thisWindow.dispose();
					}else {
						currentQuiz = quizVector.get(page);
						questionLabel.setText(currentQuiz.getQuestion());
						answerField.setText("");

						showAnswer = false;
					}
				}
				answerLabel.setVisible(showAnswer);
				answerField.setVisible(!showAnswer);
			}
		});

		setTitle(title);
		setSize(750, 300);
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
