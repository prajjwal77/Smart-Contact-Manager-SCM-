package com.scm.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/user")
public class UserController {
    //user dashboard page
    @RequestMapping(value="/dashboard")
    public String userDashboard() {
        System.out.println("User dasdboard");
        return "user/dashboard";
    }
    //profile page
    @RequestMapping(value="/profile")
    public String userProfile() {
        System.out.println("User Profile");
        return "user/profile";
    }
    //user add contact page

    //user view contacts
    //user edit contact
    //user delete contact
    //user search contact
}
