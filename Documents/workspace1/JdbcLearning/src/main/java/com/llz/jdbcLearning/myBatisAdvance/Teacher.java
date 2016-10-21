package com.llz.jdbcLearning.myBatisAdvance;

public class Teacher {

	private int id;
	private String name;
	
	public Teacher(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Teacher(String name) {
		super();
		this.name = name;
	}
	
	public Teacher(){
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
