package com.example.demo;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.example.demo.repository.JdbcCourseRepository;

@Component
public class ConvetorOfSubjectIDs implements Converter<String, Course> {
	private JdbcCourseRepository repo;

	public ConvetorOfSubjectIDs(JdbcCourseRepository repo) {
		this.repo = repo;
	}

	@Override
	public Course convert(String source) {
		return repo.findById(source).orElse(null);
	}
}
