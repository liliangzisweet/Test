/**
 * 
 */
package com.resource;

import java.io.IOException;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.io.Resource;

/**
 * @author liliangzi
 * 
 */
public class AcquireResource implements ApplicationContextAware {

	private ApplicationContext applicationContext;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.context.ApplicationContextAware#setApplicationContext
	 * (org.springframework.context.ApplicationContext)
	 */
	public void setApplicationContext(ApplicationContext arg0)
			throws BeansException {
		// TODO Auto-generated method stub
		System.out.println("sssssss");
		this.applicationContext=arg0;
	}
	
	public void resource() throws IOException{
		Resource resource=applicationContext.getResource("http://www.cnblogs.com/shz365/p/5099780.html");
		System.out.println(resource.getFilename());
		System.out.println(resource.contentLength());
	}

}
