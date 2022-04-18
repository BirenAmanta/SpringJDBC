package com.mindtree.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@EnableAspectJAutoProxy
@Configuration
@PropertySource("classpath:application.properties")
@ComponentScan(basePackages = { "com.mindtree.reposiotry", "com.mindtree.service", "com.mindtree.utility" })
public class JdbcConfig {
	@Autowired
	Environment ev;

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dms = new DriverManagerDataSource();
		dms.setDriverClassName(ev.getProperty("spring.datasource.driver-class-name"));
		dms.setUrl(ev.getProperty("spring.datasource.url"));
		dms.setPassword(ev.getProperty("spring.datasource.password"));
		dms.setUsername(ev.getProperty("spring.datasource.username"));
		return dms;
	}

	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}
	

}
