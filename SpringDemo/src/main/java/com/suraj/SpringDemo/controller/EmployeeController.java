package com.suraj.SpringDemo.controller;

import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.suraj.SpringDemo.model.Employee;
import com.suraj.SpringDemo.service.EmpServiceImpl;
import com.suraj.SpringDemo.service.EmployeeService;

@RestController
public class EmployeeController {

	private EmployeeService serviceImpl;
	
	
	public EmployeeController() {
		serviceImpl=new EmpServiceImpl();
	}
	
	@RequestMapping(value="/fetchAll",method = RequestMethod.GET)
	public ResponseEntity<List<Employee>> fetchAllEmp(){
		List<Employee> list= serviceImpl.fetchAllEmployee();
		return new ResponseEntity<List<Employee>>(list,HttpStatus.OK);
	}
	
	@RequestMapping("/fetch/{id}") 
	public ResponseEntity<Employee> fetchEmployee(@PathVariable("id") int id) {
			Employee employee=serviceImpl.fetchEmployee(id);
			if(employee!=null)
				return new ResponseEntity<Employee>(employee,HttpStatus.OK);
			return new  ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
	 }
	 
	@RequestMapping("/addEmp")
	public ResponseEntity<Employee> insertEmp(@RequestBody Employee employee, UriComponentsBuilder ucBuilder) {
		employee.setId(serviceImpl.insertEmployee(employee));
		if(employee.getId()!=0) {
					
			return new ResponseEntity<Employee>(employee, HttpStatus.CREATED);	
		}
		
		return  new ResponseEntity<Employee>(HttpStatus.CONFLICT);
		
	}
	
	@RequestMapping("/delEmp/{id}")
	public boolean delEmp(@PathVariable int id) {
		return serviceImpl.delEmployee(id);
	}
	  
}
