/**
 * 
 */
package com.test.autowire;

import org.junit.Test;

import com.autowire.AutoWireService;
import com.test.base.UnitTestBase;

/**
 * @author liliangzi
 *
 */
public class TestAutoWire extends UnitTestBase {
	public TestAutoWire(){
		super("classpath:spring-autowire.xml");
	}
	@Test
	public void testAuto(){
		AutoWireService autoWireSerice=super.getBean("autoWireService");
		autoWireSerice.say("aaaaa");
	}

}
