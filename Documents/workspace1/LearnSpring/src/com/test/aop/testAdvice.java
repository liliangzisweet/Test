/**
 * 
 */
package com.test.aop;

import org.junit.Test;

import com.aspect.AspectBiz;
import com.aspect.AspectInterface;
import com.test.base.UnitTestBase;

/**
 * @author liliangzi
 * 
 */
public class testAdvice extends UnitTestBase {
	public testAdvice() {
		super("classpath:spring-aop.xml");
	}

	@Test
	public void testA() {
		AspectBiz biz = super.getBean("aspectBiz");
		biz.biz();
	}

	@Test
	public void testInit() {
		AspectBiz biz = super.getBean("aspectBiz");
		biz.init("Hello",1);
	}
	
	@Test
	public void testIntface() {
		AspectInterface aspInt = (AspectInterface)super.getBean("aspectBiz");
		System.out.println(aspInt.getClass().getName());
		aspInt.filter();
	}
}
