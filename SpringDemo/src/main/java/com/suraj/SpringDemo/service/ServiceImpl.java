package com.suraj.SpringDemo.service;

import java.util.ArrayList;
import java.util.List;

import com.suraj.SpringDemo.model.Student;

public class ServiceImpl implements StudentServices {

	private List<Student> students;
	
	public ServiceImpl() {
		 students=new ArrayList<>();
		students.add(new Student(1, "suraj"));
		students.add(new Student(2, "yash"));
		students.add(new Student(3, "pratik"));
	}
	@Override
	public boolean insertStudent(Student student) {
		return students.add(student);
		
	}

	@Override
	public List<Student> fetchAllStudent() {
		return students;
	}

	@Override
	public boolean delStudent(int id) {
		if(students.remove(id)!=null) {
			return true;
		}
		return false;
	}

	@Override
	public Student fetchStudent(int id) {
		
		return students.get(id);
	}

}
