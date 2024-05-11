package com.nikhiln.coderHack.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.nikhiln.coderHack.model.User;

public interface CoderHackRepository extends MongoRepository<User, String> {
    
}
