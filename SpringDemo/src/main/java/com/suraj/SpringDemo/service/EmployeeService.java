package com.suraj.SpringDemo.service;

import java.util.List;

import com.suraj.SpringDemo.model.Employee;

public interface EmployeeService {
	
	public int insertEmployee(Employee employee);
	public List<Employee> fetchAllEmployee();
	public boolean delEmployee(int id);
	public Employee fetchEmployee(int id);
	
}
