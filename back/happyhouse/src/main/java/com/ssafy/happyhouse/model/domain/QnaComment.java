package com.ssafy.happyhouse.model.domain;

import lombok.Data;

import java.time.LocalDate;

@Data
public class QnaComment {
    private int id;
    private int qna_id;
    private String userid;
    private String username;
    private String content;
    private LocalDate regtime;
}
