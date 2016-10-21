package com.llz.jdbcLearning.JdbcLearning;

class TestThread extends Thread {
	private String name;

	public TestThread(String name) {
		this.name = name;
	}

	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println(name + "运行  :  " + i);
			try {
				sleep((int) Math.random() * 10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}
}

public class Thread1 {

	public static void main(String[] args) {
		TestThread mTh1 = new TestThread("A");
		TestThread mTh2 = new TestThread("B");
		mTh1.start();
		mTh2.start();

	}

}