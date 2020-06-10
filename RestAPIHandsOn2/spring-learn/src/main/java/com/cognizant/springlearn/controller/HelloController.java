package com.cognizant.springlearn.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.springlearn.SpringLearnApplication;

@Controller
public class HelloController {
	private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);


//	@GetMapping("/hello")
	@RequestMapping("/hello")
	@ResponseBody
	public String sayHello() {
		LOGGER.info("START");
		LOGGER.info("END");
		return "Hello World!!";	
	}
	
}
