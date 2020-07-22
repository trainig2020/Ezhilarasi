package com.spring;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;

public class Circle implements Shape{

	private Points center;
	
	public Points getCenter() {
		return center;
	}
	@Resource(name="point2")
	public void setCenter(Points center) {
		this.center = center;
	}

	@Override
	public void draw() {
		System.out.println("Drawing circle : ");
		System.out.println("center is ("+ center.getX()+" , "+center.getY()+")");
		
	}
	
	@PostConstruct
	public void initializeCircle(){
		System.out.println("Init method");
	}
	
	@PreDestroy
	public void destruction(){
		System.out.println("Destroy method");
	}

}
