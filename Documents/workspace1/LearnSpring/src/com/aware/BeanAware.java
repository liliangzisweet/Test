/**
 * 
 */
package com.aware;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author liliangzi
 *
 */
public class BeanAware implements ApplicationContextAware,BeanNameAware {
	private String name;

	/* (non-Javadoc)
	 * @see org.springframework.beans.factory.BeanNameAware#setBeanName(java.lang.String)
	 */ 
	public void setBeanName(String arg0) {
		// TODO Auto-generated method stub
		this.name=arg0;
		System.out.println(arg0);
	}

	/* (non-Javadoc)
	 * @see org.springframework.context.ApplicationContextAware#setApplicationContext(org.springframework.context.ApplicationContext)
	 */
	public void setApplicationContext(ApplicationContext arg0)
			throws BeansException {
		// TODO Auto-generated method stub
		System.out.println(arg0.getBean(name).hashCode());
	}

}
