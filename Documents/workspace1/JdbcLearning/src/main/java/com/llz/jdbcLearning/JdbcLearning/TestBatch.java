package com.llz.jdbcLearning.JdbcLearning;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

public class TestBatch {

	private static final String url = "jdbc:mysql://localhost:3306/yunketang?useCursorFetch=true";
	private static final String user = "root";
	private static final String password = "881125";
	private static Connection connection = null;

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(url, user, password);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void insertUsers(Set<String> users) {

		Statement stmt = null;
		try {
			stmt = connection.createStatement();
			for (String user : users) {
				String sql = "insert into user(userName) values" + "('" + user
						+ "')";
				System.out.println(sql);
				stmt.addBatch(sql);
				stmt.executeBatch();
				stmt.clearBatch();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (connection != null)
					connection.close();
				if (stmt != null)
					stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Set<String> users = new HashSet<String>();
		users.add("weizi");
		users.add("dandan");
		insertUsers(users);
	}
}
