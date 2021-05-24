package com.ssafy.happyhouse.controller;

import com.ssafy.happyhouse.model.domain.User;
import com.ssafy.happyhouse.model.service.FileService;
import com.ssafy.happyhouse.model.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

import java.util.List;

import static com.ssafy.happyhouse.utils.StringUtil.*;

@RestController
@CrossOrigin("*")
public class UserController {
    @Autowired
    UserService service;

    @Autowired
    FileService fileService;

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
        if (service.findByIdList(userid)) {
            return new ResponseEntity<>(SUCCESS, HttpStatus.OK);
        }
        return new ResponseEntity<>(FAIL, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/user/{userid}")
    public ResponseEntity<User> getUer(@PathVariable String userid) {
        return new ResponseEntity<>(service.findById(userid), HttpStatus.OK);
    }

    @PutMapping("/user")
    public ResponseEntity<User> update(@RequestBody User user) {
        if (service.update(user)) {
            return new ResponseEntity<>(service.findById(user.getUserid()), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @DeleteMapping("/user/{userid}")
    public ResponseEntity<String> delete(@PathVariable String userid) {
        if (service.delete(userid)) {
            fileService.delete(userid);
            return new ResponseEntity<>(SUCCESS, HttpStatus.OK);
        }
        return new ResponseEntity<>(FAIL, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/user")
    public ResponseEntity<List<User>> selectAll() {
        return new ResponseEntity<>(service.selectAll(), HttpStatus.OK);
    }
}
