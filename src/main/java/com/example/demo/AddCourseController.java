package com.example.demo;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.repository.JdbcCourseRepository;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/add-course")
public class AddCourseController {
	private JdbcCourseRepository repo;

	public AddCourseController(JdbcCourseRepository repo) {
		this.repo = repo;
	}

	@GetMapping
	public String getAddCoursePage(HttpSession session, Model model) {
		Student student = (Student) session.getAttribute("student");
		List<Course> course = repo.findAll();
		/*
		 * course.add(new Course("111", "Introduction to Telecommunication", 9,
		 * "08:00am - 09:00am", "1")); course.add(new Course("121",
		 * "Introduction to High level programming", 9, "08:00am - 09:00am", "2"));
		 * course.add(new Course("122", "Introduction to Database management system", 9,
		 * "08:00am - 09:00am", "2")); course.add(new Course("123",
		 * "Introduction to Probability and statistics", 9, "08:00am - 09:00am", "2"));
		 * course.add(new Course("124", "Introduction to Software Engineering", 6,
		 * "08:00am - 09:00am", "1")); course.add(new Course("113",
		 * "Development perspectives", 7.5, "11:00am - 12:00am", "1")); course.add(new
		 * Course("125", "Wearable computing", 7.5, "13:00 - 14:00", "2"));
		 * course.add(new Course("232", "High level matrics", 9, "16:00 - 17:00", "2"));
		 * course.add(new Course("129", "Speaking skill", 7.5, "08:00am - 09:00am",
		 * "1")); course.add(new Course("130", "Advanced Calculus", 9,
		 * "08:00am - 09:00am", "1"));
		 */
		if (student == null) {
			model.addAttribute("course", course);
			model.addAttribute("student", new Student());
		} else {
			List<Course> unselected = course.stream().filter(c -> !(student.getSelected().contains(c)))
					.collect(Collectors.toList());
			model.addAttribute("course", unselected);
			model.addAttribute("student", student);
		}
		return "add-course";
	}

	@PostMapping
	public String getAddedCourses(@Valid @ModelAttribute Student formStudent, Errors errors, Model model,
			HttpSession session) {
		Student sessionStudent = (Student) session.getAttribute("student");
		if (sessionStudent == null || sessionStudent.getId() == null) {
			model.addAttribute("error",
					"Unable to add course: please ensure the student information is complete and valid");
			return "add-course";
		}
		if (formStudent != null && formStudent.getTemp() != null) {
			sessionStudent.getSelected().addAll(formStudent.getTemp());
			sessionStudent.setTotal(sessionStudent.getSelected().size());
			double sum = 0;
			for (Course c : sessionStudent.getSelected()) {
				sum += c.getCredits();
			}
			sessionStudent.setTotal_credits(sum);
		}
		session.setAttribute("student", sessionStudent);
		model.addAttribute(sessionStudent);

		return "summary";
	}

}
