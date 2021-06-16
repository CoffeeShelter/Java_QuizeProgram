package quizeprogram.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class UserDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	public UserDAO() {
		try {
			String dbURL = "jdbc:mysql://localhost/quizprogram";
			String dbID = "root";
			String dbPassword = "1234";
			Class.forName("com.mysql.jdbc.Driver");
			this.conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean checkId(String id) {
		String SQL = "select * from user where id=?";
		try {
			pstmt = conn.prepareStatement(SQL);

			pstmt.setString(1, id);

			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}
	
	public boolean checkName(String name) {
		String SQL = "select * from user where name=?";
		try {
			pstmt = conn.prepareStatement(SQL);

			pstmt.setString(1, name);

			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}
	
	public User getUser(String id) {
		User user = new User();
		String SQL = "select * from user where id=?";
		try {
			pstmt = conn.prepareStatement(SQL);

			pstmt.setString(1, id);

			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				user.setId(rs.getString("id"));
				user.setPw(rs.getString("pw"));
				user.setsNumber(rs.getString("snumber"));
				user.setName(rs.getString("name"));
				user.setAuth(rs.getInt("auth"));
			}

			return user;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public User getUser(String name, String sNumber) {
		User user = null;

		String SQL = "select * from user where name=? and snumber=?";
		try {
			pstmt = conn.prepareStatement(SQL);

			pstmt.setString(1, name);
			pstmt.setString(2, sNumber);

			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				user = new User();

				user.setId(rs.getString("id"));
				user.setPw(rs.getString("pw"));
				user.setsNumber(rs.getString("snumber"));
				user.setName(rs.getString("name"));
				user.setAuth(rs.getInt("auth"));

				return user;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public User getUserforPw(String id, String sNumber) {
		User user = null;

		String SQL = "select * from user where id=? and snumber=?";
		try {
			pstmt = conn.prepareStatement(SQL);

			pstmt.setString(1, id);
			pstmt.setString(2, sNumber);
			System.out.println("getUserforPw: " + SQL);

			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				user = new User();

				user.setId(rs.getString("id"));
				user.setPw(rs.getString("pw"));
				user.setsNumber(rs.getString("snumber"));
				user.setName(rs.getString("name"));
				user.setAuth(rs.getInt("auth"));

				return user;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public Vector<User> getUserList() {
		Vector<User> userVector = new Vector<>();

		String SQL = "select * from user";

		try {
			Statement stmt = conn.createStatement();
			rs = stmt.executeQuery(SQL);
			System.out.println("getUserList: " + SQL);
			while (rs.next()) {
				User user = new User();

				user.setId(rs.getString("id"));
				user.setPw(rs.getString("pw"));
				user.setsNumber(rs.getString("snumber"));
				user.setName(rs.getString("name"));
				user.setAuth(rs.getInt("auth"));

				userVector.add(user);
				System.out.println(user.getId() + " : 추가");
			}

			return userVector;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public int login(String id, String pw) {
		String SQL = "Select pw from user where id=?";
		try {
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, id);
			System.out.println("로그인: " + pstmt.toString());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				if (rs.getString("pw").equals(pw)) {
					return 1; // 로그인 성공
				} else {
					return 0; // 비밀번호 불일치
				}
			}
			return -1; // 아이디 없음
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -2; // 데이터 베이스 오류
	}

	public int join(User user) {
		String SQL = "insert into user values (?, ?, ?, ?, ?)";
		try {
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, user.getId());
			pstmt.setString(2, user.getPw());
			pstmt.setString(3, user.getsNumber());
			pstmt.setString(4, user.getName());
			pstmt.setInt(5, 0);
			System.out.println("회원가입: " + pstmt.toString());
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	public int update(String id, User user) {
		String SQL = "update user set id=?, pw=?, snumber=?, name=?, auth=? where id=?";
		try {
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, user.getId());
			pstmt.setString(2, user.getPw());
			pstmt.setString(3, user.getsNumber());
			pstmt.setString(4, user.getName());
			pstmt.setInt(5, user.getAuth());
			pstmt.setString(6, id);
			System.out.println("유저 정보 수정: " + pstmt.toString());
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
}
