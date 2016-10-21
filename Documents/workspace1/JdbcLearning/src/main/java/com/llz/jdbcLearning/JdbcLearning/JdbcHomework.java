package com.llz.jdbcLearning.JdbcLearning;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcHomework {
	private static final String DB_URL = "jdbc:mysql://localhost:3306/yunketang?useCursorFetch=true&characterEncoding=utf-8";
	private static final String DB_USER_NAME = "root";
	private static final String DB_PASSWORD = "881125";
	private static final String DRIVER_NAME = "com.mysql.jdbc.Driver";
	private static Connection connection = null;

	static {
		try {
			Class.forName(DRIVER_NAME);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static Connection getConnection() {
		if (connection == null) {
			try {
				connection = DriverManager.getConnection(DB_URL, DB_USER_NAME,
						DB_PASSWORD);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return connection;
		}
		return connection;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement("select * from product where id =?");
			pstmt.setInt(1, 1);
			pstmt.setFetchSize(2);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				System.out.println("商品名称：" + rs.getString("ProductName"));
				System.out.println("商品库存：" + rs.getString("Inventory"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
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
