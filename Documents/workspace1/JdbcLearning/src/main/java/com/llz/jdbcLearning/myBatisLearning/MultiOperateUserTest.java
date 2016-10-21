package com.llz.jdbcLearning.myBatisLearning;

import java.io.InputStream;

import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MultiOperateUserTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String resource = "myBatisConfMultiple.xml";
		InputStream in = MultiOperateUserTest.class.getClassLoader()
				.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
				.build(in);
		//Configuration conf = sqlSessionFactory.getConfiguration();
		//conf.addMapper(MuliOperatOnUser.class);
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		try {
			MuliOperatOnUser op = sqlSession.getMapper(MuliOperatOnUser.class);
			User user1 = new User("tongtong", 1000);
			op.addUser(user1);
			System.out.println(user1.getId());
			user1 = op.getUser(user1.getId());
			user1.setUserName("xiaoxiao");
			op.updateUser(user1);
			System.out.println(user1.getId() + ":" + user1.getUserName() + " "
					+ user1.getAccount());
			op.delUser(user1.getId());
		} finally {
			sqlSession.close();
		}
	}

}
