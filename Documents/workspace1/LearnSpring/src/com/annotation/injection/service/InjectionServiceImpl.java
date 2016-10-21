/**
 * 
 */
package com.annotation.injection.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.annotation.injection.dao.InjectionDao;

/**
 * @author liliangzi
 * 
 */
@Service
public class InjectionServiceImpl implements InjectionService {
	@Autowired
	private InjectionDao injectionDao2;

	public InjectionServiceImpl() {
	}

	@Autowired
	public InjectionServiceImpl(InjectionDao injectionDao) {
		super();
		this.injectionDao2 = injectionDao;
	}

//	@Autowired
//	public void setInjectionDao2(InjectionDao injectionDao) {
//		this.injectionDao2 = injectionDao;
//	}

	public void save(String arg) {
		System.out.println("Service接收：" + arg);
		arg = arg + " : " + this.hashCode();
		injectionDao2.save(arg);
	}

}
