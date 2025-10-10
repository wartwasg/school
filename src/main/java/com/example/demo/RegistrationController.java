package com.example.demo;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.empty.RegistrationChecks;
import com.example.demo.repository.JdbcCourseRepository;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/registration")
public class RegistrationController {
	private JdbcCourseRepository repo;

	public RegistrationController(JdbcCourseRepository repo) {
		this.repo = repo;
	}

	@ModelAttribute
	void prepareCourses(Model model) {
		List<Course> course = repo.findAll();
		model.addAttribute("course", course);
	}

	@GetMapping
	public String getRegistrationPage(Model model) {
		model.addAttribute("student", new Student());
		return "registration";
	}

	@PostMapping
	public String getStudentInfo(@Validated(RegistrationChecks.class) @ModelAttribute Student student, Errors errors,
			Model model, HttpSession session) {
		if (errors.hasErrors()) {
			System.out.println("All errors captured  :" + errors.getAllErrors());
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
