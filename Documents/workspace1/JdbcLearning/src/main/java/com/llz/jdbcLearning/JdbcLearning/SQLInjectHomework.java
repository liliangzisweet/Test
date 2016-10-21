package com.llz.jdbcLearning.JdbcLearning;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLInjectHomework {
	private static final String DB_URL = "jdbc:mysql://localhost:3306/yunketang?useCursorFetch=true&characterEncoding=utf-8";
	private static final String USER = "root";
	private static final String PASS = "881125";
	private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";

	public static void getStudent(String name) throws ClassNotFoundException {
		Connection conn = null;
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			ptmt = conn
					.prepareStatement("select name,score from student where name=?");
			ptmt.setString(1, name);
			rs = ptmt.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getString("name") + ":"
						+ rs.getInt("score"));
			}
		} catch (SQLException e) {
			// ignore
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
					// ignore
				}
			}
			if (ptmt != null) {
				try {
					ptmt.close();
				} catch (Exception e) {
					// ignore
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// ignore
				}
			}
		}
	}

	public static void main(String[] args) {
		try {
			getStudent("XiaoMing");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
