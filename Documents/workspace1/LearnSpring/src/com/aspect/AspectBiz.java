/**
 * 
 */
package com.aspect;

import javax.management.RuntimeErrorException;

/**
 * @author liliangzi
 *
 */
public class AspectBiz {
	public void biz(){
		System.out.println("AspectBiz biz...");
		//throw new RuntimeException();
		
	}
	
	public void init(String name, int number){
		System.out.println(name+" "+number+" init...");
	}

}
