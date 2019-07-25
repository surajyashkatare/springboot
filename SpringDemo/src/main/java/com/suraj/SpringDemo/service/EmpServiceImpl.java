package com.suraj.SpringDemo.service;

import java.util.ArrayList;
import java.util.List;

import com.suraj.SpringDemo.model.Employee;

public class EmpServiceImpl implements EmployeeService {

	private List<Employee> employees;
	
	public EmpServiceImpl() {
		employees=new ArrayList<>();
		employees.add(new Employee(1, "suraj"));
		employees.add(new Employee(2, "yash"));
		employees.add(new Employee(3, "pratik"));
	}
	@Override
	public int insertEmployee(Employee employee) {
		if(employees.add(employee))
			return employees.size();	
		else
			return 0;
	}

	@Override
	public List<Employee> fetchAllEmployee() {
		return employees;
	}

	@Override
	public boolean delEmployee(int id) {
		if(employees.remove(id)!=null) {
			return true;
		}
		return false;
	}

	@Override
	public Employee fetchEmployee(int id) {
		
		return employees.get(id);
	}

}
