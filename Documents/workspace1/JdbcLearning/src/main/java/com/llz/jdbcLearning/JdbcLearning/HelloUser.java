package com.llz.jdbcLearning.JdbcLearning;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class HelloUser {

	private static final String url = "jdbc:mysql://localhost:3306/yunketang";
	private static final String user = "root";
	private static final String password = "881125";

	public static void procesJDBCUser() throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Connection connection = DriverManager
				.getConnection(url, user, password);
		Statement stmt = connection.createStatement();
		// TODO Auto-generated catch block

		ResultSet rt = null;
		String sql = "select * from user";
		try {
			rt = stmt.executeQuery(sql);
			while (rt.next()) {
				System.out.println("hello, " + rt.getString("userName"));
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
				if (rt != null)
					rt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		procesJDBCUser();
	}
}
