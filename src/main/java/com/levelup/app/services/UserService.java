package com.levelup.app.services;

import com.levelup.app.models.User;
import com.levelup.app.models.dtos.UserDto;

public interface UserService {

    User save(UserDto user);
    
}
