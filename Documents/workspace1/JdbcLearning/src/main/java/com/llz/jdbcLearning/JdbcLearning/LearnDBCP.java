package com.llz.jdbcLearning.JdbcLearning;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.dbcp2.BasicDataSource;

public class LearnDBCP {
	private static final String DB_URL = "jdbc:mysql://localhost:3306/yunketang?useCursorFetch=true&characterEncoding=utf-8";
	private static final String DB_USER_NAME = "root";
	private static final String DB_PASSWORD = "881125";
	private static final String DRIVER_NAME = "com.mysql.jdbc.Driver";
	private static BasicDataSource ds = null;

	public static void TestDBCPProcess() {
		Connection conn = null;
		ds = new BasicDataSource();
		ds.setUrl(DB_URL);
		ds.setUsername(DB_USER_NAME);
		ds.setPassword(DB_PASSWORD);
		ds.setDriverClassName(DRIVER_NAME);
		ds.setMaxTotal(2);

		try {
			conn = ds.getConnection();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement("select * from Product where id = ?");
			pstmt.setInt(1, 1);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				System.out.println("商品名称：" + rs.getString("ProductName"));
				System.out.println("商品库存：" + rs.getString("Inventory"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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

	public static void main(String[] args) {
		TestDBCPProcess();
	}
}
