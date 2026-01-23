package com.levelup.app.services;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.levelup.app.entities.Comuna;
import com.levelup.app.entities.Role;
import com.levelup.app.entities.User;
import com.levelup.app.exception.NotFoundException;
import com.levelup.app.exception.UserAlreadyExist;
import com.levelup.app.models.UserDto;
import com.levelup.app.repositories.ComunaRepository;
import com.levelup.app.repositories.RoleRepository;
import com.levelup.app.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ComunaRepository comunaRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Transactional
    @Override
    public User save(UserDto user) {

        Comuna comuna = comunaRepository.findById(user.getComunaId().longValue())
                .orElseThrow(() -> new NotFoundException("La comuna no existe!"));
        Role role = null;

        if (user.getRole() == null) {

            role = roleRepository.findById(1L)
                    .orElseThrow(() -> new NotFoundException("El rol por defecto no existe!"));

        } else {
            role = roleRepository.findById(user.getRole().longValue())
                    .orElseThrow(() -> new NotFoundException("El rol por defecto no existe!"));
        }

        if(userRepository.findByRun(user.getRun()).isPresent()){
            throw new UserAlreadyExist("Este RUN ya esta registrado!");
        }

        if(userRepository.findUserByEmail(user.getEmail()).isPresent()){
            throw new UserAlreadyExist("Este email ya esta registrado!");
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate birthday = LocalDate.parse(user.getBirthday(), formatter);
        String encodedPassword = passwordEncoder.encode(user.getPassword());

        User newUser = new User(
                user.getRun(),
                user.getName(),
                user.getLastname(),
                user.getEmail(),
                birthday,
                encodedPassword,
                comuna,
                role);

        return userRepository.save(newUser);
    }

}
