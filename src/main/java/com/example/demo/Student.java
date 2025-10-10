package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.empty.RegistrationChecks;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
	@NotBlank(message = "the student id cannot be empty", groups = RegistrationChecks.class)
	private String id;
	@NotBlank(message = "the student name should not be empty", groups = RegistrationChecks.class)
	private String fname;
	@Email(message = "", groups = RegistrationChecks.class)
	@Pattern(regexp = "^[0-9a-z!#$%&'*+-/=?^_\\{\\}][0-9a-z!#$%&'*+-\\./=?^_\\{\\}]+[0-9a-z!#$%&'*+-/=?^_\\{\\}]@gmail\\.com$", message = "invalid email", groups = RegistrationChecks.class)
	private String email;
	@Size(min = 1, message = "Select atleast one course", groups = RegistrationChecks.class)
	private List<Course> selected = new ArrayList<>();
	private FeeDetails fee = new FeeDetails();
	@Valid
	private Payment payment = new Payment();
	private String semester;
	private int total = 0;
	private double total_credits = 0;
	private String registration_status = "InActive";
	private List<Course> temp = new ArrayList<>();

	public Student(String id, String fname, String email, String semester, String registration_status) {
		this.id = id;
		this.fname = fname;
		this.email = email;
		this.semester = semester;
		this.registration_status = registration_status;
	}
}
