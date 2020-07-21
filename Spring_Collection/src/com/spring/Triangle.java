package com.spring;

import java.util.List;

public class Triangle {
	private List<Points> points;
	


	public List<Points> getPoints() {
		return points;
	}



	public void setPoints(List<Points> points) {
		this.points = points;
	}
	
	public void draw(){
		for(Points point:points){
			System.out.println("point : ("+ point.getX()+" , "+point.getY()+")");

		}

	}
}
