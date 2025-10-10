package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import com.example.demo.Student;

public interface StudentRepository {
	public List<Student> findAll();

	public Optional<Student> findById(String id);

	public void Save(Student student);
}
