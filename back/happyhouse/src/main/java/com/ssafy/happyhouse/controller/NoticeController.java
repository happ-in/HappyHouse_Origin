package com.ssafy.happyhouse.controller;

import com.ssafy.happyhouse.model.domain.Notice;
import com.ssafy.happyhouse.model.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.ssafy.happyhouse.utils.StringUtil.*;

@RestController
@RequestMapping("/notice")
@CrossOrigin("*")
public class NoticeController {

    @Autowired
    NoticeService service;

    @PostMapping
    public ResponseEntity<String> create(@RequestBody Notice notice) {
        if(service.insert(notice)) {
            return new ResponseEntity<>(SUCCESS, HttpStatus.OK);
        }
        return new ResponseEntity<>(FAIL, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping
    public ResponseEntity<List<Notice>> selectAll() {
        return new ResponseEntity<>(service.selectAll(), HttpStatus.OK);
    }

    @GetMapping("/{no}")
    public ResponseEntity<Notice> selectOne(@PathVariable("no") int noticeno) {
        return new ResponseEntity<>(service.selectOne(noticeno), HttpStatus.OK);
    }
}
