package com.nikhiln.coderHack.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.nikhiln.coderHack.model.User;
import java.util.List;
public interface CoderHackRepository extends MongoRepository<User, String> {

    List<User> findAllByOrderByScoreDesc();
    
}
