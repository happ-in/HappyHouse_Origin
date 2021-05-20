package com.ssafy.happyhouse.controller;

import com.ssafy.happyhouse.model.domain.User;
import com.ssafy.happyhouse.model.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class UserController {
    @Autowired
    UserService service;

    @PostMapping
    public ResponseEntity<User> login(@RequestBody User user) {
        return new ResponseEntity<>(service.findByIdAndPassword(user), HttpStatus.OK);
    }
}
