package org.fstt.oracle.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContactUs {

	@GetMapping(path="/contact")
	public String index(){
		return "contact";
	}
	
}
