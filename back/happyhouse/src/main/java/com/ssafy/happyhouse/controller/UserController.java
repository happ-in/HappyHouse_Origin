package com.ssafy.happyhouse.controller;

import com.ssafy.happyhouse.model.domain.User;
import com.ssafy.happyhouse.model.service.FileService;
import com.ssafy.happyhouse.model.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.ssafy.happyhouse.utils.StringUtil.FAIL;
import static com.ssafy.happyhouse.utils.StringUtil.SUCCESS;

@RestController
@CrossOrigin("*")
@RequestMapping("/user")
public class UserController {
    @Autowired UserService service;
    @Autowired FileService fileService;

    @GetMapping("/{userid}")
    public ResponseEntity<User> getUer(@PathVariable String userid) {
        return new ResponseEntity<>(service.findById(userid), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<User>> selectAll() {
        return new ResponseEntity<>(service.selectAll(), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<User> update(@RequestBody User user) {
        if (service.update(user)) {
            return new ResponseEntity<>(service.findById(user.getUserid()), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @DeleteMapping("/{userid}")
    public ResponseEntity<String> delete(@PathVariable String userid) {
        if (service.delete(userid)) {
            fileService.delete(userid);
            return new ResponseEntity<>(SUCCESS, HttpStatus.OK);
        }
        return new ResponseEntity<>(FAIL, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
