package com.levelup.app.services;

import com.levelup.app.models.User;
import com.levelup.app.models.dtos.UserDto;

import java.util.List;

public interface UserService {

    User save(UserDto user);

    List<UserDto> findAllUserDto();

    UserDto findUserDtoById(Long id);

    void destroy(Long id);
}
