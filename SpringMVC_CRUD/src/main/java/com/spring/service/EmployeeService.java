package com.spring.service;

import java.util.List;

import com.spring.model.Employee;



public interface EmployeeService {

	
	

	public void insertEmployee(Employee emp);

	public void updateEmployee(Employee emp);

	public void deleteEmployee(int id);

	public Employee getEmployees(int deptId);

	public List<Employee> getAllEmployees();

}
