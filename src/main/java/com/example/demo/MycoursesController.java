package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/summary")
public class MycoursesController {
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
		student.setRegistration_status("Registered");
		model.addAttribute(student);
		// session.invalidate();
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
