package com.example.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/payment")
public class PaymentControl {
	@GetMapping
	public String getPayment(HttpSession session, Model model) {
		HashMap<String, String> unpaid_things = new HashMap<>();
		List<String> semester = new ArrayList<>();
		List<String> payment_method = new ArrayList<>();
		HashMap<String, String> available_course = new HashMap<>();
		unpaid_things.put("Direct Costs", "240,000/=");
		unpaid_things.put("registration fee", "60,000/=");
		unpaid_things.put("Accomodation fee", "237,000/=");
		unpaid_things.put("Udoso contribution", "10,000/=");
		unpaid_things.put("Fee", "1,500,000/=");

		available_course.put("1st year", "1");
		available_course.put("2nd year", "2");
		available_course.put("3rd year", "3");
		available_course.put("4th year", "4");

		semester.add("1");
		semester.add("2");

		payment_method.add("Credit Card");
		payment_method.add("Debit Card");
		payment_method.add("Bank Transfer");
		payment_method.add("Check/Cheque");
		payment_method.add("Cash (At School Office)");

		model.addAttribute("years", available_course);
		model.addAttribute("unpaid_semester", semester);
		model.addAttribute("unpaid", unpaid_things);
		model.addAttribute("payment_method", payment_method);

		Student student = (Student) session.getAttribute("student");
		if (student == null) {
			model.addAttribute("student", new Student());
		} else {
			model.addAttribute("student", student);
		}
		return "payment";
	}

	@PostMapping
	public String postPayment(@Valid @ModelAttribute Student student, Errors errors, Model model) {
		if (errors.hasErrors()) {
			return "payment";
		} else {
			return "summary";
		}
	}
}
