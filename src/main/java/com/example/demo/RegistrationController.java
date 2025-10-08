package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/registration")
@SessionAttributes("MySelections")
public class RegistrationController {
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

	@GetMapping
	public String getRegistrationPage(Model model) {
		model.addAttribute("student", new Student());
		return "registration";
	}

	@PostMapping
	public String getStudentInfo(@Valid @ModelAttribute Student student, Errors errors, Model model,
			HttpSession session) {
		if (errors.hasErrors()) {
			model.addAttribute("student", student);
			return "registration";
		} else {
			student.setTotal(student.getSelected().size());
			double sum = 0;
			for (Course c : student.getSelected()) {
				sum += c.getCredits();
			}
			student.setTotal_credits(sum);
			session.setAttribute("student", student);
			Student students = (Student) session.getAttribute("student");
			model.addAttribute("total", students.getSelected().size());
			return "summary";
		}
	}
}
