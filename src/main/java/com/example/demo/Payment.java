package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {
	private String g_name;
	private String g_email;
	private String phone;
	private String resident_address;
	private String city;
	private String zipCode;
}
