package com.levelup.app.controller;

import com.levelup.app.models.dtos.UserDto;
import com.levelup.app.services.UserService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDto>> getAlluser() {
        return ResponseEntity.ok().body(userService.findAllUserDto());

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        userService.destroy(id);
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Usuario eliminado!");
        return ResponseEntity.ok().body(response);
    }

    @PostMapping
    public ResponseEntity<?> createUser(@Valid @RequestBody UserDto user, BindingResult result) {

        if (result.hasErrors()) {
            return validation(result);
        }

        userService.save(user);
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Registro exitoso!");
        return ResponseEntity.status(HttpStatus.CREATED.value()).body(response);

    }

    private ResponseEntity<?> validation(BindingResult result) {
        Map<String, Object> response = new HashMap<>();
        result.getFieldErrors().forEach(error -> {
            response.put(error.getField(), "El campo " + error.getField() + " es invalido!");
        });

        return ResponseEntity.badRequest().body(response);

    }

}
