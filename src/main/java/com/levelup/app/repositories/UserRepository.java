package com.levelup.app.repositories;

import java.util.Optional;


import org.springframework.data.repository.CrudRepository;

import com.levelup.app.models.User;


public interface UserRepository extends CrudRepository<User, Long> {

    Optional<User> findUserByEmail(String email);

    Optional<User> findByRun(String run);

    /*@Query("SELECT new com.levelup.app.models.dtos.UserDto(u.run,u.name,u.lastname,u.email,u.birthday,u.addres,u.comuna.id,u.role.id) FROM User u WHERE u.id = ?1 ")
    Optional<UserDto> findUserDtoById(Long id);*/

    /*@Query("SELECT new com.levelup.app.models.dtos.UserDto(u.run,u.name,u.lastname,u.email,FUNCTION('DATE_FORMAT', u.birthday, '%Y-%m-%d'),u.addres,u.comuna.id,u.role.id) FROM User u")
    List<UserDto> findAllUserDto();*/

}
