package org.fstt.oracle.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AboutUs {

	@GetMapping(path="/about")
	public String index(){
		return "about";
	}
}
