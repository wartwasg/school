package com.example.demo;

import java.util.HashMap;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ConvetorOfSubjectIDs implements Converter<String, Course> {
	HashMap<String, Course> course = new HashMap<>();

	public ConvetorOfSubjectIDs() {
		course.put("111", new Course("111", "Introduction to Telecommunication", 9, "08:00am - 09:00am", "1"));
		course.put("121", new Course("121", "Introduction to High level programming", 9, "08:00am - 09:00am", "2"));
		course.put("122", new Course("122", "Introduction to Database management system", 9, "08:00am - 09:00am", "2"));
		course.put("123", new Course("123", "Introduction to Probability and statistics", 9, "08:00am - 09:00am", "2"));
		course.put("124", new Course("124", "Introduction to Software Engineering", 6, "08:00am - 09:00am", "1"));
		course.put("113", new Course("113", "Development perspectives", 7.5, "11:00am - 12:00am", "1"));
		course.put("125", new Course("125", "Wearable computing", 7.5, "13:00 - 14:00", "2"));
		course.put("232", new Course("232", "High level matrics", 9, "16:00 - 17:00", "2"));
		course.put("129", new Course("129", "Speaking skill", 7.5, "08:00am - 09:00am", "1"));
		course.put("130", new Course("130", "Advanced Calculus", 9, "08:00am - 09:00am", "1"));
	}

	@Override
	public Course convert(String source) {
		return course.get(source);
	}
}
