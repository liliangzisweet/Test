/**
 * 
 */
package com.annotation;

import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Component;

/**
 * @author liliangzi
 *
 */
@Component("bean")
@Scope
public class BeanAnnotation {

	public BeanAnnotation(){
		
	}
	
	public void say(String arg){
		System.out.println("BeanAnnotation :"+arg);
	}
	
	public void getHashcode(){
		System.out.println(this.hashCode());
	}
}
