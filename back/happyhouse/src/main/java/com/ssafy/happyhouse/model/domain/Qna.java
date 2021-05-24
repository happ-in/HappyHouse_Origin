package com.ssafy.happyhouse.model.domain;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Qna {
    private int id;
    private String username;
    private String userid;
    private String title;
    private String content;
    private LocalDate mod_date;
    private String folder;
    private String filename;
}
