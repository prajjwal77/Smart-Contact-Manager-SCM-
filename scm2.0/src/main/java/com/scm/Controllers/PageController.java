package com.scm.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.scm.Entities.User;
import com.scm.Services.UserService;
import com.scm.Services.impl.UserServiceImpl;
import com.scm.forms.UserForm;
import com.scm.helpers.Message;
import com.scm.helpers.MessageType;

import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PageController {
    @Autowired
    private UserService userService;

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
    public String processingRegister(@ModelAttribute UserForm userForm, HttpSession session){
        //fetch the form data
        //validate from data
        //save to database
        //userService.saveUser(userForm)

        // User user = User.builder()
        // .name(userForm.getName())
        // .email(userForm.getEmail())
        // .password(userForm.getPassword())
        // .about(userForm.getAbout())
        // .phoneNumber(userForm.getPhoneNumber())
        // .build();
        User user = new User();
        user.setName(userForm.getName());
        user.setEmail(userForm.getEmail());
        user.setPassword(userForm.getPassword());
        user.setAbout(userForm.getAbout());
        user.setPhoneNumber(userForm.getPhoneNumber());
        user.setProfilePic("");

    
        User savedUser = userService.saveUser(user);
        System.out.println("user saved");
       
        //message = "Registration Successfull"

        //add the message
        Message message = Message.builder().content("Registration Successful").type(MessageType.green).build();

        session.setAttribute("message", message);

        //redirection login page
        return "redirect:/register";
        //
    }
}
