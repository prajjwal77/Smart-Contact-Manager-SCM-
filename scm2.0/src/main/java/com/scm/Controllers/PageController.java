package com.scm.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.scm.Entities.User;
import com.scm.Services.impl.UserServiceImpl;
import com.scm.forms.UserForm;

import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PageController {
    @Autowired
    private UserServiceImpl userServiceImpl;

	@RequestMapping("/home")
	public String home(Model model) {
		System.out.println("Home page Handler.");
		model.addAttribute("name","Substring Technology");
		model.addAttribute("Linkedin","www.linkedin.com/in/prajjwal-yadav-881a89262");
		model.addAttribute("github","https://github.com/prajjwal77/Smart-Contact-Manager-SCM-.git");
		
		return "home";
	}

    @RequestMapping("/about")
    public String aboutPage(){
        System.out.println("About page handler.");
        return "about";
    }

    @RequestMapping("/services")
    public String servicePage(){
        System.out.println("Service page handler.");
        return "services";
    }

    @RequestMapping("/contact")
    public String contact(){
        return "contact";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/register")
    public String register(Model model){
        UserForm userForm = new UserForm();
        model.addAttribute("userForm",userForm);
        return "register";
    }

    //processing register
    @RequestMapping(value = "/do-register", method =RequestMethod.POST)
    public String processingRegister(@ModelAttribute UserForm userForm){
        //fetch the form data
        //validate from data
        //save to database
        //userService.saveUser(userForm)
        User user = User.builder()
        .name(userForm.getName())
        .email(userForm.getEmail())
        .password(userForm.getPassword())
        .about(userForm.getAbout())
        .phoneNumber(userForm.getPhoneNumber())
        .build();
        User savedUser = userServiceImpl.saveUser(user);
        System.out.println("user saved");
        //message = "Registration Successfull"
        //redirection login page
        return "redirect:/register";
        //
    }
}
