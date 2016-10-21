package com.llz.jdbcLearning.myBatisAdvance;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class BatisAdvanceTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String resource = "batisAdvanceConf.xml";
		InputStream in = BatisAdvanceTest.class.getClassLoader()
				.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
				.build(in);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			StudentOp studentOp = sqlSession.getMapper(StudentOp.class);
			Student stu = studentOp.getStudent(1);
			System.out.println(stu);
			List<Course> courseList = stu.getCourses();
			for (Course c : courseList) {
				System.out.println(c.getCourseId() + ":" + c.getCourseName()
						+ c.getTeacher().getId() + ":"
						+ c.getTeacher().getName());
			}
		} finally {
			sqlSession.close();
		}

	}

}
