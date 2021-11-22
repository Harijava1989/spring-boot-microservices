package com.javacodegeeks.example.rest.addition;

import java.util.logging.Logger;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdditionController {

	protected Logger logger = Logger.getLogger(AdditionController.class
			.getName());

	@RequestMapping("/add")
	public String doAdd(@RequestParam(defaultValue = "0") String addend1,
						@RequestParam(defaultValue = "0") String addend2,
						@RequestParam(defaultValue = "0") String addend3) {

		int augend1 = Integer.valueOf(addend1);
		int augend2 = Integer.valueOf(addend2);
		int augend3 = Integer.valueOf(addend3);
		int sum = augend1 + augend2 + augend3;

		return "{\"addend1\":\"" + addend1 + "\", \"addend2\":\"" + addend2 + "\", \"addend3\":\"" + addend3 + "\", \"sum\": \"" + sum + "\"}";
	}
	@RequestMapping("/tadd")
	public String doAdd(@RequestParam(defaultValue = "0") String addend1,
						@RequestParam(defaultValue = "0") String addend2) {

		int augend1 = Integer.valueOf(addend1);
		int augend2 = Integer.valueOf(addend2);
		int sum = augend1 + augend2;

		return "{\"addend1\":\"" + addend1 + "\", \"addend2\":\"" + addend2 + "\", \"sum\": \"" + sum + "\"}";
	}
}
