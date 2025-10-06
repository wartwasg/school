package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Payment extends Student {
	private String g_name;
	private String g_email;
	private String phone;
	private String resident_address;
	private String city;
	private String zipCode;
}
