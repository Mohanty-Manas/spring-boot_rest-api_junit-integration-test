package com.test.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Manas Mohanty
 * 
 * The Class HomeController.
 */
@Controller
@RequestMapping("/test-api")
public class HomeController {

	/**
	 * Home.
	 *
	 * @return the string
	 */
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String home() {
		return "index";
	}
	
	
}
