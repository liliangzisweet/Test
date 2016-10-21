package com.llz.jdbcLearning.JdbcLearning;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestCursor {
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

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub

		PreparedStatement pstmt = connection
				.prepareStatement("select * from user where userName = ? and id=?");
		pstmt.setString(1, "beibei");
		pstmt.setInt(2, 1);
		pstmt.setFetchSize(1);
		ResultSet rs = null;
		try {
			rs = pstmt.executeQuery();
			while (rs.next()) {
				System.out.println("hello, " + rs.getString("userName"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (connection != null)
					connection.close();
				if (pstmt != null)
					pstmt.close();
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
}
