package com.llz.jdbcLearning.myBatisLearning;

import org.apache.ibatis.annotations.Select;

public interface GetUserInfoAnno {
	@Select("select id,userName,account from user where id=#{id}")
	public User getUser(int id);
}
