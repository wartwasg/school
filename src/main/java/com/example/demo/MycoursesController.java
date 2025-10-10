package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.repository.JdbcStudentRepository;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/summary")
public class MycoursesController {
	private JdbcStudentRepository repo;

	public MycoursesController(JdbcStudentRepository repo) {
		this.repo = repo;
	}

	@GetMapping
	public String getSummaryPage(HttpSession session, Model model) {
		Student student = (Student) session.getAttribute("student");
		if (student == null) {
			model.addAttribute("student", new Student());
			session.setAttribute("student", new Student());
		} else {
			student.setRegistration_status("Active");
			session.setAttribute("student", student);
			model.addAttribute("student", student);
		}
		return "summary";
	}

	@PostMapping
	public String getSubmitted(HttpSession session, Model model) {
		Student student = (Student) session.getAttribute("student");
		if (student == null) {
			model.addAttribute("error", "Unable to register course: no valid student information available");
		} else {
			student.setRegistration_status("Registered");
			model.addAttribute(student);
			repo.Save(student);
			session.invalidate();
		}

		return "summary";
	}

	@PostMapping("/delete")
	public String deleteCourse(@RequestParam String code, HttpSession session, Model model) {
		Student student = (Student) session.getAttribute("student");
		student.getSelected().removeIf(c -> c.getCode().trim().equals(code.trim()));
		student.setTotal(student.getSelected().size());
		double sum = 0;
		for (Course c : student.getSelected()) {
			sum += c.getCredits();
		}
		student.setTotal_credits(sum);
		session.setAttribute("student", student);
		model.addAttribute("student", student);
		return "summary";
	}
}
