package com.ssafy.happyhouse.controller;

import com.ssafy.happyhouse.model.domain.Apt;
import com.ssafy.happyhouse.model.service.AptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/apt")
@CrossOrigin("*")
public class AptController {

    @Autowired
    AptService service;

    @GetMapping
    public ResponseEntity<List<Apt>> findByDong(HttpServletRequest request) {
        String dong = request.getParameter("dong");
        return new ResponseEntity<>(service.findByDong(dong), HttpStatus.OK);
    }
}
