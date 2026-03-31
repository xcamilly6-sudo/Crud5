package com.senai.api.controllers;

import com.senai.api.dtos.LoginDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

    @RestController
    @RequestMapping
    public class ControllerLogin {
        @PostMapping("/login")
        public ResponseEntity<String> login(@RequestBody LoginDto loginDto) {
            return null;
        }
    }
