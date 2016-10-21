package com.llz.jdbcLearning.JdbcLearning;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.dbcp2.BasicDataSource;

public class JdbcExam {

	private static final String url = "jdbc:mysql://localhost:3306/batisHomework?useCursorFetch=true&characterEncoding=utf-8";
	private static final String username = "root";
	private static final String password = "881125";
	private static final String driver = "com.mysql.jdbc.Driver";
	private static BasicDataSource ds = null;

	static {
		ds = new BasicDataSource();
		ds.setUrl(url);
		ds.setUsername(username);
		ds.setPassword(password);
		ds.setDriverClassName(driver);
		ds.setMaxTotal(4);
	}

	public static void usePool() {
		Connection conn = null;
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		String sql = "delete from timetable where UserName=? and CourseName=?";
		String sql1 = "INSERT INTO `batisHomework`.`timetable` (`UserName`, `CourseName`) VALUES (?, ?)";
		try {
			conn = ds.getConnection();
			conn.setAutoCommit(false);
			ptmt = conn.prepareStatement(sql);
			ptmt.setString(1, "ZhangSan");
			ptmt.setString(2, "math");
			ptmt.execute();
			ptmt = conn.prepareStatement(sql1);
			ptmt.setString(1, "LiSi");
			ptmt.setString(2, "math");
			ptmt.execute();
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			try {
				if (conn != null) {
					try {
						conn.rollback();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			} finally {
				try {
					if (conn != null)
						conn.close();
					if (ptmt != null)
						ptmt.close();
					if (rs != null)
						rs.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) {
		usePool();
	}

}
