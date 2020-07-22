package com.spring.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.dao.HibernateDaoImpl;

public class Demotest {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		ApplicationContext  context = new ClassPathXmlApplicationContext("spring.xml");
		
		
		HibernateDaoImpl dao =  context.getBean("hibernateDaoImpl", HibernateDaoImpl.class);
		
		System.out.println(dao.getCircleCount());
		
		
		
		
		

	}

}
