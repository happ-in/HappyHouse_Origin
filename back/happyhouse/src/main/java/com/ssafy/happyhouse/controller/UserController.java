package com.ssafy.happyhouse.controller;

import com.ssafy.happyhouse.model.domain.User;
import com.ssafy.happyhouse.model.domain.UserImage;
import com.ssafy.happyhouse.model.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

import static com.ssafy.happyhouse.utils.StringUtil.*;

@RestController
@CrossOrigin("*")
public class UserController {
    @Autowired
    UserService service;

    @PostMapping
    public ResponseEntity<User> login(@RequestBody User user) {
        return new ResponseEntity<>(service.findByIdAndPassword(user), HttpStatus.OK);
    }

    @PostMapping("/join")
    public ResponseEntity<String> join(@RequestBody User user) {
        if (service.join(user)) {
            return new ResponseEntity<>(SUCCESS, HttpStatus.OK);
        }
        return new ResponseEntity<>(FAIL, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/validate")
    public ResponseEntity<String> IdCheck(HttpServletRequest request) {
        String userid = request.getParameter("id");
        if (service.findById(userid)) {
            return new ResponseEntity<>(SUCCESS, HttpStatus.OK);
        }
        return new ResponseEntity<>(FAIL, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
