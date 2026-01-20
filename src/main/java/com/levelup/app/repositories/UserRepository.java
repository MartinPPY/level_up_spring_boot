package com.levelup.app.repositories;

import org.springframework.data.repository.CrudRepository;

import com.levelup.app.entities.User;

public interface UserRepository extends CrudRepository<User, Long> {

}
