package com.javacodegeeks.example.rest.multiplication;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
public class MultiplicationController {

	protected Logger logger = Logger.getLogger(MultiplicationController.class
			.getName());

	@RequestMapping("/multi")
	public String doMulti(@RequestParam(defaultValue = "1") String addend1,
						@RequestParam(defaultValue = "1") String addend2) {

		int augend1 = Integer.valueOf(addend1);
		int augend2 = Integer.valueOf(addend2);
		int product = augend1 * augend2;

		return "{\"addend1\":\"" + addend1 + "\", \"addend2\":\"" + addend2 + "\", \"product\": \"" + product + "\"}";
	}
}
