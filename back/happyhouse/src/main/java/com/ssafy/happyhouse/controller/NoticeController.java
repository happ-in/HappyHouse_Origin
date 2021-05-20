package com.ssafy.happyhouse.controller;

import com.ssafy.happyhouse.model.domain.Notice;
import com.ssafy.happyhouse.model.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notice")
public class NoticeController {

    final static String SUCCESS = "success";
    final static String FAIL = "fail";

    @Autowired
    NoticeService service;

    @PostMapping
    public ResponseEntity<String> create(@RequestBody Notice notice) {
        if(service.insert(notice)) {
            return new ResponseEntity<>(SUCCESS, HttpStatus.OK);
        }
        return new ResponseEntity<>(FAIL, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
