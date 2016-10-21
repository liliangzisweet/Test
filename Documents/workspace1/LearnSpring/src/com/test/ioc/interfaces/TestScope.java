/**
 * 
 */
package com.test.ioc.interfaces;

import org.junit.Test;

import com.injection.dao.BeanScope;
import com.test.base.UnitTestBase;

/**
 * @author liliangzi
 * 
 */
public class TestScope extends UnitTestBase {

	public TestScope() {
		super("classpath:spring-beanscope.xml");
	}

	@Test
	public void testScope() {
		BeanScope beanScope = super.getBean("BeanScope");
		beanScope.say();
		BeanScope beanScope2 = super.getBean("BeanScope");
		beanScope2.say();
		
	}
	@Test
	public void testScope2(){
		BeanScope beanScope = super.getBean("BeanScope");
		beanScope.say();
	}
}
