package com.scm.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scm.Entities.Contact;
@Repository
public interface ContactRepo extends JpaRepository< Contact, String > {

}
