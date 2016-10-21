package com.llz.jdbcLearning.myBatisAdvance;

import java.util.List;

public class Student {
	private int userId;
	private String name;
	private String className;
	private List<Course> courses;
	

	public List<Course> getCourses() {
		return courses;
	}

	@Override
	public String toString() {
		return "Student [id=" + userId +  ", name=" + name + ", className="
				+ className + "]";
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	public Student(Integer userId, String name, String className) {
		this.userId = userId;
		this.name = name;
		this.className = className;
	}

	public int getId() {
		return userId;
	}

	public void setId(int id) {
		this.userId = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

}
