package com.levelup.app.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.levelup.app.models.User;

public interface UserRepository extends CrudRepository<User, Long> {

    Optional<User> findUserByEmail(String email);
    
    Optional<User> findByRun(String run);

}
