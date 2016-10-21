package com.llz.jdbcLearning.myBatisLearning;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface MuliOperatOnUser {

	//@Select("select id,userName,account from user where id=#{id}")
	public User getUser(int id);

	//@Insert("insert into user(userName,account) values(#{userName},#{account})")
	public void addUser(User user);

	//@Update("update user set userName=#{userName},account=#{account} where id=#{id}")
	public void updateUser(User user);
	
	//@Delete("delete from user where id=#{id}")
	public void delUser(int id);
}
