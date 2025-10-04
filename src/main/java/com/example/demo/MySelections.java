package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public class MySelections {
	List<Student> student = new ArrayList<>();

	void addNewStudent(Student student) {
		this.student.add(student);
	}

	List<Student> getStudent() {
		return this.student;
	}
}
