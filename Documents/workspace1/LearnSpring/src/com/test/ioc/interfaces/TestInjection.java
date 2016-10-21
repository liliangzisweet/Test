/**
 * 
 */
package com.test.ioc.interfaces;

import org.junit.Test;

import com.injection.service.InjectionService;
import com.test.base.UnitTestBase;

/**
 * @author liliangzi
 *
 */
public class TestInjection extends UnitTestBase {
	public TestInjection() {
		super("classpath:spring-injection.xml");
	}
	
	@Test	
	public void testSetter() {
		InjectionService service = super.getBean("injectionService");
		service.save("这是要保存的数据");
	}
	
	@Test
	public void testCons() {
		InjectionService service = super.getBean("injectionService");
		service.save("这是要保存的数据");
	}

}
