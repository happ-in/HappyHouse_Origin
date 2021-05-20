package com.ssafy.happyhouse.controller;

import com.ssafy.happyhouse.model.domain.Qna;
import com.ssafy.happyhouse.model.service.QnaService;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.ssafy.happyhouse.utils.StringUtil.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/qna")
public class QnaController {

    @Autowired
    QnaService service;

    @PostMapping
    public ResponseEntity<String> insert(@RequestBody Qna qna) {
        if (service.insert(qna)) {
            return new ResponseEntity<>(SUCCESS, HttpStatus.OK);
        }
        return new ResponseEntity<>(FAIL, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PutMapping
    public ResponseEntity<String> update(@RequestBody Qna qna) {
        if (service.update(qna)) {
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

    @GetMapping
    public ResponseEntity<List<Qna>> selectAll() {
        return new ResponseEntity<>(service.selectAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Qna> selectOne(@PathVariable("id") int id) {
        return new ResponseEntity<>(service.selectOne(id), HttpStatus.OK);
    }
}
