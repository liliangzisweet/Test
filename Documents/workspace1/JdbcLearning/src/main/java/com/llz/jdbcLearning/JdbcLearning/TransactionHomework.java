package com.llz.jdbcLearning.JdbcLearning;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Savepoint;

import org.apache.commons.dbcp2.BasicDataSource;

public class TransactionHomework {

	private static final String DB_URL = "jdbc:mysql://localhost:3306/yunketang?useCursorFetch=true&characterEncoding=utf-8";
	private static final String DB_USER_NAME = "root";
	private static final String DB_PASSWORD = "881125";
	private static final String DRIVER_NAME = "com.mysql.jdbc.Driver";
	private static BasicDataSource ds = null;

	public static void beginTransction(String productName, int number,
			String buyer) {
		Connection conn = null;
		PreparedStatement ptmt = null;
		// Savepoint sp = null;
		ds = new BasicDataSource();
		ds.setMaxTotal(4);
		ds.setMaxIdle(4);
		try {
			ds.setDriverClassName(DRIVER_NAME);
			ds.setUrl(DB_URL);
			ds.setUsername(DB_USER_NAME);
			ds.setPassword(DB_PASSWORD);
			conn = ds.getConnection();
			conn.setAutoCommit(false);
			ptmt = conn
					.prepareStatement("update Inventory set Inventory=Inventory-? where ProductName=?");
			ptmt.setInt(1, number);
			ptmt.setString(2, productName);
			ptmt.execute();
			ptmt = conn
					.prepareStatement("insert into `Order` (buyer,ProductName) values (?,?)");
			ptmt.setString(1, buyer);
			ptmt.setString(2, productName);
			ptmt.execute();
			conn.commit();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			try {
				if (conn != null) {
					conn.rollback();
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
		beginTransction("bag", 1, "XiaoMing");

	}

}
