/**
 * 
 */
package com.injection.dao;

/**
 * @author liliangzi
 *
 */
public class InjectionDaoImpl implements InjectionDao {
	public void save(String args){
		System.out.println(args +"这是要保存的数据");
	}

}
