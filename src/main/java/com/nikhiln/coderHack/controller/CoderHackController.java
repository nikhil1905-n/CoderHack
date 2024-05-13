package com.nikhiln.coderHack.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nikhiln.coderHack.dto.UserDto;
import com.nikhiln.coderHack.dto.UserIdDto;
import com.nikhiln.coderHack.dto.UserScoreDto;
import com.nikhiln.coderHack.exception.UserAlreadyExistsException;
import com.nikhiln.coderHack.exception.UserNotFoundException;
import com.nikhiln.coderHack.model.User;
import com.nikhiln.coderHack.service.CoderHackService;


@RestController
@RequestMapping(CoderHackController.USER_API_ENDPOINT)
public class CoderHackController {

    public static final String USER_API_ENDPOINT = "/users";
    public static final String USER_ID = "/{userId}";

    @Autowired
    private CoderHackService coderHackService;


    @GetMapping
    public ResponseEntity<List<User>> getUsers() {

        List<User> user = coderHackService.getUsers();
        return ResponseEntity.ok().body(user);

    }

    @GetMapping(USER_ID)
    public ResponseEntity<User> getUserById(@PathVariable String userId) {

        Optional<User> user = coderHackService.getUserById(userId);

        if(user.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.ok().body(user.get());

    }

    @PostMapping
    public ResponseEntity<UserIdDto> registerUser(@Valid @RequestBody UserDto userDto) {
        
        User user = coderHackService.registerUser(userDto);
        UserIdDto userIdDto = new UserIdDto(user.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(userIdDto);
        
    }

    @PutMapping(USER_ID)
    public ResponseEntity<User> updateUser(@PathVariable String userId, @Valid @RequestBody UserScoreDto score) {

        if(score.getScore() < 0 || score.getScore() > 100) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        User user = coderHackService.updateUserScore(userId, score);
        return ResponseEntity.ok().body(user);

    }

    @DeleteMapping(USER_ID)
    public ResponseEntity<?> deleteUser(@PathVariable String userId) {

        coderHackService.deleteUserById(userId);
        return ResponseEntity.ok().build();
        
    }


    @ExceptionHandler
    public ResponseEntity<String> userAlreadyExistsException(UserAlreadyExistsException exception) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body("User Already Exists");
    }

    @ExceptionHandler
    public ResponseEntity<String> userNotFoundException(UserNotFoundException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User Not Found");
    }
    
}
