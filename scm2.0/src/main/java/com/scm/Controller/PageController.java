package com.scm.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
	@RequestMapping("/home")
	public String home(Model model) {
		System.out.println("Home page handler");
		model.addAttribute("name","Substring Technologies");
		model.addAttribute("ytChannel","PrajjwalFitness");
		model.addAttribute("lindedin","www.linkedin.com/in/prajjwal-yadav-881a89262");
		return "home";
	}
}
 