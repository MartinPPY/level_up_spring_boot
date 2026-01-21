package com.levelup.app.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    public ResponseEntity<Map<String, Object>> login() {

        Map<String, Object> response = new HashMap<>();
        response.put("message", "Registro exitoso!");
        return ResponseEntity.status(HttpStatus.CREATED.value()).body(response);
    }

}
