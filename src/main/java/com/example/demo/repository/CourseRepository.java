package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import com.example.demo.Course;

public interface CourseRepository {
	List<Course> findAll();

	Optional<Course> findById(String id);

	Course save(Course Course);
}
