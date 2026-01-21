package com.levelup.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.levelup.app.entities.User;
import com.levelup.app.repositories.UserRepository;

@Service
public class UserServiceImple implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    @Override
    public User save(User user) {
        
        
        

        return null;
    }

}
