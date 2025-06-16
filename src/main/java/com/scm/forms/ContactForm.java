package com.scm.forms;

import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ContactForm {
    
    @NotBlank(message = "Name is required")
    private String name;
    
    @NotBlank(message = "Email is required")
    @Email(message = "Email is not valid")
    private String email;

    @NotBlank(message = "Phone number is required")
    @Pattern(regexp = "^\\+?[0-9]{10,15}$", message = "Phone number is not valid")
    private String phoneNumber;

    @NotBlank(message = "Address is required")
    private String address;


    private String description;


    private boolean favorite;

    
    private String websiteLink;
    private String linkedInLink;

    //creating annotation for file upload
    //size
    //resolution
    
    private MultipartFile contactImage;

    public void setFavorite(boolean b) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
