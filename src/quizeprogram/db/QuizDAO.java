package quizeprogram.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class QuizDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public QuizDAO() {
		try {
			String dbURL = "jdbc:mysql://localhost/quizprogram";
			String dbID = "root";
			String dbPassword = "1234";
			Class.forName("com.mysql.jdbc.Driver");
			this.conn = DriverManager.getConnection(dbURL,dbID,dbPassword);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public String[] getQuizGroup(){
		Vector<String> quizGroups = new Vector<>();
		String SQL = "select distinct quizgroup from quiz";
		try {
			pstmt = conn.prepareStatement(SQL);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				quizGroups.add(rs.getString("quizgroup"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		String[] groupArr = new String[quizGroups.size()];
		int i = 0;
		for(String group : quizGroups) {
			groupArr[i++] = group;
		}
		
		return groupArr;
	}
	
	public Vector<Quiz> getQuiz(String quizGroup){
		Vector<Quiz> quizVector = new Vector<>();
		String SQL = "select * from quiz where quizGroup=?";
		try {
			pstmt = conn.prepareStatement(SQL);
			
			pstmt.setString(1, quizGroup);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				Quiz quiz = new Quiz();
				
				quiz.setQuizGroup(quizGroup);
				quiz.setQuestion(rs.getString("question"));
				quiz.setAnswer(rs.getString("answer"));
				
				quizVector.add(quiz);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return quizVector;
	}
	
	public int addQuiz(Quiz quiz){
		Vector<Quiz> quizVector = new Vector<>();
		String SQL = "insert into quiz values (?, ?, ?)";
		try {
			pstmt = conn.prepareStatement(SQL);
			
			pstmt.setString(1, quiz.getQuizGroup());
			pstmt.setString(2, quiz.getQuestion());
			pstmt.setString(3, quiz.getAnswer());

			System.out.println("addQuiz: " + SQL);
			
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return -1;
	}
}
