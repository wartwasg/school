package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/payment")
public class PaymentControl {
	@GetMapping
	public String getPayment() {
		return "payment";
	}

	@PostMapping
	public String postPayment() {
		return "payment";
	}
}
