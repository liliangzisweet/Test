/**
 * 
 */
package com.autowire;

/**
 * @author liliangzi
 * 
 */
public class AutoWireService {
	private AutoWireDao autoWireDao;

	public AutoWireService() {

	}
	
	public AutoWireService(AutoWireDao autoWireDao) {
		this.autoWireDao=autoWireDao;
		System.out.println("by Constructor");
	}

	public void setAutoWireDao(AutoWireDao autoWireDao) {
		System.out.println("by Setter");
		this.autoWireDao = autoWireDao;
	}

	public void say(String arg) {
		autoWireDao.say(arg);
	}
}
