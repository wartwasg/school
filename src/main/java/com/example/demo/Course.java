package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Course {
	private String code;
	private String name;
	private double credits;
	private String time;
	private String semester;
}
