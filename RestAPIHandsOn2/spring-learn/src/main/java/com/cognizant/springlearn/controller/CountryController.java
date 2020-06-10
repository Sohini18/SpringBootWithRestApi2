package com.cognizant.springlearn.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.springlearn.Country;
import com.cognizant.springlearn.SpringLearnApplication;
import com.cognizant.springlearn.service.CountryService;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;

@Controller
public class CountryController {
	private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);

	@Autowired
	CountryService countryService;

//	@GetMapping("/hello")
	@RequestMapping("/country")
	@ResponseBody
	public Country getCountryIndia(){
		LOGGER.info("START");
		ApplicationContext context=new ClassPathXmlApplicationContext("country.xml");
		Country country=(Country) context.getBean("in");
		LOGGER.info("END");
		return country;
	}
	@GetMapping("/countries")
	@ResponseBody
	public List<Country> getAllCountries() {
		LOGGER.info("START");
		ApplicationContext context=new ClassPathXmlApplicationContext("country.xml");
		List<Country> countryList=(List<Country>) context.getBean("countryList");
		LOGGER.info("END");
		return countryList;
	}
	
	@GetMapping("/countries/{code}")
	@ResponseBody
	public Country getCountry(@PathVariable String code) throws CountryNotFoundException {
		LOGGER.info("START");
		Country country=countryService.getCountry(code);
		LOGGER.info("END");
		return country;
	}
}
