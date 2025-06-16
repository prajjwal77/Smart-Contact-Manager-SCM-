package com.scm.Controllers;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.scm.Entities.Contact;
import com.scm.Entities.User;
import com.scm.Services.ContactService;
import com.scm.Services.UserService;
import com.scm.forms.ContactForm;
import com.scm.helpers.Helper;
import com.scm.helpers.Message;
import com.scm.helpers.MessageType;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/user/contacts")
public class ContactController {

    private Logger logger = org.slf4j.LoggerFactory.getLogger(ContactController.class);

    @Autowired
    private ContactService contactService;

    @Autowired
    private UserService userService;

    // add contact page: Handler
    @RequestMapping("/add")
    // add contact page: handler
    public String addContactView(Model model) {
        ContactForm contactForm = new ContactForm();

        contactForm.setFavorite(true);
        model.addAttribute("contactForm", contactForm);
        return "user/add_contact";
    }


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String saveContact(@Valid @ModelAttribute ContactForm contactForm, BindingResult result,Authentication authentication, HttpSession session) {

        // process the form data

        //1. validate the form data


         //Todo: add validation logic here
        if(result.hasErrors()) {
            // if there are errors, return to the add contact page with error messages
            System.out.println(result.getAllErrors());
            session.setAttribute("message", Message.builder()
                    .content("Please correct the following errors")
                    .type(MessageType.red)
                    .build());   
            return "user/add_contact";
        }




        String username = Helper.getEmailOfLoggedInUser(authentication);
        
        // form --> contact
        
        User user = userService.getUserByEmail(username);
        
        //process the contact picture
        //1. image processing logic
        //logger.info("file Infformation : {}  " + contactForm.getContactImage().getOriginalFilename());

        //code to upload image
        

        Contact contact = new Contact();
        contact.setName(contactForm.getName());
        contact.setEmail(contactForm.getEmail());
        contact.setFavorite(contactForm.isFavorite());
        contact.setPhoneNumber(contactForm.getPhoneNumber());
        contact.setFavorite(contactForm.isFavorite());
        contact.setAddress(contactForm.getAddress());
        contact.setDescription(contactForm.getDescription());
        contact.setUser(user);
       // contactService.save(contact);
        System.out.println(contactForm);

        //2.set the contact picture url


        //3.set message to be displayed on the view
        session.setAttribute("message", 
        Message.builder()
            .content("Contact added successfully")
            .type(MessageType.green) 
            .build()); 
        //4.redirect to the contact list page
        return "redirect:/user/contacts/add";
    }

}

// @Autowired
// private ContactService contactService;
//
// @GetMapping("/contacts")
// public String getContacts(Model model) {
// model.addAttribute("contacts", contactService.getAllContacts());
// return "contacts";
// }
//
// @GetMapping("/contacts/{id}")
// public String getContact(@PathVariable Long id, Model model) {
// model.addAttribute("contact", contactService.getContactById(id));
// return "contact";
// }
//
// @GetMapping("/contacts/new")
// public String newContact(Model model) {
// model.addAttribute("contact", new Contact());
// return "newContact";
// }
//
// @PostMapping("/contacts")
// public String saveContact(@ModelAttribute Contact contact) {
// contactService.saveContact(contact);
// return "redirect:/contacts";
// }
//
// @GetMapping("/contacts/edit/{id}")
// public String editContact(@PathVariable Long id, Model model) {
// model.addAttribute("contact", contactService.getContactById(id));
// return "editContact";
// }
//
// @PostMapping("/contacts/update/{id}")
// public String updateContact(@PathVariable Long id, @ModelAttribute Contact
// contact) {
// contactService.updateContact(id, contact);
// return "redirect:/contacts";
// }
//
// @GetMapping("/contacts/delete/{id}")
// public String deleteContact(@PathVariable Long id) {
// contactService.deleteContact(id);
// return "redirect:/contacts";
// }