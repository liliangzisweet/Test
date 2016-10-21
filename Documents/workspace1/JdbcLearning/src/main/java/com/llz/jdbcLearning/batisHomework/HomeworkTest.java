package com.llz.jdbcLearning.batisHomework;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class HomeworkTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String resource = "batisAdvanceConf.xml";
		InputStream in = HomeworkTest.class.getClassLoader()
				.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
				.build(in);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			Op op = sqlSession.getMapper(Op.class);
			User u = op.getUser(1);
			System.out.println("用户ID：" + u.getId() + "_用户名：" + u.getUserName()
					+ "_用户电话：" + u.getTel());
			System.out.println("共买了如下商品：");
			List<Integer> list = u.getProducts();
			for (Integer id : list) {
				Product p = op.getProduct(id);
				System.out.println("商品ID：" + p.getId() + "_商品名称："
						+ p.getProductName() + "_商品型号：" + p.getCatalog());
			}
		} finally {
			sqlSession.close();
		}

	}
}
