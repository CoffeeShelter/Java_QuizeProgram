package quizeprogram.gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import quizeprogram.db.User;
import quizeprogram.db.UserDAO;

public class ViewUserList extends JFrame {
	private JTable table;

	public ViewUserList() {
		setTitle("유저 리스트");
		setSize(720, 420);
		setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, BorderLayout.CENTER);

		table = new JTable();
		scrollPane.setViewportView(table);

		// 헤더
		String header[] = { "닉네임", "아이디", "비밀번호", "학번", "권한" };

		DefaultTableModel model = new DefaultTableModel(header, 0);

		UserDAO userDAO = new UserDAO();
		
		Vector<User> userVector = userDAO.getUserList();
		
		if (userVector != null) {
			for (User user : userVector) {
				String u[] = new String[5];
				u[0] = user.getName();
				u[1] = user.getId();
				u[2] = user.getPw();
				u[3] = user.getsNumber();
				if(user.getAuth() == 1) {
					u[4] = "관리자";
				}else {
					u[4] = "회원";
				}

				model.addRow(u);
			}
		}
		table.setModel(model);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("설정");
		menuBar.add(mnNewMenu);
		
		JMenuItem modifyMenu = new JMenuItem("유정 정보 수정");
		mnNewMenu.add(modifyMenu);
		modifyMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ModifyUserDataWindow_ADMIN();
			}		
		});

		setVisible(true);
	}

}
