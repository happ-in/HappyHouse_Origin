package com.ssafy.happyhouse.model.domain;

import lombok.Data;

@Data
public class Search {
    private String title;
    private String content;
    private int offset;
}
