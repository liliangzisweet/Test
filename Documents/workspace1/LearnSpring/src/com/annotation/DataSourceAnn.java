/**
 * 
 */
package com.annotation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * @author liliangzi
 *
 */
@Configuration
@ImportResource("classpath:spring-datasource.xml")
public class DataSourceAnn {
	@Value("${jdbc.username}")
	String username;
	@Value("${jdbc.password}")
	String password;
	@Value("${jdbc.url}")
	String url;
	
	@Bean
	public DataSourceManager datasourceManager(){
		return new DataSourceManager(username,password,url);
	}

}
