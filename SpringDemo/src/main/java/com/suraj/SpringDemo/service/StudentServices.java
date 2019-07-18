package com.suraj.SpringDemo.service;

import java.util.List;

import com.suraj.SpringDemo.model.Student;

public interface StudentServices {
	
	public boolean insertStudent(Student student);
	public List<Student> fetchAllStudent();
	public boolean delStudent(int id);
	public Student fetchStudent(int id);
	
}
