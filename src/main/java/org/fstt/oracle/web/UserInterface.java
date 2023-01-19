package org.fstt.oracle.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserInterface {

	@GetMapping(path="/CreateRequest")
	public String index(){
		return "CreateRequest";
	}
}
