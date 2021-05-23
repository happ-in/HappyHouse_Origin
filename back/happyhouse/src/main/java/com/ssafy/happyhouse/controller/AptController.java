package com.ssafy.happyhouse.controller;

import com.ssafy.happyhouse.model.domain.Apt;
import com.ssafy.happyhouse.model.domain.AptPrice;
import com.ssafy.happyhouse.model.service.AptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/price")
    public ResponseEntity<List<Apt>> findByDealAmount(HttpServletRequest request) {
        String dong = request.getParameter("dong");
        int min = Integer.parseInt(request.getParameter("min"));
        int max = Integer.parseInt(request.getParameter("max"));
        AptPrice aptPrice = new AptPrice(dong, min, max);
        return new ResponseEntity<>(service.findByDealAmount(aptPrice), HttpStatus.OK);
    }
}
