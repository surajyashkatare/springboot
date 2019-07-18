package com.suraj.SpringDemo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.suraj.SpringDemo.model.Student;

@RestController
public class StudentController {

	private List<Student> students=new ArrayList<Student>();
	
	public StudentController() {
		students.add(new Student(1, "suraj"));
		students.add(new Student(2, "yash"));
		students.add(new Student(3, "pratik"));
	}
	
	@RequestMapping("/fetchAll")
	public List<Student> fetchAllStud(){
		return students;
	}
	
	@RequestMapping("/fetchStud/{id}") 
	public Student fetchStudent(@PathVariable("id") int id) { 
		  return students.get(id);
	 }
	 
	@RequestMapping("/insertStud")
	public void insertStud(@RequestBody Student student) {
		System.out.println(students.add(student));
	}
	
	@RequestMapping("/delStud/{id}")
	public void delStud(@PathVariable int id) {
		students.remove(id);
	}
	  
}
