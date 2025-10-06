package com.example.demo;

import org.hibernate.validator.constraints.CreditCardNumber;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FeeDetails extends Student {
	@NotBlank(message = "select the valid payment type")
	private String type;
	@NotBlank(message = "the entered amount should not be blank")
	private double amount;
	@NotBlank(message = "select the valid payment method")
	private String method;
	@CreditCardNumber(message = "invalid credit card number")
	private String card_number;
	private String card_holder_name;
	@Pattern(regexp = "(0[0-9]{1} | 1[0-2]{1})/[0-9]{2}")
	private String exp;
	@Digits(integer = 3, fraction = 0, message = "invalid cvv")
	private String cvv;
	@Digits(integer = 5, fraction = 0, message = "invalid billing zip")
	private String billing_zip;
	private String instructions;
}
