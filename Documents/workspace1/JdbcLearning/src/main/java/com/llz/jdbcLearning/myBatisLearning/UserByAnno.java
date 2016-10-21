package com.llz.jdbcLearning.myBatisLearning;

import java.io.InputStream;

import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class UserByAnno {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String resource = "myBatisConfAnnotation.xml";
		InputStream in = UserByAnno.class.getClassLoader().getResourceAsStream(
				resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
				.build(in);
		Configuration conf = sqlSessionFactory.getConfiguration();
		conf.addMapper(GetUserInfoAnno.class);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			GetUserInfoAnno getUser = sqlSession
					.getMapper(GetUserInfoAnno.class);
			User user = getUser.getUser(1);
			System.out.println(user.getId() + ":" + user.getUserName() + " "
					+ user.getAccount());
		} finally {
			sqlSession.close();
		}
	}
}
