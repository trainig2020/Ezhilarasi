package com.spring.model;

public class Circle {
	private int id;
	private String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Circle() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Circle(int circleid, String name) {
		setId(circleid);
		setName(name);
	}
	

}
