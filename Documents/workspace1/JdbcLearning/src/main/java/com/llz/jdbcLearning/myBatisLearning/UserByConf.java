package com.llz.jdbcLearning.myBatisLearning;

import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class UserByConf {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String resource = "myBatisConf.xml";
		InputStream in = UserByConf.class.getClassLoader().getResourceAsStream(
				resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
				.build(in);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			GetUserInfo getUserInfo = sqlSession.getMapper(GetUserInfo.class);
			User user = getUserInfo.getUser(1);
			System.out.println(user.getId() + ":" + user.getUserName() + " "
					+ user.getAccount());
		} finally {
			sqlSession.close();
		}
	}
}
