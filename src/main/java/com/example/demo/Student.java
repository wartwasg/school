package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class Student {
	private String id;
	private String fname;
	private String email;
	private List<Course> selected = new ArrayList<>();
	private String semester;
	private int total = 0;
	private double total_credits = 0;
	private String registration_status = "InActive";
	private List<Course> temp = new ArrayList<>();
}
