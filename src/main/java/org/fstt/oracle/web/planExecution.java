package org.fstt.oracle.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class planExecution {

	@GetMapping(path="/planExecution")
	public String index(){
		return "planExecution";
	}
}
