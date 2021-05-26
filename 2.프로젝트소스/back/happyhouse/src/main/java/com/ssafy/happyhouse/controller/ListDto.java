package com.ssafy.happyhouse.controller;

import lombok.Data;

@Data
public class ListDto<T> {
    T list;
    int page;
    int length;

    public ListDto(T list, int page, int length) {
        this.list = list;
        this.page = page;
        this.length = length;
    }
}
