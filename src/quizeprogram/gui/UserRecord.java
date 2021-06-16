package quizeprogram.gui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import quizeprogram.db.Record;
import quizeprogram.db.RecordDAO;
import quizeprogram.db.User;

public class UserRecord extends JFrame {
	private JTable table;
	private RecordDAO recordDAO = new RecordDAO();

	public UserRecord(User user) {
		setTitle("유저 정보 확인");
		setSize(680, 320);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		getContentPane().add(panel);
		panel.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel nameLabel = new JLabel("닉네임 :  " + user.getName());
		nameLabel.setFont(new Font("굴림", Font.BOLD, 20));
		nameLabel.setHorizontalAlignment(SwingConstants.LEFT);
		nameLabel.setBounds(14, 12, 316, 38);
		panel.add(nameLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(14, 105, 634, 156);
		panel.add(scrollPane);
		
		String header[] = {"퀴즈 그룹 명", "총 문제 개수", "맞은 문제 개수", "백분율" };
		DefaultTableModel model = new DefaultTableModel(header, 0) ;
		
		Vector<Record> records = recordDAO.getRecord(user.getId());
		for(Record rc : records) {
			String[] r = new String[4];
			r[0] = rc.getGroupName();
			r[1] = Integer.toString(rc.getTotalCount());
			r[2] = Integer.toString(rc.getCorrectCount());
			r[3] = rc.getPercent();
			model.addRow(r);
		}
		
		table = new JTable();
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		table.setModel(model);
		scrollPane.setViewportView(table);
		
		JLabel quizLabel = new JLabel("퀴즈 정보");
		quizLabel.setFont(new Font("굴림", Font.BOLD, 15));
		quizLabel.setHorizontalAlignment(SwingConstants.LEFT);
		quizLabel.setBounds(14, 74, 160, 31);
		panel.add(quizLabel);
		
		setVisible(true);
	}
}
