package com.scm.Controllers;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.scm.Entities.User;
import com.scm.Services.UserService;
import com.scm.helpers.Helper;


@Controller
@RequestMapping("/user")
public class UserController {

    private Logger logger =  LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    //user dashboard page
    @RequestMapping(value="/dashboard")
    public String userDashboard() {
        System.out.println("User dasdboard");
        return "user/dashboard";
    }
    //user profile page
    @RequestMapping(value="/profile")
    public String userProfile(Model model,Authentication authentication) {
        String username = Helper.getEmailOfLoggedInUser(authentication);
        logger.info("User logged in : {}",username);
        
        //get user data from database
       User user  = userService.getUserByEmail(username);

       System.out.println(user.getName());
       System.out.println(user.getEmail());

       model.addAttribute("logedInUser",user);
        return "user/profile";
    }
    //user add contact page

    //user view contacts
    //user edit contact
    //user delete contact
    //user search contact
}
    