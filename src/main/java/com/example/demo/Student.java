package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class Student {
	@NotBlank(message = "the student id cannot be empty")
	private String id;
	@NotBlank(message = "the student name should not be empty")
	private String fname;
	@NotBlank(message = "Email is required")
	@Email(message = "Invalid email")
	@Pattern(regexp = "^[0-9a-z!#$%&'*+-/=?^_\\{\\}][0-9a-z!#$%&'*+-\\./=?^_\\{\\}]+[0-9a-z!#$%&'*+-/=?^_\\{\\}]@gmail\\.com$", message = "invalid email")
	private String email;
	@Size(min = 1, message = "Select atleast one course")
	private List<Course> selected = new ArrayList<>();
	private FeeDetails fee = new FeeDetails();
	private Payment payment = new Payment();
	private String semester;
	private int total = 0;
	private double total_credits = 0;
	private String registration_status = "InActive";
	private List<Course> temp = new ArrayList<>();
}
