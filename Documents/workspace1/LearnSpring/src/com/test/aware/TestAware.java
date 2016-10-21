/**
 * 
 */
package com.test.aware;

import org.junit.Test;

import com.test.base.UnitTestBase;

/**
 * @author liliangzi
 *
 */
public class TestAware extends UnitTestBase{
	
	public TestAware(){
		super("classpath:spring-aware.xml");
	}
	
	@Test
	public void testAware(){
		System.out.println("from test:"+super.getBean("beanAware").hashCode());
	}

}
