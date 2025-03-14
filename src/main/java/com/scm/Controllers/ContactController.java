package com.scm.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.scm.forms.ContactForm;

@Controller
@RequestMapping("/user/contacts")
public class ContactController {
    
    
    //add contact page: Handler
    @RequestMapping("/add")
    public String addContact(Model model) {
        ContactForm contactForm = new ContactForm();
        contactForm.setName("Prajjwal Yadav");
        contactForm.setFavorite(true);
        model.addAttribute("contactForm",  contactForm);
        return "user/add_Contact";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String saveContact(@ModelAttribute("contactForm") ContactForm contactForm) {
       
       //process the form data
        System.out.println(
            "Name: " + contactForm.getName() + "\n" +
            "Email: " + contactForm.getEmail() + "\n" +
            "Phone Number: " + contactForm.getPhoneNumber() + "\n" +
            "Address: " + contactForm.getAddress() + "\n" +
            "Description: " + contactForm.getDescription() + "\n" +
            "Favorite: " + contactForm.isFavorite() + "\n" +
            "Website Link: " + contactForm.getWebsiteLink() + "\n" +
            "LinkedIn Link: " + contactForm.getLinkedInLink() + "\n" +
            "Profile Image: " + contactForm.getProfileImage().getOriginalFilename()
        );
        return "redirect:/user/contacts/add";
    }

}

    // @Autowired
    // private ContactService contactService;
    // 
    // @GetMapping("/contacts")
    // public String getContacts(Model model) {
    //     model.addAttribute("contacts", contactService.getAllContacts());
    //     return "contacts";
    // }
    // 
    // @GetMapping("/contacts/{id}")
    // public String getContact(@PathVariable Long id, Model model) {
    //     model.addAttribute("contact", contactService.getContactById(id));
    //     return "contact";
    // }
    // 
    // @GetMapping("/contacts/new")
    // public String newContact(Model model) {
    //     model.addAttribute("contact", new Contact());
    //     return "newContact";
    // }
    // 
    // @PostMapping("/contacts")
    // public String saveContact(@ModelAttribute Contact contact) {
    //     contactService.saveContact(contact);
    //     return "redirect:/contacts";
    // }
    // 
    // @GetMapping("/contacts/edit/{id}")
    // public String editContact(@PathVariable Long id, Model model) {
    //     model.addAttribute("contact", contactService.getContactById(id));
    //     return "editContact";
    // }
    // 
    // @PostMapping("/contacts/update/{id}")
    // public String updateContact(@PathVariable Long id, @ModelAttribute Contact contact) {
    //     contactService.updateContact(id, contact);
    //     return "redirect:/contacts";
    // }
    // 
    // @GetMapping("/contacts/delete/{id}")
    // public String deleteContact(@PathVariable Long id) {
    //     contactService.deleteContact(id);
    //     return "redirect:/contacts";
    // }