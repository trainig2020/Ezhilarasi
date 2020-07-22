package com.spring.main;

import com.spring.dao.CircleDaoImpl;
import com.spring.model.Circle;

public class Demotest {

	public static void main(String[] args) {
		Circle circle = new CircleDaoImpl().getCircle(1);
		System.out.println(circle.getName());

	}

}
