package org.fstt.oracle.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Home {

	@GetMapping(path="/home")
	public String index(){
		return "home";
	}
}
