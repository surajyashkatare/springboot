package com.suraj.SpringDemo.controller;

import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.suraj.SpringDemo.model.Student;
import com.suraj.SpringDemo.service.ServiceImpl;
import com.suraj.SpringDemo.service.StudentServices;

@RestController
public class StudentController {

	private StudentServices serviceImpl;
	
	
	public StudentController() {
		serviceImpl=new ServiceImpl();
	}
	
	@RequestMapping("/fetchAll")
	public List<Student> fetchAllStud(){
		return serviceImpl.fetchAllStudent();
	}
	
	@RequestMapping("/fetchStud/{id}") 
	public Student fetchStudent(@PathVariable("id") int id) { 
		  return serviceImpl.fetchStudent(id);
	 }
	 
	@RequestMapping("/insertStud")
	public boolean insertStud(@RequestBody Student student) {
		return serviceImpl.insertStudent(student);
	}
	
	@RequestMapping("/delStud/{id}")
	public boolean delStud(@PathVariable int id) {
		return serviceImpl.delStudent(id);
	}
	  
}
