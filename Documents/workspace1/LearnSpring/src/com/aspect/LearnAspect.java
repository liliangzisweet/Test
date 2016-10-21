/**
 * 
 */
package com.aspect;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * @author liliangzi
 * 
 */
public class LearnAspect {

	public void before() {
		System.out.println("LearnAspect before...");

	}

	public void returnAfter() {
		System.out.println("LearnAspect returnAfter...");
	}

	public void afterThrow() {
		System.out.println("LearnAspect afterThrow...");
	}

	public void after() {
		System.out.println("LearnAspect after...");
	}

	public Object around(ProceedingJoinPoint prj) throws Throwable {
		System.out.println("around before...");
		Object obj = prj.proceed();
		System.out.println("around after...");
		return obj;
	}

	public Object aroundinit(ProceedingJoinPoint prj, String name, int number) throws Throwable {
		System.out.println("around before..."+name+" "+number);
		Object obj = prj.proceed();
		System.out.println("around after..."+name+" "+number);
		return obj;
	}
}
