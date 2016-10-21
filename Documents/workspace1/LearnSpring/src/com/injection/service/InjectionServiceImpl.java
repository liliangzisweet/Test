/**
 * 
 */
package com.injection.service;

import com.injection.dao.InjectionDao;

/**
 * @author liliangzi
 * 
 */
public class InjectionServiceImpl implements InjectionService {
	private InjectionDao injectionDao2;
	
	public InjectionServiceImpl(){}

	public InjectionServiceImpl(InjectionDao injectionDao) {
		super();
		this.injectionDao2 = injectionDao;
	}

	public void setInjectionDao2(InjectionDao injectionDao) {
		this.injectionDao2 = injectionDao;
	}

	public void save(String arg) {
		System.out.println("Service接收：" + arg);
		arg = arg + " : " + this.hashCode();
		injectionDao2.save(arg);
	}

}
