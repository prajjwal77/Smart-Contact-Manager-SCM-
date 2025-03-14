package com.scm.Services;

import com.scm.Entities.Contact;

public interface ConntactService {
    //save contact
    Contact save(Contact contact);

    //update contact
    Contact update(Contact contact);
}
