package com.ssafy.happyhouse.controller;

import com.ssafy.happyhouse.model.domain.Qna;
import com.ssafy.happyhouse.model.domain.Search;
import com.ssafy.happyhouse.model.service.QnaService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

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

    @GetMapping("/list/{page}")
    public ResponseEntity<ListDto> selectAll(@PathVariable("page") int page) {
        int offset = (page - 1) * SIZE;
        return new ResponseEntity<>(new ListDto<>(service.selectAll(offset), page,(service.count() + SIZE - 1)/SIZE), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Qna> selectOne(@PathVariable("id") int id) {
        return new ResponseEntity<>(service.selectOne(id), HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<ListDto> selectByKeyword(HttpServletRequest request) {
        int page = Integer.parseInt(request.getParameter("page"));
        Search search = new Search();
        search.setTitle(request.getParameter("title"));
        search.setContent(request.getParameter("content"));
        search.setOffset((page-1) * SIZE);
        int length = (service.findByKeywordCount(search) + SIZE - 1)/SIZE;
        return new ResponseEntity<>(new ListDto(service.findByKeyword(search), page, length), HttpStatus.OK);
    }

}
