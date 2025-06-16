package com.scm.Services;

import java.util.List;

import com.scm.Entities.Contact;

public interface ContactService {
    // save contact
    Contact save(Contact contact);

    // update contact
    Contact update(Contact contact);

    // get contacts
    List<Contact> getAll();

    // get contact by id
    Contact getById(String id);

    
    // delete contact
    void delete(String id);

    // get contacts by userId
    List<Contact> getByUserId(String userId);
}
