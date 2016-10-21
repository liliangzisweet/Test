/**
 * 
 */
package com.test.jsr;

import org.junit.Test;

import com.jsr.JsrService;
import com.test.base.UnitTestBase;

/**
 * @author liliangzi
 *
 */
public class TestJsr extends UnitTestBase {
	public TestJsr(){
		super("classpath:spring-jsrannotation.xml");
	}
	@Test
	public void testRsrc(){
		JsrService jsrServ= super.getBean("jsrService");
		jsrServ.save();
	}

}
