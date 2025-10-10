package com.example.demo;

import com.example.demo.empty.PaymentChecks;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class Payment {
	private String id;
	@NotBlank(message = "Guardian name cannot be empty", groups = PaymentChecks.class)
	private String g_name;
	@NotBlank(message = "Email address cannot be empty", groups = PaymentChecks.class)
	@Email(message = "Invalid email address", groups = PaymentChecks.class)
	private String g_email;
	@Pattern(regexp = "^(\\+255)7[0-9]{8}|^(\\\\+255)6[0-9]{8}", message = "Invalid phone number", groups = PaymentChecks.class)
	private String phone;
	@NotBlank(message = "The resident andress cannot be empty", groups = PaymentChecks.class)
	private String resident_address;
	@NotBlank(message = "The city cannot be empty", groups = PaymentChecks.class)
	private String city;
	@Pattern(regexp = "[0-9]{5}", message = "invalid zip code", groups = PaymentChecks.class)
	private String zipCode;
}
