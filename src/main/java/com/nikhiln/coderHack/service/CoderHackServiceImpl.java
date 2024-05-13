package com.nikhiln.coderHack.service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nikhiln.coderHack.dto.UserDto;
import com.nikhiln.coderHack.dto.UserScoreDto;
import com.nikhiln.coderHack.exception.UserNotFoundException;
import com.nikhiln.coderHack.model.Badges;
import com.nikhiln.coderHack.model.User;
import com.nikhiln.coderHack.repository.CoderHackRepository;

@Service
public class CoderHackServiceImpl implements CoderHackService {

    @Autowired
    private CoderHackRepository coderHackRepository;


    @Override
    public List<User> getUsers() {
        return coderHackRepository.findAllByOrderByScoreDesc();
    }

    @Override
    public Optional<User> getUserById(String userId) {
        return coderHackRepository.findById(userId);
    }

    @Override
    public User registerUser(UserDto userDto) {

        User createdUser = new User();
        createdUser.setUsername(userDto.getUsername());
        createdUser.setScore(0);
        createdUser.setBadges(new HashSet<>());

        return coderHackRepository.save(createdUser);

    }

    @Override
    public User updateUserScore(String userId, UserScoreDto score) {

        Optional<User> existingUser = coderHackRepository.findById(userId);
        
        if(existingUser.isEmpty()) {
            throw new UserNotFoundException();
        }

        User user = existingUser.get();
        user.setScore(score.getScore());
        user.setBadges(assignBadges(score.getScore()));

        User updatedUser = coderHackRepository.save(user);

        return updatedUser;

    }

    @Override
    public void deleteUserById(String userId) {

        if(!coderHackRepository.existsById(userId)) {
            throw new UserNotFoundException();
        }

        coderHackRepository.deleteById(userId);

    }


    private Set<Badges> assignBadges(int score) {

        Set<Badges> badges = new HashSet<>();

        if(score >= 1) {
            badges.add(Badges.Code_Ninja);
        }

        if(score >= 30) {
            badges.add(Badges.Code_Champ);
        }

        if(score >= 60) {
            badges.add(Badges.Code_Master);
        }

        return badges;

    }
    
}
