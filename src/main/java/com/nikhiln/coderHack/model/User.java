package com.nikhiln.coderHack.model;

import java.util.Set;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "users")
public class User {

    @Id
    private String id;
    
    private String username;

    @Min(value = 0, message = "Score should not be less than 0")
    @Max(value = 100, message = "Score should not be greater than 100")
    private int score;
    
    private Set<Badges> badges;

}
