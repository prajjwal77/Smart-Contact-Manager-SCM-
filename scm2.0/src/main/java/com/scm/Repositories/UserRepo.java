package com.scm.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scm.Entities.User;
@Repository
public interface UserRepo extends JpaRepository<User, String>{
//extra methods db related to do operations
//custom query methods 
//custom finder methods
}
