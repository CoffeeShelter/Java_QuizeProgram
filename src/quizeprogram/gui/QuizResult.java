package quizeprogram.gui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import quizeprogram.db.Record;
import quizeprogram.db.RecordDAO;
import quizeprogram.db.User;

public class QuizResult extends JFrame {
	private QuizResult thisWindow = this;
	private String quizGroup;
	private int total;
	private int correctCount;

	private RecordDAO recordDAO = new RecordDAO();
	private Record record = new Record();
	private Vector<Record> records = new Vector<>();

	public QuizResult(String quizGroup, int total, int correctCount, User user) {
		this.quizGroup = quizGroup;
		this.total = total;
		this.correctCount = correctCount;

		float percent = ((float) correctCount / (float) total) * 100.0f;

		records = recordDAO.getRecord(user.getId());

		setTitle("퀴즈 결과");
		setSize(430, 300);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout(0, 0));

		JPanel mainPanel = new JPanel();
		getContentPane().add(mainPanel);
		mainPanel.setLayout(null);

		JLabel quizGroupLabel = new JLabel("퀴즈 그룹 : " + quizGroup);
		quizGroupLabel.setFont(new Font("굴림", Font.BOLD, 20));
		quizGroupLabel.setBounds(26, 22, 349, 33);
		mainPanel.add(quizGroupLabel);

		JLabel totalCountLabel = new JLabel("총 문제 개수 : " + Integer.toString(total));
		totalCountLabel.setFont(new Font("굴림", Font.BOLD, 20));
		totalCountLabel.setBounds(26, 67, 349, 33);
		mainPanel.add(totalCountLabel);

		JLabel correctCountLabel = new JLabel("맞은 문제 개수 : " + Integer.toString(correctCount));
		correctCountLabel.setFont(new Font("굴림", Font.BOLD, 20));
		correctCountLabel.setBounds(26, 112, 349, 33);
		mainPanel.add(correctCountLabel);

		JLabel percentLabel = new JLabel("백분율 : " + Float.toString(percent) + "퍼센트");
		percentLabel.setFont(new Font("굴림", Font.BOLD, 20));
		percentLabel.setBounds(26, 157, 349, 33);
		mainPanel.add(percentLabel);

		JButton button = new JButton("확인");
		button.setFont(new Font("굴림", Font.BOLD, 15));
		button.setBounds(153, 202, 105, 27);
		mainPanel.add(button);

		this.record.setId(user.getId());
		this.record.setGroupName(quizGroup);
		this.record.setPercent(Float.toString(percent));
		this.record.setTotalCount(total);
		this.record.setCorrectCount(correctCount);

		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Record rc = recordDAO.getOneRecord(user.getId(), quizGroup);
				// 퀴즈 전체 개수가 다르면 퀴즈 수정이 일어난것으로 재 업로드
				if (rc != null) {
					if (record.getTotalCount() != rc.getTotalCount()) {
						recordDAO.updateRecord(record);
					} else {
						// 맞은 개수 증가 시 업로드
						if (record.getCorrectCount() > rc.getCorrectCount()) {
							recordDAO.updateRecord(record);
						}
					}
				} else {
					// 첫 업로드
					recordDAO.setRecord(record);
				}
				System.out.println("퀴즈 기록 업로드 완료");
				thisWindow.dispose();
			}
		});

		setVisible(true);
	}

}
