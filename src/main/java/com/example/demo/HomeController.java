package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class HomeController {
	@ModelAttribute
	MySelections prepareCourses(Model model) {
		List<Course> course = new ArrayList<>();
		course.add(new Course("111", "Introduction to Telecommunication", 9, "08:00am - 09:00am", "1"));
		course.add(new Course("121", "Introduction to High level programming", 9, "08:00am - 09:00am", "2"));
		course.add(new Course("122", "Introduction to Database management system", 9, "08:00am - 09:00am", "2"));
		course.add(new Course("123", "Introduction to Probability and statistics", 9, "08:00am - 09:00am", "2"));
		course.add(new Course("124", "Introduction to Software Engineering", 6, "08:00am - 09:00am", "1"));
		course.add(new Course("113", "Development perspectives", 7.5, "11:00am - 12:00am", "1"));
		course.add(new Course("125", "Wearable computing", 7.5, "13:00 - 14:00", "2"));
		course.add(new Course("232", "High level matrics", 9, "16:00 - 17:00", "2"));
		course.add(new Course("129", "Speaking skill", 7.5, "08:00am - 09:00am", "1"));
		course.add(new Course("130", "Advanced Calculus", 9, "08:00am - 09:00am", "1"));
		model.addAttribute("course", course);
		return new MySelections();
	}

	@GetMapping("/")
	public String getHomePage(Model model) {
		model.addAttribute("student", new Student());
		return "registration";
	}
}
