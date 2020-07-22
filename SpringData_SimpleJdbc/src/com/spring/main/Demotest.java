package com.spring.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.dao.CircleDaoImpl;
import com.spring.dao.JdbcDaoImpl;
import com.spring.model.Circle;

public class Demotest {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		ApplicationContext  context = new ClassPathXmlApplicationContext("spring.xml");
		
		//CircleDaoImpl dao =  context.getBean("circleDaoImpl", CircleDaoImpl.class);
		
		JdbcDaoImpl dao =  context.getBean("jdbcDaoImpl", JdbcDaoImpl.class);
		
		System.out.println(dao.getCircleCount());
		
		
		
		
		

	}

}
