package com.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;

public class Circle implements Shape{

	private Points center;
	
	public Points getCenter() {
		return center;
	}
	@Autowired
	@Qualifier("circleRelated")
	public void setCenter(Points center) {
		this.center = center;
	}

	@Override
	public void draw() {
		System.out.println("Drawing circle : ");
		System.out.println("center is ("+ center.getX()+" , "+center.getY()+")");
		
	}

}
