package com.levelup.app.services;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.levelup.app.exception.NotFoundException;
import com.levelup.app.exception.UserAlreadyExist;
import com.levelup.app.models.Comuna;
import com.levelup.app.models.Role;
import com.levelup.app.models.User;
import com.levelup.app.models.dtos.UserDto;
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

        if (userRepository.findByRun(user.getRun()).isPresent()) {
            throw new UserAlreadyExist("Este RUN ya esta registrado!");
        }

        if (userRepository.findUserByEmail(user.getEmail()).isPresent()) {
            throw new UserAlreadyExist("Este email ya esta registrado!");
        }

        LocalDate birthday = null;

        if (user.getBirthday() != null && !user.getBirthday().isEmpty()) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            birthday = LocalDate.parse(user.getBirthday(), formatter);
        }

        String encodedPassword = passwordEncoder.encode(user.getPassword());

        User newUser = new User(
                user.getRun(),
                user.getName(),
                user.getLastname(),
                user.getEmail(),
                birthday,
                encodedPassword,
                user.getAddres(),
                comuna,
                role);

        return userRepository.save(newUser);
    }

    @Transactional
    @Override
    public List<UserDto> findAllUserDto() {
        List<UserDto> users = new ArrayList<>();

        for (User user : userRepository.findAll()) {

            String birthdayStr = null;
            if (user.getBirthday() != null) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                birthdayStr = user.getBirthday().format(formatter);
            }

            UserDto userDto = new UserDto(
                    user.getRun(),
                    user.getName(),
                    user.getLastname(),
                    user.getEmail(),
                    birthdayStr,
                    user.getAddres(),
                    user.getComuna().getId(),
                    user.getRole().getId(),
                    user.getId());
            users.add(userDto);

        }

        return users;

    }

    @Override
    public UserDto findUserDtoById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findUserDtoById'");
    }

    @Override
    public void destroy(Long id) {

        userRepository.deleteById(id);

    }
}
