/**
 * 
 */
package com.test.resource;

import java.io.IOException;

import org.junit.Test;

import com.resource.AcquireResource;
import com.test.base.UnitTestBase;

/**
 * @author liliangzi
 *
 */
public class TestResource extends UnitTestBase {
	public TestResource(){
		super("classpath:spring-resource.xml");
	}
	@Test
	public void testR() throws IOException{
		AcquireResource acquireResource=super.getBean("acquireResource");
		acquireResource.resource();
	}

}
