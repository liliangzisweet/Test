/**
 * 
 */
package com.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * @author liliangzi
 * 
 */
public class BeanLifecyle {// implements InitializingBean, DisposableBean {

	// public void init() {
	// System.out.println("init from BeanXML Configuration");
	// }

	public void defaultInit() {
		System.out.println("defaultInit...");
	}

	public void defaultDestroy() {
		System.out.println("defaultDestroy...");
	}

	// public void destroy1() {
	// System.out.println("destroy from BeanXML Configuration");
	// }
	//
	// /*
	// * (non-Javadoc)
	// *
	// * @see
	// * org.springframework.beans.factory.InitializingBean#afterPropertiesSet()
	// */
	// public void afterPropertiesSet() throws Exception {
	// // TODO Auto-generated method stub
	// System.out.println("afterPropertiesSet() from interface");
	// }
	//
	// public void destroy() {
	// System.out.println("destroy() from interface");
	// }
}
