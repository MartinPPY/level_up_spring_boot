package com.levelup.app.services;

import com.levelup.app.entities.User;
import com.levelup.app.models.UserDto;

public interface UserService {

    User save(UserDto user);
    
}
