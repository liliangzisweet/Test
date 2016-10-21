/**
 * 
 */
package com.test.lifecyle;

import org.junit.Test;

import com.test.base.UnitTestBase;

/**
 * @author liliangzi
 *
 */
public class BeanLifeCycleTest extends UnitTestBase{
	public BeanLifeCycleTest() {
		super("classpath:spring-lifecycle.xml");
		
	}
	
	@Test
	public void testLifeCyle(){
		super.getBean("beanLifecyle");
	}
	

}
