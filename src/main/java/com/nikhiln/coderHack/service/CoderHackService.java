package com.nikhiln.coderHack.service;

import java.util.List;
import java.util.Optional;

import com.nikhiln.coderHack.dto.UserDto;
import com.nikhiln.coderHack.dto.UserScoreDto;
import com.nikhiln.coderHack.model.User;


public interface CoderHackService {

    public List<User> getUsers();

    public Optional<User> getUserById(String userId);

    public User registerUser(UserDto userDto);

    public User updateUserScore(String userId, UserScoreDto score);

    public void deleteUserById(String userId);

}
