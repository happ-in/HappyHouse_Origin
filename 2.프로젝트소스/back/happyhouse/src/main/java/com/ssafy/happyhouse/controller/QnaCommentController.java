package com.ssafy.happyhouse.controller;

import com.ssafy.happyhouse.model.domain.QnaComment;
import com.ssafy.happyhouse.model.service.QnaCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.ssafy.happyhouse.utils.StringUtil.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/comment")
public class QnaCommentController {

    @Autowired
    QnaCommentService service;

    @GetMapping("/{id}")
    public ResponseEntity<List<QnaComment>> searchAll(@PathVariable("id") int qna_id) {
        return new ResponseEntity<>(service.searchAll(qna_id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> insert(@RequestBody QnaComment comment) {
        if (service.insert(comment)) {
            return new ResponseEntity<>(SUCCESS, HttpStatus.OK);
        }
        return new ResponseEntity<>(FAIL, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") int id) {
        if (service.delete(id)) {
            return new ResponseEntity<>(SUCCESS, HttpStatus.OK);
        }
        return new ResponseEntity<>(FAIL, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
