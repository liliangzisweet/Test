package com.llz.jdbcLearning.myBatisLearning;

public class User {
	private int id;
	private String userName;
	private int account;

	public User() {
		super();
	}

	public User(int id, String userName, int account) {
		this.id = id;
		this.userName = userName;
		this.account = account;
	}

	public User(String userName, int account) {
		this.userName = userName;
		this.account = account;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getAccount() {
		return account;
	}

	public void setAccount(int account) {
		this.account = account;
	}

}
