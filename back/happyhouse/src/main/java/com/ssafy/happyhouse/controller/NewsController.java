package com.ssafy.happyhouse.controller;

import lombok.extern.log4j.Log4j2;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("news")
public class NewsController {

    @Autowired
    News news;

    @GetMapping
    public String getNews(HttpServletRequest req) {
        String query = req.getParameter("query");
        return news.getNews(query);
    }
}
