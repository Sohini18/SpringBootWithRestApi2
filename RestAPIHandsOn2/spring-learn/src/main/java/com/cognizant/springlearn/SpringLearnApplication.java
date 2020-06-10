package com.cognizant.springlearn;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class SpringLearnApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringLearnApplication.class, args);
		displayDate();
		displayCountry();
		displayCountries();
	}

	public static void displayDate() {
		LOGGER.info("START");
		ApplicationContext context = new ClassPathXmlApplicationContext("date-format.xml");
		SimpleDateFormat format = context.getBean("dateFormat", SimpleDateFormat.class);
		String date1 = "31/12/2018";
		Date date = null;
		try {
			date = format.parse(date1);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// System.out.println(date);
		LOGGER.debug(date.toString());
		LOGGER.info("END");
	}
	
	public static void displayCountry() {
		LOGGER.info("START");
		ApplicationContext context=new ClassPathXmlApplicationContext("country.xml");
		Country country=(Country) context.getBean("country");
		//Country anotherCountry = context.getBean("country", Country.class); 
		LOGGER.debug("Country : {} ",country.toString());
		LOGGER.info("END");
	}
	
	public static void displayCountries() {
		LOGGER.info("START");
		ApplicationContext context=new ClassPathXmlApplicationContext("country.xml");
		ArrayList<Country> countryList=(ArrayList<Country>) context.getBean("countryList");
		//Country anotherCountry = context.getBean("country", Country.class); 
		LOGGER.debug("Country List : {} ",countryList.toString());
		LOGGER.info("END");
	}

}
