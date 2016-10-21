/**
 * 
 */
package com.annotation;

/**
 * @author liliangzi
 *
 */
public class StringStore implements Store<String> {
	public void init(){
		System.out.println("This is init...");
		
	}
	
	public void cleanUp(){
		System.out.println("This is destroy...");
	}
	
}
