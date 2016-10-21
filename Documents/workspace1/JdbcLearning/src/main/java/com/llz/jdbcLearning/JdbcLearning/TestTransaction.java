package com.llz.jdbcLearning.JdbcLearning;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Savepoint; 

import org.apache.commons.dbcp2.BasicDataSource;

public class TestTransaction {
	private static final String DB_URL = "jdbc:mysql://localhost:3306/yunketang?useCursorFetch=true&characterEncoding=utf-8";
	private static final String DB_USER_NAME = "root";
	private static final String DB_PASSWORD = "881125";
	private static final String DRIVER_NAME = "com.mysql.jdbc.Driver";
	private static BasicDataSource ds = null;

	public static void testTransction() {
		Connection conn = null;
		PreparedStatement ptmt = null;
		Savepoint sp = null;
		ds = new BasicDataSource();
		try {
			ds.setDriverClassName(DRIVER_NAME);
			ds.setUrl(DB_URL);
			ds.setUsername(DB_USER_NAME);
			ds.setPassword(DB_PASSWORD);
			conn = ds.getConnection();
			conn.setAutoCommit(false);
			ptmt = conn
					.prepareStatement("update user set account=? where userName=?");
			ptmt.setInt(1, 0);
			ptmt.setString(2, "beibei");
			ptmt.execute();
			sp = conn.setSavepoint();
			ptmt.setInt(1, 100);
			ptmt.setString(2, "mengmeng");
			ptmt.execute();
			throw new SQLException();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			try {
				if (conn != null) {
					conn.rollback(sp);
					conn.commit();
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} finally {
				try {
					if (conn != null)
						conn.close();
					if (ptmt != null)
						ptmt.close();

				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
			}

		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testTransction();

	}

}
