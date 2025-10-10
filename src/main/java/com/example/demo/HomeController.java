package com.example.demo;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.demo.repository.JdbcCourseRepository;

@Controller
public class HomeController {
	public JdbcCourseRepository repo;

	public HomeController(JdbcCourseRepository repo) {
		this.repo = repo;
	}

	@ModelAttribute
	void prepareCourses(Model model) {
		List<Course> course = repo.findAll();
		model.addAttribute("course", course);
	}

	@GetMapping("/")
	public String getHomePage(Model model) {
		model.addAttribute("student", new Student());
		return "registration";
	}
}
