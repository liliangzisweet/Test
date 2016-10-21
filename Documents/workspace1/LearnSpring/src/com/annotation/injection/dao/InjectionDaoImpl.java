/**
 * 
 */
package com.annotation.injection.dao;

import org.springframework.stereotype.Repository;

/**
 * @author liliangzi
 *
 */
@Repository
public class InjectionDaoImpl implements InjectionDao {
	public void save(String args){
		System.out.println(args +"这是要保存的数据");
	}

}
