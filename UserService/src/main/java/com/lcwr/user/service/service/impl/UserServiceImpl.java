package com.lcwr.user.service.service.impl;

import com.lcwr.user.service.entity.User;
import com.lcwr.user.service.exceptions.ResourceNotFoundException;
import com.lcwr.user.service.repository.UserRepository;
import com.lcwr.user.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
   private   UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        // generate random user ID
    String randomUID= UUID.randomUUID().toString();
        user.setUserId(randomUID);

        return userRepository.save(user);


    }

    @Override
    public User getUser(String userID) {

        return  userRepository.findById(userID).orElseThrow(()->new ResourceNotFoundException("user with given ID not found on server : !!"+userID));
    }

    @Override
    public List<User> getAllUser() {

        return userRepository.findAll();
    }

    @Override
    public User updateUser(User user, Integer userId) {
        return null;
    }

    @Override
    public void deleteUser(Integer userId) {

    }
}
