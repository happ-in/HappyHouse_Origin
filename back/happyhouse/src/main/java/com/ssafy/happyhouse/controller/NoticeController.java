package com.ssafy.happyhouse.controller;

import com.ssafy.happyhouse.model.domain.Notice;
import com.ssafy.happyhouse.model.domain.Search;
import com.ssafy.happyhouse.model.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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

    @GetMapping("/list/{page}")
    public ResponseEntity<ListDto> selectAll(@PathVariable("page") int page) {
        int offset = (page - 1) * SIZE;
        return new ResponseEntity<>(new ListDto(service.selectAll(offset), page, (service.count() + SIZE - 1)/SIZE), HttpStatus.OK);
    }

    @GetMapping("/{no}")
    public ResponseEntity<Notice> selectOne(@PathVariable("no") int noticeno) {
        return new ResponseEntity<>(service.selectOne(noticeno), HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<ListDto> findByKeyword(HttpServletRequest request) {
        int page = Integer.parseInt(request.getParameter("page"));
        Search search = new Search();
        search.setTitle(request.getParameter("title"));
        search.setContent(request.getParameter("content"));
        search.setOffset((page - 1) * SIZE);
        int length = (service.findByKeywordCount(search) + SIZE - 1)/SIZE;
        return  new ResponseEntity<>(new ListDto(service.findByKeyword(search), page, length), HttpStatus.OK);
    }

    @DeleteMapping("/{no}")
    public ResponseEntity<String> delete(@PathVariable("no") int noticeno) {
        if(service.delete(noticeno)) {
            return new ResponseEntity<>(SUCCESS, HttpStatus.OK);
        }
        return new ResponseEntity<>(FAIL, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
