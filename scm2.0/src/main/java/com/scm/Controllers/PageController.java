package com.scm.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
	@RequestMapping("/home")
	public String home(Model model) {
		System.out.println("Home page Handler.");
		model.addAttribute("name","Substring Technology");
		model.addAttribute("Linkedin","www.linkedin.com/in/prajjwal-yadav-881a89262");
		model.addAttribute("github","https://github.com/prajjwal77/Smart-Contact-Manager-SCM-.git");
		
		return "home";
	}
}
