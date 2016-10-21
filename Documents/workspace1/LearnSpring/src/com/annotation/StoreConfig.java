/**
 * 
 */
package com.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author liliangzi
 *
 */
@Configuration
public class StoreConfig {
//	@Scope("prototype")
//	@Bean(name="store",initMethod="init",destroyMethod="cleanUp")
//	public Store stringStore(){
//		return new StringStore();
//	}
	@Autowired
	private Store<String>s1;

	@Autowired
	private Store<Integer>s2;
	
	@Bean
	public StringStore stringStore(){
		return new StringStore();
	}
	
	@Bean
	public IntegerStore integerStore(){
		return new IntegerStore();
	}
	
	@Bean(name="stro")
	public Store storeTest(){
		System.out.println(s1.getClass().getName());
		System.out.println(s2.getClass().getName());
		return new StringStore();
	}
}
