/**
 * 
 */
package com.test.annotation;

import org.junit.Test;

import com.annotation.BeanAnnotation;
import com.annotation.DataSourceManager;
import com.annotation.Store;
import com.annotation.StringStore;
import com.annotation.injection.dao.AutoWireSetList;
import com.annotation.injection.service.InjectionService;
import com.test.base.UnitTestBase;

/**
 * @author liliangzi
 *
 */
public class TestAnnotation extends UnitTestBase {

	public TestAnnotation(){
		super("classpath:spring-annotation.xml");
	}
	
	@Test
	public void testStore(){
		StringStore store=super.getBean("stro");
	}
	
	@Test
	public void testInjectionAutowired(){
		InjectionService injectionService = super.getBean("injectionServiceImpl");
		injectionService.save("Test InjectionAutowired");
	
	}
	
	@Test
	public void testDatasource(){
		DataSourceManager datasource=super.getBean("datasourceManager");
		System.out.println(datasource.getClass().getName());
		
	}
	
	@Test
	public void testStoreConfig(){
		Store store = super.getBean("store");
		System.out.println(store.hashCode());
		store = super.getBean("store");
		System.out.println(store.hashCode());
	}
	
	@Test
	public void testInterfaceAuto(){
		AutoWireSetList setlist =super.getBean("autoWireSetList");
		setlist.say();
	}
	
	@Test
	public void testAnn(){
		BeanAnnotation bean=super.getBean("bean");
		bean.say("hi");
	}
	
	@Test
	public void testScope(){
		BeanAnnotation bean=super.getBean("bean");
		bean.getHashcode();
		
		BeanAnnotation bean1=super.getBean("bean");
		bean1.getHashcode();
	}
	
}
