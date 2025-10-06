package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class Student {
	@NotNull
	@Size(max = 12, message = "student id cannot be null or more than 12")
	private String id;
	@NotNull
	@Size(min = 1, message = "name should not be empty")
	private String fname;
	@NotNull
	private String email;
	@NotNull
	@Size(min = 1, message = "please choose atleast one course")
	private List<Course> selected = new ArrayList<>();
	private String semester;
	private int total = 0;
	private double total_credits = 0;
	private String registration_status = "InActive";
	private List<Course> temp = new ArrayList<>();
}
