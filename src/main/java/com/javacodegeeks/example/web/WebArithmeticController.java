package com.javacodegeeks.example.web;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WebArithmeticController {
	@Autowired
	protected WebAdditionService additionService;
	@Autowired
	protected WebMultiplicationService multiplicationService;

	@Autowired
	protected WebSubtractionService subtractionService;

	protected Logger logger = Logger.getLogger(WebArithmeticController.class
			.getName());

	public WebArithmeticController(WebAdditionService additionService, WebSubtractionService subtractionService, WebMultiplicationService multiplicationService) {
		this.additionService = additionService;
		this.subtractionService = subtractionService;
		this.multiplicationService = multiplicationService;
	}

	@RequestMapping("/add")
	public String doAdd(@RequestParam(defaultValue="0") String addend1,
			@RequestParam(defaultValue="0") String addend2,
						@RequestParam(defaultValue="0") String addend3,
			Model model) {

		String sum = additionService.add(addend1, addend2, addend3);

		logger.info("Sum: " + sum);
		model.addAttribute("json", sum);

		return "sum";
	}
	@RequestMapping("/tadd")
	public String doAdd(@RequestParam(defaultValue="0") String addend1,
						@RequestParam(defaultValue="0") String addend2,
						Model model) {

		String sum = additionService.add(addend1, addend2);

		logger.info("Sum: " + sum);
		model.addAttribute("json", sum);

		return "sum";
	}
	@RequestMapping("/multi")
	public String doMulti(@RequestParam(defaultValue="1") String addend1,
						@RequestParam(defaultValue="1") String addend2,
						Model model) {

		String product = multiplicationService.multi(addend1, addend2);

		logger.info("Product: " + product);
		model.addAttribute("json", product);

		return "product";
	}
	@RequestMapping("/subtract")
	public String doSubtract(@RequestParam(defaultValue="0") String minuend,
			@RequestParam(defaultValue="0") String subtrahend,
			Model model) {

		String difference = subtractionService.subtract(minuend, subtrahend);

		logger.info("Difference: " + difference);
		model.addAttribute("json", difference);

		return "difference";
	}
}
