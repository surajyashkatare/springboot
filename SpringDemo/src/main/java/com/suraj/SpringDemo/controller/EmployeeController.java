package com.suraj.SpringDemo.controller;

import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.suraj.SpringDemo.model.Employee;
import com.suraj.SpringDemo.service.EmpServiceImpl;
import com.suraj.SpringDemo.service.EmployeeServices;

@RestController
public class EmployeeController {

	private EmployeeServices serviceImpl;
	
	
	public EmployeeController() {
		serviceImpl=new EmpServiceImpl();
	}
	
	@RequestMapping("/fetchAllEmployee")
	public List<Employee> fetchAllStud(){
		return serviceImpl.fetchAllEmployee();
	}
	
	@RequestMapping("/fetchEmployee/{id}") 
	public Employee fetchStudent(@PathVariable("id") int id) { 
		  return serviceImpl.fetchEmployee(id);
	 }
	 
	@RequestMapping("/insertEmployee")
	public Employee insertStud(@RequestBody Employee employee) {
		return serviceImpl.insertEmployee(employee);
	}
	
	@RequestMapping("/delEmployee/{id}")
	public boolean delStud(@PathVariable int id) {
		return serviceImpl.delEmployee(id);
	}
	  
}
