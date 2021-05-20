package com.ssafy.happyhouse.model.domain;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Notice {
    private int noticeno;
    private String userid;
    private String subject;
    private String content;
    private LocalDate regtime;
}
