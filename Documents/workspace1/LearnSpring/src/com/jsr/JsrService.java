/**
 * 
 */
package com.jsr;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * @author liliangzi
 *
 */
@Named
public class JsrService {

	//@Autowired 效果和@Resource是一样的
	//@Resource JSR2.5
	private JsrDao jsrDao;
	
	@PostConstruct
	public void start(){
		System.out.println("start...");
	}
	
	@PreDestroy
	public void destroy(){
		System.out.println("end...");
	}
	
	//@Resource
	@Inject //JSR3.0
	public void setJsrDao(@Named("jsrDao")JsrDao jsrDao) {
		this.jsrDao = jsrDao;
	}

	public void save(){
		jsrDao.save();
	}
}
